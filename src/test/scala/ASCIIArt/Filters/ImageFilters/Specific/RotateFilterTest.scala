package ASCIIArt.Filters.ImageFilters.Specific

import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Filters.Image.ImageFilters.Rotate.RotateImageFilter
import ASCIIArt.Filters.ImageFilters.ImageFilterTest

class RotateFilterTest extends ImageFilterTest {

  test("Rotate +0 (square)") {
    val image = createGSSquareImage()
    val rotateFilter = new RotateImageFilter[GSPixel](0)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel1)
    assert(filteredImage.pixelAtPos(1, 0) == pixel2)
    assert(filteredImage.pixelAtPos(0, 1) == pixel3)
    assert(filteredImage.pixelAtPos(1, 1) == pixel4)
  }

  test("Rotate +90 (square)") {
    val image = createGSSquareImage()
    val rotateFilter = new RotateImageFilter[GSPixel](90)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel3)
    assert(filteredImage.pixelAtPos(1, 0) == pixel1)
    assert(filteredImage.pixelAtPos(0, 1) == pixel4)
    assert(filteredImage.pixelAtPos(1, 1) == pixel2)
  }

  test("Rotate -90 (square)") {
    val image = createGSSquareImage()
    val rotateFilter = new RotateImageFilter[GSPixel](-90)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel2)
    assert(filteredImage.pixelAtPos(1, 0) == pixel4)
    assert(filteredImage.pixelAtPos(0, 1) == pixel1)
    assert(filteredImage.pixelAtPos(1, 1) == pixel3)
  }

  test("Rotate +180 (square)") {
    val image = createGSSquareImage()
    val rotateFilter = new RotateImageFilter[GSPixel](180)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel4)
    assert(filteredImage.pixelAtPos(1, 0) == pixel3)
    assert(filteredImage.pixelAtPos(0, 1) == pixel2)
    assert(filteredImage.pixelAtPos(1, 1) == pixel1)
  }

  test("Rotate -180 (square)") {
    val image = createGSSquareImage()
    val rotateFilter = new RotateImageFilter[GSPixel](-180)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel4)
    assert(filteredImage.pixelAtPos(1, 0) == pixel3)
    assert(filteredImage.pixelAtPos(0, 1) == pixel2)
    assert(filteredImage.pixelAtPos(1, 1) == pixel1)
  }

  test("Rotate +270 (square)") {
    val image = createGSSquareImage()
    val rotateFilter = new RotateImageFilter[GSPixel](270)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel2)
    assert(filteredImage.pixelAtPos(1, 0) == pixel4)
    assert(filteredImage.pixelAtPos(0, 1) == pixel1)
    assert(filteredImage.pixelAtPos(1, 1) == pixel3)
  }

  test("Rotate -270 (square)") {
    val image = createGSSquareImage()
    val rotateFilter = new RotateImageFilter[GSPixel](-270)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel3)
    assert(filteredImage.pixelAtPos(1, 0) == pixel1)
    assert(filteredImage.pixelAtPos(0, 1) == pixel4)
    assert(filteredImage.pixelAtPos(1, 1) == pixel2)
  }

  test("Rotate +3600 (square)") {
    val image = createGSSquareImage()
    val rotateFilter = new RotateImageFilter[GSPixel](3600)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel1)
    assert(filteredImage.pixelAtPos(1, 0) == pixel2)
    assert(filteredImage.pixelAtPos(0, 1) == pixel3)
    assert(filteredImage.pixelAtPos(1, 1) == pixel4)
  }

  test("Rotate -3600 (square)") {
    val image = createGSSquareImage()
    val rotateFilter = new RotateImageFilter[GSPixel](-3600)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel1)
    assert(filteredImage.pixelAtPos(1, 0) == pixel2)
    assert(filteredImage.pixelAtPos(0, 1) == pixel3)
    assert(filteredImage.pixelAtPos(1, 1) == pixel4)
  }

  test("Rotate +3690 (square)") {
    val image = createGSSquareImage()
    val rotateFilter = new RotateImageFilter[GSPixel](3690)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel3)
    assert(filteredImage.pixelAtPos(1, 0) == pixel1)
    assert(filteredImage.pixelAtPos(0, 1) == pixel4)
    assert(filteredImage.pixelAtPos(1, 1) == pixel2)
  }

  test("Rotate -3690 (square)") {
    val image = createGSSquareImage()
    val rotateFilter = new RotateImageFilter[GSPixel](-3690)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel2)
    assert(filteredImage.pixelAtPos(1, 0) == pixel4)
    assert(filteredImage.pixelAtPos(0, 1) == pixel1)
    assert(filteredImage.pixelAtPos(1, 1) == pixel3)
  }

  test("Rotate +0 (rectangle)") {
    val image = createGSRectangleImage()
    val rotateFilter = new RotateImageFilter[GSPixel](0)
    val filteredImage = rotateFilter.apply(image)

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

  test("Rotate +90 (rectangle)") {
    val image = createGSRectangleImage()
    val rotateFilter = new RotateImageFilter[GSPixel](90)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.height)
    assert(image.height == filteredImage.width)
    assert(filteredImage.pixelAtPos(0, 0) == pixel3)
    assert(filteredImage.pixelAtPos(0, 1) == pixel3)
    assert(filteredImage.pixelAtPos(0, 2) == pixel4)
    assert(filteredImage.pixelAtPos(0, 3) == pixel4)
    assert(filteredImage.pixelAtPos(1, 0) == pixel1)
    assert(filteredImage.pixelAtPos(1, 1) == pixel1)
    assert(filteredImage.pixelAtPos(1, 2) == pixel2)
    assert(filteredImage.pixelAtPos(1, 3) == pixel2)
  }

  test("Rotate -90 (rectangle)") {
    val image = createGSRectangleImage()
    val rotateFilter = new RotateImageFilter[GSPixel](-90)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.height)
    assert(image.height == filteredImage.width)
    assert(filteredImage.pixelAtPos(0, 0) == pixel2)
    assert(filteredImage.pixelAtPos(0, 1) == pixel2)
    assert(filteredImage.pixelAtPos(0, 2) == pixel1)
    assert(filteredImage.pixelAtPos(0, 3) == pixel1)
    assert(filteredImage.pixelAtPos(1, 0) == pixel4)
    assert(filteredImage.pixelAtPos(1, 1) == pixel4)
    assert(filteredImage.pixelAtPos(1, 2) == pixel3)
    assert(filteredImage.pixelAtPos(1, 3) == pixel3)
  }

  test("Rotate +180 (rectangle)") {
    val image = createGSRectangleImage()
    val rotateFilter = new RotateImageFilter[GSPixel](180)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel4)
    assert(filteredImage.pixelAtPos(1, 0) == pixel4)
    assert(filteredImage.pixelAtPos(2, 0) == pixel3)
    assert(filteredImage.pixelAtPos(3, 0) == pixel3)
    assert(filteredImage.pixelAtPos(0, 1) == pixel2)
    assert(filteredImage.pixelAtPos(1, 1) == pixel2)
    assert(filteredImage.pixelAtPos(2, 1) == pixel1)
    assert(filteredImage.pixelAtPos(3, 1) == pixel1)
  }

  test("Rotate -180 (rectangle)") {
    val image = createGSRectangleImage()
    val rotateFilter = new RotateImageFilter[GSPixel](-180)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.width)
    assert(image.height == filteredImage.height)
    assert(filteredImage.pixelAtPos(0, 0) == pixel4)
    assert(filteredImage.pixelAtPos(1, 0) == pixel4)
    assert(filteredImage.pixelAtPos(2, 0) == pixel3)
    assert(filteredImage.pixelAtPos(3, 0) == pixel3)
    assert(filteredImage.pixelAtPos(0, 1) == pixel2)
    assert(filteredImage.pixelAtPos(1, 1) == pixel2)
    assert(filteredImage.pixelAtPos(2, 1) == pixel1)
    assert(filteredImage.pixelAtPos(3, 1) == pixel1)
  }

  test("Rotate +270 (rectangle)") {
    val image = createGSRectangleImage()
    val rotateFilter = new RotateImageFilter[GSPixel](270)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.height)
    assert(image.height == filteredImage.width)
    assert(filteredImage.pixelAtPos(0, 0) == pixel2)
    assert(filteredImage.pixelAtPos(0, 1) == pixel2)
    assert(filteredImage.pixelAtPos(0, 2) == pixel1)
    assert(filteredImage.pixelAtPos(0, 3) == pixel1)
    assert(filteredImage.pixelAtPos(1, 0) == pixel4)
    assert(filteredImage.pixelAtPos(1, 1) == pixel4)
    assert(filteredImage.pixelAtPos(1, 2) == pixel3)
    assert(filteredImage.pixelAtPos(1, 3) == pixel3)
  }

  test("Rotate -270 (rectangle)") {
    val image = createGSRectangleImage()
    val rotateFilter = new RotateImageFilter[GSPixel](-270)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.height)
    assert(image.height == filteredImage.width)
    assert(filteredImage.pixelAtPos(0, 0) == pixel3)
    assert(filteredImage.pixelAtPos(0, 1) == pixel3)
    assert(filteredImage.pixelAtPos(0, 2) == pixel4)
    assert(filteredImage.pixelAtPos(0, 3) == pixel4)
    assert(filteredImage.pixelAtPos(1, 0) == pixel1)
    assert(filteredImage.pixelAtPos(1, 1) == pixel1)
    assert(filteredImage.pixelAtPos(1, 2) == pixel2)
    assert(filteredImage.pixelAtPos(1, 3) == pixel2)
  }

  test("Rotate +3600 (rectangle)") {
    val image = createGSRectangleImage()
    val rotateFilter = new RotateImageFilter[GSPixel](3600)
    val filteredImage = rotateFilter.apply(image)

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

  test("Rotate -3600 (rectangle)") {
    val image = createGSRectangleImage()
    val rotateFilter = new RotateImageFilter[GSPixel](-3600)
    val filteredImage = rotateFilter.apply(image)

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

  test("Rotate +3690 (rectangle)") {
    val image = createGSRectangleImage()
    val rotateFilter = new RotateImageFilter[GSPixel](3690)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.height)
    assert(image.height == filteredImage.width)
    assert(filteredImage.pixelAtPos(0, 0) == pixel3)
    assert(filteredImage.pixelAtPos(0, 1) == pixel3)
    assert(filteredImage.pixelAtPos(0, 2) == pixel4)
    assert(filteredImage.pixelAtPos(0, 3) == pixel4)
    assert(filteredImage.pixelAtPos(1, 0) == pixel1)
    assert(filteredImage.pixelAtPos(1, 1) == pixel1)
    assert(filteredImage.pixelAtPos(1, 2) == pixel2)
    assert(filteredImage.pixelAtPos(1, 3) == pixel2)
  }

  test("Rotate -3690 (rectangle)") {
    val image = createGSRectangleImage()
    val rotateFilter = new RotateImageFilter[GSPixel](-3690)
    val filteredImage = rotateFilter.apply(image)

    assert(image.width == filteredImage.height)
    assert(image.height == filteredImage.width)
    assert(filteredImage.pixelAtPos(0, 0) == pixel2)
    assert(filteredImage.pixelAtPos(0, 1) == pixel2)
    assert(filteredImage.pixelAtPos(0, 2) == pixel1)
    assert(filteredImage.pixelAtPos(0, 3) == pixel1)
    assert(filteredImage.pixelAtPos(1, 0) == pixel4)
    assert(filteredImage.pixelAtPos(1, 1) == pixel4)
    assert(filteredImage.pixelAtPos(1, 2) == pixel3)
    assert(filteredImage.pixelAtPos(1, 3) == pixel3)
  }
}
