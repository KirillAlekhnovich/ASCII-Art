package ASCIIArt.Exceptions

class OutOfBounds(x: Int, y: Int) extends RuntimeException(
  "You were trying to get pixel that was out of bounds: (x = " + x + ", y = " + y + ")."
)
