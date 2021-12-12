package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // final keyword 가 달린 멤버 변수의 생성자를 만들어준다.
public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  // 생성자가 하나 일경우에는 Autowired 를 생략해도 됨
//  @Autowired
//  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//    System.out.println("memberRepository = " + memberRepository);
//    System.out.println("discountPolicy = " + discountPolicy);
//    this.memberRepository = memberRepository;
//    this.discountPolicy = discountPolicy;
//  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  // Test
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
