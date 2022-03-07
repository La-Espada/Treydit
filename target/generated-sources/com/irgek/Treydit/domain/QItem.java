package com.irgek.Treydit.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = 227739541L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItem item = new QItem("item");

    public final org.springframework.data.jpa.domain.QAbstractPersistable _super = new org.springframework.data.jpa.domain.QAbstractPersistable(this);

    public final EnumPath<Category> category = createEnum("category", Category.class);

    public final NumberPath<Double> cost = createNumber("cost", Double.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<Condition> itemCondition = createEnum("itemCondition", Condition.class);

    public final StringPath name = createString("name");

    public final QTreyder treyder;

    public QItem(String variable) {
        this(Item.class, forVariable(variable), INITS);
    }

    public QItem(Path<? extends Item> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItem(PathMetadata metadata, PathInits inits) {
        this(Item.class, metadata, inits);
    }

    public QItem(Class<? extends Item> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.treyder = inits.isInitialized("treyder") ? new QTreyder(forProperty("treyder"), inits.get("treyder")) : null;
    }

}

