package ASCIIArt.Filters.Image.PixelFilters.Invert

import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Filters.Image.PixelFilters.PixelFilter

/**
 * Filter that inverts image.
 */
class InvertPixelFilter extends PixelFilter[GSPixel] {

  /**
   * Function that applies invert filter on pixel.
   * @param pixel Given pixel
   * @return Inverted pixel
   */
  override def applyOnPixel(pixel: GSPixel): GSPixel =
    GSPixel(255 - pixel.value)
}
