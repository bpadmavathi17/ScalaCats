package lectures.part4Implicits

object ImplicitIntro extends App{

  //Type class
    trait testUnderScore{
    def test(x:Int,y:Int) :Int
  }
  //ins is type class instance
  //which defines the behavior test by providing the implementation as
  //_ + _ which is syntactic sugar for (x,y) => x+y
  val ins:testUnderScore = _ + _
  print(ins.test(1,2))

  //Example of where implicits is used

  case class Person(name:String, age:Int)

  val persons = List(
    Person("Steve",30),
    Person("Amy", 22),
    Person("John",66)
  )

  //Ordering is OOB type class which has the method fromLessThan. This method takes a method which returns boolean and
  // returns type class instance of Ordering. This type class instance is passed as implicit to the sorted method.
  //Thus the custom implementation of sorting for any data type can be achieved by creating implicit(type class instance using
  //fromLessThan method of Ordering Type class

  //implicit val personOrdering:Ordering[Person] = Ordering.fromLessThan(_.name < _.name)
  implicit val personOrdering:Ordering[Person] = Ordering.fromLessThan((a,b) => a.name.compareTo(b.name) < 0)
  print(persons.sorted)

}
