package ASCIIArt.InputParams.TextParams.Importers.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.Generated.NoiseFunction.NoiseFunctionImporter
import ASCIIArt.InputParams.TextParams.Importers.ImporterHandler

/**
 * Class that handles noise function importer parameter received from user.
 */
class NoiseFunctionImporterHandler extends ImporterHandler {

  /**
   * Function that sets received noise function random generator.
   * @param config App configuration
   */
  override def execute(config: Config): Unit = {
    checkImporter(config)
    config.RGBImporter =
      Option[NoiseFunctionImporter](new NoiseFunctionImporter())
  }
}
