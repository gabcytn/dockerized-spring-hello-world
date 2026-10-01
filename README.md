## STEPS TO RUN

- Clone repo
  ```git
  git clone https://github.com/gabcytn/dockerized-spring-hello-world
  ```
- Define env variables
  ```bash
  export DEMO_DB_ADDRESS=
  export DEMO_DB_PORT=
  export DEMO_DB_NAME=
  export DEMO_DB_USER=
  export DEMO_DB_PASSWORD=
  export DEMO_REDIS_HOST=
  export DEMO_REDIS_PORT=
  ```
- Package app in a jar file
  ```bash
  ./mvnw package -DskipTests
  ```
- Build image
  ```bash
  docker compose build
  ```
- Run
  ```bash
  docker compose up
  ```
