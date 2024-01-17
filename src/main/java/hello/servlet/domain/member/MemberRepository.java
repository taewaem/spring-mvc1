package hello.servlet.domain.member;

import javax.sound.midi.MetaMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    //동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();


    //무조건 이것으로 조회해야 한다.
    public static MemberRepository getInstance(){
        return instance;
    }

    //싱글톤을 생성할 때는 private로 생성자를 아무나 생성하지 못하게 막아야한다.
    private MemberRepository(){

    }

    public static Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    //Id로 객체 조회
    public Member findById(Long id) {
        return store.get(id);
    }

    //전체 조회
    public List<Member> findALl() {
        return new ArrayList<>(store.values());
    }

    //데이터를 다 날려버림.
    public void clearStore(){
        store.clear();
    }
}