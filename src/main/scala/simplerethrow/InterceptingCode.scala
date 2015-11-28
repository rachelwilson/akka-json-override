package simplerethrow

class InterceptingCode {
  def returnDefaultValueInSpecialCaseButRethrowAnythingElse(isSpecialCase: Boolean) = {
    try {
      (new TroublesomeCode).doSomethingRisky(isSpecialCase)
    } catch {
      case e: NoSuchElementException =>
        if (e.getMessage contains "special case") 1
        throw e
    }
  }
}
