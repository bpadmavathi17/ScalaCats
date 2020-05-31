package lectures.part1

object AdvancedPatternMatching extends App{


  //#1.Unapply

  //case classes are used in pattern matching by utilising their OOB implementation for unapply method.
  //For classes that cannot be declared as case classes, we have to define unapply method and then use in pattern matching

  class Person (val name:String)
  object Person{
    def unapply(arg: Person): Option[String] = Some(arg.name)
  }
  val bob = new Person("Bob")
  val matchExp = bob match{
    case Person(name) => s"Person with name $name"
    case _ => "Default"
  }
  println(matchExp)
  //unapply method can be overloaded

  //#2. Inix Patterns for types

  case class Or[A,B](a:A, b:B)
  val either = Or(2,"two")
  val description = either match{
      case n Or s => s"$n is $s in description"
      // equal to case Or(n,s) => s"$n is $s in description" and applicable to only two types
      case _ => "Default"
  }
  println(description)


}
