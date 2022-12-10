package ASCIIArt.InputParams.TextParams.Conversion.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Exceptions.UndefinedGSTable
import ASCIIArt.InputParams.TextParams.Conversion.ConversionHandler

/**
 * Class for handling GS table parameter.
 */
class GSTableHandler extends ConversionHandler {

  /**
   * Setting char ramp from input to config.
   * @param characters Given char ramp
   * @param config App configuration
   */
  override def execute(characters: String, config: Config): Unit = {
    if (characters == "") throw new UndefinedGSTable()
    config.charRamp = Option[String](characters)
  }
}
