# Multi-Module Vert.x Example Maven Project

To run this project with autodeploy working follow these steps.

1. Set `VERTX_MODS` env variable to the full path of a common directory. Like a mods directory under the parent project i.e. `export VERTX_MODS=/home/user/multi-example/mods`
1. Run `mvn clean compile` in parent project.
2. In each module (core, deployer, and server) run `mvn vertx:init`. This will create module.link files for each module under the directory you set `VERTX_MODS` to.
3. run `mvn vertx:runMod` in the deployer module. You can also run `vertx runmod io.vertx.nscavell~multi-example-deployer~1.0` in the parent project.

If you follow these steps you should see the following output
 
    [INFO] CTRL-C to stop server
    Core Verticle started
    Deployed core verticle !
    Deployed server verticle !
    Server ready !

You can now make changes, compile, and see the modules are re-deployed and your changes are live !
