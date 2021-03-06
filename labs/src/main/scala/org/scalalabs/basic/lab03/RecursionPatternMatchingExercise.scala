package org.scalalabs.basic.lab03

import sys._

/**
 * This exercise introduces you to pattern matching in combination with recursion.
 *
 * Recursion is a key concept for the functional style programming.
 * In the exercises below you learn how to apply recursion in combination with Scala's pattern matching facilities.
 *
 * For this exercise exclusively use pattern matching constructs in order to make the corresponding unittest work.
 *
 * Reference material to solve these exercises can be found here:
 * Pattern matching in general: http://programming-scala.labs.oreilly.com/ch03.html#PatternMatching
 * Pattern matching and recursion: http://programming-scala.labs.oreilly.com/ch08.html#Recursion
 */

object RecursionPatternMatchingExercise {

  /** ***********************************************************************
    * Recursive algorithms with pattern matching
    * For expected solution see unittest @RecursionPatternMatchingExerciseTest
    * ************************************************************************/

  def compress[T](in: List[T]): List[T] = {
    in.distinct
    //    in match {
    //    case Nil => Nil
    //    case a :: b :: tail if a == b => compress(a :: tail)
    //    case a :: tail => a :: compress(tail)
    //    }
  }

  def groupConsecutive[T](in: List[T]): List[List[T]] = {
    in match {
      case Nil => Nil
      case a :: tail => {
        val (equals, tail) = in.span(_ == a)
        equals :: groupConsecutive(tail)
      }
    }
  }

  def groupEquals[T](in: List[T]): List[List[T]] = {
    in match {
      case Nil => Nil
      case a :: b :: tail => {
        val (equals, tail) = in.partition(_ == a)
        equals :: groupEquals(tail)
      }
    }
  }

  def amountEqualMembers[T](in: List[T]): List[(Int, T)] = {
    groupEquals(in).map((x: List[T]) => (x.length, x.head))
  }

  def zipMultiple(in: List[List[_]]): List[List[_]] = {
    error("fix me")
  }

  def zipMultipleWithDifferentSize(in: List[List[_]]): List[List[_]] = {
    error("fix me")
  }

}
