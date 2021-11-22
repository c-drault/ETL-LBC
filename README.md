# ETL-LBC

## Deploiement 🚀
File are present in the last pre-release

1) Start the mongodb 
    ```bash
    docker compose up
    ```

2) Run crawler
    ```bash
    java -jar etl-crawler-1.0-SNAPSHOT-jar-with-dependencies.jar
    ```

3) Start the API
    ```bash
    java -jar api-lbc-0.0.1-SNAPSHOT.jar
    ```

## Setup in production
In production we can :
- Deploy the different images of application in docker hub (or equivalent),
- Launch an unique docker-compose.

## Limitation
- The deep of the crawl. 
- 

## Improvement
- Code upgrade with application.properties file.
- Add unit test
- Adding logger
- Use design pattern for the development

A schema repository is usefull to don't have to replicate the declaration of the type of data. Once is describe in one emplacement, we can update it quickly.
