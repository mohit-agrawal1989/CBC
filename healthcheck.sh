#!/usr/bin/env bash

#echo "Checking hub - $HUB_HOST"
#
#while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
#do
#	sleep 1
#done


# start the java command
java -cp aquaweb-tests.jar:libs/*:aquaweb.jar -Dcucumber.options="classpath:features" org.testng.TestNG testng.xml
