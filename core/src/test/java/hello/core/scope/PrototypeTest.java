package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    public void findPrototypeBeanTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeClass.class);
        PrototypeClass bean1 = ac.getBean(PrototypeClass.class);
        PrototypeClass bean2 = ac.getBean(PrototypeClass.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);

        Assertions.assertThat(bean1).isNotSameAs(bean2);

        ac.close();
    }

    @Scope("prototype")
    static class PrototypeClass{
        @PostConstruct
        public void init(){
            System.out.println("PrototypeClass.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeClass.destroy");
        }
    }
}
