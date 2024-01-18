package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingleTonTest {
    @Test
    void pureDiContainerTest(){
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singleTonTest(){
        SingleTonService singleTonService1 = SingleTonService.getInstance();
        SingleTonService singleTonService2 = SingleTonService.getInstance();

        Assertions.assertThat(singleTonService1).isSameAs(singleTonService2);
    }

    @Test
    @DisplayName("싱글톤 컨테이너 사용 시 빈이 싱글톤 패턴으로 생성되야함")
    void singleTonContainerTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService1).isSameAs(memberService2);

    }
}
