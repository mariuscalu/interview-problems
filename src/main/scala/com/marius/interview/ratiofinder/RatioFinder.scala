package com.marius.interview.ratiofinder

import RateGraph._

/**
 * Implementation of the Ratio Finder algorithm
 */
class RatioFinder {

  /**
   *
   * @param from initial unit of measurement
   * @param to target unit of measurement
   * @return the ratio in case there is a path between the two units of measurement
   */
  def find(from: String, to: String): Option[Double] = {

    def helper(from: String, to: String, originalRate: Double, visited: Set[String]): Option[Double] =
      if(from.equals(to)) Some(originalRate)
      else getNeighbors(from) match {
          case Some(list) =>
            list
              .filter(tuple => !visited.contains(tuple._1))
              .map(tuple => helper(tuple._1, to, originalRate * tuple._2, visited + from))
              .foldLeft(Option(1.0))((acc, ratio) => multiply(acc, ratio))
          case None => None
        }

    helper(from, to, 1.0, Set[String]())
  }

  private def multiply(op1: Option[Double], op2: Option[Double]): Option[Double] =
    op1 match {
      case Some(value) => if (op2.isDefined) Some(value * op2.get) else Some(value)
      case None => op2
    }
}
