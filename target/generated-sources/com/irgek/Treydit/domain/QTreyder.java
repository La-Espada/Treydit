package com.irgek.Treydit.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTreyder is a Querydsl query type for Treyder
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTreyder extends EntityPathBase<Treyder> {

    private static final long serialVersionUID = -343857315L;

    public static final QTreyder treyder = new QTreyder("treyder");

    public final DateTimePath<java.time.LocalDateTime> created = createDateTime("created", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final StringPath firstname = createString("firstname");

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Item, QItem> items = this.<Item, QItem>createList("items", Item.class, QItem.class, PathInits.DIRECT2);

    public final StringPath lastname = createString("lastname");

    public final StringPath password = createString("password");

    public final StringPath phonenumber = createString("phonenumber");

    public final EnumPath<Reputation> reputation = createEnum("reputation", Reputation.class);

    public final SetPath<Role, QRole> roles = this.<Role, QRole>createSet("roles", Role.class, QRole.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> updated = createDateTime("updated", java.time.LocalDateTime.class);

    public final StringPath username = createString("username");

    public QTreyder(String variable) {
        super(Treyder.class, forVariable(variable));
    }

    public QTreyder(Path<? extends Treyder> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTreyder(PathMetadata metadata) {
        super(Treyder.class, metadata);
    }

}

