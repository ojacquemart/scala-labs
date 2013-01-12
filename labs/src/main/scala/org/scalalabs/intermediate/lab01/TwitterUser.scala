package org.scalalabs.intermediate.lab01

import scala.xml._

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

object TwitterUser extends XMLHelper {

  def apply(implicit node: Node): TwitterUser = {

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
