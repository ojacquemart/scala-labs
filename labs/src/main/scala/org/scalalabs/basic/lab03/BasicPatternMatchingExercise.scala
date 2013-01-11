package org.scalalabs.basic.lab03
import sys._
/**
 * This exercise introduces you to the powerful pattern matching features of Scala.
 *
 * Pattern matching can in its essence be compared to Java's 'switch' statement,
 * even though it provides many more possibilites. Whereas the Java switch statmenet
 * lets you 'match' primitive types up to int's, Scala's pattern matching goes much
 * further. Practically everything from all types of objects and Collections
 * can be matched, not forgetting xml and a special type of class called case classes.
 *
 * Pattern matching is also often used in combination with recursive algorithms.
 *
 * For this exercise exclusively use pattern matching constructs in order to make the
 * corresponding unit test work.
 *
 * Reference material to solve these exercises can be found here:
 * Pattern matching in general: http://programming-scala.labs.oreilly.com/ch03.html#PatternMatching
 * Pattern matching in combination with partial functions: http://programming-scala.labs.oreilly.com/ch08.html#PartialFunctions
 */

object BasicPatternMatchingExercise {

  /*************************************************************************
   * Basic pattern matching exercises
   * For expected solution see unittest @BasicPatternMatchingExerciseTest
   *************************************************************************/

  val languagesDescriptions = Map(
          ("Java" -> "OOP"),
          ("Smalltalk" -> "OOP"),
          ("Clojure" -> "Functional"),
          ("Clojure" -> "Functional"),
          ("Haskell" -> "Functional"),
          ("Scala" -> "Hybrid"),
          ("C" -> "Procedural"))

  def describeLanguage(s: String) = {
    languagesDescriptions.getOrElse(s, "Unknown")
  }

  def matchOnInputType(in: Any) = in match {
    case (s: String) => "A string with length " + s.length
    case (i: Int) => if (i > 0) "A positive integer" else "A negative integer"
    case (o: Option[_]) => "A Scala Option subtype"
    case (a: Any) => "Some Scala class"
    case _ => "A null value"
  }

  def older(p: Person): Option[String] = {
    if (p.age > 30) Some(p.name)
    else None
  }

  /*************************************************************************
   * Pattern matching with partial functions
   * For expected solution see @BasicPatternMatchingExerciseTest
   *************************************************************************/

  val   pf1: PartialFunction[String, String] = {
    case "scala-labs" => "Got scala-labs"
    case "stuff" => "Got stuff"
  }

  val pf2: PartialFunction[String, String] = {
    case "other stuff" => "Got stuff"
  }

  val pf3:PartialFunction[String, String] = {
    pf1 orElse pf2
  }

}

case class Person(name: String, age: Int)