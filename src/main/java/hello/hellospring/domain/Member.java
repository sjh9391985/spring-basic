package hello.hellospring.domain;

public class Member {

    // 요구사항
    // 1. 식별자(데이터를 구분하기 이한 시스템이 정의한 id)
    // 2. 이름

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
