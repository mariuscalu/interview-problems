package com.marius.interview.knightsdialer

/**
 * Utility object which maps each key with the corresponding keys where the Knights can go
 */
object Neighbors {

  private val NEIGHBORS = Map(
    1 -> List(6, 8),
    2 -> List(7, 9),
    3 -> List(4, 8),
    4 -> List(3, 9, 0),
    5 -> Nil,
    6 -> List(1, 7, 0),
    7 -> List(2, 6),
    8 -> List(1, 3),
    9 -> List(2, 4),
    0 -> List(4, 6)
  )

  /**
   * It returns the all possible moves for a given position
   * @param position starting key
   * @return all keys where the knights can go
   */
  def neighbors(position: Int): List[Int] = NEIGHBORS.getOrElse(position, Nil)
}
