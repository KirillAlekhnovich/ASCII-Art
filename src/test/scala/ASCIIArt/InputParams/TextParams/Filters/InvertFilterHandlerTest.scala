package ASCIIArt.InputParams.TextParams.Filters

import ASCIIArt.Config.Config
import ASCIIArt.Filters.Image.PixelFilters.Invert.InvertPixelFilter
import ASCIIArt.InputParams.TextParams.Filters.Specific.InvertFilterHandler
import org.scalatest.FunSuite

class InvertFilterHandlerTest extends FunSuite {

  test("Correct invert pixel filter") {
    val config = new Config()
    val invertFilterHandler = new InvertFilterHandler()
    invertFilterHandler.execute(config)

    assert(config.GSFilters.head.isInstanceOf[InvertPixelFilter])
  }
}
