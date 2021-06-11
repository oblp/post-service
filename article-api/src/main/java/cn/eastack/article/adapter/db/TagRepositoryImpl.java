package cn.eastack.article.adapter.db;

import cn.eastack.article.domain.tag.Tag;
import cn.eastack.article.domain.tag.TagRepository;
import com.google.inject.Singleton;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.*;
import io.vertx.sqlclient.templates.RowMapper;
import io.vertx.sqlclient.templates.SqlTemplate;

import java.util.HashMap;

@Singleton
public class TagRepositoryImpl implements TagRepository {
    PgConnectOptions connectOptions = new PgConnectOptions()
        .setPort(5432)
        .setHost("localhost")
        .setDatabase("postgres")
        .setUser("eastack")
        .setPassword("helloworld");

    // Pool options
    PoolOptions poolOptions = new PoolOptions()
        .setMaxSize(5);


    public Future<RowSet<Tag>> getTag(Vertx vertx) {
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("id", 1);
        parameter.put("name", "java");

        RowMapper<Tag> ROW_TAG_MAPPER = row -> {
            Tag tag = new Tag();
            tag.setName(row.getString("name"));
            tag.setId(row.getInteger("id"));
            return tag;
        };

        // Create the client pool
        SqlClient client = PgPool.pool(vertx, connectOptions, poolOptions);
        return SqlTemplate.forQuery(client, "SELECT * FROM public.tag")
            .mapTo(ROW_TAG_MAPPER)
            .execute(parameter);
    }
}
