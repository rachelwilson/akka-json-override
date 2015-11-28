package simplerethrow

import java.util.NoSuchElementException

class TroublesomeCode {
  def doSomethingRisky(isSpecialCase: Boolean) = {
    if (isSpecialCase)
      throw new NoSuchElementException("special case")
    else
      throw new NoSuchElementException("rethrow me")
  }
}
