package ASCIIArt.Filters.Image.ImageFilters.Flip

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.Pixel
import ASCIIArt.Exceptions.InvalidAxis
import FlipEnum.FlipEnum
import ASCIIArt.Filters.Image.ImageFilter

/**
 * Filter that flips image by given axis.
 * @param axis Axis for flipping
 * @tparam P Image pixel type
 */
class FlipImageFilter[P <: Pixel](private val axis: FlipEnum) extends ImageFilter[P] {

  /**
   * Function that applies flip filter.
   * @param source Given image
   * @return Flipped image
   */
  override def apply(source: Image[P]): Image[P] =
    axis match {
      case FlipEnum.X => flipX(source)
      case FlipEnum.Y => flipY(source)
      case _          => throw new InvalidAxis()
    }

  /**
   * Function that flips image by X axis.
   * @param source Given image
   * @return Flipped image by X
   */
  private def flipX(source: Image[P]): Image[P] = {
    var result = Seq.empty[Seq[P]]
    for (height <- (source.height - 1) until -1 by -1) {
      var row = Seq.empty[P]
      for (width <- 0 until source.width)
        row = row :+ source.pixelAtPos(width, height)
      result = result :+ row
    }
    new Image[P](result)
  }

  /**
   * Function that flips image by Y axis.
   * @param source Given image
   * @return Flipped image by Y
   */
  private def flipY(source: Image[P]): Image[P] = {
    var result = Seq.empty[Seq[P]]
    for (height <- 0 until source.height) {
      var row = Seq.empty[P]
      for (width <- (source.width - 1) until -1 by -1)
        row = row :+ source.pixelAtPos(width, height)
      result = result :+ row
    }
    new Image[P](result)
  }
}
