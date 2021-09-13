# Spring Cloud Stream for kafka Streams

### Apache Kakfa Setup in Linux/MacOS
Download an Apache Kafka package (i.e., `tgz` file) from `https://kafka.apache.org/downloads` and upzip it.
In the Terminal, `cd` to the unzip folder and start Kakfa with the following commands:
```bash
./bin/zookeeper-server-start.sh
```
```bash
./bin/kafka-server-start.sh
```

### Apache Kafka Setup in Windows 
Download an Apache Kafka package (i.e., `tgz` file) from `https://kafka.apache.org/downloads` and unzip it to 
such a directory as `C:\kafka` &ndash; 
Windows does not like a complex path name. 

In the configuration file `C:\kafka\config\zookeeper.properties`, comment out the string `dataDir=/tmp/zookeeper`. In `C:\kafka\config\server.properties`, change `log.dirs=/tmp/kafka-logs` to `log.dirs=.kafka-log`.

Use the following two commands in the Windows CMD (one in each window) to start Kafka:
```bash
C:\kafka\bin\windows\zookeeper-server-start.bat C:\kafka\config\zookeeper.properties
```
```bash
C:\kafka\bin\windows\kafka-server-start.bat C:\kafka\config\server.properties
```

#### Kafka Topic Data
Sometimes you may want to clean up data in the Kafka topics. For this purpose, in Linux/MacOS, delete the folders `/tmp/zookeeper`, `/tmp/kafka-log` and `/tmp/kafka-streams`; and in Windows, delete `C:\kakfa\.dataDirzookeeper` and `C:\kakfa\.kakfa-log`.

