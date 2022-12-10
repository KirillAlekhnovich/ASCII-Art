package ASCIIArt.InputParams.TextParams.Filters

import ASCIIArt.Config.Config
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Exceptions.InvalidAxis
import ASCIIArt.Filters.Image.ImageFilters.Flip.FlipImageFilter
import ASCIIArt.InputParams.TextParams.Filters.Specific.FlipFilterHandler
import org.scalatest.FunSuite

class FlipFilterHandlerTest extends FunSuite {

  test("Flip filter no param") {
    val config = new Config()
    val flipFilterHandler = new FlipFilterHandler()

    assertThrows[InvalidAxis](flipFilterHandler.execute(config))
  }

  test("Flip filter wrong axis") {
    val config = new Config()
    val flipFilterHandler = new FlipFilterHandler()

    assertThrows[InvalidAxis](flipFilterHandler.execute("a", config))
  }

  test("Correct flip filter") {
    val config = new Config()
    val flipFilterHandler = new FlipFilterHandler()
    flipFilterHandler.execute("x", config)

    assert(config.GSFilters.head.isInstanceOf[FlipImageFilter[GSPixel]])
  }
}
