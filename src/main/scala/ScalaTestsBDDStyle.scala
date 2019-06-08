import org.scalatest.FlatSpec
import org.scalatest.Matchers
import Element.elem

class ElementTestSuite extends FlatSpec with Matchers {
  "A Uniform Element" should
  "have width to the passed value in" in {
    val ele = elem('x',2,3)
    ele.width should be (2)
  }

  it should "have height to be passed value in " in {
    val ele = elem('x',2,3)
    ele.height should be (3)
  }

  //it should "throw an IAE if passed with a negative width " in {
  //  an [IllegalArgumentException] should be thrownBy {
  //    elem('x',-2,3)
  //  }
  //}
}

