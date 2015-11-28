import org.scalatest.{Matchers, FlatSpec}

class SafeListSpec extends FlatSpec with Matchers {

  "Creating a SafeList with a null value" should "produce an EmptyList" in {
    val result = SafeList(null)
    val expected = EmptyList

    assertResult(expected)(result)
  }

  "Creating a SafeList with a list value" should "produce a HasItems" in {
    val result = SafeList(List("a", "b"))
    result shouldBe a [HasItems[_]]
  }

  "Getting the value out of a EmptyList" should "produce an empty list" in {
    val result = SafeList(null).get
    val expected = List()

    assertResult(expected)(result)
  }

  "Getting the value out of a SafeList create with a list value" should "produce the original list value" in {
    val listValue = List("a", "b")
    val result = SafeList(listValue).get
    val expected = listValue

    assertResult(expected)(result)
  }
}
