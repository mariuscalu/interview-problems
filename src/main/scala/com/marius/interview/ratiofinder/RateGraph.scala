package com.marius.interview.ratiofinder

/**
 * Utility object which holds multiple conversions structured as a graph
 */
object RateGraph {

  val rates: Map[String, List[(String, Double)]] = Map(
    "foot" -> List(("inch", 12.0)),
    "inch" -> List(("hand", 0.25), ("centimeter", 2.54)),
    "mile" -> List(("foot", 5280.0), ("kilometer", 1.6)),
    "lightyear" -> List(("kilometer", 9.461e+12)),
    "meter" -> List(("centimeter", 100.0)),
    "kilometer" -> List(("meter", 1000.0))
  )

  /**
   * It returns the neighbours of a node if it has any
   * @param node node for which we want to know the neighbours
   * @return a list of neighbours in case it has
   */
  def getNeighbors(node: String): Option[List[(String, Double)]] =
    rates.get(node)
}