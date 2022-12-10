package ASCIIArt.Exporters

import ASCIIArt.Exceptions.ExportError
import ASCIIArt.Exporters.Text.File.FileExporter
import org.scalatest.FunSuite

import scala.io.Source

class FileExporterTest extends FunSuite {

  test("Invalid exporter path") {
    val fileContent: String = "Converted image as string"
    val path: String = "assets/non_existing_folder/file.txt"
    val fileExporter = new FileExporter(path)

    assertThrows[ExportError](fileExporter.export(fileContent))
  }

  test("Correct export") {
    val exportContent: String = "Converted image as string"
    val path: String = "assets/output/TestExport.txt"
    val fileExporter = new FileExporter(path)
    fileExporter.export(exportContent)

    val file = Source.fromFile(path)
    val fileContent = file.mkString
    file.close()

    assert(exportContent == fileContent)
  }
}
