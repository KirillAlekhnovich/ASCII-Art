package ASCIIArt.InputParams.TextParams.Importers.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.Generated.RandomPixels.RandomPixelsImporter
import ASCIIArt.InputParams.TextParams.Importers.ImporterHandler

/**
 * Class that handles random pixels importer parameter received from user.
 */
class RandomPixelsImporterHandler extends ImporterHandler {

  /**
   * Function that sets received pixel randomness generator.
   * @param config App configuration
   */
  override def execute(config: Config): Unit = {
    checkImporter(config)
    config.RGBImporter =
      Option[RandomPixelsImporter](new RandomPixelsImporter())
  }
}
