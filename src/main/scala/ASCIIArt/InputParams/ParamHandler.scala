package ASCIIArt.InputParams

import ASCIIArt.Config.Config

/**
 * Interface for parameter handlers.
 * @tparam T Type of input values
 */
trait ParamHandler[T] {

  /**
   * Function that sets received parameter.
   * @param param Additional parameter
   * @param config App configuration
   */
  def execute(param: T, config: Config): Unit

  /**
   * Function that sets received parameter.
   * @param config App configuration
   */
  def execute(config: Config): Unit
}
