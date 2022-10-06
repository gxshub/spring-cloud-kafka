# Stream Processing with Spring Cloud Stream and Kafka Streams

### Apache Kafka Setup

See [this brief guide](https://github.com/gxshub/cargo-tracker#a-short-guide-to-set-up-apache-kafka).

<!-- **Note. Recommend to use a Kafka version 2.x.x but not 3.x.x because Java 8 is deprecate in 3.x.x ** -->

## About the Application 
The producer application gets `Appliance` JSON data from a public [API](https://random-data-api.com/api/appliance/random_appliance) and 
publishes it to a Kafka topic named `appliance-topic`. 
The processor application subscribes to that Kafka topic, computes a total count for each (appliance) `Brand` 
and publishes the results to another Kafka topic named `brand-topic`. 
The processor application also implements two state stores for interactive queries which can be accessed via REST requests (see below).
The consumer application simply subscribes to `brand-topic` and logs the records.

### Interactive queries
After running the producer and processor, 
to get a list of `Brand` names, request the following URL:
```url
http://localhost:8183/brands/all
```
To get the updating counts for a `Brand` (e.g. `IKEA`), request the following URL:
```url
http://localhost:8183/brand/IKEA/quantity
```
To get a list of equipments (names) for a `Brand` (e.g. `IKEA`), request the following URL:
```url
http://localhost:8183/brand/IKEA/equipments
```
