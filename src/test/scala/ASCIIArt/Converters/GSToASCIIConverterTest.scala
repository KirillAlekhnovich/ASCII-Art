package ASCIIArt.Converters

import ASCIIArt.Converters.ImageConverters.GSToASCII.GSToASCIIConverter
import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.ASCIIPixel.ASCIIPixel
import ASCIIArt.Data.Pixel.GSPixel.GSPixel

class GSToASCIIConverterTest extends ConvertersTest[GSPixel] {

  private val blackGSPixel = GSPixel(0)
  private val redGSPixel = GSPixel(76)
  private val whiteGSPixel = GSPixel(255)
  private val blackASCIIPixel = ASCIIPixel('$')
  private val redASCIIPixel = ASCIIPixel('Z')
  private val whiteASCIIPixel = ASCIIPixel(' ')

  test("Convert squared white GS image to ASCII") {
    val image = createSquareImage(whiteGSPixel)
    val converter = new GSToASCIIConverter()
    val convertedImage = converter.convert(image)

    assert(image.height == convertedImage.height)
    assert(image.width == convertedImage.width)
    assert(convertedImage.pixelAtPos(0, 0) == whiteASCIIPixel)
    assert(convertedImage.pixelAtPos(1, 0) == whiteASCIIPixel)
    assert(convertedImage.pixelAtPos(0, 1) == whiteASCIIPixel)
    assert(convertedImage.pixelAtPos(1, 1) == whiteASCIIPixel)
  }

  test("Convert rectangle black GS image to ASCII") {
    val image = createRectangleImage(blackGSPixel)
    val converter = new GSToASCIIConverter()
    val convertedImage = converter.convert(image)

    assert(image.height == convertedImage.height)
    assert(image.width == convertedImage.width)
    assert(convertedImage.pixelAtPos(0, 0) == blackASCIIPixel)
    assert(convertedImage.pixelAtPos(1, 0) == blackASCIIPixel)
    assert(convertedImage.pixelAtPos(2, 0) == blackASCIIPixel)
    assert(convertedImage.pixelAtPos(3, 0) == blackASCIIPixel)
    assert(convertedImage.pixelAtPos(0, 1) == blackASCIIPixel)
    assert(convertedImage.pixelAtPos(1, 1) == blackASCIIPixel)
    assert(convertedImage.pixelAtPos(2, 1) == blackASCIIPixel)
    assert(convertedImage.pixelAtPos(3, 1) == blackASCIIPixel)
  }

  test("Convert GS image with multiple colors to ASCII") {
    val image = createColorfulImage(whiteGSPixel, redGSPixel)
    val converter = new GSToASCIIConverter()
    val convertedImage = converter.convert(image)

    assert(image.height == convertedImage.height)
    assert(image.width == convertedImage.width)
    assert(convertedImage.pixelAtPos(0, 0) == whiteASCIIPixel)
    assert(convertedImage.pixelAtPos(1, 0) == whiteASCIIPixel)
    assert(convertedImage.pixelAtPos(2, 0) == whiteASCIIPixel)
    assert(convertedImage.pixelAtPos(3, 0) == whiteASCIIPixel)
    assert(convertedImage.pixelAtPos(0, 1) == redASCIIPixel)
    assert(convertedImage.pixelAtPos(1, 1) == redASCIIPixel)
    assert(convertedImage.pixelAtPos(2, 1) == redASCIIPixel)
    assert(convertedImage.pixelAtPos(3, 1) == redASCIIPixel)
    assert(convertedImage.pixelAtPos(0, 2) == whiteASCIIPixel)
    assert(convertedImage.pixelAtPos(1, 2) == whiteASCIIPixel)
    assert(convertedImage.pixelAtPos(2, 2) == whiteASCIIPixel)
    assert(convertedImage.pixelAtPos(3, 2) == whiteASCIIPixel)
  }
}
