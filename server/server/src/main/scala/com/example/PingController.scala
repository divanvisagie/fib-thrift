package com.example

import com.example.ping.thriftscala.PingService
import com.example.ping.thriftscala.PingService.Ping
import com.twitter.finatra.thrift.Controller
import com.twitter.util.Future
import javax.inject.Singleton

import com.example.math.thriftscala.MathService
import com.example.math.thriftscala.MathService.Fibonacci
import com.example.math.thriftscala.MathService.Fibonacci.{Args, Result}
import com.twitter.finagle.Service

import scala.annotation.tailrec

@Singleton
class PingController
  extends Controller
  with PingService.BaseServiceIface {

  	override val ping = handle(Ping) { args: Ping.Args =>
  		info(s"Responding to ping thrift call")
  		Future.value("pong")
  	}
}

@Singleton
class MathController extends  Controller with MathService.BaseServiceIface {

  def fibonacci(n :Int) : Int = {
    @tailrec
    def fib(n : Int, next :Int, acc :Int) :Int = {
      if(n == 0) acc
      else fib(n-1, acc + next,next)
    }
    fib(n,1,0)
  }
  override def fibonacci: Service[Args, Result] = handle(Fibonacci) { args: Fibonacci.Args =>
    Future.value(fibonacci(args.count))
  }
}

