#!/bin/bash
pwd

if [ -z "$1" ] then
  thetag=ci
else
  thetag=$1
fi

cd docker
cd apache-wtsadsi
mkdir htdocs
cp -r ../../WEB_APP/* htdocs/
cp ../../target/LICENSE .
docker build -t wtsintegration/apache-wtsadsi:$thetag .
rm -rf htdocs

cd ..
cd api-wtsadsi
cp ../../com.wtsintegration/adsi/1.0/adsi-1.0.jar .
cp ../../target/LICENSE .
docker build -t wtsintegration/api-wtsadsi:$thetag .
rm adsi-1.0.jar

if [ -z "$1" ]
  then
docker run -d -p 8102:8880 --name api_wts_adsi -i -t wtsintegration/api-wtsadsi:ci
docker run -d -p 8101:80 --name apache_wts_adsi -i -t wtsintegration/apache-wtsadsi:ci
fi
