package ASCIIArt.InputParams.TextParams.Filters

import ASCIIArt.Config.Config
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Exceptions.InvalidParameter
import ASCIIArt.Filters.Image.ImageFilters.Scale.ScaleImageFilter
import ASCIIArt.InputParams.TextParams.Filters.Specific.ScaleFilterHandler
import org.scalatest.FunSuite

class ScaleFilterHandlerTest extends FunSuite {

  test("Scale filter no param") {
    val config = new Config()
    val scaleFilter = new ScaleFilterHandler()

    assertThrows[InvalidParameter](scaleFilter.execute(config))
  }

  test("Scale filter NaN param") {
    val config = new Config()
    val scaleFilter = new ScaleFilterHandler()

    assertThrows[InvalidParameter](scaleFilter.execute("Text", config))
  }

  test("Scale filter unsupported scaling") {
    val config = new Config()
    val scaleFilter = new ScaleFilterHandler()

    assertThrows[InvalidParameter](scaleFilter.execute("3", config))
  }

  test("Correct scale filter") {
    val config = new Config()
    val scaleFilter = new ScaleFilterHandler()
    scaleFilter.execute("4", config)

    assert(config.GSFilters.head.isInstanceOf[ScaleImageFilter[GSPixel]])
  }
}
