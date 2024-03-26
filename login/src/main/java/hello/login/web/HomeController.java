package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.argumentResolver.Login;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

   // @GetMapping("/")
    public String home(@CookieValue(name = "memberId", required = false) Long memberId, Model model){
        if(memberId == null){
            return "home";
        }

        Member byId = memberRepository.findById(memberId);
        if(byId == null){
            return "home";
        }

        model.addAttribute("member", byId);
        return "loginHome";
    }

  //  @GetMapping("/")
    public String homeV2(HttpServletRequest request, Model model){
        Member member = (Member)sessionManager.getSession(request);

        if(member == null){
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }

   // @GetMapping("/")
    public String homeV3(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        if(session == null){
            return "home";
        }

        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(member == null){
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }



//    @GetMapping("/")
    public String homeV4(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member member, Model model){
        if(member == null){
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }

    @GetMapping("/")
    public String homeV5(@Login Member member, Model model){
        if(member == null){
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }
}