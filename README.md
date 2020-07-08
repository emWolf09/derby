#Derby Image Sharing Platform BackEnd

##Setup: 
Ojdb7 is missing download and install it using this command
mvn install:install-file -Dfile=./ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.1 -Dpackaging=jar


**Note : Fron-end is in Angular - practise repo**


##Stack
 -Java 
 -Spring boot
 -Spring cloud (Zuul, Eureka, Config server)
 -spring cache,JPA
 -Spring security
 -hibernate
 -maven build automation tool

##Implemented
 -caching level -1 (secondary level future scope)
 -Image are stored in Filesystem(local) and a url for that directory is stored in db. Upload and download is in Multipart object of java
 -Dynamic host and port configuration in cloud using spring cloud config server and github configuration properties file.
 -dozer mapper and lombok
 -pagination and Pageable
 -A.O.P. -  Custom Exception handling, logging(futute scope)
 -load balancing using Ribbon (future scope)  
 
