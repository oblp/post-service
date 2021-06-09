# Extend vert.x image
FROM vertx/vertx4

#                                                       (1)
ENV VERTICLE_NAME cn.eastack.article.adapter.inbound.rest.ArticleVerticle
ENV VERTICLE_FILE build/libs/article-api-0.0.1-SNAPSHOT-all.jar

# Set the location of the verticles
ENV VERTICLE_HOME /usr/verticles

EXPOSE 8888

# Copy your verticle to the container                   (2)
COPY $VERTICLE_FILE $VERTICLE_HOME/

# Launch the verticle
WORKDIR $VERTICLE_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec vertx run $VERTICLE_NAME -cp $VERTICLE_HOME/*"]
