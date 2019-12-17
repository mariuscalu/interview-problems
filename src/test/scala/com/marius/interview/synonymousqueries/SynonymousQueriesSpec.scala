package com.marius.interview.synonymousqueries

import org.scalatest.{FlatSpec, Matchers}

class SynonymousQueriesSpec extends FlatSpec with Matchers {
  import SynonymousQueriesSpec._

  behavior of "SynonymousQueries"

  it should "output for each query if they are synonyms or not based on the given synonyms" in {
    synonymousQueries.synonymQueries(SYNONYMS, QUERIES) shouldEqual expectedOutput
  }

}

object SynonymousQueriesSpec {

  val synonymousQueries = new SynonymousQueries()
  val expectedOutput = List(true)
  val SYNONYMS = List(
    ("rate", "ratings"),
    ("approval", "popularity"))
  val QUERIES = List(
    ("obama approval rate", "obama popularity ratings"))
}
