package io.vertx.nscavell.server;

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.platform.Verticle;

public class ServerVerticle extends Verticle {
  public void start() {
    vertx.createHttpServer().requestHandler(request -> {
      String path = request.path();
      vertx.eventBus().send("core.address", path, (Handler<Message<Boolean>>) reply -> {
        if (reply.body()) {
          request.response().end("Message sent to core module");
        } else {
          request.response().setStatusCode(500);
          request.response().end("Failed to send to core module");
        }
      });
    }).listen(8080, result -> {
      if (result.succeeded()) {
        System.out.println("Server ready !");
      } else {
        System.out.println("Server failed to start.");
        result.cause().printStackTrace();
      }
    });
  }
}
