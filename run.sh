#!/bin/sh

function help {
  echo "local <config>|remote <spark-master-url> <config>"
}

BASEDIR=$(dirname $0)
EXECUTOR_MEMORY=10G
DRIVER_MEMORY=2G

if [ "$#" -lt 2 ]; then
  echo "Incorrect number of input arguments"
  help
  exit 1
fi

if [ "x$1" == "xlocal" ]; then

 (cd $BASEDIR; sbt -Dspark.master=local "run $2")

fi

if [ "x$1" == "xremote" ]; then

 if [ "$#" -ne 3 ]; then
  echo "Incorrect number of input arguments2"
  help
  exit 1
 fi

 if ! command -v spark-submit > /dev/null; then
  echo "Could not find spark-submit script. Please make sure its in the PATH."
  exit 2
 fi

 spark-submit --class com.sungevity.analytics.Main --executor-memory $EXECUTOR_MEMORY --driver-memory $DRIVER_MEMORY --master $2 $BASEDIR/target/scala-2.11/anomaly-detection-assembly-1.0.jar $3

fi


