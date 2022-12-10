package ASCIIArt.Exporters.Text.Console

import ASCIIArt.Exporters.Text.TextExporter

/**
 * Class used to export into console.
 */
class ConsoleExporter extends TextExporter {

  /**
   * Function that prints given string into console.
   * @param text String that should be exported
   */
  override def export(text: String): Unit = println(text)
}
