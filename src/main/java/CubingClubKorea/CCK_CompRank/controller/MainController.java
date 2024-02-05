package CubingClubKorea.CCK_CompRank.controller;


import CubingClubKorea.CCK_CompRank.DTO.CompListDTO;
import CubingClubKorea.CCK_CompRank.DTO.RoundDTO;
import CubingClubKorea.CCK_CompRank.Service.CompListService;
import CubingClubKorea.CCK_CompRank.Service.ParticipateService;
import CubingClubKorea.CCK_CompRank.Service.RoundService;
import CubingClubKorea.CCK_CompRank.entity.CompList;
import CubingClubKorea.CCK_CompRank.entity.Participate;
import CubingClubKorea.CCK_CompRank.entity.Round;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private final CompListService complistService;
    @Autowired
    private final RoundService roundService;
    @Autowired
    private final ParticipateService participateService;

    private Date now=new Date();
    @GetMapping("/")
    public String MainPage(Model model){
        List<CompList> compListPast=complistService.getListPast(now);
        List<CompList> compListToday=complistService.getListToday(now);
        List<CompList> compListFuture=complistService.getListFuture(now);
        model.addAttribute("pastList",compListPast);
        model.addAttribute("todayList",compListToday);
        model.addAttribute("futureList",compListFuture);
        return "index";
    }

    @GetMapping("/index")
    public String Index(Model model){
        List<CompList> compListPast=complistService.getListPast(now);
        List<CompList> compListToday=complistService.getListToday(now);
        List<CompList> compListFuture=complistService.getListFuture(now);
        model.addAttribute("pastList",compListPast);
        model.addAttribute("todayList",compListToday);
        model.addAttribute("futureList",compListFuture);
        return "index";
    }

    @GetMapping("/round")
    public String Round(@RequestParam(name="compIdx") int compIdx , Model model){
        CompList comp=complistService.getOne(compIdx);
        List<Round> roundPast=roundService.getRoundPast(now, compIdx);
        List<Round> roundNow=roundService.getRoundNow(now, compIdx);
        List<Round> roundFuture=roundService.getRoundFuture(now, compIdx);
        model.addAttribute("comp",comp);
        model.addAttribute("pastList",roundPast);
        model.addAttribute("nowList",roundNow);
        model.addAttribute("futureList",roundFuture);
        model.addAttribute("compIdx",compIdx);
        return "round";
    }

    @GetMapping("/makecomp")
    public String MakeComp(Model model){
        model.addAttribute("compList",new CompListDTO());
        return "makecomp";
    }

    @PostMapping("/makecomp")
    public String NewComp(@ModelAttribute("compList")CompListDTO compList){
        int index=complistService.create(compList.toEntity());
        int countRound=complistService.getOne(index).getCountRound();
        return "redirect:/makeround?countRound="+countRound+"&compIdx="+index;
    }

    @PostMapping("/deletecomp")
    public String DeleteComp(@RequestParam(name="idx") int idx){
        roundService.deleteRound(idx);
        complistService.deleteByIdx(idx);
        return "redirect:/";
    }
    @GetMapping("/makeround")
    public String MakeRound(@RequestParam(name="countRound") int countRound, @RequestParam(name="compIdx") int compIdx, Model model){
        model.addAttribute("countRound", countRound);
        RoundDTO round[]=new RoundDTO[countRound];
        for(int i=0; i<countRound; i++){
            round[i]=new RoundDTO();
        }
        model.addAttribute("round", round);
        return "makeround";
    }

    @PostMapping("/makeround")
    public String NewRound(@ModelAttribute Round round){

        return "redirect:/";
    }
    @GetMapping("/myrank")
    public String MyRank(Model model){
        return "myrank";
    }
    @GetMapping("/record")
    public String Record(@RequestParam(name="compIdx") int compIdx, @RequestParam(name="roundIdx") int roundIdx, Model model){
        CompList comp=complistService.getOne(compIdx);
        Round round=roundService.getOne(roundIdx);
        List<Participate> participates=participateService.getParticipate(roundIdx);
        model.addAttribute("comp",comp);
        model.addAttribute("round",round);
        model.addAttribute("partList",participates);
        return "record";
    }
    @GetMapping("/recordcomp")
    public String RecordComp(Model model){
        return "recordcomp";
    }
    @GetMapping("/recordlist")
    public String RecordList(Model model){
        return "register";
    }

    @GetMapping("/register")
    public String Register(Model model){
        return "register";
    }
    @GetMapping("/confirm")
    public String Confirm(Model model){
        return "confirm";
    }
}
