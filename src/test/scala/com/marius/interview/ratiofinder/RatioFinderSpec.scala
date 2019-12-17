package com.marius.interview.ratiofinder

import org.scalatest.{FlatSpec, Matchers}

class RatioFinderSpec extends FlatSpec with Matchers {
  import RatioFinderSpec._

  behavior of "RatioFinder"

  it should "return the ratio for the two units of measurement when there is a path to convert them" in {
    val result = ratioFinder.find(FROM, TO)
    result match {
     case Some(ratio) => assertResult(expectedRatio)(ratio)
     case None => fail(s"There was no result for the conversion of $FROM to $TO")
   }
  }

}

object RatioFinderSpec {
  val ratioFinder = new RatioFinder()
  val FROM = "foot"
  val TO = "hand"
  val expectedRatio = 3.0
}
