package ASCIIArt.Filters.Image.ImageFilters.Scale

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.Pixel
import ASCIIArt.Exceptions.InvalidScale
import ASCIIArt.Filters.Image.ImageFilter
import ScaleEnum.ScaleEnum

/**
 * Filter that scales image by given value.
 * @param value Multiplier for scaling
 * @tparam P Image pixel type
 */
class ScaleImageFilter[P <: Pixel](private val value: ScaleEnum) extends ImageFilter[P] {

  /**
   * Function that applies scale filter.
   * @param source Given image
   * @return Scaled image
   */
  override def apply(source: Image[P]): Image[P] =
    value match {
      case ScaleEnum.HALF_IMAGE   => quarterImage(source)
      case ScaleEnum.ORIGINAL     => source
      case ScaleEnum.DOUBLE_IMAGE => fourTimesImage(source)
      case _                      => throw new InvalidScale()
    }

  /**
   * Function to get quarter size image.
   * @param source Given image
   * @return Quartered image
   */
  private def quarterImage(source: Image[P]): Image[P] = {
    var result = Seq.empty[Seq[P]]
    for (height <- 0 until source.height by 2) {
      var row = Seq.empty[P]
      for (width <- 0 until source.width by 2)
        row = row :+ source.pixelAtPos(width, height)
      result = result :+ row
    }
    new Image[P](result)
  }

  /**
   * Function to get x4 size image.
   * @param source Given image
   * @return Multiplied image
   */
  private def fourTimesImage(source: Image[P]): Image[P] = {
    var result = Seq.empty[Seq[P]]
    for (height <- 0 until source.height) {
      var row = Seq.empty[P]
      for (width <- 0 until source.width)
        row = row :+ source.pixelAtPos(width, height) :+ source.pixelAtPos(
          width,
          height)
      result = result :+ row :+ row
    }
    new Image[P](result)
  }
}
