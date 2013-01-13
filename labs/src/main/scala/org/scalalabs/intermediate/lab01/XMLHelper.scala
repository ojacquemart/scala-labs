package org.scalalabs.intermediate.lab01

import scala.xml._

import java.util.Locale

import org.joda.time.format._
import org.joda.time.DateTime

trait XMLHelper  {
  def boolean(attribute: String)(implicit node: Node) = text(attribute).toBoolean
  def long(attribute: String)(implicit node: Node) = text(attribute)(node).toLong
  def int(attribute: String)(implicit node: Node) = text(attribute)(node).toInt
  def text(attribute: String)(implicit node: Node) = (node \ attribute).text

  def option(attribute: String)(implicit node: Node): Option[Long] = {
    val value: String = text(attribute)(node)
    if (value.isEmpty) None
    else Some(value.toLong)
  }

  def dateFormat(attribute: String)(implicit node: Node): DateTime = {
    val dtf: DateTimeFormatter = DateTimeFormat.forPattern("EE MMM dd HH:mm:ss Z yyyy").withLocale(Locale.US)
    dtf.parseDateTime(text(attribute)(node))
  }
}