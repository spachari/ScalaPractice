package com.scalaCookbook.examples.Files


import sys.process._



object RunningSparkjobInfinitely extends App {

  def checkStreamingJobStatus() : Boolean = {
    val listOfSparkJobs = "yarn application --list" !!
    val isVisitSummaryJobPresent = listOfSparkJobs.contains("Visit Summary")
    isVisitSummaryJobPresent
  }

  val spark_command = "nohup spark-submit --deploy-mode client --num-executors 10 --executor-cores 5 --executor-memory 30g --driver-memory 30g --conf 'spark.memory.offHeap.enabled=false' --conf 'spark.memory.offHeap.size=4g' --conf 'spark.driver.extraJavaOptions=-Djava.net.preferIPv4Stack=true -XX:ReservedCodeCacheSize=100m -XX:+UseCodeCacheFlushing' --class com.hotels.hde.cas.visitsummary.VisitStreamingDriver /tmp/aws-cds-clickstream-visit-streaming.jar  --configFile file:///tmp/application_prod.conf --batchDuration 10 --checkpointDirectory /tmp/ --numOfReceivers 20 --outputDirectory /tmp/visitStreamingData/ > myStreamProgram.out 2>&1"

  var i = 0
  while(!checkStreamingJobStatus()) {
    Thread.sleep(10000)
    i = i + 1
    println(i)
    println("Spark job killed, so running again")
    spark_command.!
  }

  /*
  @annotation.tailrec def process(availableRetries: Int): String = {
    try {
      return doSomething()
    } catch {
      case e: Exception => {
        if (availableRetries < 0) {
          throw e
        }
      }
    }
    return process(availableRetries - 1)
  }*/

}
