package ASCIIArt.Data

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.Pixel
import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel
import ASCIIArt.Exceptions.EmptyGrid
import org.scalatest.FunSuite

import java.awt.Color

class ImageTest extends FunSuite {

  test("Image creation from empty grid") {
    val grid: Seq[Seq[Pixel]] = Seq.empty

    assertThrows[EmptyGrid](new Image(grid))
  }

  test("Correct image creation from grid") {
    var grid: Seq[Seq[Pixel]] = Seq.empty
    val height = 5
    val width = 10

    for (h <- 0 until height) {
      var row = Seq.empty[RGBPixel]
      for (w <- 0 until width)
        row = row :+ RGBPixel(new Color(255, 0, 0))
      grid = grid :+ row
    }
    val image = new Image(grid)

    assert(image.height == height)
    assert(image.width == width)
  }

  test("Correct getting pixel at position") {
    var grid: Seq[Seq[Pixel]] = Seq.empty
    val height = 3
    val width = 3

    // Inserting black pixel if we're in grid center, otherwise white ones
    for (h <- 0 until height) {
      var row = Seq.empty[RGBPixel]
      for (w <- 0 until width) {
        if (w == 1 && h == 1) {
          row = row :+ RGBPixel(new Color(0, 0, 0))
        } else {
          row = row :+ RGBPixel(new Color(255, 255, 255))
        }
      }
      grid = grid :+ row
    }
    val image = new Image(grid)

    for (h <- 0 until height) {
      for (w <- 0 until width)
      if (w == 1 && h == 1) {
        assert(image.pixelAtPos(w, h) == RGBPixel(Color.BLACK))
      } else{
        assert(image.pixelAtPos(w, h) == RGBPixel(Color.WHITE))
      }
    }
  }
}
