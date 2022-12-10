package ASCIIArt.Filters.Image.ImageFilters.Rotate

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.Pixel
import ASCIIArt.Filters.Image.ImageFilter

/**
 * Filter that rotates image by given degree.
 * @param degrees Degree to rotate image
 * @tparam P Image pixel type
 */
class RotateImageFilter[P <: Pixel](private var degrees: Int) extends ImageFilter[P] {

  /**
   * Function that applies rotate filter.
   * @param source Given image
   * @return Filtered image
   */
  override def apply(source: Image[P]): Image[P] = {
    decreaseDegrees()
    if (degrees == 0) return source
    apply(rotate90Right(source))
  }

  /**
   * Decreasing degree value to be in range [0 - 360].
   */
  def decreaseDegrees(): Unit = {
    var decreased = degrees % 360
    if (decreased < 0) decreased += 360
    degrees = decreased
  }

  /**
   * One 90 degree rotate to the right. May be used multiple times to rotate image on 180 or 270 degrees.
   * @param source Given image
   * @return Image rotated right by 90 degrees
   */
  private def rotate90Right(source: Image[P]): Image[P] = {
    var result = Seq.empty[Seq[P]]
    for (width <- 0 until source.width) {
      var row = Seq.empty[P]
      for (height <- (source.height - 1) until -1 by -1)
        row = row :+ source.pixelAtPos(width, height)
      result = result :+ row
    }

    if (degrees > 0) degrees -= 90 else degrees += 90
    new Image[P](result)
  }
}
