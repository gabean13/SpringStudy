package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        Member member = new Member(1L, "member1", Grade.VIP);

        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        int fixDiscountPrice = discountService.discountService(member, 10000, "fixDiscountPolicy");
        int rateDiscountPrice = discountService.discountService(member, 15000, "rateDiscountPolicy");

        Assertions.assertThat(fixDiscountPrice).isEqualTo(1000);
        Assertions.assertThat(rateDiscountPrice).isEqualTo(1500);
    }

    @RequiredArgsConstructor
    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;

        public int discountService(Member member, int price, String discountCode){
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            int discountPrice = discountPolicy.discount(member, price);
            return discountPrice;
        }
    }
}
