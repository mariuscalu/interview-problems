package com.marius.interview.synonymousqueries

/**
 * Implementation of the Synonymous Queries algorithm
 */
class SynonymousQueries {

  val SPLIT_REGEX = " "

  /**
   * It outputs a list of booleans for a given a pair of synonyms and queries
   *
   * @param synonym_words iterable of pairs of strings representing synonymous words
   * @param queries iterable of pairs of strings representing queries to be tested for synonymous-ness
   * @return list of boolean values such that each entry in the output indicates whether
   * the corresponding pair of queries are synonymous
   */
  def synonymQueries(synonym_words: List[(String, String)], queries: List[(String, String)]): List[Boolean] = {

    val synonyms = createSynonyms(synonym_words)

    queries.map(query => {

      val firstQuery = query._1.split(SPLIT_REGEX)
      val secondQuery = query._2.split(SPLIT_REGEX)

      if (firstQuery.length != secondQuery.length)
        false
       else {
        val differences: List[Boolean] = for {
          index <- Range(0, firstQuery.length).toList
        } yield checkIfSynonyms(firstQuery(index), secondQuery(index), synonyms)
        val areTheSame = differences.forall(_ == true)
        if (areTheSame) true
          else false
       }
    })
  }

  private def createSynonyms(synonym_words: List[(String, String)]): Map[String, String] = {
    val buffer = collection.mutable.Map[String, String]()
    synonym_words.foreach(synonym => {
      buffer(synonym._1) = synonym._2
    })
    buffer.toMap
  }

  private def checkIfSynonyms(wordF: String, wordS: String, synonyms: Map[String, String]): Boolean =
    if (wordF.equals(wordS)) true
      else
    (synonyms.contains(wordF) && synonyms(wordF) == wordS) ||
      (synonyms.contains(wordS) && synonyms(wordS) == wordF)

}
