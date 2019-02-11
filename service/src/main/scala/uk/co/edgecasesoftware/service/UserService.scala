package uk.co.edgecasesoftware.service

import com.typesafe.scalalogging.LazyLogging
import io.circe._
import io.circe.generic.semiauto._

import scala.collection.mutable.ListBuffer
import scala.concurrent.{ExecutionContext, Future}

case class User(id:Int, name:String, surname:String, email:String)

class UserService(implicit val ec:ExecutionContext) extends LazyLogging {

  val userList = new ListBuffer[User]()

  def getUsers: List[User] = {
    userList.toList
  }

  def addUser(user:User):Future[User] = Future {
    userList += user
    user
  }

  def deleteUserById(userId:Int): List[User] = {
    userList.find(user => user.id == userId) match {
      case Some(user) => userList -= user
      case None => logger.info("User not present!")
    }
    userList.toList
  }
}
