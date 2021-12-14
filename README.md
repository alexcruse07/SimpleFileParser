# interact-bacnet-service

## Prerequisites

* JDK 1.8+
* Gradle 6.8.x and above

### Application

Application uses Spring Schedulers to keep checking files at given path.
Currently supports .pdf and .txt extensions and give stats for word and special chars count for input files.

Application uses apache PDF library to read PDF files.

#### Local development
Developed using Java and Spring boot libraries

#### Import
Import existing Gradle project into Intellij or STS(Spring Tool Suite)

#### Build
To build in terminal
```shell script
$ gradle clean build 
``` 
Builds a project

#### Run
Run application as SpringBoot Application.

### Points to Remember
* Source path can be given only once in console.
* Destination path for processed files will be created at given path and processed files will be moved to processed folder.
* Once processed all the files application will check for new files in every 10 sec.