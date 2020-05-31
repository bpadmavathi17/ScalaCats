package lectures.part4Implicits

object ImplicitsAndTypeClass extends App {

  case class User(name: String, email: String)
  case class SpecialUser(name: String, email: String,  status :String = "active")

  val john = User("john", "john@gmail.com")
  val anotherJohn = User("john", "john@yopmail.com")

  val johnS = SpecialUser("john", "john@gmail.com")
  val anotherJohnS = SpecialUser("john", "john@yopmail.com")

  //type class
  trait Equal[T] {
    def apply(a: T, b: T): Boolean
  }

  // To use type classes as implicits declare companion object for the type class
  // and declare the input which will be implicit, usually it will be the type class instance that defines the behavior,
  // in this case equalizer
  object Equal {
    def apply[T](a: T, b: T)(implicit equalizer: Equal[T]) = equalizer.apply(a, b)
  }

  //declare the type class instance by overriding apply method
  object NameEquality extends Equal[User] {
    override def apply(a: User, b: User): Boolean = a.name == b.name
  }

  //type class instance 2
  implicit object FullEquality extends Equal[User] {
    override def apply(a: User, b: User): Boolean = a.name == b.name && a.email == b.email
  }
  // Compiler will look for appropriate implicit param based on the data type of inputs.
  //When more than one implicit definition is found, ambigous implicit values exception is thrown
  println(Equal(john, anotherJohn))

  //To handle this wrap the type class instance into an object and import and use as necessarily

  object FullEqualityObj{
    implicit object  FullEquality extends Equal[User]  {
      override def apply(a:User, b:User) : Boolean = a.name == b.name && a.email == b.email
    }
  }

  object NameEqualityObj{
    implicit object NameEquality extends Equal[User]  {
      override def apply(a:User, b:User) : Boolean = a.name == b.name
    }
  }
  import  FullEqualityObj._
  println(Equal(john, anotherJohn))


  // EqualEnhancer is type enhancer(class that makes the type to belong to the type class by
  // wrapping up the type class behaviour(method) to a new method
  //Now for the data types(like User) which has implicits defined, we can call ===, !== methods

  implicit class EqualEnhancer[T](value:T) {
    def === ( b: T)( implicit imp : Equal[T]): Boolean  = imp.apply(value,b)
    def !== ( b: T)( implicit imp : Equal[T]): Boolean  = !imp.apply(value,b)
  }

  //Compiler will look for anything that can convert john to a object that has === method.
  // Since the john is of type 'User'. It has the implicit of type Equal[T]
  // Complier gets that implicit and calls the === as below
  // john.===(anotherJohn, NameEquality)

  println(john === anotherJohn) // syntactic sugar for infix method call
  println (  john. !==  (anotherJohn))


  //For a new type called SpecialUser, we have the below implicit defined.
  //When === is called on this new type, Compiler will make use of this EqualEnhancer and call the apply method accordingly

  implicit object SpecialUserEquality extends Equal[SpecialUser]  {
    override def apply(a:SpecialUser, b:SpecialUser) : Boolean = a.name == b.name && a.status =="active" && b.status == "active"
  }
  println(johnS === anotherJohnS)
}
