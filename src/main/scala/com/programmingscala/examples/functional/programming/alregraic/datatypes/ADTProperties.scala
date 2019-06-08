package com.programmingscala.examples.functional.programming.alregraic.datatypes

class ADTProperties {
    //In mathematics an algebra is defined by three aspects:

    //A set of objects: not to be confused with our the OO notion of objects. They could be numbers or almost anything.

    //A set of operations: how elements are combined to create new elements.

    //A set of laws: these are rules that define the relationships between operations and objects. For example, for numbers, (x + (y + z)) == ((x + y) + z) (associativity law).

}

class CategoryTheory {
  //Category theory defines three entities which matches the definition of algebra (above)

  //1. A class consists of objects. These are not the term as OOP, but they ahve similar implications

  //2. A class of morphisms, also called arrows. A generalized notion of functions and written f: A -> B (f: A => B in Scala). For each morphism, f, one object is the domain of f and one is the codomain.

  //3. A binary operation called morphism composition with the property that for f: A -> B and g: B -> C, the composition g ◦ f: A -> C exists.

  //Two axioms are satisfied by morphism composition
  //Each object x has one and only one identity morphism, i.e., where the domain and codomain are the same, IDx and composition with identity has the following property: f ◦ IDx = IDx ◦ f.

  //Associativity. For f: A -> B, g: B -> C, h: C -> D, (f ◦ g) ◦ h = f ◦ (g ◦ h).
}