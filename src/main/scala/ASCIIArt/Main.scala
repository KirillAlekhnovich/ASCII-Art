package ASCIIArt

import ASCIIArt.Config.Config
import ASCIIArt.Converters.ImageConverters.GSToASCII.GSToASCIIConverter
import ASCIIArt.Converters.ImageConverters.RGBToGS.RGBToGSConverter
import ASCIIArt.Converters.TextConverters.ASCIIToString.ASCIIToStringConverter
import ASCIIArt.UI.ConsoleInput.ConsoleInputHandler

object Main extends App {
  val config = new Config()
  val inputHandler = new ConsoleInputHandler(config)
  inputHandler.readInput(args.toList)

  val RGBToGS = new RGBToGSConverter()
  var GSToASCII: GSToASCIIConverter = new GSToASCIIConverter()
  if (config.charRamp.isDefined)
    GSToASCII = new GSToASCIIConverter(config.charRamp.get)
  val ASCIIToString = new ASCIIToStringConverter()

  var RGBImage = config.RGBImporter.get.load()
  for (filter <- config.RGBFilters)
    RGBImage = filter.apply(RGBImage)

  var GSImage = RGBToGS.convert(RGBImage)
  for (filter <- config.GSFilters)
    GSImage = filter.apply(GSImage)

  var ASCIIIMage = GSToASCII.convert(GSImage)
  for (filter <- config.ASCIIFilters)
    ASCIIIMage = filter.apply(ASCIIIMage)

  config.textExporters.foreach(e => e.export(ASCIIToString.convert(ASCIIIMage)))
}
