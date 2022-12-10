package ASCIIArt.Converters.ImageConverters

import ASCIIArt.Converters.Converter
import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.Pixel

/**
 * Interface for all image converters from one pixel type to another.
 *
 * @tparam S Source pixel type
 * @tparam T Target pixel type
 */
trait ImageConverter[S <: Pixel, T <: Pixel] extends Converter[Image[S], Image[T]] {

  /**
   * Function to convert whole image with one pixel type to another.
   * @param sourceImage Given image
   * @return Converted image
   */
  override def convert(sourceImage: Image[S]): Image[T] = {
    var convertedGrid = Seq.empty[Seq[T]]
    for (height <- 0 until sourceImage.height) {
      var row = Seq.empty[T]
      for (width <- 0 until sourceImage.width)
        row = row :+ convertPixel(sourceImage.pixelAtPos(width, height))
      convertedGrid = convertedGrid :+ row
    }
    new Image[T](convertedGrid)
  }

  /**
   * Function to convert specific pixel.
   * @param sourcePixel Given pixel
   * @return Converted pixel
   */
  def convertPixel(sourcePixel: S): T
}
