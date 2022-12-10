package ASCIIArt.UI.ConsoleInput

import ASCIIArt.Config.Config
import ASCIIArt.Exceptions.{
  EmptyInput,
  UndefinedSource,
  UndefinedTarget,
  UnknownAttribute
}
import ASCIIArt.InputParams.TextParams.Conversion.Specific.GSTableHandler
import ASCIIArt.InputParams.TextParams.Exporters.Specific.{
  ConsoleExporterHandler,
  FileExporterHandler
}
import ASCIIArt.InputParams.TextParams.Filters.Specific.{
  BrightnessFilterHandler,
  FlipFilterHandler,
  InvertFilterHandler,
  RotateFilterHandler,
  ScaleFilterHandler
}
import ASCIIArt.InputParams.TextParams.Importers.Specific.{
  LocalImporterHandler,
  RandomPixelsImporterHandler,
  URLImporterHandler
}
import ASCIIArt.UI.InputHandler

/**
 * Class that handles console input.
 * @param config App configuration
 */
class ConsoleInputHandler(private val config: Config)
    extends InputHandler[Seq[String]] {

  /**
   * Function that reads input from console.
   * @param args Command line arguments
   */
  override def readInput(args: Seq[String]): Unit = {
    if (args.isEmpty) throw new EmptyInput()
    parseArguments(args)
    if (config.RGBImporter.isEmpty) throw new UndefinedSource()
    if (config.textExporters.isEmpty) throw new UndefinedTarget()
  }

  /**
   * Function to parse console arguments and call correct handlers.
   * @param args Command line arguments
   */
  def parseArguments(args: Seq[String]): Unit =
    args match {
      case "--image" :: filePath :: tail =>
        new LocalImporterHandler().execute(filePath, config)
        parseArguments(tail)
      case "--image-url" :: url :: tail =>
        new URLImporterHandler().execute(url, config)
        parseArguments(tail)
      case "--image-random" :: tail =>
        new RandomPixelsImporterHandler().execute(config)
        parseArguments(tail)
//      Noise function is not implemented, it's just an example of how you can add more different randomizers
//      case "--image-random-noise" :: tail =>
//        new NoiseFunctionImporterHandler().execute(config)
//        parseArguments(tail)
      case "--custom-table" :: characters :: tail =>
        new GSTableHandler().execute(characters, config)
        parseArguments(tail)
      case "--rotate" :: degrees :: tail =>
        new RotateFilterHandler().execute(degrees, config)
        parseArguments(tail)
      case "--scale" :: value :: tail =>
        new ScaleFilterHandler().execute(value, config)
        parseArguments(tail)
      case "--invert" :: tail =>
        new InvertFilterHandler().execute(config)
        parseArguments(tail)
      case "--flip" :: axis :: tail =>
        new FlipFilterHandler().execute(axis, config)
        parseArguments(tail)
      case "--brightness" :: value :: tail =>
        new BrightnessFilterHandler().execute(value, config)
        parseArguments(tail)
      case "--output-console" :: tail =>
        new ConsoleExporterHandler().execute(config)
        parseArguments(tail)
      case "--output-file" :: path :: tail =>
        new FileExporterHandler().execute(path, config)
        parseArguments(tail)
      case Nil =>
      case _   => throw new UnknownAttribute()
    }
}
