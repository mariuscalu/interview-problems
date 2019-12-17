package com.marius.interview.knightsdialer

import Neighbors.neighbors

/**
 * Implementation of the The Knight’s Dialer algorithm using recursion
 * linear time and space
 */
class KnightsDialerRecursive {

  /**
   * It computes all distinct numbers that can be dialed for the given parameters
   * @param startPosition starting key
   * @param numHops number of moves
   * @return all distinct numbers
   */
  def countSequences(startPosition: Int, numHops: Int): Int = {

    val cache = collection.mutable.Map[(Int, Int), Int]()

    def loop(position: Int, numHops: Int): Int = {
      if(cache.contains((position, numHops))) cache((position, numHops))
      else if(numHops == 0) 1 else {
       val numSequences = neighbors(position).map(neighbor => loop(neighbor, numHops - 1)).sum
        cache((position, numHops)) = numSequences
        numSequences
      }
    }

    loop(startPosition, numHops)
  }

}
