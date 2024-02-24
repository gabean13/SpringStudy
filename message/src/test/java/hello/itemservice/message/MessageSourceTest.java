package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    public MessageSource ms;

    @Test
    void helloMessage(){
        String message = ms.getMessage("hello", null, null);
        assertThat(message).isEqualTo("안녕");
    }

    @Test
    void noMessageFound(){
        assertThatThrownBy(() -> ms.getMessage("no-code", null, null)).isInstanceOf(NoSuchMessageException.class);
    }
    @Test
    void noMessageFoundDefaultMessage(){
        String message = ms.getMessage("no-code", null, "default", null);
        assertThat(message).isEqualTo("default");
    }

    @Test
    void argMessage(){
        String message = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
        assertThat(message).isEqualTo("안녕 Spring");
    }

    @Test
    void KOMessage(){
        assertThat(ms.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
    }

    @Test
    void ENMessage(){
        assertThat(ms.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
    }
}
