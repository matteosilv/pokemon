# Pokemon API

Pokemon API is a simple microservice exposing the endpoint:

**GET** _/pokemon/{name}_

returning the Pokemon description as a JSON response in the format:

```JSON
{
  "name" : "charizard",
  "description" : "Charizard flies 'round the sky in search of powerful opponents."
}
```

It is build on top of [Quarkus](https://quarkus.io/), a Java based microservices framework.

## Prerequisites

You will need to install Java version 11 at least.
Follow the instructions at https://adoptopenjdk.net/installation.html

Then, depending on your OS and the way you installed Java, you may export the path to your JDK in the `JAVA_HOME` environment variable.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `pokemon-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/pokemon-1.0.0-SNAPSHOT-runner.jar`.

## Building the Docker container

Before building the container image run:

```shell script
./mvnw package
```
Then, build the image with:

```shell script
docker build -f src/main/docker/Dockerfile.jvm -t pokemon .
```

Then run the container using:

```shell script
docker run -i --rm -p 8080:8080 pokemon
```

If you want to include the debug port and enable remote debugging run the container using:

```shell script
docker run -i --rm -p 8080:8080 -p 5005:5005 -e JAVA_ENABLE_DEBUG="true" pokemon
```