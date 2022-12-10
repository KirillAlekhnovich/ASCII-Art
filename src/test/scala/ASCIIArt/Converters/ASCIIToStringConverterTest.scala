package ASCIIArt.Converters

import ASCIIArt.Converters.TextConverters.ASCIIToString.ASCIIToStringConverter
import ASCIIArt.Data.Pixel.ASCIIPixel.ASCIIPixel

class ASCIIToStringConverterTest extends ConvertersTest[ASCIIPixel] {

  private val pixel1: ASCIIPixel = ASCIIPixel('$')
  private val pixel2: ASCIIPixel = ASCIIPixel('#')
  private val pixel3: ASCIIPixel = ASCIIPixel('@')

  test("ASCII image to String conversion (square)") {
    val image = createSquareImage(pixel1)
    val expected = "$$\n$$\n"
    val converter = new ASCIIToStringConverter()
    val convertedImage = converter.convert(image)

    assert(convertedImage == expected)
  }

  test("ASCII image to String conversion (rectangle)") {
    val image = createRectangleImage(pixel2)
    val expected = "####\n####\n"
    val converter = new ASCIIToStringConverter()
    val convertedImage = converter.convert(image)

    assert(convertedImage == expected)
  }

  test("ASCII image to String conversion (different symbols)") {
    val image = createColorfulImage(pixel1, pixel3)
    val expected = "$$$$\n@@@@\n$$$$\n"
    val converter = new ASCIIToStringConverter()
    val convertedImage = converter.convert(image)

    assert(convertedImage == expected)
  }
}
