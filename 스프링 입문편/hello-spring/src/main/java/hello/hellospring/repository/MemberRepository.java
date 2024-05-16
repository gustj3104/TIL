package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}

/*
인터페이스: 사물 간 또는 인간 간의 의사소통이 가능하도록 일시적/영속적 접근을 목적으로 만들어진 물리적, 가상적 매개체
save()
Optional: null일 때 오류를 방지하기 위해 사용
서비스는 회원 정보를 매개로 함수 실행
서비스 ---> 멤버리포지토리 <---메모리멤버리포지토리
 */