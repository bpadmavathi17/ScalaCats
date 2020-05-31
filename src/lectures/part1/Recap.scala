package lectures.part1

import scala.annotation.tailrec

object Recap extends App{

  val aCond : Boolean = false
  val aCondVal = if(aCond) 42 else 66
  //instructions - fundamental operation in imperative languages
  //expressions

  //Compiler infers types for us
  val aCodeBlock = {
    if(aCond) 42
    66
  }
  //Unit = void
  val theUnit = println("Hello Scala")

  //function
  def aFunction(x:Int) : Int = x+1

  //recursion : stack and tail
  @tailrec
  def factorial(n:Int, acc:Int ) : Int = {
    if (n <= 0) acc
    else factorial(n - 1, n * acc)
  }

  //object oriented programming
  class Animal
  class Dog extends Animal
  val dog : Animal = new Dog //subtyping polymorphism

  trait Carnivore {
    def eats(a:Animal) : Unit
  }
  class Crocodile extends Animal with Carnivore {
    override def eats(a: Animal): Unit = println("Crunch!")
  }

  //Method Notations
  val aCroc = new Crocodile
  aCroc.eats(dog)
  aCroc eats dog

  //Anonymous class
  val aCarnivore = new Carnivore {
    override def eats(a: Animal): Unit = println("Anonymous class carnivore")
  }

  //generics
  abstract class MyList[+A]
  object MyList
  //class and object are companions. +A is variance(covariance)

  //case classes
  case class Person(age: Int, name: String)

  //Exception try catch finally
  val throwsExcep = throw new RuntimeException //Nothing type
  val aPotentialException = try{
    throw new RuntimeException
  }catch{
    case e : Exception => "I caught Exception"
  }finally {
    println("Some logs")
  }

  //Functional Programming
  val incrementer = new Function1[Int,Int]{
    override def apply(v1: Int): Int = v1+1
  }
  //Function1 is a trait that has apply method defined. incrementer holds an instance of the newly
  // defined class of trait Function1
  incrementer(1) // prints 2
  //syntactic sugar for the above is
  val anonymInc = (x:Int) => x+1

  List(1,2,3).map(anonymInc) // HOF
  //map, flatmap, filter

  //for-comprehension
  val pairs = for{
    num <- List(1,2,3)
    char <- List('a','b','c')
  }yield num + '_' + char

  //Collections : Seq, Arrays, Vectors, maps Tuples
  val aMap = Map(
    "D" -> 789,
    "J" -> 123
  )

  //Options, Try
  val anOption = Some(2)

  //pattern matching
  val x = 2
  val order =x match {
    case 1 => "first"
    case 2 => "second"
    case _ => "anything else"
  }






}
