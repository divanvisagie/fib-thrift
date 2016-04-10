package com.client

import com.example.math.thriftscala.MathService
import com.twitter.finagle.service.TimeoutFilter
import com.twitter.finagle.util.DefaultTimer
import com.twitter.finagle.{IndividualRequestTimeoutException, Thrift}
import com.twitter.util.Duration

object ThriftClient {
  def timeoutFilter[Req, Rep](duration: Duration) = {
    val exc = new IndividualRequestTimeoutException(duration)
    val timer = DefaultTimer.twitter
    new TimeoutFilter[Req, Rep](duration, exc, timer)
  }

  def main(args: Array[String]) {
    println("Running Client for 9090")


    val client = Thrift.newIface[MathService.FutureIface]("localhost:9090")


    val fut = client.fibonacci(30)

    fut.onSuccess { response =>
      println(s"Received response -> $response")
    }

    fut.onFailure { err =>
      println(s"error -> ${err.getMessage}")
    }
  }
}
