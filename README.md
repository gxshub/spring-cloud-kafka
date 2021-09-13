# Spring Cloud Stream for kafka Streams

### Kafka Setup in Windows 
Download the Apache Kafka package (i.e., `tgz` file) from `https://kafka.apache.org/downloads`.
Unzip the package to a home directory with a simple path (e.g., `C:\kafka`) &ndash; 
Windows does not like a complex path name. 

In the configuration file `C:\kafka\config\zookeeper.properties`, comment out the string `dataDir=/tmp/zookeeper`. In `C:\kafka\config\server.properties`, change `log.dirs=/tmp/kafka-logs` to `log.dirs=.kafka-log`.

Use the following two commands in the Windows CMD (one in each window) to start Kafka:
```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

#### Kafka Topic Data
Sometimes you may want to clean up data in the Kafka topcis. For this purpose, in Linux/MacOS, delete the folders `/tmp/zookeeper`, `/tmp/kafka-log` and `/tmp/kafka-streams`; and in Windows, delete `C:\kakfa\.dataDirzookeeper` and `C:\kakfa\.kakfa-log`.

