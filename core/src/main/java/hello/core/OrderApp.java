package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member1 = new Member(memberId, "gabin", Grade.VIP);
        memberService.join(member1);

        Order order = orderService.createOrder(memberId, "book", 15000);
        System.out.println(order);

    }
}
