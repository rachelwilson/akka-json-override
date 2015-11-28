import org.scalatest.FlatSpec
import SafeCollectionFormats._
import GenieJsonProtocol._
import spray.json.{JsObject, JsString, JsArray, JsValue}

class SafeCollectionFormatsMarshallingSpec extends FlatSpec {

//  "Unmarshalling a json array with simple items" should "produce a SafeList with simple items" in {
//    val json: JsValue = JsArray(JsString("a"), JsString("b"), JsString("c"))
//    val list = List("a", "b", "c")
//
//    val result = json.convertTo[SafeList[String]]
//
//    assertResult(list)(result.get)
//  }
//
//  "Unmarshalling a json array with objects" should "produce a SafeList with objects" in {
//    val wish = Wish("two front teeth", "good")
//    val list = List(wish)
//
//    val json: JsValue = JsArray(
//      JsObject(
//        Map(
//          "request" -> JsString("two front teeth"),
//          "likelihood" -> JsString("good")
//        )
//      )
//    )
//    val result = json.convertTo[SafeList[Wish]]
//
//    assertResult(list)(result.get)
//  }
//
//  "Unmarshalling json that is missing a SafeList field" should "produce an object with a EmptyList field you can interrogate safely" in {
//    val wishesJson = JsObject(
//      Map(
//        "master" -> JsString("aladdin")
//      )
//    )
//    val result = wishesJson.convertTo[GenieWithSafeList]
//
//    assertResult(Nil)(result.wishes.get)
//  }
}
