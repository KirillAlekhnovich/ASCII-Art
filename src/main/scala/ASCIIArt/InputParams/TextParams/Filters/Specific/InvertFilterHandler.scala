package ASCIIArt.InputParams.TextParams.Filters.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Filters.Image.PixelFilters.Invert.InvertPixelFilter
import ASCIIArt.InputParams.TextParams.Filters.FilterHandler

/**
 * Class that handles invert filter parameter received from user.
 */
class InvertFilterHandler extends FilterHandler {

  /**
   * Function that sets received invert filter.
   * @param config App configuration
   */
  override def execute(config: Config): Unit =
    config.addGSFilter(new InvertPixelFilter())
}
