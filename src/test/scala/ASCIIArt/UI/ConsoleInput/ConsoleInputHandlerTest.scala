package ASCIIArt.UI.ConsoleInput

import ASCIIArt.Config.Config
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Exceptions.{EmptyInput, ForbiddenExtension, MultipleImageSources, UndefinedSource, UndefinedTarget, UnknownAttribute}
import ASCIIArt.Exporters.Text.Console.ConsoleExporter
import ASCIIArt.Exporters.Text.File.FileExporter
import ASCIIArt.Filters.Image.ImageFilters.Flip.FlipImageFilter
import ASCIIArt.Filters.Image.ImageFilters.Rotate.RotateImageFilter
import ASCIIArt.Filters.Image.ImageFilters.Scale.ScaleImageFilter
import ASCIIArt.Filters.Image.PixelFilters.Brightness.BrightnessPixelFilter
import ASCIIArt.Filters.Image.PixelFilters.Invert.InvertPixelFilter
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.File.LocalStorage.LocalImageImporter
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.File.URL.URLImageImporter
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.Generated.RandomPixels.RandomPixelsImporter
import org.scalatest.FunSuite

class ConsoleInputHandlerTest extends FunSuite {
  val importFile: String = "--image"
  val importUrl: String = "--image-url"
  val importRandom: String = "--image-random"
  val brightnessFilter: String = "--brightness"
  val flipFilter: String = "--flip"
  val invertFilter: String = "--invert"
  val rotateFilter: String = "--rotate"
  val scaleFilter: String = "--scale"
  val exportFile: String = "--output-file"
  val exportConsole: String = "--output-console"

  test("Empty args") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val args = Seq[String]()

    assertThrows[EmptyInput](consoleInputHandler.readInput(args))
  }

  test("Unknown input attribute") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val args = Seq[String]("--cool-but-invalid-attribute")

    assertThrows[UnknownAttribute](consoleInputHandler.readInput(args))
  }

  test("No importers") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val args = Seq[String](exportConsole)

    assertThrows[UndefinedSource](consoleInputHandler.readInput(args))
  }

  test("Multiple importers") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val file: String = "assets/images/Pikachu.png"
    val args = Seq[String](importFile, file, importRandom)

    assertThrows[MultipleImageSources](consoleInputHandler.readInput(args))
  }

  test("Importer with invalid extension") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val file: String = "cool-web.io"
    val args = Seq[String](importFile, file, exportConsole)

    assertThrows[ForbiddenExtension](consoleInputHandler.readInput(args))
  }

  test("Correct file importer") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val file: String = "assets/images/Pikachu.png"
    val args = Seq[String](importFile, file, exportConsole)
    consoleInputHandler.readInput(args)

    assert(config.RGBImporter.isDefined)
    assert(config.RGBImporter.get.isInstanceOf[LocalImageImporter])
  }

  test("Correct url importer") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val file: String = "https://website.com/image.png"
    val args = Seq[String](importUrl, file, exportConsole)
    consoleInputHandler.readInput(args)

    assert(config.RGBImporter.isDefined)
    assert(config.RGBImporter.get.isInstanceOf[URLImageImporter])
  }

  test("Correct random importer") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val args = Seq[String](importRandom, exportConsole)
    consoleInputHandler.readInput(args)

    assert(config.RGBImporter.isDefined)
    assert(config.RGBImporter.get.isInstanceOf[RandomPixelsImporter])
  }

  test("No exporters") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val args = Seq[String](importRandom)

    assertThrows[UndefinedTarget](consoleInputHandler.readInput(args))
  }

  test("Correct file output") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val file: String = "assets/output/Random.txt"
    val args = Seq[String](importRandom, exportFile, file)
    consoleInputHandler.readInput(args)

    assert(config.textExporters(0).isInstanceOf[FileExporter])
  }

  test("Correct console output") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val args = Seq[String](importRandom, exportConsole)
    consoleInputHandler.readInput(args)

    assert(config.textExporters(0).isInstanceOf[ConsoleExporter])
  }

  test("Multiple exporters") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val file: String = "assets/output/Random.txt"
    val args = Seq[String](importRandom, exportFile, file, exportConsole)
    consoleInputHandler.readInput(args)

    assert(config.textExporters(0).isInstanceOf[FileExporter])
    assert(config.textExporters(1).isInstanceOf[ConsoleExporter])
  }

  test("Normal args without filters") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val importedFile: String = "assets/images/SadPepe.jpg"
    val exportedFile: String = "assets/output/SadPepe.txt"
    val args = Seq[String](importFile, importedFile, exportFile, exportedFile, exportConsole)
    consoleInputHandler.readInput(args)

    assert(config.RGBImporter.isDefined)
    assert(config.RGBImporter.get.isInstanceOf[LocalImageImporter])
    assert(config.textExporters(0).isInstanceOf[FileExporter])
    assert(config.textExporters(1).isInstanceOf[ConsoleExporter])
  }

  test("Normal args with filters") {
    val config = new Config()
    val consoleInputHandler = new ConsoleInputHandler(config)
    val importedFile: String = "assets/images/SadPepe.jpg"
    val exportedFile: String = "assets/output/SadPepe.txt"
    val args = Seq[String](importFile, importedFile, brightnessFilter, "100", flipFilter, "x", invertFilter,
      rotateFilter, "90", scaleFilter, "4", flipFilter, "Y", exportFile, exportedFile, exportConsole)
    consoleInputHandler.readInput(args)

    assert(config.RGBImporter.isDefined)
    assert(config.RGBImporter.get.isInstanceOf[LocalImageImporter])
    assert(config.GSFilters(0).isInstanceOf[BrightnessPixelFilter])
    assert(config.GSFilters(1).isInstanceOf[FlipImageFilter[GSPixel]])
    assert(config.GSFilters(2).isInstanceOf[InvertPixelFilter])
    assert(config.GSFilters(3).isInstanceOf[RotateImageFilter[GSPixel]])
    assert(config.GSFilters(4).isInstanceOf[ScaleImageFilter[GSPixel]])
    assert(config.GSFilters(5).isInstanceOf[FlipImageFilter[GSPixel]])
    assert(config.textExporters(0).isInstanceOf[FileExporter])
    assert(config.textExporters(1).isInstanceOf[ConsoleExporter])
  }
}
