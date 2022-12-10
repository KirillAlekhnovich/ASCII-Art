package ASCIIArt.Filters.PixelFilters.Specific

import ASCIIArt.Filters.Image.PixelFilters.Invert.InvertPixelFilter
import ASCIIArt.Filters.PixelFilters.PixelFilterTest

class InvertFilterTest extends PixelFilterTest {

  val initPixelValue = 50

  test("Invert filter") {
    val invertPixelFilter = new InvertPixelFilter()
    val image = create1x1GSImage(initPixelValue)
    val filteredImage = invertPixelFilter.apply(image)

    assert(filteredImage.pixelAtPos(0, 0).value == 255 - initPixelValue)
  }
}
