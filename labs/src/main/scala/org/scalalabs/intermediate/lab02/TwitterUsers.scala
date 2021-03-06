package org.scalalabs.intermediate.lab02


object TwitterUsers {

  def thatArePopular(users: List[TwitterUser]) = {
    users.filter(_.followersCount > 2000)
  }

  def thatArePopularByScreenName(users: List[TwitterUser]) = {
    thatArePopular(users).map(_.screen_name)
  }

  def thatArePopularByScreenNameSortedbyPopularity(users: List[TwitterUser]) = {
    thatArePopular(users).sortWith(_.followersCount > _.followersCount).map(_.screen_name)
  }

  def thatArePopularByScreenNameAndPopularitySortedbyPopularity(users: List[TwitterUser]) = {
    thatArePopular(users).sortWith(_.followersCount > _.followersCount).map(u => (u.screen_name, u.followersCount))
  }

  def thatAreInBothLists(users: List[TwitterUser], followers: List[TwitterUser]) = {
    users.intersect(followers)
  }

}

class ImplicitTwitterUsers(users: List[TwitterUser]) {

  def thatArePopular() = TwitterUsers.thatArePopular(users)
  def thatArePopularByScreenName() = TwitterUsers.thatArePopularByScreenName(users)
  def thatArePopularByScreenNameAndPopularitySortedbyPopularity() = TwitterUsers.thatArePopularByScreenNameAndPopularitySortedbyPopularity(users)
  def thatArePopularByScreenNameSortedbyPopularity() = TwitterUsers.thatArePopularByScreenNameSortedbyPopularity(users)
  def thatAreInBothLists(followers: List[TwitterUser]) = TwitterUsers.thatAreInBothLists(users, followers)

}

object ImplicitTwitterUsers {

  implicit def listToTwitterUsers(users: List[TwitterUser]): ImplicitTwitterUsers = new ImplicitTwitterUsers(users)
}



