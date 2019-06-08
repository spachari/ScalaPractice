import org.scalatest.FunSuite
import Element.elem
import org.scalatest.DiagrammedAssertions

class ElementSuite extends FunSuite {
  test ("Element should have passed width") {
    val ele = elem('x', 2, 3)

    //assert will only check if the left hand value matches the right hand value
    assert(ele.width == 2)

    //assertResult will compare both the value with expected and actual
    //assertResult(3) {
    //  ele.width
    //}
    //Runnign the above will give Expected 3, but got 2

    //Checking exceptions, not working

    //assertThrows[IllegalArgumentException] {
    //  elem('x',-2,3)
    //}
  }

  test("Check if the list contains 4") {
    assert(List(1,2,3).contains(3))
  }

  test("intercept") {
    val caught = intercept[ArithmeticException] { 1 / 0}
    assert(caught.getMessage == "/ by zero")
  }
}

class ElementSuite1 extends DiagrammedAssertions {
  assert(List(1,2,3).contains(4))
}
