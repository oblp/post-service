package cn.eastack.article.domain.tag;

import cn.eastack.article.adapter.db.TagRepositoryImpl;
import com.google.inject.ImplementedBy;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.sqlclient.RowSet;

@ImplementedBy(TagRepositoryImpl.class)
public interface TagRepository {
     Future<RowSet<Tag>> getTag(Vertx vertx);
}
