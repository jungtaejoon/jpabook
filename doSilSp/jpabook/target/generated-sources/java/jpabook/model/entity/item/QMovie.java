package jpabook.model.entity.item;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QMovie is a Querydsl query type for Movie
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMovie extends EntityPathBase<Movie> {

    private static final long serialVersionUID = 324071729L;

    public static final QMovie movie = new QMovie("movie");

    public final QItem _super = new QItem(this);

    public final StringPath actor = createString("actor");

    //inherited
    public final ListPath<jpabook.model.entity.Category, jpabook.model.entity.QCategory> categories = _super.categories;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final StringPath director = createString("director");

    //inherited
    public final NumberPath<Long> itemId = _super.itemId;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedDate = _super.lastModifiedDate;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Integer> price = _super.price;

    //inherited
    public final NumberPath<Integer> stockQuantity = _super.stockQuantity;

    public QMovie(String variable) {
        super(Movie.class, forVariable(variable));
    }

    public QMovie(Path<? extends Movie> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovie(PathMetadata<?> metadata) {
        super(Movie.class, metadata);
    }

}

