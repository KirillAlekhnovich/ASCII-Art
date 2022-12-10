package ASCIIArt.Filters.ImageFilters.Specific

import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Filters.Image.ImageFilters.Scale.{ScaleEnum, ScaleImageFilter}
import ASCIIArt.Filters.ImageFilters.ImageFilterTest

class ScaleFilterTest extends ImageFilterTest {

  test("Scale 0.25 (square)") {
    val image = createGSSquareImage()
    val scaleFilter = new ScaleImageFilter[GSPixel](ScaleEnum.HALF_IMAGE)
    val filteredImage = scaleFilter.apply(image)

    assert(filteredImage.width == 1)
    assert(filteredImage.height == 1)
    assert(filteredImage.pixelAtPos(0, 0) == pixel1)
  }

  test("Scale 1 (square)") {
    val image = createGSSquareImage()
    val scaleFilter = new ScaleImageFilter[GSPixel](ScaleEnum.ORIGINAL)
    val filteredImage = scaleFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel1)
    assert(filteredImage.pixelAtPos(1, 0) == pixel2)
    assert(filteredImage.pixelAtPos(0, 1) == pixel3)
    assert(filteredImage.pixelAtPos(1, 1) == pixel4)
  }

  test("Scale 4 (square)") {
    val image = createGSSquareImage()
    val scaleFilter = new ScaleImageFilter[GSPixel](ScaleEnum.DOUBLE_IMAGE)
    val filteredImage = scaleFilter.apply(image)

    assert(filteredImage.width == 4)
    assert(filteredImage.height == 4)
    assert(filteredImage.pixelAtPos(0, 0) == pixel1)
    assert(filteredImage.pixelAtPos(1, 0) == pixel1)
    assert(filteredImage.pixelAtPos(0, 1) == pixel1)
    assert(filteredImage.pixelAtPos(1, 1) == pixel1)
    assert(filteredImage.pixelAtPos(2, 0) == pixel2)
    assert(filteredImage.pixelAtPos(3, 0) == pixel2)
    assert(filteredImage.pixelAtPos(2, 1) == pixel2)
    assert(filteredImage.pixelAtPos(3, 1) == pixel2)
    assert(filteredImage.pixelAtPos(0, 2) == pixel3)
    assert(filteredImage.pixelAtPos(1, 2) == pixel3)
    assert(filteredImage.pixelAtPos(0, 3) == pixel3)
    assert(filteredImage.pixelAtPos(1, 3) == pixel3)
    assert(filteredImage.pixelAtPos(2, 2) == pixel4)
    assert(filteredImage.pixelAtPos(3, 2) == pixel4)
    assert(filteredImage.pixelAtPos(2, 3) == pixel4)
    assert(filteredImage.pixelAtPos(3, 3) == pixel4)
  }

  test("Scale 0.25 (rectangle)") {
    val image = createGSRectangleImage()
    val scaleFilter = new ScaleImageFilter[GSPixel](ScaleEnum.HALF_IMAGE)
    val filteredImage = scaleFilter.apply(image)

    assert(filteredImage.width == 2)
    assert(filteredImage.height == 1)
    assert(filteredImage.pixelAtPos(0, 0) == pixel1)
    assert(filteredImage.pixelAtPos(1, 0) == pixel2)
  }

  test("Scale 1 (rectangle)") {
    val image = createGSRectangleImage()
    val scaleFilter = new ScaleImageFilter[GSPixel](ScaleEnum.ORIGINAL)
    val filteredImage = scaleFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel1)
    assert(filteredImage.pixelAtPos(1, 0) == pixel1)
    assert(filteredImage.pixelAtPos(2, 0) == pixel2)
    assert(filteredImage.pixelAtPos(3, 0) == pixel2)
    assert(filteredImage.pixelAtPos(0, 1) == pixel3)
    assert(filteredImage.pixelAtPos(1, 1) == pixel3)
    assert(filteredImage.pixelAtPos(2, 1) == pixel4)
    assert(filteredImage.pixelAtPos(3, 1) == pixel4)
  }

  test("Scale 4 (rectangle)") {
    val image = createGSRectangleImage()
    val scaleFilter = new ScaleImageFilter[GSPixel](ScaleEnum.DOUBLE_IMAGE)
    val filteredImage = scaleFilter.apply(image)

    assert(filteredImage.width == 8)
    assert(filteredImage.height == 4)
    assert(filteredImage.pixelAtPos(0, 0) == pixel1)
    assert(filteredImage.pixelAtPos(1, 0) == pixel1)
    assert(filteredImage.pixelAtPos(0, 1) == pixel1)
    assert(filteredImage.pixelAtPos(1, 1) == pixel1)
    assert(filteredImage.pixelAtPos(2, 0) == pixel1)
    assert(filteredImage.pixelAtPos(3, 0) == pixel1)
    assert(filteredImage.pixelAtPos(2, 1) == pixel1)
    assert(filteredImage.pixelAtPos(3, 1) == pixel1)
    assert(filteredImage.pixelAtPos(4, 0) == pixel2)
    assert(filteredImage.pixelAtPos(5, 0) == pixel2)
    assert(filteredImage.pixelAtPos(4, 1) == pixel2)
    assert(filteredImage.pixelAtPos(5, 1) == pixel2)
    assert(filteredImage.pixelAtPos(6, 0) == pixel2)
    assert(filteredImage.pixelAtPos(7, 0) == pixel2)
    assert(filteredImage.pixelAtPos(6, 1) == pixel2)
    assert(filteredImage.pixelAtPos(7, 1) == pixel2)
    assert(filteredImage.pixelAtPos(0, 2) == pixel3)
    assert(filteredImage.pixelAtPos(1, 2) == pixel3)
    assert(filteredImage.pixelAtPos(0, 3) == pixel3)
    assert(filteredImage.pixelAtPos(1, 3) == pixel3)
    assert(filteredImage.pixelAtPos(2, 2) == pixel3)
    assert(filteredImage.pixelAtPos(3, 2) == pixel3)
    assert(filteredImage.pixelAtPos(2, 3) == pixel3)
    assert(filteredImage.pixelAtPos(3, 3) == pixel3)
    assert(filteredImage.pixelAtPos(4, 2) == pixel4)
    assert(filteredImage.pixelAtPos(5, 2) == pixel4)
    assert(filteredImage.pixelAtPos(4, 3) == pixel4)
    assert(filteredImage.pixelAtPos(5, 3) == pixel4)
    assert(filteredImage.pixelAtPos(6, 2) == pixel4)
    assert(filteredImage.pixelAtPos(7, 2) == pixel4)
    assert(filteredImage.pixelAtPos(6, 3) == pixel4)
    assert(filteredImage.pixelAtPos(7, 3) == pixel4)
  }
}
