package com.scalaCookbook.examples.Packages {
  class Foo {
    override def toString: String = s"I am from com.scalaCookbook.examples.Packages.Foo package"
  }
}

package com.scalaCookbook.examples.Packages.orderentry {
  class Foo {
    override def toString: String = s"I am from com.scalaCookbook.examples.orderentry.Foo package"
  }
}

package com.scalaCookbook.examples.Packages.customers {
  class Foo {
    override def toString: String = s"I am from com.scalaCookbook.examples.customers.Foo package"
  }

  package database {
    class Foo {
      override def toString: String = s"I am from com.scalaCookbook.examples.customers.database.Foo package"
    }
  }
}