package ASCIIArt.Filters.ImageFilters.Specific

import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Filters.Image.ImageFilters.Flip.{FlipEnum, FlipImageFilter}
import ASCIIArt.Filters.ImageFilters.ImageFilterTest

class FlipFilterTest extends ImageFilterTest {

  test("Flip x (square)") {
    val image = createGSSquareImage()

    val flipFilter = new FlipImageFilter[GSPixel](FlipEnum.X)
    val filteredImage = flipFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel3)
    assert(filteredImage.pixelAtPos(1, 0) == pixel4)
    assert(filteredImage.pixelAtPos(0, 1) == pixel1)
    assert(filteredImage.pixelAtPos(1, 1) == pixel2)
  }

  test("Flip y (square)") {
    val image = createGSSquareImage()

    val flipFilter = new FlipImageFilter[GSPixel](FlipEnum.Y)
    val filteredImage = flipFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel2)
    assert(filteredImage.pixelAtPos(1, 0) == pixel1)
    assert(filteredImage.pixelAtPos(0, 1) == pixel4)
    assert(filteredImage.pixelAtPos(1, 1) == pixel3)
  }

  test("Flip x (rectangle)") {
    val image = createGSRectangleImage()

    val flipFilter = new FlipImageFilter[GSPixel](FlipEnum.X)
    val filteredImage = flipFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel3)
    assert(filteredImage.pixelAtPos(1, 0) == pixel3)
    assert(filteredImage.pixelAtPos(2, 0) == pixel4)
    assert(filteredImage.pixelAtPos(3, 0) == pixel4)
    assert(filteredImage.pixelAtPos(0, 1) == pixel1)
    assert(filteredImage.pixelAtPos(1, 1) == pixel1)
    assert(filteredImage.pixelAtPos(2, 1) == pixel2)
    assert(filteredImage.pixelAtPos(3, 1) == pixel2)
  }

  test("Flip y (rectangle)") {
    val image = createGSRectangleImage()

    val flipFilter = new FlipImageFilter[GSPixel](FlipEnum.Y)
    val filteredImage = flipFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel2)
    assert(filteredImage.pixelAtPos(1, 0) == pixel2)
    assert(filteredImage.pixelAtPos(2, 0) == pixel1)
    assert(filteredImage.pixelAtPos(3, 0) == pixel1)
    assert(filteredImage.pixelAtPos(0, 1) == pixel4)
    assert(filteredImage.pixelAtPos(1, 1) == pixel4)
    assert(filteredImage.pixelAtPos(2, 1) == pixel3)
    assert(filteredImage.pixelAtPos(3, 1) == pixel3)
  }
}
