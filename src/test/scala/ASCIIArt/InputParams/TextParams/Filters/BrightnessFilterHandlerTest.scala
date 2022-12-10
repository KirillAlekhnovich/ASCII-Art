package ASCIIArt.InputParams.TextParams.Filters

import ASCIIArt.Config.Config
import ASCIIArt.Exceptions.InvalidParameter
import ASCIIArt.Filters.Image.PixelFilters.Brightness.BrightnessPixelFilter
import ASCIIArt.InputParams.TextParams.Filters.Specific.BrightnessFilterHandler
import org.scalatest.FunSuite

class BrightnessFilterHandlerTest extends FunSuite {

  test("Brightness filter no param") {
    val config = new Config()
    val brightnessFilterHandler = new BrightnessFilterHandler()

    assertThrows[InvalidParameter](brightnessFilterHandler.execute(config))
  }

  test("Brightness filter NaN param") {
    val config = new Config()
    val brightnessFilterHandler = new BrightnessFilterHandler()

    assertThrows[InvalidParameter](brightnessFilterHandler.execute("Text", config))
  }

  test("Correct brightness filter") {
    val config = new Config()
    val brightnessFilterHandler = new BrightnessFilterHandler()
    brightnessFilterHandler.execute("100", config)

    assert(config.GSFilters.head.isInstanceOf[BrightnessPixelFilter])
  }
}
