package ASCIIArt.InputParams.TextParams.Importers.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.File.URL.URLImageImporter
import ASCIIArt.InputParams.TextParams.Importers.ImporterHandler

/**
 * Class that handles URL importer parameter received from user.
 */
class URLImporterHandler extends ImporterHandler {

  /**
   * Function that sets received URL importer.
   * @param path URL link to image
   * @param config App configuration
   */
  override def execute(path: String, config: Config): Unit = {
    checkImporter(path, config)
    config.RGBImporter = Option[URLImageImporter](new URLImageImporter(path))
  }
}
