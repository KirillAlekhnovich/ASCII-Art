package ASCIIArt.Converters

/**
 * Common interface for all converters.
 * @tparam S Source type for converter
 * @tparam T Converter target type
 */
trait Converter[S, T] {

  /**
   * Method that converts from one type to another.
   * @param source Source type for converter
   * @return Converter target type
   */
  def convert(source: S): T
}
