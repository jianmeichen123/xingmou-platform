#!/usr/bin/env bash
java -jar -Dspring.profiles.active=$1 -Dserver.port=$2 -Ddubbo.protocol.dubbo.port=$3 /home/vincent/workspace_idea/company/xm-platform/xingmou-platform/xingmou-service/target/xingmou-service-1.0-bt-SNAPSHOT.jar
