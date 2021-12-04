package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        MemberService memberService = config.memberService();
        Member member1 = new Member(1L, "jongyun", Grade.BASIC);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("member1 = " + member1.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}


