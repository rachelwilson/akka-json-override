
class MalformedContentException(msg: String, cause: Throwable) extends RuntimeException(msg) {
  if (cause != null) initCause(cause)
}
