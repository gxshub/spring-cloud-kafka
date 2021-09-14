# Spring Cloud Stream for kafka Streams

### Apache Kafka Setup
#### Linux and MacOS
Download an Apache Kafka ***binary package*** (i.e., `tgz` file) from `https://kafka.apache.org/downloads` and upzip it.
In the Terminal, `cd` to the unzip folder and start Kakfa with the following commands:
```bash
./bin/zookeeper-server-start.sh
```
```bash
./bin/kafka-server-start.sh
```
 
#### Windows 
Download an Apache Kafka ***binary package*** (i.e., `tgz` file) from `https://kafka.apache.org/downloads` and unzip it to 
such a directory as `C:\kafka` &ndash; 
Windows does not like a complex path name (!). 

In the configuration file `C:\kafka\config\zookeeper.properties`, comment out the string `dataDir=/tmp/zookeeper`. In `C:\kafka\config\server.properties`, change `log.dirs=/tmp/kafka-logs` to `log.dirs=.kafka-log`.

Use the following two commands in the Windows CMD (one in each window) to start Kafka:
```bash
C:\kafka\bin\windows\zookeeper-server-start.bat C:\kafka\config\zookeeper.properties
```
```bash
C:\kafka\bin\windows\kafka-server-start.bat C:\kafka\config\server.properties
```

#### Kafka Topic Data
Sometimes you may want to clean up data in the Kafka topics to start over. For this purpose, in Linux/MacOS, delete the folders `/tmp/zookeeper`, `/tmp/kafka-log` and `/tmp/kafka-streams`. In Windows, delete the folders `C:\kafka\.dataDirzookeeper` and `C:\kafka\.kafka-log`.

## The Applications 
The proceduer gets `appliance` JSON data from a public [API](https://random-data-api.com/api/appliance/random_appliance) and publishes it to a Kafka topic. The processor subscribes to that Kafka topic, computes a total count for each (appliance) `brand` and publishes the results to another Kakfa topic. The processor also implements an interactive query servce that allows users to query the results via REST.

When the two applications are running, use the following URL to get a list of `brand` names:
```url
http://localhost:8183/brands/all
```
Then, use the following URL (and refresh it) to get the updating result for each `brand`, e.g. `IKEA`:
```url
http://localhost:8183/brand/IKEA/quantity
```
