package com.programmingscala.examples.types.typeProjections

//We can define a type like this
trait HList {
  type Hd
}

//We are using the type.
class IntList extends HList{
  type Hd = Int
}



object SimpleExampleAndDefinitionOfHashOrTypeProjection extends App {

  //In scala, The only way to access a type is via a #
  val x: IntList#Hd = 10

  //ClassName#typeName

  //Let's test using implicitly
  implicitly[Int =:= IntList#Hd]

  //Consider this example
  class X {
    class Y
    def getY(x : Y) = "Gor an x"
    def getY1(y : X#Y) = "Got any instance of X"
  }

  val x1 = new X
  val x2 = new X

  val y1 = x1.getY(new x1.Y)
  val y2 = x2.getY(new x2.Y)

  //With Type projections such as X#Y, we can do this
  val y3 = x1.getY1(new x1.Y)
  val y4 = x1.getY1(new x2.Y)

  //SO effectively what we are saying is X#Y means an x's type y

  //Let's get back to type lambda.

  //Consider an anomyous function/lambda and its usage
  val multiplyBy4 : (Int) => (Int) = _ * 2

  val list = List(1,2,3,4)

  val output = list map multiplyBy4

  //Type lambda is lambda for types

  //As its name suggests, it is similar to anonymous functions, but for types.
  //In fact, type lambdas are used to define an anonymous/inner types for a given context.
  //It is particularly useful when a type constructor has fewer type parameters compared to the parameterized type
  //that we want to apply in that context.

  //Consider the following trait we want to implement

  trait myFunctor[A, +M[_]]{
    def map[B](func : A =>  B) : M[B]
  }

  //Let's implement it for a sequence
  case class SeqFunctor[A] (container : Seq[A]) extends myFunctor[A, Seq] {
    override def map[B](func: A => B): Seq[B] = container map func
  }

  val list1 = SeqFunctor(list)
  val output1 = list1.map(multiplyBy4)

  println(output1)


  //However, in the case of Map[K,V] it can be tricky to extend as +M[_] has only one _ and you have to fit in two variables
  case class MapFunctor[K,V](container : Map[K,V])
    extends myFunctor[V,({ type V[A] = Map[K,A]})#V] //Here, you are not saying [K,V], you are stating V[A] is actually a type of
                                                     //Map[K,A] and then getting the types value by using #
                                                     //In other words you are trying to say V = Map[K]
                                                     //The V is an alias for Map with an embedded type parameter that
      //  will be inferred in subsequent code.
  {
    override def map[B](func: V => B): Map[K, B] = container map  {
      case(k,v) => (k, func(v))
    }
  }


  //Let's disseminate
  //({ type V[A] = Map[K,A]})#V

  //Here { type V[A] = Map[K,A]} denotes a structural type.
  // It essentially specifies an inner/annonymous type alias V[A],

  //like in the this example
  type V[A] = Map[Int, A] //

  // which is then matched against the (outer) #V.
  // Type parameter K is partially applied and has been resolved from the context in this case.
  // By applying type projection, #L, we get the type member out of the structural type, and thus define an alias for
  // Map[K,_] in effect.

  val map = Map(1 -> 2, 2 -> 3)

  val mapFunctor = MapFunctor(map)

  val mapOutput = mapFunctor.map(multiplyBy4)

  println(mapOutput)

  //To avoid using this MapFunctor we can do this
  //1. Use back ticks to partially apply Map[K] and get Map[K, V2]
  //(thats all we want, if you think about it). The source signature is

  //trait myFunctor[A, +M[_]]

  //So we want to be able to pass 1 value for M (like Seq), but cannot not Map[_,_]

  //1. type `Map[K]`[V2] = Map[K, V2] will help us to use `Map[K]` as M in myFunctor[A, +M[_]]
  //2. myFunctor[V, `Map[K]`] will help us to substitute `Map[K]` for +M[_]

  case class ReadableMapFunctor[K,V](container : Map[K,V]) {
    def mapFunctor[V2] = {
      type `Map[K]`[V2] = Map[K, V2]

      new myFunctor[V, `Map[K]`] {
        override def map[B](func: V => B) = container map {
          case(k,v) => (k,func(v))
        }
      }
    }
  }

  val mapReadableFunctor = ReadableMapFunctor(map)

  val output2 = mapReadableFunctor.mapFunctor.map(multiplyBy4)

  println(output2)
}
