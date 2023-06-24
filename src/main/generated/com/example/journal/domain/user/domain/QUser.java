package com.example.journal.domain.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1972316300L;

    public static final QUser user = new QUser("user");

    public final StringPath accountId = createString("accountId");

    public final EnumPath<com.example.journal.global.enums.Authority> authority = createEnum("authority", com.example.journal.global.enums.Authority.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath intro = createString("intro");

    public final StringPath password = createString("password");

    public final ListPath<com.example.journal.domain.post.domain.Posts, com.example.journal.domain.post.domain.QPosts> posts = this.<com.example.journal.domain.post.domain.Posts, com.example.journal.domain.post.domain.QPosts>createList("posts", com.example.journal.domain.post.domain.Posts.class, com.example.journal.domain.post.domain.QPosts.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

