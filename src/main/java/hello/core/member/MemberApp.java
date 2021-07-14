package hello.core.member;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member1 = new Member(1L, "jongyun", Grade.BASIC);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("member1 = " + member1.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}


