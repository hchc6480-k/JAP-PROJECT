package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @Embedded // 값 타입을 정의하는 곳에 표시
    private Address address;

    @JsonIgnore // 결과 값에 데이터 안보이게
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
