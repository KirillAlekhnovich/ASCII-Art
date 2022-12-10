package ASCIIArt.Filters

/**
 * Interface for all filters
 * @tparam T Type of filtered item
 */
trait Filter[T] {

  /**
   * Function that applies filter on given source.
   * @param source Given source
   * @return Filtered item
   */
  def apply(source: T): T
}
