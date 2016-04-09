package com.example

import com.example.math.thriftscala.MathService
import com.twitter.finatra.thrift.EmbeddedThriftServer
import com.twitter.inject.server.FeatureTest
import com.twitter.util.Future


class FibonacciFeatureTest extends FeatureTest {
  override val server = new EmbeddedThriftServer(new ExampleServer)

  val client = server.thriftClient[MathService[Future]](clientId = "client123")

  "service given fibonacci 30" should {
    "respond with 832040" in {
      client.fibonacci(30).value should be(832040)
    }
  }
}
