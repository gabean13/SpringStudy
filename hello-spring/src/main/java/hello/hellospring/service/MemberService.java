package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemoryMemberRepository repository;


    public MemberService(MemoryMemberRepository memoryMemberRepository){
        repository = memoryMemberRepository;
    }
    //회원가입
    public Long join(Member member){
        validateDuplicateMember(member);    //중복회원검사
        repository.saveMember(member);
        return member.getId();

    }
    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName()).ifPresent(
                m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체회원조회
    public List<Member> findMembers(){
        return repository.findAll();
    }

    //아이디로 회원조회
    public Optional<Member> findOne(Long id){
        return repository.findById(id);
    }
}
