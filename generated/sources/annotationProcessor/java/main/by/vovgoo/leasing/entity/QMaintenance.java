package by.vovgoo.leasing.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMaintenance is a Querydsl query type for Maintenance
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMaintenance extends EntityPathBase<Maintenance> {

    private static final long serialVersionUID = 1637036588L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMaintenance maintenance = new QMaintenance("maintenance");

    public final QCars cars;

    public final NumberPath<Double> cost = createNumber("cost", Double.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath serviceName = createString("serviceName");

    public QMaintenance(String variable) {
        this(Maintenance.class, forVariable(variable), INITS);
    }

    public QMaintenance(Path<? extends Maintenance> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMaintenance(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMaintenance(PathMetadata metadata, PathInits inits) {
        this(Maintenance.class, metadata, inits);
    }

    public QMaintenance(Class<? extends Maintenance> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cars = inits.isInitialized("cars") ? new QCars(forProperty("cars")) : null;
    }

}

