package ASCIIArt.Config

/**
 * Enum list of allowed extensions for source files.
 */
object Extensions extends Enumeration {

  private val png = Value("png")
  private val jpg = Value("jpg")
  private val jpeg = Value("jpeg")
  private val gif = Value("gif")

  /**
   * Function that checks if file extension is acceptable.
   * @param file Input file path
   * @return true => extension allowed, otherwise false
   */
  def isAllowed(file: String): Boolean =
    values.exists(getExtension(file) == _.toString)

  /**
   * Function that retrieves file extension from its path.
   * @param file Input file path
   * @return File extension as String
   */
  private def getExtension(file: String): String =
    file.takeRight(file.length - file.lastIndexOf('.') - 1)
}
