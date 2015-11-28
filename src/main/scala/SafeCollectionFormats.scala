import spray.json._

object SafeCollectionFormats extends DefaultJsonProtocol {

  class SafeListFormat[A : JsonFormat] extends RootJsonFormat[SafeList[A]] {
    def write(sl: SafeList[A]): JsValue =
      listFormat[A].write(sl.get)

    def read(json: JsValue): SafeList[A] = {
      val list: List[A] = listFormat[A].read(json)
      SafeList[A](list)
    }
  }

  implicit def safeListFormat[A : JsonFormat]: RootJsonFormat[SafeList[A]] = new SafeListFormat[A]

  /**
   * Overrides fromField in spray.json ProductFormats in order to intercept the DeserialisationException thrown by missing fields in the json
   * Only if the object to be unmarshalled to is a SafeList then return a SafeList.EmptyList in this case.
   * Otherwise rethrow the original DeserializationException
   */
  override def fromField[T](value: JsValue, fieldName: String)(implicit reader: JsonReader[T]) = {
    try {
      super.fromField(value, fieldName)(reader)
    } catch {
      case e: DeserializationException =>
        if (reader.isInstanceOf[SafeListFormat[_]]) EmptyList.asInstanceOf[T]
        else deserializationError("Object is missing required member '" + fieldName + "'", e)

        //this also doesnt work
        //else throw new DeserializationException(e.getMessage, e.getCause, List(fieldName))

        //however this *does* work
        //else throw new MalformedContentException(e.getMessage, e.getCause)
    }
  }

}

