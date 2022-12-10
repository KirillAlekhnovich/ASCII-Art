package ASCIIArt.InputParams.TextParams.Importers

import ASCIIArt.Config.{Config, Extensions}
import ASCIIArt.Exceptions.{ForbiddenExtension, MultipleImageSources}
import ASCIIArt.InputParams.TextParams.TextParamHandler

/**
 * Interface for importer handlers.
 */
trait ImporterHandler extends TextParamHandler {

  /**
   * Function that checks importer presence.
   * @param config App configuration
   */
  def checkImporter(config: Config): Unit =
    if (config.RGBImporter.isDefined) throw new MultipleImageSources()

  /**
   * Function that checks importer presence.
   * @param path Path to file
   * @param config App configuration
   */
  def checkImporter(path: String, config: Config): Unit = {
    if (config.RGBImporter.isDefined) throw new MultipleImageSources()
    if (!Extensions.isAllowed(path)) throw new ForbiddenExtension()
  }
}
