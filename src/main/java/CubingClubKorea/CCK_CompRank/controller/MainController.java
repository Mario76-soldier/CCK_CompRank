package CubingClubKorea.CCK_CompRank.controller;


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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "makecomp";
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
        return "recordlist";
    }
    @GetMapping("/recordround")
    public String RecordRound(Model model){
        return "recordround";
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
