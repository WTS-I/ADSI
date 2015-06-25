#!/bin/bash
pwd

cd docker
cd apache-wtsadsi
mkdir htdocs
cp -r ../../WEB_APP/* htdocs/
docker build -t wtsintegration/apache-wtsadsi .
rm -rf htdocs

cd ..
cd api-wtsadsi
cp ../../com.wtsintegration/adsi/1.0/adsi-1.0.jar .
docker build -t wtsintegration/api-wtsadsi .
rm adsi-1.0.jar

docker run -d -p 8102:8880 --name api_wts_adsi -i -t wtsintegration/apache-wtsadsi
docker run -d -p 8101:80 --name http_wts_adsi -i -t wtsintegration/apache-wtsadsi

