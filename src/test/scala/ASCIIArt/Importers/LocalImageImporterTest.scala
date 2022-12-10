package ASCIIArt.Importers

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel
import ASCIIArt.Exceptions.FileCantBeImported
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.File.LocalStorage.LocalImageImporter
import org.scalatest.FunSuite

import java.awt.Color
import java.io.File

class LocalImageImporterTest extends FunSuite {

  test("Importer with invalid path (local storage)") {
    val file: String = "absolutely/wrong/path.jpg"
    val localImageImporter = new LocalImageImporter(file)

    assertThrows[FileCantBeImported](localImageImporter.load())
  }

  test("Correct import square jpg picture (local storage)") {
    val file: String = "assets/testImages/RGBSquare2x2.jpg"
    val localImageImporter = new LocalImageImporter(file)
    val image = localImageImporter.load()

    assert(image.isInstanceOf[Image[RGBPixel]])
    assert(image.height == 2)
    assert(image.width == 2)
//    JPG colors could not be tested due to lossy compression
//    assert(image.pixelAtPos(0, 0).value == Color.RED)
//    assert(image.pixelAtPos(0, 1).value == Color.GREEN)
//    assert(image.pixelAtPos(1, 0).value == Color.BLUE)
//    assert(image.pixelAtPos(1, 1).value == Color.BLACK)
  }

  test("Correct import rectangle jpg picture (local storage)") {
    val file: String = "assets/testImages/RGBRectangle1x3.jpg"
    val localImageImporter = new LocalImageImporter(file)
    val image = localImageImporter.load()

    assert(image.isInstanceOf[Image[RGBPixel]])
    assert(image.height == 1)
    assert(image.width == 3)
//    JPG colors could not be tested due to lossy compression
//    assert(image.pixelAtPos(0, 0).value == Color.RED)
//    assert(image.pixelAtPos(0, 1).value == Color.GREEN)
//    assert(image.pixelAtPos(0, 2).value == Color.BLUE)
  }

  test("Correct import square png picture (local storage)") {
    val file: String = "assets/testImages/RGBSquare2x2.png"
    val localImageImporter = new LocalImageImporter(file)
    val image = localImageImporter.load()

    assert(image.isInstanceOf[Image[RGBPixel]])
    assert(image.height == 2)
    assert(image.width == 2)
    assert(image.pixelAtPos(0, 0).value == Color.RED)
    assert(image.pixelAtPos(1, 0).value == Color.GREEN)
    assert(image.pixelAtPos(0, 1).value == Color.BLUE)
    assert(image.pixelAtPos(1, 1).value == Color.BLACK)
  }

  test("Correct import rectangle png picture (local storage)") {
    val file: String = "assets/testImages/RGBRectangle1x3.png"
    val localImageImporter = new LocalImageImporter(file)
    val image = localImageImporter.load()

    assert(image.isInstanceOf[Image[RGBPixel]])
    assert(image.height == 1)
    assert(image.width == 3)
    assert(image.pixelAtPos(0, 0).value == Color.RED)
    assert(image.pixelAtPos(1, 0).value == Color.GREEN)
    assert(image.pixelAtPos(2, 0).value == Color.BLUE)
  }

  test("Correct import with absolute path") {
    val relativePath: String = "assets/testImages/BlackPixel1x1.png"
    val absolutePath: String = new File(relativePath).getAbsolutePath
    val localImageImporter = new LocalImageImporter(absolutePath)
    val image = localImageImporter.load()

    assert(image.isInstanceOf[Image[RGBPixel]])
    assert(image.height == 1)
    assert(image.width == 1)
    assert(image.pixelAtPos(0, 0).value == Color.BLACK)
  }
}
