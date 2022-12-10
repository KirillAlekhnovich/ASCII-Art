package ASCIIArt.InputParams.TextParams

import ASCIIArt.Config.Config
import ASCIIArt.InputParams.ParamHandler

/**
 * Interface for text parameter handlers.
 */
trait TextParamHandler extends ParamHandler[String] {

  /**
   * Function that sets received text parameter.
   * @param param Additional parameter
   * @param config App configuration
   */
  override def execute(param: String, config: Config): Unit = execute(config)

  /**
   * Function that sets received text parameter.
   * @param config App configuration
   */
  override def execute(config: Config): Unit = execute("", config)
}
