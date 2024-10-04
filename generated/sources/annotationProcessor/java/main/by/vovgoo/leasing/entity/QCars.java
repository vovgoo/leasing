package by.vovgoo.leasing.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCars is a Querydsl query type for Cars
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCars extends EntityPathBase<Cars> {

    private static final long serialVersionUID = 1207834150L;

    public static final QCars cars = new QCars("cars");

    public final EnumPath<by.vovgoo.leasing.entity.enums.CarStatus> carStatus = createEnum("carStatus", by.vovgoo.leasing.entity.enums.CarStatus.class);

    public final StringPath color = createString("color");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final StringPath make = createString("make");

    public final NumberPath<Double> mileage = createNumber("mileage", Double.class);

    public final StringPath model = createString("model");

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QCars(String variable) {
        super(Cars.class, forVariable(variable));
    }

    public QCars(Path<? extends Cars> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCars(PathMetadata metadata) {
        super(Cars.class, metadata);
    }

}

