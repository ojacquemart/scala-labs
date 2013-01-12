package org.scalalabs.intermediate.lab01

import scala.xml._
import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}
import java.util.Locale

case class TwitterUser(
  id: Long,
  name: String,
  screen_name: String,
  description: String,
  location: String,
  url: String,
  profileImageUrl: String,
  statusesCount: Int,
  friendsCount: Int,
  followersCount: Int
)

object TwitterUser {

  def apply(node: Node): TwitterUser = {
    def text(attribute: String) = (node \ attribute).text
    def boolean(attribute: String) = text(attribute).toBoolean
    def long(attribute: String) = text(attribute).toLong
    def int(attribute: String) = text(attribute).toInt
    def option(attribute: String): Option[Long] = {
      val value: String = text(attribute)
      if (value.isEmpty) None
      else Some(value.toLong)
    }

    def dateFormat(attribute: String): DateTime = {
      val dtf: DateTimeFormatter = DateTimeFormat.forPattern("EE MMM dd HH:mm:ss Z yyyy").withLocale(Locale.US)
      dtf.parseDateTime(text(attribute))
    }

    new TwitterUser(
      long("id"),
      text("name"),
      text("screen_name"),
      text("description"),
      text("location"),
      text("url"),
      text("profile_image_url"),
      int("statuses_count"),
      int("friends_count"),
      int("followers_count")
    )
  }
}
