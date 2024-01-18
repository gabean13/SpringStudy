package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 컨테이너에서 stateful 필드가 있는 경우")
    void orderTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulConfig.class);

        StatefulService statefulService = ac.getBean("statefulService", StatefulService.class);
        statefulService.order("멤버1", 10000);
        statefulService.order("멤버2", 20000);

        Assertions.assertThat(statefulService.getPrice()).isEqualTo(20000);
    }

    @Configuration
    static class StatefulConfig {

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}