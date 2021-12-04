package hello.core.Order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig config = new AppConfig();
        memberService = config.memberService();
        orderService = config.orderService();
    }

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
