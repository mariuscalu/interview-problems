package com.marius.interview.knightsdialer

import Neighbors.neighbors

/**
 * Implementation of the The Knight’s Dialer algorithm using dynamic programming
 * linear time, constant space
 */
class KnightsDialerDP {

  /**
   * It computes all distinct numbers that can be dialed for the given parameters
   * @param startPosition starting key
   * @param numHops number of moves
   * @return all distinct numbers
   */
  def countSequences(startPosition: Int, numHops: Int): Int = {

    var priorCase = collection.mutable.ListBuffer(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    var currentCase = new collection.mutable.ListBuffer[Int]
    var currentNumHops = 1

    while (currentNumHops <= numHops) {
      currentCase = collection.mutable.ListBuffer(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
      currentNumHops += 1

      Range(0, 10).toList
        .map(position => (position, neighbors(position)))
        .flatMap(tuple => tuple._2.map(neighbor => (tuple._1, neighbor)))
        .foreach(tuple => {
        currentCase(tuple._1) += priorCase(tuple._2)
      })

      priorCase = currentCase
    }

    currentCase(startPosition)
  }
}
