package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 함")
    void vip_o(){
        //given
        Member member1 = new Member(1L, "member1", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member1, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("BASIC은 할인이 0원이어야함")
    void vip_x(){
        //given
        Member member2 = new Member(2L, "member2", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member2, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}