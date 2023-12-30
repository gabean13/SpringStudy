package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    @AfterEach
    public void clearRepository(){
        repository.clear();
    }

    @Test
    public void save(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.saveMember(member1);

        Member result = repository.findById(member1.getId()).get();
        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.saveMember(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.saveMember(member2);

        Member result = repository.findByName("spring2").get();

        assertThat(member2).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.saveMember(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.saveMember(member2);

        Member member3 = new Member();
        member3.setName("spring3");
        repository.saveMember(member3);

        assertThat(repository.findAll().size()).isEqualTo(3);
    }
}
