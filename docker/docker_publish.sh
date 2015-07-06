#!/bin/bash

docker tag -f wtsintegration/api-wtsadsi:$1 wtsintegration/api-wtsadsi:latest
docker tag -f wtsintegration/apache-wtsadsi:$1 wtsintegration/apache-wtsadsi:latest

docker push wtsintegration/api-wtsadsi:$1
docker push wtsintegration/apache-wtsadsi:$1

docker push wtsintegration/api-wtsadsi:latest
docker push wtsintegration/apache-wtsadsi:latest

