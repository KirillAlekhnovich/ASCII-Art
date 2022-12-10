package ASCIIArt.Exceptions

class InvalidParameter(attribute: String) extends RuntimeException(
  "Couldn't convert \"" + attribute + "\" parameter into required data type."
)
