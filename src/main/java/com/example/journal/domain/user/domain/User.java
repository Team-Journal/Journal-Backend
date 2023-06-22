package com.example.journal.domain.user.domain;

import com.example.journal.domain.post.domain.Posts;
import com.example.journal.global.enums.Authority;
import com.mysql.cj.xdevapi.Collection;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    @NotNull
    @Size(min = 4, max = 15)
    private String accountId;

    @Column
    @NotNull
    @Size(min = 8)
    private String password;

    @Column
    @NotNull
    private Authority authority;

    @Column
    @Size(max = 40)
    private String intro;
    
    @OneToMany(mappedBy = "user")
    private List<Posts> posts;


    @Builder
    public User(Long id, String email, String accountId, String password, Authority authority, String intro){
        this.id = id;
        this.email = email;
        this.accountId = accountId;
        this.password = password;
        this.authority = authority;
        this.intro = intro;
    }

    public User updateIntro(String intro){
        this.intro = intro;
        return this;
    }
}
