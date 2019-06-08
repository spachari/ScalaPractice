
package bobsrockets


package launch {
  import navigation._
  object Vehicle {
    private[launch] val guide = new Navigator
  }
}

//In particular, the access to Navigator in object Vehicle is permitted because Vehicle is contained in package launch, which is contained in bobsrockets.
// On the other hand, all code outside the package bobsrockets cannot access class Navigator.

//This technique is quite useful in large projects that span several packages. It allows you to define things that are visible in several sub-packages of your
// project but that remain hidden from clients external to your project. The same technique is not possible in Java. There, once a definition escapes its immediate
// package boundary, it is visible to the world at large.

//Of course, the qualifier of a private may also be the directly enclosing package. An example is the access modifier of guide in object Vehicle in Listing 13.12.
// Such an access modifier is equivalent to Java's package-private access.

//13.1
//no access modifier	public access
//private[bobsrockets]	access within outer package
//private[navigation]	same as package visibility in Java
//private[Navigator]	same as private in Java
//private[LegOfJourney]	same as private in Scala
//private[this]	access only from same object

//All qualifiers can also be applied to protected, with the same meaning as private. That is, a modifier protected[X] in a class C allows access to the labeled
//definition in all subclasses of C and also within the enclosing package, class, or object X. For instance, the useStarChart method in Listing 13.12 is accessible
//in all subclasses of Navigator and also in all code contained in the enclosing package navigation. It thus corresponds exactly to the meaning of protected in Java.

//The qualifiers of private can also refer to an enclosing class or object. For instance the distance variable in class LegOfJourney in Listing 13.12 is labeled
// private[Navigator], so it is visible from everywhere in class Navigator. This gives the same access capabilities as for private members of inner classes in Java.
// A private[C] where C is the outermost enclosing class is the same as just private in Java.

package navigation {
  private[bobsrockets] class Navigator { //This means class Navigator is visible in all classes and packages that are contained in package bobsrockets
    protected[navigation] def useStarChart() = {}
    class LegOfJourney {
      private[Navigator] val distance = 100 //This value can be accesssed from anywhere in class Navigator eventhough it is an inner class variable
                                            //This is the same as java
    }
    private[this] var speed = 200        //A definition labeled private[this] is accessible only from within the same object that contains the definition.
                                         //Such a definition is called object-private. This means that any access must not only be within class Navigator, it must also be made from the very same instance of Navigator.
                                         //So access "this.speed" and speed is valid

    //The following access, though, would not be allowed, even if it appeared inside class Navigator:

    //val other = new Navigator
    //other.speed // this line would not compile
    //Marking a member private[this] is a guarantee that it will not be seen from other objects of the same class. This can be useful for documentation.
    // It also sometimes lets you write more general variance annotations (see Section 19.7 for details).
  }
  class NavigatorTest {
    val b = new Navigator
  }
}

//Finally, Scala also has an access modifier that is even more restrictive than private. A definition labeled private[this] is accessible only from within the same
// object that contains the definition. Such a definition is called object-private. For instance, the definition of speed in class Navigator in Listing 13.12 is
// object-private. This means that any access must not only be within class Navigator, it must also be made from the very same instance of Navigator. Thus the
// accesses "speed" and "this.speed" would be legal from within Navigator.

//The following access, though, would not be allowed, even if it appeared inside class Navigator:

//val other = new Navigator
//other.speed // this line would not compile
//Marking a member private[this] is a guarantee that it will not be seen from other objects of the same class. This can be useful for documentation.
// It also sometimes lets you write more general variance annotations (see Section 19.7 for details).

//To summarize, Table 13.1 here lists the effects of private qualifiers. Each line shows a qualified private modifier and what it would mean if such a modifier were
// attached to the distance variable declared in class LegOfJourney in Listing 13.12.