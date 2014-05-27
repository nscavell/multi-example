package io.vertx.nscavell.core;

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.platform.Verticle;

public class CoreVerticle extends Verticle {

  public void start() {
    vertx.eventBus().registerHandler("core.address", (Handler<Message<String>>) message -> {
      String msg = message.body();
      if (!"/favicon.ico".equals(msg)) { // filter out favicon request
        System.out.println("Core Verticle: Received message '" + message.body() + "'");
      }
      message.reply(true);
    });

    System.out.println("Core Verticle started");
  }
}
