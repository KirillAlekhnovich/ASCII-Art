package ASCIIArt.InputParams.TextParams.Filters.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Exceptions.InvalidAxis
import ASCIIArt.Filters.Image.ImageFilters.Flip.{FlipEnum, FlipImageFilter}
import ASCIIArt.InputParams.TextParams.Filters.FilterHandler

/**
 * Class that handles flip filter parameter received from user.
 */
class FlipFilterHandler extends FilterHandler {

  /**
   * Function that sets received flip filter.
   * @param param Flip axis
   * @param config App configuration
   */
  override def execute(param: String, config: Config): Unit =
    param match {
      case "X" | "x" => config.addGSFilter(new FlipImageFilter[GSPixel](FlipEnum.X))
      case "Y" | "y" => config.addGSFilter(new FlipImageFilter[GSPixel](FlipEnum.Y))
      case _   => throw new InvalidAxis()
    }
}
