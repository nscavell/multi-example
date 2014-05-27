package io.vertx.nscavell.deployer;

import org.vertx.java.platform.Verticle;

public class DeployerVerticle extends Verticle {

  public void start() {
    System.out.println("Deployer Verticle deploying verticles...");
    container.deployModule("io.vertx.nscavell~multi-example-core~1.0", result -> {
      if (result.succeeded()) {
        System.out.println("Deployed core verticle !");
      } else {
        result.cause().printStackTrace();
      }
    });
    container.deployModule("io.vertx.nscavell~multi-example-server~1.0", result -> {
      if (result.succeeded()) {
        System.out.println("Deployed server verticle !");
      } else {
        result.cause().printStackTrace();
      }
    });
  }
}
