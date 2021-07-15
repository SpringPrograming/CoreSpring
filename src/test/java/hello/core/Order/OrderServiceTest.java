package hello.core.Order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "jongyun", Grade.VIP);
        memberService.join(member);

        //when
        Order item1 = orderService.createOrder(memberId, "item1", 10000);

        //then
        Assertions.assertThat(item1.getItemPrice() - 1000).isEqualTo(item1.calculatePrice());


    }
}
