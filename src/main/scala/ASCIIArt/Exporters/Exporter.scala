package ASCIIArt.Exporters

/**
 * Interface for exporting.
 * @tparam T Type of exported item
 */
trait Exporter[T] {
  def export(item: T): Unit
}
