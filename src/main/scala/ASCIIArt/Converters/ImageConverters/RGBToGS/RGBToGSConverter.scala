package ASCIIArt.Converters.ImageConverters.RGBToGS

import ASCIIArt.Converters.ImageConverters.ImageConverter
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel

/**
 * RGB to GrayScale converter.
 */
class RGBToGSConverter extends ImageConverter[RGBPixel, GSPixel] {

  /**
   * Function that converts single RGB pixel into GrayScale pixel.
   * @param sourcePixel Given RGB pixel
   * @return Converted GrayScale pixel
   */
  override def convertPixel(sourcePixel: RGBPixel): GSPixel = {
    val rgb = sourcePixel.value
    val gs = (0.3 * rgb.getRed) + (0.59 * rgb.getGreen) + (0.11 * rgb.getBlue)
    GSPixel(gs.toInt)
  }
}
