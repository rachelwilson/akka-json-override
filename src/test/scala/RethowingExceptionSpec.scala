import java.util.NoSuchElementException
import spray.json._

import org.scalatest.{Matchers, FlatSpec}
import simplerethrow.InterceptingCode

class RethowingExceptionSpec extends FlatSpec with Matchers {

  // prove that overridden methods can rethrow exceptions thrown in the original method
  "catching and rethrowing an exception originally thrown from class that I control" should "rethrow the exception" in {
    val underTest = new InterceptingCode

    the [NoSuchElementException] thrownBy underTest.returnDefaultValueInSpecialCaseButRethrowAnythingElse(isSpecialCase=false) should have message "rethrow me"
  }

  //now get akka/spray json involved
  "unmarshalling a List of wishes with one missing likelihood" should "result in an DeserializationException thrown with the correct" in {
    val underTest = new GenieSerializer

    //this fails
    the [DeserializationException] thrownBy underTest.deserializeWishesAsList should have message "Object is missing required member 'likelihood'"

    //but this passes
    //the [DeserializationException] thrownBy underTest.deserializeWishesAsList should have message "Object is missing required member 'wishes'"
  }

  "unmarshalling a SafeList of wishes with one missing likelihood" should "result in a DeserializationException" in {
    val underTest = new GenieSerializer

    //this fails
    an [DeserializationException] should be thrownBy underTest.deserializeWishesAsSafeList

    //but this passes if I change the code in SafeCollectionFormats to throw MalformedContentException instead
    //the [MalformedContentException] thrownBy underTest.deserializeWishesAsList should have message "Object is missing required member 'likelihood'"
  }

}
