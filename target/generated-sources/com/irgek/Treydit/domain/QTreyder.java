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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTreyder treyder = new QTreyder("treyder");

    public final org.springframework.data.jpa.domain.QAbstractPersistable _super = new org.springframework.data.jpa.domain.QAbstractPersistable(this);

    public final QAddress address;

    public final DatePath<java.time.LocalDate> birthDate = createDate("birthDate", java.time.LocalDate.class);

    public final QCity city;

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

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final DateTimePath<java.time.LocalDateTime> updated = createDateTime("updated", java.time.LocalDateTime.class);

    public final StringPath username = createString("username");

    public QTreyder(String variable) {
        this(Treyder.class, forVariable(variable), INITS);
    }

    public QTreyder(Path<? extends Treyder> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTreyder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTreyder(PathMetadata metadata, PathInits inits) {
        this(Treyder.class, metadata, inits);
    }

    public QTreyder(Class<? extends Treyder> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
        this.city = inits.isInitialized("city") ? new QCity(forProperty("city"), inits.get("city")) : null;
    }

}

