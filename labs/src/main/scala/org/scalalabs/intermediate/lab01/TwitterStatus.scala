package org.scalalabs.intermediate.lab01

import scala.xml._
import org.joda.time._
import format.{DateTimeFormatter, DateTimeFormat}
import java.util.Locale

case class TwitterStatus(
    id: Long,
    inReplyToStatusId: Option[Long],
    inReplyToUserId: Option[Long],
    truncated: Boolean,
    favorited: Boolean,
    text: String,
    createdAt: DateTime,
    user: TwitterUser
)

object TwitterStatus {

  def apply(node: Node): TwitterStatus = {

    def text(attribute: String) = (node \ attribute).text
    def boolean(attribute: String) = text(attribute).toBoolean
    def long(attribute: String) = text(attribute).toLong
    def option(attribute: String): Option[Long] = {
      val value: String = text(attribute)
      if (value.isEmpty) None
      else Some(value.toLong)
    }

    def dateFormat(attribute: String): DateTime = {
      val dtf: DateTimeFormatter = DateTimeFormat.forPattern("EE MMM dd HH:mm:ss Z yyyy").withLocale(Locale.US)
      dtf.parseDateTime(text(attribute))
    }

    new TwitterStatus(
      long("id"),
      option("in_reply_to_status_id"),
      option("in_reply_to_user_id"),
      boolean("truncated"),
      boolean("favorited"),
      text("text"),
      dateFormat("created_at"),
      TwitterUser((node \ "user").head)
    )
  }


}