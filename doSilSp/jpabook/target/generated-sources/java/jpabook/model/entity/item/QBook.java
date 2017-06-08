package jpabook.model.entity.item;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 564315336L;

    public static final QBook book = new QBook("book");

    public final QItem _super = new QItem(this);

    public final StringPath author = createString("author");

    //inherited
    public final ListPath<jpabook.model.entity.Category, jpabook.model.entity.QCategory> categories = _super.categories;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final StringPath isbn = createString("isbn");

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

    public QBook(String variable) {
        super(Book.class, forVariable(variable));
    }

    public QBook(Path<? extends Book> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook(PathMetadata<?> metadata) {
        super(Book.class, metadata);
    }

}

