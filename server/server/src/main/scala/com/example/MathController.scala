package com.example

import com.example.math.thriftscala.MathService
import com.example.math.thriftscala.MathService.Fibonacci
import com.twitter.finatra.thrift.Controller
import com.twitter.util.Future
import javax.inject.Singleton

import scala.annotation.tailrec

/**
  * Created by divan on 2016/04/09.
  */
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
  override def fibonacci = handle(Fibonacci) { args: Fibonacci.Args =>
    Future.value(fibonacci(args.count))
  }
}
