package com.scalaCookbook.examples.Functions

//Notes
//Let's take an example
//val x = 10                     //This means x is set to 10
//val x = (i : Int) => i + 10    //This means x is set to a function literal (i : Int) => i + 10

//In the above example, (i : Int) => i + 10 is the function literal, in that => is the transformer that transforms what is in left
                                        //(i : Int) to what is in the right i + 10
//Let's assign this function literal to a value called double

//val double = (i : Int) => i + 10

//Now, just like when we have an expression
// like val x = 10
// we say x is of type Int or is an instance of Int


//Same way, we can say that in

//val double = (i : Int) => i + 10

//double is an type/instance of a function that takes an Int and transforms it into an Int
//we can see the type by
// scala> :t double
// Int => Int

//We can now invoke double like this
//double(2)

//Or we can pass it to any method that takes a function parameter with it's signature
//For example, the map method of a Sequence is a generic method that takes a input parameter of type A and returns type B
//We can pass around double to map

//scala> list
//res269: List[Int] = List(1, 2, 3, 4)

//scala> list.map(double)
//res270: List[Int] = List(11, 12, 13, 14)

//There are two ways of declaring/creating a function literal
//Implicit apporach - this way scala can infer the return type of the function as Boolean
//val add = (i : Int) => { i % 2 == 0}

//Explicit approach - this way we will specifically mention the return type of the function

//val add : (Int) => Boolean = i => { i % 2 == 0 }

//This says add's type is (Int) => Boolean and it's value is i => { i % 2 == 0 }


//Anoher example of implicit and explicit declarations

//implicit approach
//val addition = (x : Int, y : Int) => x + y

//explicit approach
//val expAddition : (Int, Int) => Int = (x,y) => x + y

//access method - val
//name of the function - expAddition
//type of the function (Int, Int) => Int = (x,y)
//actual code - (x,y) => x + y which is the function literal
          //Within the code (x,y) => input parameters
                            //x + y => method body

//It is same as
//val x : Int = 10




object PassAFunctionLikeAVariable {

}
