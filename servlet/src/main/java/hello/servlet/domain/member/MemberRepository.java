package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Long memberId = 0L;
    private static Map<Long, Member> store = new HashMap<>();
    private static final MemberRepository memberRepository = new MemberRepository();

    public MemberRepository() {
    }

    public static MemberRepository getInstance(){
        return memberRepository;
    }

    public Member save(Member member){
        member.setId(++memberId);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List findAll() {
        return new ArrayList(store.values());
    }

    public void clear(){
        store.clear();
    }
}
