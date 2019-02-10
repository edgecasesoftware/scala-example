package uk.co.edgecasesoftware.sample

import org.scalatest.FlatSpec

class EmployeeServiceTest extends FlatSpec {

  behavior of "The Employee Service"

  it should "get the Person object of an Employee" in {

    val name = "michele"
    val surname = "satta"

    class MyPersonServiceMock(val personList: List[Person] = List[Person]()) extends PersonService {
      override def findPersonByName(name: String): Person = {
        Person(name, surname)
      }
    }

    implicit val myPersonServiceMock:PersonService = new MyPersonServiceMock()

    val employeeService = new EmployeeServiceImpl()


    employeeService.getEmployeeByName(name) match {
      case Right(person) => assert(person.surname == surname)
      case Left(_) => fail()
    }

  }


  it should "return return the correct exception eveloped in an Either object" in {

    val name = "michele"
    val surname = "satta"

    class MyPersonServiceMock(val personList: List[Person] = List[Person]()) extends PersonService {
      override def findPersonByName(name: String): Person = {
        throw new IllegalArgumentException
      }
    }

    implicit val myPersonServiceMock:PersonService = new MyPersonServiceMock()

    val employeeService = new EmployeeServiceImpl()


    val eitherPerson = employeeService.getEmployeeByName(name)

    eitherPerson match {
      case Right(_) => fail()
      case Left(exception) => exception.isInstanceOf[IllegalArgumentException]
    }

  }

}
