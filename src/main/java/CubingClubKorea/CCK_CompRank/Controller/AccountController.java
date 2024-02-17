package CubingClubKorea.CCK_CompRank.Controller;

import CubingClubKorea.CCK_CompRank.DTO.AccountDTO;
import CubingClubKorea.CCK_CompRank.DTO.AccountRequest;
import CubingClubKorea.CCK_CompRank.Service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/login")
    public String login(@RequestParam(required = false, value="hasMessage") boolean hasMessage,
                        @RequestParam(required = false, value="message") String message,
                        Model model){
        model.addAttribute("hasMessage", hasMessage);
        model.addAttribute("message", message);
        model.addAttribute("login", new AccountRequest());
        return "login";
    }

    @GetMapping("/join")
    public String join(Model model){
        model.addAttribute("joinRequest", new AccountDTO());
        return "join";
    }

    @PostMapping("/join")
    public String addJoin(@ModelAttribute AccountDTO accountDTO, BindingResult bindingResult, Model model){
        if(accountService.checkEmailDuplicate(accountDTO.getEmail())) {
            bindingResult.addError(new FieldError("joinRequest", "loginId", "로그인 아이디가 중복됩니다."));
            System.out.println("중복");
        }
        if(bindingResult.hasErrors()) {
            return "join";
        }
        accountService.join(accountDTO);
        return "redirect:/";
    }
}
