package jpabook.model.entity.item;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = 564528370L;

    public static final QItem item = new QItem("item");

    public final jpabook.model.entity.QBaseEntity _super = new jpabook.model.entity.QBaseEntity(this);

    public final ListPath<jpabook.model.entity.Category, jpabook.model.entity.QCategory> categories = this.<jpabook.model.entity.Category, jpabook.model.entity.QCategory>createList("categories", jpabook.model.entity.Category.class, jpabook.model.entity.QCategory.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> stockQuantity = createNumber("stockQuantity", Integer.class);

    public QItem(String variable) {
        super(Item.class, forVariable(variable));
    }

    public QItem(Path<? extends Item> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItem(PathMetadata<?> metadata) {
        super(Item.class, metadata);
    }

}

