package com.example.journal.domain.user.domain;

import com.example.journal.global.enums.Authority;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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


    @Builder
    public User(Long id, String email, String accountId, String password, Authority authority, String intro){
        this.id = id;
        this.email = email;
        this.accountId = accountId;
        this.password = password;
        this.authority = authority;
        this.intro = intro;
    }
}