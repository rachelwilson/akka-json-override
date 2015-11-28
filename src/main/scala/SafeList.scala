/**
 *  Represents a null safe List.  This class is based on Scala's Option https://github.com/scala/scala/blob/2.11.x/src/library/scala/Option.scala
 *  Instances of SafeList are either an instance of bbc.types.HasItems or the object EmptyList.
 */
object SafeList {
  def apply[A](x: List[A]): SafeList[A] = if (x == null) EmptyList else HasItems[A](x)
}

sealed abstract class SafeList[+A] extends Product with Serializable {
  def get: List[A]
}

final case class HasItems[+A](x: List[A]) extends SafeList[A] {
  def get = x
}

case object EmptyList extends SafeList[Nothing] {
  def get = Nil
}