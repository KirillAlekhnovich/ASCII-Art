package ASCIIArt.Importers

import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.Generated.RandomPixels.RandomPixelsImporter
import org.scalatest.FunSuite

class RandomPixelsImporterTest extends FunSuite {

  test("Correct random pixels importer") {
    val randomImporter = new RandomPixelsImporter()
    val generatedImage = randomImporter.load()

    assert(generatedImage.width >= 200 && generatedImage.width <= 400)
    assert(generatedImage.height >= 200 && generatedImage.height <= 400)

    for (height <- 0 until generatedImage.height)
      for (width <- 0 until generatedImage.width)
        assert(generatedImage.pixelAtPos(width, height).isInstanceOf[RGBPixel])
  }
}
