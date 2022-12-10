package ASCIIArt.InputParams.TextParams.Importers.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.File.LocalStorage.LocalImageImporter
import ASCIIArt.InputParams.TextParams.Importers.ImporterHandler

/**
 * Class that handles local storage importer parameter received from user.
 */
class LocalImporterHandler extends ImporterHandler {

  /**
   * Function that sets received local importer.
   * @param path Path to given input file
   * @param config App configuration
   */
  override def execute(path: String, config: Config): Unit = {
    checkImporter(path, config)
    config.RGBImporter =
      Option[LocalImageImporter](new LocalImageImporter(path))
  }
}
