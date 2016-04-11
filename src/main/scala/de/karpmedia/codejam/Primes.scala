package de.karpmedia.codejam

object Primes {
  lazy val stream: Stream[Int] = 2 #:: Stream.from(3).filter(current => is(current))
  def couldDivide(num: Long) = stream.takeWhile(prime => prime.toLong * prime.toLong <= num)
  def is(num: Long): Boolean = couldDivide(num).forall(num % _ != 0)
  def smallestFactor(num: Long): Option[Int] = couldDivide(num).find(num % _ == 0)
  def factors(num: Long): Int Map Int = {
    def inner(cur: Long, accu: Int Map Int = Map.empty.withDefaultValue(0) ): Int Map Int = smallestFactor(cur) match {
      case Some(factor) => inner(cur / factor, accu + (factor -> accu(factor)))
      case None => accu
    }
    inner(num)
  }
}
