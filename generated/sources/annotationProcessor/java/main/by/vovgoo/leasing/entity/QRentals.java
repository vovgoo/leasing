package by.vovgoo.leasing.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRentals is a Querydsl query type for Rentals
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRentals extends EntityPathBase<Rentals> {

    private static final long serialVersionUID = -110240920L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRentals rentals = new QRentals("rentals");

    public final QCars cars;

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<by.vovgoo.leasing.entity.enums.RentalsStatus> rentalsStatus = createEnum("rentalsStatus", by.vovgoo.leasing.entity.enums.RentalsStatus.class);

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public final QUser user;

    public QRentals(String variable) {
        this(Rentals.class, forVariable(variable), INITS);
    }

    public QRentals(Path<? extends Rentals> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRentals(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRentals(PathMetadata metadata, PathInits inits) {
        this(Rentals.class, metadata, inits);
    }

    public QRentals(Class<? extends Rentals> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cars = inits.isInitialized("cars") ? new QCars(forProperty("cars")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

