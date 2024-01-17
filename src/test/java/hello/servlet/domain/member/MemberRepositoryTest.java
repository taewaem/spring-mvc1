package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    //싱글톤이기 때문에 new를 쓸 필요가 없다.(스프링은 싱글톤을 보장한다.)
    MemberRepository memberRepository = MemberRepository.getInstance();

    //하나의 테스트가 끝나면 자동적으로 생성된다.
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member savedMember = MemberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        MemberRepository.save(member1);
        MemberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findALl();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1, member2 );

    }
}
