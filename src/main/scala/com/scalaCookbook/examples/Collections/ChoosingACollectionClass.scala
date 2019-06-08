package com.scalaCookbook.examples.Collections

object ChoosingACollectionClass {

  //There are three main collections to choose from
  //1. Seq - Linear collection of elements, either linear (linked list) or indexed
  //2. Set - A collection that contains no duplicate elements
  //3. Map - A collection of key value pairs with unique keys

  //Other collections that are not that popular
  //Stack
  //Queue
  //Range


  //Collection like Types
  //Option/SOme/None
  //Enumerations
  //tuples
  //Try/Success/Failure

  //Choosing a Sequence
  //If we want a indexed sequence, meaning we need to access any elements at constant time (quickly), we use Indexed Sequence
  //If we want a linear sequence, meaning we will work with head, tail and isEmpty, we use Linear sequence

  //Should the collection be mutable or immutable

  //Scala's default collections for Sequences
  //    Collection   |   Immutable   | Mutable
  //2.  Indexed      |  Vector     | ArrayBuffer
  //3.  Linear       |   List      | ListBuffer


  //Total list of immutable sequences
  //List - A singly linked list. Suited for recursive algorithms that work by splitting the head from the remainder of the list.
  //Queue - A first-in, first-out data structure.
  //Range - A range of integer values.
  //Stack - A last-in, first-out data structure.
  //Stream - Similar to List, but it’s lazy and persistent. Good for a large or infinite sequence, similar to a Haskell List.
  //String - Can be treated as an immutable, indexed sequence of characters.
  //Vector - The “go to” immutable, indexed sequence. The Scaladoc describes it as, “Implemented as a set of nested arrays that’s efficient
  // at splitting and joining.”

  //Total list of mutable sequences
  //Array - Backed by a Java array, its elements are mutable, but it can’t change in size.
  //ArrayBuffer - The “go to” class for a mutable, sequential collection. The amortized cost for appending elements is constant.
  //ArrayStack - A last-in, first-out data structure. Prefer over Stack when performance is important.
  //DoubleLinkedList - Like a singly linked list, but with a prev method as well. The documentation states, “The additional
  //links make element removal very fast.”
  //LinkedList - A mutable, singly linked list.
  //ListBuffer - Like an ArrayBuffer, but backed by a list. The documentation states, “If you plan to convert the buffer to a list,
  // use ListBuffer instead of ArrayBuffer.” Offers constant-time prepend and append; most other operations are linear.
  //MutableList - A mutable, singly linked list with constant-time append.
  //Queue - A first-in, first-out data structure.
  //Stack - A last-in, first-out data structure. (The documentation suggests that an ArrayStack is slightly more efficient.)
  //StringBuilder- Used to build strings, as in a loop. Like the Java StringBuilder.

  //When we are creating a library for an API, we can refer to the following traits
  //IndexedSeq - Implies that random access is efficient
  //LinearSeq - Implies that linear access is efficient
  //Seq - Implies that access speed is unimportant

  //Choosing a Map
  //HashMap - The immutable version “implements maps using a hash trie”; the mutable version “implements maps using a hashtable.”
  //LinkedHashMap - “Implements mutable maps using a hashtable.” Returns elements by the order in which they were inserted.
  //ListMap - A map implemented using a list data structure. Returns elements in the opposite order by which they were inserted, as though each element
  // is inserted at the head of the map.
  //Map - The base map, with both mutable and immutable implementations.
  //SortedMap - A base trait that stores its keys in sorted order. (Creating a variable as a SortedMap currently returns a TreeMap.)
  //TreeMap - An immutable, sorted map, implemented as a red-black tree.
  //WeakHashMap - A hash map with weak references, it’s a wrapper around java.util.WeakHashMap.

  //Choosing a Set
  //BitSet - A set of “non-negative integers represented as variable-size arrays of bits packed into 64-bit words.” Used to save memory when you have a
  // set of integers.
  //HashSet - The immutable version “implements sets using a hash trie”; the mutable version “implements sets using a hashtable.”
  //LinkedHashSet - A mutable set implemented using a hashtable. Returns elements in the order in which they were inserted.
  //ListSet✓ A set implemented using a list structure.
  //TreeSet✓✓The immutable version “implements immutable sets using a tree.” The mutable version is a mutable SortedSet with “an immutable AVL Tree
  // as underlying data structure.”
  // Set✓✓Generic base traits, with both mutable and immutable implementations.
  // SortedSet✓✓A base trait. (Creating a variable as a SortedSet returns a TreeSet.)

  //Types that act like a collection
  //Enumeration - A finite collection of constant values (i.e., the days in a week or months in a year).
  //Iterator - An iterator isn’t a collection; instead, it gives you a way to access the elements in a collection. It does, however,
  // define many of the methods you’ll see in a normal collection class, including foreach, map, flatMap, etc. You can also convert an iterator
  // to a collection when needed.
  //Option - Acts as a collection that contains zero or one elements. The Some class and None object extend Option. Some is a container for one element,
  // and None holds zero elements.
  //Tuple - Supports a heterogeneous collection of elements. There is no one “Tuple” class; tuples are implemented as case classes ranging from Tuple1
  // to Tuple22, which support 1 to 22 elements.

}
