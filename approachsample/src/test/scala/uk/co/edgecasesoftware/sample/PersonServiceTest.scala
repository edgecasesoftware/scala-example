package uk.co.edgecasesoftware.sample

import org.scalatest._

class PersonServiceTest extends FlatSpec with Matchers  {

  behavior of "Person Service"

  it should "implement a function to find a person by name" in {
    implicit val personList:List[Person] = List[Person](Person("michele", "satta"), Person("dorian","dressler"))

    val personService = new PersonServiceImp()

    val michele = Person("michele","satta")

    val person = personService.findPersonByName(michele.name)

    assert(michele.surname == person.surname)
  }


  it should "throw an exception in case the name is not there" in {
    implicit val personList:List[Person] = List[Person](Person("michele", "satta"), Person("dorian","dressler"))

    val personService = new PersonServiceImp()

    val michele = "neil"

    assertThrows[IllegalArgumentException] {
      personService.findPersonByName(michele)
    }
  }

}


