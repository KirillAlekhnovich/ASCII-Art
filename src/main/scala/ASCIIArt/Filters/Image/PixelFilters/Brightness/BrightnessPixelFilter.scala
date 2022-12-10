package ASCIIArt.Filters.Image.PixelFilters.Brightness

import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Filters.Image.PixelFilters.PixelFilter

/**
 * Filter that brightens image by given value.
 * @param brightness Brightness value
 */
class BrightnessPixelFilter(private val brightness: Int) extends PixelFilter[GSPixel] {

  /**
   * Function that applies brightness filter on pixel.
   * @param pixel Given pixel
   * @return Brightened pixel
   */
  override def applyOnPixel(pixel: GSPixel): GSPixel = {
    var newPixelValue = pixel.value + brightness
    if (newPixelValue < 0) newPixelValue = 0
    if (newPixelValue > 255) newPixelValue = 255
    GSPixel(newPixelValue)
  }
}
