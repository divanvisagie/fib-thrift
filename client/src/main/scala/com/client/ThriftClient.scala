package com.client

import com.fib.thrift.math.thriftscala.MathService
import com.twitter.finagle._
import com.twitter.finagle.param.{Tracer => PTracer}
import com.twitter.finagle.stats.NullStatsReceiver
import com.twitter.finagle.tracing._
import com.twitter.util.{Await, Future}

import scala.language.reflectiveCalls


object ThriftClient {

  val svc: MathService[Future] = ThriftMux.client
      .configured(param.Tracer(NullTracer))
      .configured(param.Stats(NullStatsReceiver))
      .newIface[MathService.FutureIface]("localhost:9090")

  def main(args: Array[String]) {

    Await.ready(svc.fibonacci(30)).onSuccess( f => {
      println(s"fib 30: ${f.toString}")
    }).onFailure( err => {
      println(s"error: ${err.getMessage}")
    })
  }
}


