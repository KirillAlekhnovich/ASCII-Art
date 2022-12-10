package ASCIIArt.Importers

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel
import ASCIIArt.Exceptions.FileCantBeImported
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.File.URL.URLImageImporter
import org.scalatest.FunSuite

class URLImageImporterTest extends FunSuite {

  test("Importer with invalid path (url)") {
    val url: String = "https://fit.cvut.cz/AG1/zapocet.png"
    val URLImageImporter = new URLImageImporter(url)

    assertThrows[FileCantBeImported](URLImageImporter.load())
  }

  test("Correct url image importer") {
    val url: String = "https://i.imgur.com/9ObkT2I.jpeg"
    val URLImageImporter = new URLImageImporter(url)
    val image = URLImageImporter.load()

    assert(image.isInstanceOf[Image[RGBPixel]])
    assert(image.height == 320)
    assert(image.width == 320)
  }
}
