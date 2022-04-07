package com.irgek.Treydit.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPhonenumber is a Querydsl query type for Phonenumber
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPhonenumber extends BeanPath<Phonenumber> {

    private static final long serialVersionUID = 669092725L;

    public static final QPhonenumber phonenumber = new QPhonenumber("phonenumber");

    public final StringPath country_code = createString("country_code");

    public final StringPath serialnumber = createString("serialnumber");

    public QPhonenumber(String variable) {
        super(Phonenumber.class, forVariable(variable));
    }

    public QPhonenumber(Path<? extends Phonenumber> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPhonenumber(PathMetadata metadata) {
        super(Phonenumber.class, metadata);
    }

}

