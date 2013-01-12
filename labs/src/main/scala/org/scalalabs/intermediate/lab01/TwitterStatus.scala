package org.scalalabs.intermediate.lab01

import scala.xml._
import org.joda.time._

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

object TwitterStatus extends XMLHelper {

  def apply(implicit node: Node): TwitterStatus = {

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