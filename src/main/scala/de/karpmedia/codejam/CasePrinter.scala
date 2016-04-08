package de.karpmedia.codejam

import scala.collection.GenSeq

trait CasePrinter {
  def outLineFormat(result: String, num: Int) = s"Case #$num: $result"
  def output(results: GenSeq[String]): Seq[String] = results.zip(Stream.from(1)).map((outLineFormat _).tupled).seq
}
