package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.transaction.AfterTransaction;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @Test
    void 회원가입() {
        //given
        Member member1 = new Member();
        member1.setName("김철수");

        //when
        Long id = memberService.join(member1);

        Member result = memoryMemberRepository.findById(member1.getId()).get();
        //then
        Assertions.assertThat(result.getId()).isEqualTo(id);
    }

    @Test
    void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("김철수");

        Member member2 = new Member();
        member2.setName("김철수");

        //when
        memberService.join(member1);
        IllegalStateException iegalStateException = assertThrows(IllegalStateException.class,
                () -> {
                    memberService.join(member2);
                });

        Assertions.assertThat(iegalStateException.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}