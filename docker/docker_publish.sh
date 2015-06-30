#!/bin/bash

docker push wtsintegration/api-wtsadsi:$1
docker push wtsintegration/apache-wtsadsi:$1

