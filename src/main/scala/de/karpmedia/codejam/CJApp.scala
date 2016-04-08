package de.karpmedia.codejam

import scala.io.Source

trait CJApp extends App {
  def prob (inputLines: Iterator[String]): Seq[String]

  prob(Source.fromInputStream(System.in).getLines) foreach System.out.println
}
