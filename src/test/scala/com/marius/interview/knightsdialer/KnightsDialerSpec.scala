package com.marius.interview.knightsdialer

import org.scalatest.{FlatSpec, Matchers}

class KnightsDialerSpec extends FlatSpec with Matchers {
  import KnightsDialerSpec._

  behavior of "KnightsDialer"

  it should "return the maximum number of sequences using the DP implementation" in {
    dynamicImpl.countSequences(startPosition, numHops) shouldEqual maximumSequences
  }

  it should "return the maximum number of sequences using the recursive implementation" in {
    recursiveImpl.countSequences(startPosition, numHops) shouldEqual maximumSequences
  }
}

object KnightsDialerSpec {
  val dynamicImpl = new KnightsDialerDP()
  val recursiveImpl = new KnightsDialerRecursive()
  val startPosition = 6
  val numHops = 2
  val maximumSequences = 6
}
