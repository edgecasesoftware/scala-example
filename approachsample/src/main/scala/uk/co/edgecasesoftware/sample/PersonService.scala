package uk.co.edgecasesoftware.sample


case class Person(name:String, surname:String)

trait PersonService {

  implicit val personList:List[Person]

  private def findByName(name : String) : Option[Person] = personList.find(p => p.name == name)

  def findPersonByName(name:String) : Person = findByName(name) match {
    case None => throw new IllegalArgumentException("person not found")
    case Some(p) => p
  }

}

class PersonServiceImp(implicit val personList:List[Person]) extends PersonService
