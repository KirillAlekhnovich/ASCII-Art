package ASCIIArt.InputParams.TextParams.Exporters.Specific

import ASCIIArt.Config.Config
import ASCIIArt.Exporters.Text.Console.ConsoleExporter
import ASCIIArt.InputParams.TextParams.Exporters.ExporterHandler

/**
 * Class that handles console exporter parameter received from user.
 */
class ConsoleExporterHandler extends ExporterHandler {

  /**
   * Function that sets received text exporter.
   * @param config App configuration
   */
  override def execute(config: Config): Unit =
    config.addTextExporter(new ConsoleExporter())
}
