package lectures.part4Implicits

object TypeClass extends App{
  case class User(name:String, email:String)
  //type class
  trait Equal[T] {
    def apply(a:T, b:T):Boolean
  }

  //type class instance 1
  object NameEquality extends Equal[User]  {
    override def apply(a: User, b: User): Boolean = a.name == b.name
  }
  //type class instance 2
  object FullEquality extends Equal[User]  {
    override def apply(a: User, b: User): Boolean = a.name == b.name && a.email == b.email
  }
  val john = User("john", "john@gmail.com")
  val anotherJohn = User("john", "john@yopmail.com")
  println(FullEquality(john, anotherJohn))
  println(NameEquality(john, anotherJohn))

}
