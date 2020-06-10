Run: **mvn package**

Docker:
    Create images:
        Bookstore: **docker build -t amalik/bookstore-docker .**
        Postgres: **docker build -t amalik/postgres-bookstore-docker -f Dockerfile-postgres .**

    Run image:
        Postgres: **docker run --name postgres -d -p 5432:5432 amalik/postgres-bookstore-docker**
    bookstore: **docker run --name bookstore -d -p 8080:8080 amalik/bookstore-docker**

    Connect them:
        **_docker network create booknet
        docker network connect booknet  postgres
        docker network connect booknet bookstore_**
