package ASCIIArt.Converters.TextConverters.ASCIIToString

import ASCIIArt.Converters.TextConverters.TextConverter
import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.ASCIIPixel.ASCIIPixel

/**
 * Class for ASCII to String conversion.
 */
class ASCIIToStringConverter extends TextConverter[ASCIIPixel] {

  /**
   * Method that converts from ASCII image to String.
   *
   * @param image Source ASCII image
   * @return Converter string
   */
  override def convert(image: Image[ASCIIPixel]): String = {
    var outputStr = ""
    for (height <- 0 until image.height) {
      var row = ""
      for (width <- 0 until image.width)
        row += image.pixelAtPos(width, height).value
      outputStr += row + "\n"
    }
    outputStr
  }
}
