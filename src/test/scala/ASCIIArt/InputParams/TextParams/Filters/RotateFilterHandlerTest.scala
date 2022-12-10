package ASCIIArt.InputParams.TextParams.Filters

import ASCIIArt.Config.Config
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Exceptions.{InvalidDegrees, InvalidParameter}
import ASCIIArt.Filters.Image.ImageFilters.Rotate.RotateImageFilter
import ASCIIArt.InputParams.TextParams.Filters.Specific.RotateFilterHandler
import org.scalatest.FunSuite

class RotateFilterHandlerTest extends FunSuite {

  test("Rotate filter no param") {
    val config = new Config()
    val rotateFilterHandler = new RotateFilterHandler()

    assertThrows[InvalidParameter](rotateFilterHandler.execute(config))
  }

  test("Rotate filter NaN param") {
    val config = new Config()
    val rotateFilterHandler = new RotateFilterHandler()

    assertThrows[InvalidParameter](rotateFilterHandler.execute("Text", config))
  }

  test("Rotate filter unsupported degree") {
    val config = new Config()
    val rotateFilterHandler = new RotateFilterHandler()

    assertThrows[InvalidDegrees](rotateFilterHandler.execute("30", config))
  }

  test("Correct rotate filter") {
    val config = new Config()
    val rotateFilterHandler = new RotateFilterHandler()
    rotateFilterHandler.execute("90", config)

    assert(config.GSFilters.head.isInstanceOf[RotateImageFilter[GSPixel]])
  }

  test("Correct check degrees") {
    val rotateFilterHandler = new RotateFilterHandler()
    rotateFilterHandler.checkDegrees(90)
  }

  test("Not acceptable degrees check") {
    val rotateFilterHandler = new RotateFilterHandler()

    assertThrows[InvalidDegrees](rotateFilterHandler.checkDegrees(91))
  }
}
