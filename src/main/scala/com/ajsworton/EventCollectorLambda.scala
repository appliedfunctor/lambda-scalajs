package com.ajsworton

import cats.effect.{ExitCode, IO}

import scala.scalajs.js
import scala.scalajs.js.annotation._

@JSExport
object EventCollectorLambda {

  def main(args: Array[String]): Unit = {
    println("main")
  }

  @JSExport
  def handler(event: Object, context: Object): Unit = {

//    event.asInstanceOf[]

    val sqs = new AWS.SQS("{apiVersion: '2012-11-05'}")

    for {
      _ <- IO(println("Checking object and context"))
      _ <- IO(println(s"event: $event"))
      _ <- IO(println(s"context: $context"))
    } yield ExitCode.Success
  }.unsafeRunSync()

}



@js.native
@JSImport("aws-sdk", "AWS")
object AWS extends js.Object{

  type err = String
  type data = String

  class SQS(x: String) extends js.Object {
    def listQueues(params: String, f: (err, data) => Unit): List[String] = js.native
  }
}
