package com.example

import com.example.math.thriftscala.MathService
import com.example.math.thriftscala.MathService.Fibonacci
import com.twitter.finagle.Thrift

object ThriftClient {
  def main(args: Array[String]) {
    println("Running Client")
    val client = Thrift.newIface[MathService.FutureIface](":9990")

    client.fibonacci(30).onSuccess { response =>
      println(s"Received response -> $response")
    }.onFailure { err =>
      println(s"error -> $err")
    }
  }
}
