package com.irgek.Treydit.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QAddress extends BeanPath<Address> {

    private static final long serialVersionUID = -428496846L;

    public static final QAddress address = new QAddress("address");

    public final NumberPath<Integer> blocknumber = createNumber("blocknumber", Integer.class);

    public final NumberPath<Integer> doornumber = createNumber("doornumber", Integer.class);

    public final NumberPath<Integer> housenumber = createNumber("housenumber", Integer.class);

    public final StringPath street = createString("street");

    public final NumberPath<Integer> zipcode = createNumber("zipcode", Integer.class);

    public QAddress(String variable) {
        super(Address.class, forVariable(variable));
    }

    public QAddress(Path<? extends Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddress(PathMetadata metadata) {
        super(Address.class, metadata);
    }

}

