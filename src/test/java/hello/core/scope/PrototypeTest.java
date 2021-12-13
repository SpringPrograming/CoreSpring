package hello.core.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

  @Test
  void prototypeBeanFind() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        ProtoTypeBean.class);

    ProtoTypeBean bean1 = ac.getBean(ProtoTypeBean.class);
    ProtoTypeBean bean2 = ac.getBean(ProtoTypeBean.class);

    Assertions.assertThat(bean1).isNotSameAs(bean2);

    ac.close();
  }

  @Scope("prototype")
  static class ProtoTypeBean {

    @PostConstruct
    public void init() {
      System.out.println("init");
    }

    @PreDestroy
    public void destroy() {
      System.out.println("destroy");
    }
  }


}
