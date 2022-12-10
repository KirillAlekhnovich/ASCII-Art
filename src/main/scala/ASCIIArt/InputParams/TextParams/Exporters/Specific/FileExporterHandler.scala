package ASCIIArt.InputParams.TextParams.Exporters.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Exporters.Text.File.FileExporter
import ASCIIArt.InputParams.TextParams.Exporters.ExporterHandler

/**
 * Class that handles file exporter parameter received from user.
 */
class FileExporterHandler extends ExporterHandler {

  /**
   * Function that sets received text exporter.
   * @param path Path to output file
   * @param config App configuration
   */
  override def execute(path: String, config: Config): Unit =
    config.addTextExporter(new FileExporter(path))
}
