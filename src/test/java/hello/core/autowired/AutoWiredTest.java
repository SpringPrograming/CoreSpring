package hello.core.autowired;

import hello.core.member.Member;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

public class AutoWiredTest {

  @Test
  void AutoWiredOption() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
  }

  static class TestBean {

    // 자동주입할 대상이 없으면 수정자 메서드 자체가 호출안됨
    @Autowired(required = false)
    public void setNoBean1(Member member1) {
      System.out.println("member1 = " + member1);
    }

    @Autowired
    public void setBean2(@Nullable Member member2) {
      System.out.println("member2 = " + member2);
    }

    @Autowired
    public void setBean3(Optional<Member> member3) {
      System.out.println("member3 = " + member3);
    }
  }
}
