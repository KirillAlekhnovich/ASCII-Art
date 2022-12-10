package ASCIIArt.Filters.Image.PixelFilters

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.Pixel
import ASCIIArt.Filters.Image.ImageFilter

/**
 * Filters that use its methods on specific pixels.
 * @tparam T Pixel type
 */
trait PixelFilter[T <: Pixel] extends ImageFilter[T] {

  /**
   * Function that calls applyOnPixel function on every pixel.
   * @param sourceImage Given image
   * @return Filtered image
   */
  override def apply(sourceImage: Image[T]): Image[T] = {
    var convertedGrid = Seq.empty[Seq[T]]
    for (height <- 0 until sourceImage.height) {
      var row = Seq.empty[T]
      for (width <- 0 until sourceImage.width)
        row = row :+ applyOnPixel(sourceImage.pixelAtPos(width, height))
      convertedGrid = convertedGrid :+ row
    }
    new Image[T](convertedGrid)
  }

  /**
   * Function that applies filter on specific pixel.
   * @param pixel Given pixel
   * @return Filtered pixel
   */
  def applyOnPixel(pixel: T): T
}
