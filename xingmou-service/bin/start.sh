#!/usr/bin/env bash
rm -f xm-service-pid

nohup java -jar /data/app/xingmou-service.jar  > /dev/null 2>&1 &

echo $! > xm-service-pid

echo Start Success!