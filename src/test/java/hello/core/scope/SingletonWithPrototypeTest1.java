package hello.core.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {

  @Test
  void prototypeFind() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        PrototypeBean.class);

    PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
    bean1.addCount();
    PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
    bean2.addCount();

    Assertions.assertThat(bean1.getCount()).isEqualTo(1);
    Assertions.assertThat(bean2.getCount()).isEqualTo(1);
  }

  @Test
  void singletonClientUseProtoType() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        PrototypeBean.class, ClientBean.class);

    ClientBean bean1 = ac.getBean(ClientBean.class);
    ClientBean bean2 = ac.getBean(ClientBean.class);
    int count1 = bean1.logic();
    int count2 = bean2.logic();

    Assertions.assertThat(count1).isEqualTo(1);
    Assertions.assertThat(count2).isEqualTo(2);

  }

  @Scope("singleton")
  static class ClientBean {
    private final PrototypeBean protoTypeBean;

    @Autowired
    public ClientBean(PrototypeBean prototypeBean) {
      this.protoTypeBean = prototypeBean;
    }

    public int logic() {
      protoTypeBean.addCount();
      return protoTypeBean.getCount();
    }
  }

  @Scope("prototype")
  static class PrototypeBean {
    private int count = 0;

    public void addCount() {
      count++;
    }

    public int getCount() {
      return count;
    }

    @PostConstruct
    public void init() {
      System.out.println("count = " + count);
    }

    @PreDestroy
    public void destroy() {
      System.out.println("destroy");
    }
  }

}
