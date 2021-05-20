# Forum DDD CQRS

## Get Started

1. Launch your docker
2. Enter the following commands:

    ```shell
    $ ./run_elasticsearch_docker.sh
    $ mvn clean install
    $ mvn spring-boot:run
    ```

## Http Testing

Go to `src/main/resources/test.http`, and execute the command one by one



## Reference

* [c# - Data Repository and Complex Queries (DTO) - Software Engineering Stack Exchange](https://softwareengineering.stackexchange.com/questions/421229/data-repository-and-complex-queries-dto)
* Spring Data Elasticsearch: https://docs.spring.io/spring-data/elasticsearch/docs/current-SNAPSHOT/reference/html/#reference
* [Event-Driven Microservices - Axon Reference Guide](https://docs.axoniq.io/reference-guide/architecture-overview/event-driven-microservices) 
  * command dispatcher: [Command Dispatchers - Axon Reference Guide](https://docs.axoniq.io/reference-guide/axon-framework/axon-framework-commands/command-dispatchers)
  
### Elasticsearch

* [Multi-match query | Elasticsearch Guide [7.12] | Elastic](https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl-multi-match-query.html) 
* [Introduction to Spring Data Elasticsearch | Baeldung](https://www.baeldung.com/spring-data-elasticsearch-tutorial)
  * sample code: [tutorials/ArticleRepository.java at master · eugenp/tutorials](https://github.com/eugenp/tutorials/blob/master/persistence-modules/spring-data-elasticsearch/src/main/java/com/baeldung/spring/data/es/repository/ArticleRepository.java)



