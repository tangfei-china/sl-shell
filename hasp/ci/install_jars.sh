#!/usr/bin/env bash

## hasp-srm api
mvn install:install-file -DgroupId=com.tangf -DartifactId=hasp-srm-api -Dversion=1.0 -Dpackaging=jar -Dfile=../jars/hasp-srm-api-1.0.jar
