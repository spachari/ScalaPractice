package com.scalaCookbook.examples.Collections

object ForceAndViews extends App {
  //Except for the Stream class, whenever you create an instance of a Scala collection class, you’re creating a strict version of the collection.
  // This means that if you create a collection that contains one million elements, memory is allocated for all of those elements immediately.
  // This is the way things normally work in a language like Java.

  //In Scala you can optionally create a view on a collection. A view makes the result nonstrict, or lazy.
  // This changes the resulting collection, so when it’s used with a transformer method, the elements will only be calculated as they
  // are accessed, and not “eagerly,” as they normally would be.

  //To create a view
  val x = (1 to 100).view
  //x: scala.collection.SeqView[Int,scala.collection.immutable.IndexedSeq[Int]] = SeqView(...)

  //The signature of the SeqView shows:

  //Int is the type of the view’s elements.

  //The scala.collection.immutable.IndexedSeq[Int] portion of the output indicates the type you’ll get if you force the collection back to
  // a “normal,” strict collection.

  //To force a veiew to be strict
  x.force
  //res63: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 3, 4 ... 100)

  //When you call foreach(println) (something with a side effect), the results (of a method with view and without view) will the the same.
  //But when you call a method like map(something with no side effects), the results will differ because with view nothing happens
  //until a something like collect(), or println forces it to execute it.

  //The Scala documentation states that a view “constructs only a proxy for the result collection, and its elements
  // get constructed only as one demands them ... A view is a special kind of collection that represents some base collection, but implements
  // all transformers lazily.”

  //A transformer is a method that constructs a new collection from an existing collection. This includes methods like map, filter, reverse,
  // and many more. When you use these methods, you’re transforming the input collection to a new output collection.

  //This helps to explain why the foreach method prints the same result for a strict collection and its view: it’s not a transformer method.
  // But the map method, and other transformer methods like reverse, treat the view in a lazy manner:

  //There are two usecases to use a view
  //1. Performance - When you create a view of billion items, it makes sense to only run it when you need them

  //2. To treat the collection as a database view
  //The view change will be reflected in the collection and the collection change will be reflected in the view
  //Example
  val arr = (1 to 10).toArray

  val vie = arr.view.slice(2,5)

  //Change the array
  arr(2) = 42


  //The change will be reflected in the view
  vie.foreach(println)

  //Change the view
  vie(0) = 10
  vie(1) = 20
  vie(2) = 30

  arr.foreach(println)

  //When we have to change a collection containing billion rows, creating a view on top and changing it will be a
  //powerful way of achieving it

}
