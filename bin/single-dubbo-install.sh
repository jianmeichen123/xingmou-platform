#!/usr/bin/env bash
mvn clean install -f pom-sd.xml
mvn clean install -f xingmou-assembly/pom-sd.xml
mvn clean install -f xingmou-dal/pom-sd.xml
mvn clean install -f xingmou-biz/pom-sd.xml
mvn clean install -f xingmou-service-facede/pom.xml
mvn clean install -f xingmou-service/pom-sd.xml

