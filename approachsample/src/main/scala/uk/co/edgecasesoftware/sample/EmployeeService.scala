package uk.co.edgecasesoftware.sample

import scala.util.{Failure, Success, Try}

trait EmployeeService {

  implicit val personService:PersonService


  def getEmployeeByName(name: String):Either[Throwable, Person] = {

    Try {
      personService.findPersonByName(name)
    } match {
      case Success(person) => Right(person)
      case Failure(exception) => Left(exception)
    }

  }

}

class EmployeeServiceImpl(implicit val personService: PersonService) extends EmployeeService
