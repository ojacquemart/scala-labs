package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._

case class Person(age: Int, firstName: String, lastName: String)

object BasicListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l.max
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {
    if (l1 isEmpty) l2
    else if (l2 isEmpty) l1
    else  l1.zip(l2).map(x => x._1 + x._2)
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {

    def sumOfManyToList(l: List[List[Int]]): List[Int] = {
      l match {
        case head :: tail => sumOfTwo(head, sumOfManyToList(tail))
        case Nil => Nil
      }
    }

    sumOfManyToList(l.toList)
  }

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheMenFromTheBoys(persons: List[Person]): List[List[String]] = {

    def sortByAgeAndMapToName(persons: List[Person]) = persons.sortBy(_.age).map(_.firstName)

    val (minors, adults) = persons.partition(p => p.age < 18)

    List(sortByAgeAndMapToName(minors), sortByAgeAndMapToName(adults))
  }

}