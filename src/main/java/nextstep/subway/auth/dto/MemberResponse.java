package nextstep.subway.auth.dto;

public class MemberResponse {
    private Long id;
    private String email;
    private Integer age;

    public MemberResponse(Long id, String email, Integer age) {
        this.id = id;
        this.email = email;
        this.age = age;
    }

//    public static MemberResponse of(Member member) {
//        return new MemberResponse(member.getId(), member.getEmail(), member.getName());
//    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }
}
