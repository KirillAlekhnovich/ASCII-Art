package ASCIIArt.Converters

import ASCIIArt.Converters.ImageConverters.RGBToGS.RGBToGSConverter
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel

import java.awt.Color

class RGBToGSConverterTest extends ConvertersTest[RGBPixel] {

  private val blackRGBPixel = RGBPixel(new Color(0, 0, 0))
  private val redRGBPixel = RGBPixel(new Color(255, 0, 0))
  private val whiteRGBPixel = RGBPixel(new Color(255, 255, 255))

  test("Convert squared white RGB image to GS") {
    val image = createSquareImage(whiteRGBPixel)
    val converter = new RGBToGSConverter()
    val convertedImage = converter.convert(image)

    assert(image.height == convertedImage.height)
    assert(image.width == convertedImage.width)
    assert(convertedImage.pixelAtPos(0, 0) == GSPixel(255))
    assert(convertedImage.pixelAtPos(1, 0) == GSPixel(255))
    assert(convertedImage.pixelAtPos(0, 1) == GSPixel(255))
    assert(convertedImage.pixelAtPos(1, 1) == GSPixel(255))
  }

  test("Convert rectangle black RGB image to GS") {
    val image = createRectangleImage(blackRGBPixel)
    val converter = new RGBToGSConverter()
    val convertedImage = converter.convert(image)

    assert(image.height == convertedImage.height)
    assert(image.width == convertedImage.width)
    assert(convertedImage.pixelAtPos(0, 0) == GSPixel(0))
    assert(convertedImage.pixelAtPos(1, 0) == GSPixel(0))
    assert(convertedImage.pixelAtPos(2, 0) == GSPixel(0))
    assert(convertedImage.pixelAtPos(3, 0) == GSPixel(0))
    assert(convertedImage.pixelAtPos(0, 1) == GSPixel(0))
    assert(convertedImage.pixelAtPos(1, 1) == GSPixel(0))
    assert(convertedImage.pixelAtPos(2, 1) == GSPixel(0))
    assert(convertedImage.pixelAtPos(3, 1) == GSPixel(0))
  }

  test("Convert RGB image with multiple colors to GS") {
    val image = createColorfulImage(whiteRGBPixel, redRGBPixel)
    val converter = new RGBToGSConverter()
    val convertedImage = converter.convert(image)
    val correctRedGS = (0.3 * redRGBPixel.value.getRed) + (0.59 * redRGBPixel.value.getGreen) + (0.11 * redRGBPixel.value.getBlue)

    assert(image.height == convertedImage.height)
    assert(image.width == convertedImage.width)
    assert(convertedImage.pixelAtPos(0, 0) == GSPixel(255))
    assert(convertedImage.pixelAtPos(1, 0) == GSPixel(255))
    assert(convertedImage.pixelAtPos(2, 0) == GSPixel(255))
    assert(convertedImage.pixelAtPos(3, 0) == GSPixel(255))
    assert(convertedImage.pixelAtPos(0, 1) == GSPixel(correctRedGS.toInt))
    assert(convertedImage.pixelAtPos(1, 1) == GSPixel(correctRedGS.toInt))
    assert(convertedImage.pixelAtPos(2, 1) == GSPixel(correctRedGS.toInt))
    assert(convertedImage.pixelAtPos(3, 1) == GSPixel(correctRedGS.toInt))
    assert(convertedImage.pixelAtPos(0, 2) == GSPixel(255))
    assert(convertedImage.pixelAtPos(1, 2) == GSPixel(255))
    assert(convertedImage.pixelAtPos(2, 2) == GSPixel(255))
    assert(convertedImage.pixelAtPos(3, 2) == GSPixel(255))
  }
}
