package ASCIIArt.InputParams.TextParams.Filters.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Exceptions.{InvalidParameter, InvalidScale}
import ASCIIArt.Filters.Image.ImageFilters.Scale.{ScaleEnum, ScaleImageFilter}
import ASCIIArt.InputParams.TextParams.Filters.FilterHandler

/**
 * Class that handles scale filter parameter received from user.
 */
class ScaleFilterHandler extends FilterHandler {

  /**
   * Function that sets received scale filter.
   * @param param Scale parameter
   * @param config App configuration
   */
  override def execute(param: String, config: Config): Unit =
    try param.toDouble match {
      case 0.25 =>
        config.addGSFilter(new ScaleImageFilter[GSPixel](ScaleEnum.HALF_IMAGE))
      case 1 =>
        config.addGSFilter(new ScaleImageFilter[GSPixel](ScaleEnum.ORIGINAL))
      case 4 =>
        config.addGSFilter(
          new ScaleImageFilter[GSPixel](ScaleEnum.DOUBLE_IMAGE))
      case _ => throw new InvalidScale()
    } catch {
      case _: RuntimeException => throw new InvalidParameter("scale")
    }
}
