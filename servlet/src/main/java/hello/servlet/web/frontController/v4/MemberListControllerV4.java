package hello.servlet.web.frontController.v4;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4{

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);

        return "members";
    }
}
