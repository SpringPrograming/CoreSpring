package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "jongyun", Grade.VIP);
        memberService.join(member);

        OrderService orderService = new OrderServiceImpl();
        Order item1 = orderService.createOrder(member.getId(), "item1", 7000);
        System.out.println("item1 = " + item1);
        System.out.println("discount price = " + item1.calculatePrice() );

    }
}
