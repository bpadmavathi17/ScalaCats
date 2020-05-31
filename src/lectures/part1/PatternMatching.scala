package lectures.part1

object PatternMatching extends App{

  //1. Constants
  val x = 1
  val matchExp1 = x match {
    case 1 => "One"
  }
  println(matchExp1)

  //2. Match Anything
  // objectName is variable holding value,
  val objectName = 10
  val y = 10
  val matchExp2 = x match {
    case objectName => "Some object that has matching code"
    case _ => "Default"
  }
  println(matchExp2)

  //3. case classes

  case class Person(name:String,age:Int)
  val john = Person("John", 10)
  val matchExp3 = john match{
    case Person(name, age) => s"Person with name $name"
    case _ => "Default"
  }
  println(matchExp3)

  //4.Tuples
  val tuple = ("John",2)
  val matchExp4 = tuple match{
    case (name, age) => s"Tuple with $name, $age"
    case _ => "Default"
  }
  println(matchExp4)

  //5.If guarded
  val matchExp5 = tuple match{
    case (name, age) if age < 9 => s"Tuple with $name, $age greater than 9"
    case (name, age) if age > 9 => s"Tuple with $name, $age greater than 9"
    case _ => "Default"
  }
  println(matchExp5)

  //6.List Patters
  val aList = List(1,2,3,42)
  val matchExp6 = aList match{
    case List(1,_) => "List  with 1 and other element"
    case List(2,_*) => "List  starting with 2"
    case List(1,2,3) :+ 42 => "List  with 42"
    case _ => "Default"
  }
  println(matchExp6)

}
