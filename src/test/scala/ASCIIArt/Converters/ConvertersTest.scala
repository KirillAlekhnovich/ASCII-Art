package ASCIIArt.Converters

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.Pixel
import org.scalatest.FunSuite

class ConvertersTest[P <: Pixel] extends FunSuite {

  // Creates 2x2 image of given pixel
  protected def createSquareImage(pixel: P): Image[P] = {
    val row1 = Seq.empty[P] :+ pixel :+ pixel
    val row2 = Seq.empty[P] :+ pixel :+ pixel
    val grid = Seq.empty[Seq[P]] :+ row1 :+ row2
    new Image(grid)
  }

  // Creates 4x2 image of given pixel
  protected def createRectangleImage(pixel: P): Image[P] = {
    val row1 = Seq.empty[P] :+ pixel :+ pixel :+ pixel :+ pixel
    val row2 = Seq.empty[P] :+ pixel :+ pixel :+ pixel :+ pixel
    val grid = Seq.empty[Seq[P]] :+ row1 :+ row2
    new Image(grid)
  }

  // Creates 4x3 image of two colors
  protected def createColorfulImage(pixel1: P, pixel2: P): Image[P] = {
    val row1 = Seq.empty[P] :+ pixel1 :+ pixel1 :+ pixel1 :+ pixel1
    val row2 = Seq.empty[P] :+ pixel2 :+ pixel2 :+ pixel2 :+ pixel2
    val row3 = Seq.empty[P] :+ pixel1 :+ pixel1 :+ pixel1 :+ pixel1
    val grid = Seq.empty[Seq[P]] :+ row1 :+ row2 :+ row3
    new Image(grid)
  }
}
