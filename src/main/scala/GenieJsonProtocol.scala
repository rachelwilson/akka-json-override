import SafeCollectionFormats._

object GenieJsonProtocol {
  implicit val wishFormat = jsonFormat2(Wish)
  implicit val genieWithListFormat = jsonFormat2(GenieWithList)
  implicit val genieWithSafeListFormat = jsonFormat2(GenieWithSafeList)
}
