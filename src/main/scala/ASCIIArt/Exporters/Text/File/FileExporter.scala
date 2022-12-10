package ASCIIArt.Exporters.Text.File

import ASCIIArt.Exceptions.ExportError
import ASCIIArt.Exporters.Text.TextExporter

import java.io.{BufferedWriter, FileWriter}

/**
 * Class for exporting into specific file.
 * @param path Export file path
 */
class FileExporter(
  private var path: String
) extends TextExporter {

  /**
   * Function to export text into file.
   * @param text Text that should be exported
   */
  override def export(text: String): Unit = {
    try {
      val file = new FileWriter(path)
      val buffer = new BufferedWriter(file)
      buffer.write(text)
      buffer.close()
    } catch {
      case _: Exception => throw new ExportError()
    }
  }
}
