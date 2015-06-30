FROM java:8-jre
MAINTAINER mark.horwath@wtsintegration.com
EXPOSE 8880
CMD java -jar adsi-1.0.jar port=8880
ADD adsi-1.0.jar adsi-1.0.jar
ADD LICENSE LICENSE
LABEL Description="This image is used for the Java ADSI portion of the WTS ADSI sample application, built from github (https://github.com/WTS-I/ADSI) tag DEV_${SOURCE_BUILD}"
