package lectures.part4Implicits

object PimpMyLibrary extends App{

  implicit class RichInt(value:Int){
    def isEven:Boolean = value%2 == 0
    def sqrt:Double = Math.sqrt(value)
  }

  //Compiler looks for anything that can convert "4" to any data type that has isEven method defined.
  //In this case we have defined the implicit. So Compiler picks up the implicit and runs the method defined in it
  println(4.isEven)
  println(25.sqrt)

  //By defining Implicit classes for OOB data types, we can add new features without modifying the OOB code.
  //This is also called type enhancemenet

}
