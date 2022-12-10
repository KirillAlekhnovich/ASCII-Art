package ASCIIArt.Data.Image

import ASCIIArt.Data.Pixel.Pixel
import ASCIIArt.Exceptions.{EmptyGrid, OutOfBounds}

/**
 * Image model that stores grid of pixels.
 * @param pixelGrid Sequence of pixels that define image
 * @tparam P Type of pixel
 */
class Image[P <: Pixel](private val pixelGrid: Seq[Seq[P]]) {

  if (pixelGrid.isEmpty) throw new EmptyGrid()

  private val _height: Int = pixelGrid.size
  private val _width: Int = pixelGrid.head.size

  /**
   * Image height getter.
   * @return Image height
   */
  def height: Int = _height

  /**
   * Image width getter.
   * @return Image width
   */
  def width: Int = _width

  /**
   * Function that gets pixel at specific position.
   * @param x Width
   * @param y Height
   * @return Pixel at given position
   */
  def pixelAtPos(x: Int, y: Int): P = {
    if (y < 0 || y >= height) throw new OutOfBounds(x, y)
    if (x < 0 || x >= width) throw new OutOfBounds(x, y)
    pixelGrid(y)(x)
  }
}
