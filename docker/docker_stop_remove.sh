#!/bin/bash
docker stop api_wts_adsi
docker stop apache_wts_adsi

docker rm api_wts_adsi
docker rm apache_wts_adsi

docker rmi wtsintegration/apache-wtsadsi
docker rmi wtsintegration/api-wtsadsi 