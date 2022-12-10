package ASCIIArt.Importers

/**
 * Interface for importing.
 * @tparam T Type of imported item
 */
trait Importer[T] {

  /**
   * Function that loads item.
   * @return Loaded item
   */
  def load(): T
}
