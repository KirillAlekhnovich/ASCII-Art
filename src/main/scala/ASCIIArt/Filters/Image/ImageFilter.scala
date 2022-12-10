package ASCIIArt.Filters.Image

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.Pixel
import ASCIIArt.Filters.Filter

/**
 * Interface for all image filters.
 * @tparam T Pixel type
 */
trait ImageFilter[T <: Pixel] extends Filter[Image[T]] {}
