package ASCIIArt.Importers.ImageImporter

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.Pixel
import ASCIIArt.Importers.Importer

/**
 * Interface for importing images.
 * @tparam T Type of imported image pixel
 */
trait ImageImporter[T <: Pixel] extends Importer[Image[T]] {}
