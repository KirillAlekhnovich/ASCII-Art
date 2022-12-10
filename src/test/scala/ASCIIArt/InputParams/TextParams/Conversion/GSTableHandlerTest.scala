package ASCIIArt.InputParams.TextParams.Conversion

import ASCIIArt.Config.Config
import ASCIIArt.Exceptions.UndefinedGSTable
import ASCIIArt.InputParams.TextParams.Conversion.Specific.GSTableHandler
import org.scalatest.FunSuite

class GSTableHandlerTest extends FunSuite {

  test("Empty char ramp") {
    val config = new Config()
    val GSTableHandler = new GSTableHandler()

    assertThrows[UndefinedGSTable](GSTableHandler.execute(config))
  }

  test("Correct char ramp") {
    val config = new Config()
    val GSTableHandler = new GSTableHandler()
    GSTableHandler.execute(".:-=+*#%@", config)

    assert(config.charRamp.isDefined)
    assert(config.charRamp.get == ".:-=+*#%@")
  }
}
