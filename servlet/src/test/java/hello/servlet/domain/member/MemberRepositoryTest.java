package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    public void afterEach(){
        memberRepository.clear();
    }
    @Test
    public void save(){
        //given
        Member member = new Member("hello", 20);
        //when
        memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(member.getId());
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    public void findAllMember(){
        Member member1 = new Member("hello", 20);
        Member member2 = new Member("hello2", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        Assertions.assertThat(memberRepository.findAll().size()).isEqualTo(2);
        Assertions.assertThat(memberRepository.findAll()).contains(member1, member2);
    }

}