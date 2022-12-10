package ASCIIArt.Filters.ImageFilters

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import org.scalatest.FunSuite

class ImageFilterTest extends FunSuite {

  protected val pixel1: GSPixel = GSPixel(1)
  protected val pixel2: GSPixel  = GSPixel(2)
  protected val pixel3: GSPixel  = GSPixel(3)
  protected val pixel4: GSPixel  = GSPixel(4)

  protected def createGSSquareImage(): Image[GSPixel] = {
    val row1 = Seq.empty[GSPixel] :+ pixel1 :+ pixel2
    val row2 = Seq.empty[GSPixel] :+ pixel3 :+ pixel4
    val grid = Seq.empty[Seq[GSPixel]] :+ row1 :+ row2
    new Image(grid)
  }

  protected def createGSRectangleImage(): Image[GSPixel] = {
    val row1 = Seq.empty[GSPixel] :+ pixel1 :+ pixel1 :+ pixel2 :+ pixel2
    val row2 = Seq.empty[GSPixel] :+ pixel3 :+ pixel3 :+ pixel4 :+ pixel4
    val grid = Seq.empty[Seq[GSPixel]] :+ row1 :+ row2
    new Image(grid)
  }
}
