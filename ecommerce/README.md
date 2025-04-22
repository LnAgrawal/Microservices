# Microservices
**#1 Monolithic**

**Disadvantage of Monolithic**
- Assembly and deploy
- Scalibility
- CI/CD
- Heterogenity and Multi Language
- No Fault Tolerance

**Advantage of Monolothic**
- Intercommunication is easy
- Performance good
- Maintenance is easy
- Testing is easy
- Security is easy

**When to use Monolithic app?**
- Frequent changes are not expected


**#2 Service Oriented Architecture**
- Using other services API
  ESB: Enterprise Srvice Bus.. Our application communicates via ESB
  Dissadvantage:
- Single point of failure

**#3 Distributive Architecture**
- Client Server Act
- Peer to Peer
- 3 tier act
- Microservices act

**Microservices**
- desire for faster availability
- greater availability
- fine grained scalability
- fault tolerance


**Cohesion and Coupling**

- Cohesion:

Horizontal Vs Vertical

**#Pricipales of Microservices**
- Single Responsibility  principle
- Independent : Should be independent deploy
- Decentralized Data Management: Each MS should maintain there own data
- API First Design: MS should communicate each other though API
- Regilient: Should fail gracefully
- Scalability
- Continuous Integration and Delivery
- Observability: Implementing logging, tracing etc
- Security: Secure communication btwn

**#Microservice Design Pattern**
- Decomposition Pattern
    - Strangler Pattern
- Communication Pattern
    - Synchronous
    - Asynchronous
- Data Management Pattern
    - CQRS
    - Saga Pattern
- Observability Pattern
    - Distributed Tracing (Micro meter)
    - ELK logs
      -Resilience Pattern
    - Circuit Breaker Pattern
      Advanced Pattern
    - API gateway
    - Service Discovery
        - Client Service Discovery
        - Server Side Service Discovery



**#Decomposition Pattern & Strangler Pattern**

Consider you want to migrate Monolothics to microservice Architecture.
- Decompose by Business capabilities: Break down the application as per feature. This comes under Decomposition pattern.
Domain Driven Design -> Break into Sub domain -> Bounded context

- Strangler Pattern: Transformation, Co-existense and eliminate
Route the request based on the percentage. For example: Product service is developed.
Now 90% request route to Monolothic application and 10% to the new product micro service.
This will be configured in the API gateway.

**#Service Discovery**
Assume 3 Microservices which has there own host and port number. The client wants to communicate to all the 3 microservice. It's challenging to maintain the host and port details for all the microservices.

So handle such situations Eureka Service which acts a Service Discovery . This server has all the microservice host and port number. Every service needs to get register with the Eureka Service.

**Service discovery has 2 things**

- Client discovery: Client side srvice discovery fetches the microservices info from service registry and it decides which microservices to call
- Server discovery:

#1 Service will register with service registry
#2 Consumer service will call the load balancer (API Gateway)
#3 The load balancer server will call the service registry and fetch the microservice network related details

server.port=8761
eureka.client.register-with-eureka=false
eurrka.client.fetch-registry=false

@EnableEurekaServer



**#Communication Patterns**

Three ways
- RestTemplate
- Webclient
- FeighClient

RestTemplate: Is blocking in nature . Synechronous. uses postForObject
- Synechronous way of communication
- performance is slow
- Spring version 3, soon to be depricate

WebClient: Webclient is non blocking. Asynchronous way of communication. WebFlux needs to be added. Need to add webflux dependency. Reactive way of programming.
- Asynchronous way of communication
- better performance is better
- if you're going for reactive programming

FeighClient : declarative http client	. Add OpenFeign
- declarative way



**#Spring Cloud Gateway:**

Till now, CLient was responsible to have the Microservice address details. Which was problem.
To avoid this, API Gateway can be used.

API Gateway
- Dynamic routing : dynamic routing by round robing
- Load balancing : client side loadbalancing
- Security
    - filters can be added

Eureka Server is the client side service discovery.

**#Circuit Breaker design pattern**
- Regilient4J configuration
- Monitor the service failure
- 3 states
    - closed : No issues, able to service
    - open :
    - half-open
      Flow:
      Closed to open: Req failed with threshold limit
      open to half-open-state: Counter reset timeout.
      half-open-state to open: Req failed
      half-open state to Closed : Request success with threshold value



**#Config Server**
- Centralized or externalized config server
- Each microservice has its own configuration.
- Assume the configs were with the Microservice, then whenever there's a config change then we need to stop all the instance of the microservice and then update the config and start it.
- When the config server is used the downtime of the service is reduced. Restart the config server and refresh the microservices.

@RefereshScope to get the values updated


**#ELK: Elastic search kibana**

E-> Elastic search. Designed for searching & analytics engine
L -> Logstash.
- Create a pipleline where it'll transfer the logs from pipline and transfer to Elastic search
- pipeline getting the data from multiple source
- transform in into elastic search

K -> Kibana. Display the log data

Goto Elastic search  Elastic Search/bin
open cmd
elasticsearch -E xpack.security.enabled=false
elasticsearch -E xpack.security.enabled=false

http://localhost:9200


KIBANA
- enable the config of elastic search
  localhost:5601
  D:\Babu\Practice\tools\kibana-9.0.0\bin>kibana.bat

Logstash
D:\Babu\Practice\tools\logstash-9.0.0\bin>logstash -f logstash.conf


#Distributed TGracing (Observability)
- tracking the flow of the microservices
- use micrometer - Observability Pattern
- observing the tracking of the request
- To do this use Micrometer. Download Zipkin server. Add dependency micrometer.
  Micrometer supports multiple tracing backends.

client -> Product Service -> Order Service -> Payment Service

/addProduct: this will create spanId and traceId. Trace Id will be same for all the microserivce for single request

/Order will have different spanId  and traceId from productService

/payment will have different spanId  and traceId from productService

D:\Babu\Practice\tools\zipkin>java -jar zipkin-server-3.5.0-exec.jar



**#Database Design Pattern**
1. CQRS : Command query responsibility Segregation
2. Saga Pattern

#CQRS
Command - write operation
Query: read operation

- Segration of read and write operation separately.
- 2 database: Read database and write database
- Data from write database is shared via Kafka. Event is generated from write database Producer and Read Database has kafka consumer.

**#Kafka**
- Producer
- Consumer
- Broker


Confluent 7.6.1
- kafka-run-class: update the path

rem classpath addition for LSB style path
if exist %BASE_DIR%\share\java\kafka\* (
call:concat %BASE_DIR%\share\java\kafka\*
)

- zookeeper.properties: update the log path
  dataDir=D:/Babu/Practice/tools/kafkalog/tmp/zookeeper


**Start zookeeper:**
D:\Babu\Practice\tools\confluent-7.6.1>.\bin\windows\zookeeper-server-start.bat .\etc\kafka\zookeeper.properties


**Start Kafka Server:**
D:\Babu\Practice\tools\confluent-7.6.1>.\bin\windows\kafka-server-start.bat .\etc\kafka\server.properties

Offset Explorer to check the kafka logs

**#Saga Design pattern**
1. Choreography Based Saga (Event driven approach)
2. Orchestration Based Saga (Centalized control)


**#12 Factor Design Pattern**

Best practices for developing Microservice, for scaling, regilience and fault tolerance
1. Codebase
2. Dependencies
3. Config
4. Backing Services
5. Build, release, run
6. Processes :   design MS as stateless that can be scaled
7. port binding:
8. Concurrency
9. Disposability
10. Dev Prod Parity
11. Logging
12. Admin process



