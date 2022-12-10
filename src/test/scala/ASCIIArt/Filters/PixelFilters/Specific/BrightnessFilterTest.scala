package ASCIIArt.Filters.PixelFilters.Specific

import ASCIIArt.Filters.Image.PixelFilters.Brightness.BrightnessPixelFilter
import ASCIIArt.Filters.PixelFilters.PixelFilterTest

class BrightnessFilterTest extends PixelFilterTest {

  private val initPixelValue = 50

  test("Brightness +30") {
    val brightness = 30
    val image = create1x1GSImage(initPixelValue)

    val brightnessFilter = new BrightnessPixelFilter(brightness)
    val filteredImage = brightnessFilter.apply(image)

    assert(image.height == filteredImage.height)
    assert(image.width == filteredImage.width)
    assert(filteredImage.pixelAtPos(0, 0).value == initPixelValue + brightness)
  }

  test("Brightness +300 (value should be equal 255 after filtering)") {
    val brightness = 300
    val image = create1x1GSImage(initPixelValue)

    val brightnessFilter = new BrightnessPixelFilter(brightness)
    val filteredImage = brightnessFilter.apply(image)

    assert(image.height == filteredImage.height)
    assert(image.width == filteredImage.width)
    assert(filteredImage.pixelAtPos(0, 0).value == 255)
  }

  test("Brightness -30 (negative brightness with value > 0 after applying filter)") {
    val brightness = -30
    val image = create1x1GSImage(initPixelValue)

    val brightnessFilter = new BrightnessPixelFilter(brightness)
    val filteredImage = brightnessFilter.apply(image)

    assert(image.height == filteredImage.height)
    assert(image.width == filteredImage.width)
    assert(filteredImage.pixelAtPos(0, 0).value == initPixelValue + brightness)
  }

  test("Brightness -300 (pixel value should be 0)") {
    val brightness = -300
    val image = create1x1GSImage(initPixelValue)

    val brightnessFilter = new BrightnessPixelFilter(brightness)
    val filteredImage = brightnessFilter.apply(image)

    assert(image.height == filteredImage.height)
    assert(image.width == filteredImage.width)
    assert(filteredImage.pixelAtPos(0, 0).value == 0)
  }

  test("Brightness +0 (unchanged image)") {
    val brightness = 0
    val image = create1x1GSImage(initPixelValue)

    val brightnessFilter = new BrightnessPixelFilter(brightness)
    val filteredImage = brightnessFilter.apply(image)

    assert(image.height == filteredImage.height)
    assert(image.width == filteredImage.width)
    assert(filteredImage.pixelAtPos(0, 0).value == initPixelValue)
  }
}
