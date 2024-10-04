package by.vovgoo.leasing.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSupport is a Querydsl query type for Support
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSupport extends EntityPathBase<Support> {

    private static final long serialVersionUID = 1237070696L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSupport support = new QSupport("support");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath subject = createString("subject");

    public final QUser user;

    public QSupport(String variable) {
        this(Support.class, forVariable(variable), INITS);
    }

    public QSupport(Path<? extends Support> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSupport(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSupport(PathMetadata metadata, PathInits inits) {
        this(Support.class, metadata, inits);
    }

    public QSupport(Class<? extends Support> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

