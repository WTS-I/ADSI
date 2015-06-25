#!/bin/bash
pwd

cd apache-wtsadsi
docker build -t wtsintegration/apache-wtsadsi .

cd api-wtsadsi
docker build -t wtsintegration/api-wtsadsi .

docker run -d -p 8102:8880 --name api_wts_adsi -i -t wtsintegration/apache-wtsadsi
docker run -d -p 8101:80 --name http_wts_adsi -i -t wtsintegration/apache-wtsadsi

