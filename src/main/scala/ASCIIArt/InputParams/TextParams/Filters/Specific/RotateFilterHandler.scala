package ASCIIArt.InputParams.TextParams.Filters.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Exceptions.{InvalidDegrees, InvalidParameter}
import ASCIIArt.Filters.Image.ImageFilters.Rotate.RotateImageFilter
import ASCIIArt.InputParams.TextParams.Filters.FilterHandler

/**
 * Class that handles rotate filter parameter received from user.
 */
class RotateFilterHandler extends FilterHandler {

  /**
   * Function that sets received rotate filter.
   * @param param Rotation degree
   * @param config App configuration
   */
  override def execute(param: String, config: Config): Unit = {
    var degrees = 0
    try degrees = param.toInt
    catch {
      case _: RuntimeException => throw new InvalidParameter("rotate")
    }
    checkDegrees(degrees)
    config.addGSFilter(new RotateImageFilter[GSPixel](degrees))
  }

  /**
   * Check if degree is divisible by 90.
   * @param degrees Given degrees value
   */
  def checkDegrees(degrees: Int): Unit =
    degrees % 90 match {
      case 0 =>
      case _ => throw new InvalidDegrees()
    }
}
