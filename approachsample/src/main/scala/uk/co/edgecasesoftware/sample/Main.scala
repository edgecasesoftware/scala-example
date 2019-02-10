package uk.co.edgecasesoftware.sample

object Main extends App {

  override def main(args: Array[String]): Unit = {
    implicit val personList:List[Person] = List[Person](Person("michele", "satta"), Person("dorian","dressler"))

    val personService = new PersonServiceImp()

    val michele = "michele"
    val neil = "neil"

    personService.findPersonByName(michele)
    personService.findPersonByName(neil)


  }

}
