package ASCIIArt.Converters.ImageConverters.GSToASCII

import ASCIIArt.Converters.ImageConverters.ImageConverter
import ASCIIArt.Data.Pixel.ASCIIPixel.ASCIIPixel
import ASCIIArt.Data.Pixel.GSPixel.GSPixel

/**
 * GrayScale to ASCII converter.
 */
class GSToASCIIConverter(
  private val charRamp: String =
    "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "
) extends ImageConverter[GSPixel, ASCIIPixel] {

  /**
   * Function that converts single GrayScale pixel into ASCII character.
   * @param sourcePixel Given GrayScale pixel
   * @return Converted ASCII pixel
   */
  override def convertPixel(sourcePixel: GSPixel): ASCIIPixel = {
    val ASCIIChar =
      charRamp.charAt(sourcePixel.value * (charRamp.length - 1) / 255)
    ASCIIPixel(ASCIIChar)
  }
}
