package hello.core.dicount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private final int discountPercent = 10;


    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? price * discountPercent / 100 : 0;
    }
}