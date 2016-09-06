#!/usr/bin/env bash

java -Dserver.port=$1  -Ddubbo.protocol.dubbo.port=$2 -jar xingmou-service-impl/target/xingmou-service-impl-spring-boot-1.0-SNAPSHOT.jar