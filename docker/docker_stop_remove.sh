#!/bin/bash
pwd

docker stop api_wts_adsi
docker stop apache_wts_adsi

docker rm api_wts_adsi
docker rm apache_wts_adsi

docker rmi wtsintegration/apache-wtsadsi:ci
docker rmi wtsintegration/api-wtsadsi:ci