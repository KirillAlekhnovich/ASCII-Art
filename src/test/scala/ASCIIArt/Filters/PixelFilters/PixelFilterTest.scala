package ASCIIArt.Filters.PixelFilters

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import org.scalatest.FunSuite

class PixelFilterTest extends FunSuite {

  protected def create1x1GSImage(initPixelValue: Int): Image[GSPixel] = {
    val row = Seq.empty[GSPixel] :+ GSPixel(initPixelValue)
    val grid = Seq.empty[Seq[GSPixel]] :+ row
    new Image(grid)
  }
}
