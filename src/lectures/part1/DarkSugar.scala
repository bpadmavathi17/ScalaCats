package lectures.part1

object DarkSugar extends App{

  // #1. Method with single param
  def singleArgMethod (arg:Int) : String = s"hello $arg"
  val description = singleArgMethod{
    //write some code
    42
  }

  //#2. Single Abstract method
  val aThread = new Thread(new Runnable{
    override def run() : Unit = println("hello")
  })
  println(aThread.run())
  val sugarThread = new Thread( () => println("hello sugar") )
  println(sugarThread.run())

  //#3. :: & #:: Last character of the method name decides the associativity. If it is : then right associative, else left

  val prependList = 2 :: List(3,4) //rewritten by compiler as List(3,4). ::(2)
  println(prependList)


}
