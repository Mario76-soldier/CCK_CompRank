package CubingClubKorea.CCK_CompRank.Controller;


import CubingClubKorea.CCK_CompRank.DTO.CompListDTO;
import CubingClubKorea.CCK_CompRank.DTO.ParticipateDTO;
import CubingClubKorea.CCK_CompRank.DTO.RoundDTO;
import CubingClubKorea.CCK_CompRank.Service.CompListService;
import CubingClubKorea.CCK_CompRank.Service.ParticipateService;
import CubingClubKorea.CCK_CompRank.Service.RoundService;
import CubingClubKorea.CCK_CompRank.Entity.CompList;
import CubingClubKorea.CCK_CompRank.Entity.Participate;
import CubingClubKorea.CCK_CompRank.Entity.Round;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import CubingClubKorea.CCK_CompRank.Structure.MultRound;
import CubingClubKorea.CCK_CompRank.Structure.Recorder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
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

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/makecomp")
    public String MakeComp(Model model){
        model.addAttribute("compList",new CompListDTO());
        return "makecomp";
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/makecomp")
    public String NewComp(@ModelAttribute("compList")CompListDTO compList){
        int index=complistService.create(compList.toEntity());
        int countRound=complistService.getOne(index).getCountRound();
        return "redirect:/makeround?countRound="+countRound+"&compIdx="+index;
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/deletecomp")
    public String DeleteComp(@RequestParam(name="idx") int idx){
        roundService.deleteRound(idx);
        complistService.deleteByIdx(idx);
        return "redirect:/";
    }
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/makeround")
    public String MakeRound(@RequestParam(name="countRound") int countRound, @RequestParam(name="compIdx") int compIdx, Model model){
        model.addAttribute("countRound", countRound);
        MultRound round=new MultRound();
        model.addAttribute("round", round);
        model.addAttribute("compIdx", compIdx);
        return "makeround";
    }
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/makeround")
    public String NewRound(@ModelAttribute MultRound round, @RequestParam(name="compIdx")int compIdx) throws ParseException {
        System.out.println(round.getCompIdx().get(0));
        for(int i=0; i<round.getEventStart().length; i++){
            RoundDTO roundDTO=new RoundDTO();
            roundDTO.setCompIdx(compIdx);
            roundDTO.setSeq(i+1);
            roundDTO.setRound(round.getRound().get(i));
            roundDTO.setEventName(round.getEventName().get(i));
            roundDTO.setEventStart(formatter.parse(round.getEventStart()[i]));
            roundDTO.setEventEnd(formatter.parse(round.getEventEnd()[i]));
            roundDTO.setAdvance(round.getAdvance().get(i));
            roundService.newRound(roundDTO.toEntity());
        }
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
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/recordcomp")
    public String RecordComp(@RequestParam(name="compIdx") int compIdx, @RequestParam(name="roundIdx") int roundIdx, @RequestParam(required = false, name = "search")String search, Model model){
        CompList comp=complistService.getOne(compIdx);
        Round round=roundService.getOne(roundIdx);
        List<Participate> participates;
        if(search==null) {
            participates = participateService.getParticipate(roundIdx);
        }
        else{
            participates=participateService.getSearchedParticipate(roundIdx, search);
        }
        model.addAttribute("compIdx",compIdx);
        model.addAttribute("roundIdx",roundIdx);
        model.addAttribute("comp",comp);
        model.addAttribute("round",round);
        model.addAttribute("partList",participates);
        Recorder recorder=new Recorder();
        model.addAttribute("recorder",recorder);
        return "recordcomp";
    }
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/recordcomp")
    public String UpdateRecord(@ModelAttribute Recorder recorder, @RequestParam(name="compIdx") int compIdx, @RequestParam(name="roundIdx") int roundIdx, @RequestParam(name="idx")int idx)throws ParseException{
        participateService.updateRecordAo5(recorder,idx);
        return "redirect:/recordcomp?compIdx="+compIdx+"&roundIdx="+roundIdx;
    }
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/updateadvance")
    public String UpdateAdvance(@RequestParam(name="compIdx") int compIdx, @RequestParam(name="roundIdx")int roundIdx, Model model, HttpServletRequest request){
        roundService.updateAdvance(roundIdx,Integer.parseInt(request.getParameter("advance")));
        return "redirect:/recordcomp?compIdx="+compIdx+"&roundIdx="+roundIdx;
    }
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/deleterecord")
    public String UpdateRecord(@RequestParam(name="compIdx") int compIdx, @RequestParam(name="roundIdx") int roundIdx, @RequestParam(name="idx")int idx)throws ParseException{
        participateService.deleteParticipate(idx);
        return "redirect:/recordcomp?compIdx="+compIdx+"&roundIdx="+roundIdx;
    }
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/addparticipate")
    public String AddParticipate(@RequestParam(name="compIdx") int compIdx, @RequestParam(name="roundIdx") int roundIdx, Model model){
        CompList comp=complistService.getOne(compIdx);
        Round round=roundService.getOne(roundIdx);
        model.addAttribute("compIdx",compIdx);
        model.addAttribute("roundIdx",roundIdx);
        model.addAttribute("comp",comp);
        model.addAttribute("round",round);
        model.addAttribute("participate",new ParticipateDTO());
        return "addparticipate";
    }
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/addparticipate")
    public String AddingParticipate(@ModelAttribute("participate")ParticipateDTO participate, @RequestParam(name="compIdx") int compIdx, @RequestParam(name="roundIdx") int roundIdx){
        participateService.addParticipate(participate.toEntity());
        return "redirect:/recordcomp?compIdx="+compIdx+"&roundIdx="+roundIdx;
    }
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/advance")
    public String Advance(@RequestParam(name="compIdx")int compIdx, @RequestParam(name="roundIdx")int roundIdx, Model model){
        List<Round> list=roundService.getCompRound(compIdx);
        model.addAttribute("compIdx", compIdx);
        model.addAttribute("roundIdx",roundIdx);
        model.addAttribute("list",list);
        return "advance";
    }
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/advance")
    public String sendAdvance(@RequestParam(name="compIdx")int compIdx, @RequestParam(name="pastRoundIdx")int pastRoundIdx,  @RequestParam(name="nowRoundIdx")int nowRoundIdx){
        Round past=roundService.getOne(pastRoundIdx);
        List<Participate> list=participateService.getParticipate(pastRoundIdx);
        for(int i=0; i<past.getAdvance(); i++){
            Participate p=list.get(i);
            Participate advance=new Participate(p.getUserName(), p.getEmail(), p.getEventName(), nowRoundIdx);
            participateService.addParticipate(advance);
        }
        return "redirect:/round?compIdx="+compIdx;
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
