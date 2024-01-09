package CubingClubKorea.CCK_CompRank.controller;


import CubingClubKorea.CCK_CompRank.Service.CompListService;
import CubingClubKorea.CCK_CompRank.entity.CompList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private final CompListService complistService;

    private Date now=new Date();

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
    public String Round(Model model){
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
    public String Record(Model model){
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
