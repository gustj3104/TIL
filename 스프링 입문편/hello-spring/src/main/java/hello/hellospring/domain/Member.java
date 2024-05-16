package hello.hellospring.domain;

public class Member {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
get --> id, name 조회(리턴)
접근제한자: public
리턴 타입: 필드의 리턴 타입
메소드 이름: get+필드네임
리턴값: 필드값

set --> id, name 설정 (변경하지 못하도록 하려면 세터 메서드는 private 접근 제한을 갖도록 설정)
접근제한지: public
리턴 타임: void
메서드 이름: set+필드네임
매개 변수 타입: 필드타입
 */