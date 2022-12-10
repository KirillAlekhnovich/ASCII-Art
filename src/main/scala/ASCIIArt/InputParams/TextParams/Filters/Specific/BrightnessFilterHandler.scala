package ASCIIArt.InputParams.TextParams.Filters.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Exceptions.InvalidParameter
import ASCIIArt.Filters.Image.PixelFilters.Brightness.BrightnessPixelFilter
import ASCIIArt.InputParams.TextParams.Filters.FilterHandler

/**
 * Class that handles brightness filter parameter received from user.
 */
class BrightnessFilterHandler extends FilterHandler {

  /**
   * Function that sets received brightness filter.
   * @param param Brightness value
   * @param config App configuration
   */
  override def execute(param: String, config: Config): Unit = {
    try {
      config.addGSFilter(new BrightnessPixelFilter(param.toInt))
    } catch {
      case _: RuntimeException => throw new InvalidParameter("brightness")
    }
  }
}
