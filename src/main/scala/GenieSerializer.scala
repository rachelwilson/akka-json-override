class GenieSerializer {

  import GenieJsonProtocol._
  import scala.io.Source
  import spray.json._

  def deserializeWishesAsList = {
    val json = Source.fromURL(getClass.getResource("genie-wishes.json")).mkString
    json.parseJson.convertTo[GenieWithList]
  }

  def deserializeWishesAsSafeList = {
    val json = Source.fromURL(getClass.getResource("genie-wishes.json")).mkString
    json.parseJson.convertTo[GenieWithSafeList]
  }
}
