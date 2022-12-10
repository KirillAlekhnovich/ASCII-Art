package ASCIIArt.Config

import ASCIIArt.Data.Pixel.ASCIIPixel.ASCIIPixel
import ASCIIArt.Data.Pixel.GSPixel.GSPixel
import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel
import ASCIIArt.Exporters.Text.TextExporter
import ASCIIArt.Filters.Image.ImageFilter
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.RGBImageImporter

/**
 * Class that holds app configuration. Used to access importers, filters and exporters.
 */
class Config() {
  private var _RGBImporter: Option[RGBImageImporter] = None
  private var _RGBFilters: List[ImageFilter[RGBPixel]] =
    List.empty[ImageFilter[RGBPixel]]
  private var _GSFilters: List[ImageFilter[GSPixel]] =
    List.empty[ImageFilter[GSPixel]]
  private var _ASCIIFilters: List[ImageFilter[ASCIIPixel]] =
    List.empty[ImageFilter[ASCIIPixel]]
  private var _textExporters: List[TextExporter] = List.empty[TextExporter]
  private var _charRamp: Option[String] = None

  /**
   * RGBImporter getter from config.
   * @return RGBImporter
   */
  def RGBImporter: Option[RGBImageImporter] = _RGBImporter

  /**
   * RGBImporter setter to config.
   * @param newRGBImporter RGBImporter that must be set
   */
  def RGBImporter_=(newRGBImporter: Option[RGBImageImporter]): Unit =
    _RGBImporter = newRGBImporter

  /**
   * RGBFilters getter from config.
   * @return RGBFilters
   */
  def RGBFilters: List[ImageFilter[RGBPixel]] = _RGBFilters

  /**
   * Function that adds new RGBFilter to RGBFilters in config.
   * @param newRGBFilter RGBFilters that must be added
   */
  def addRGBFilter(newRGBFilter: ImageFilter[RGBPixel]): Unit =
    RGBFilters = RGBFilters :+ newRGBFilter

  /**
   * RGBFilters setter to config.
   * @param newRGBFilters List of RGBFilters that must be set
   */
  def RGBFilters_=(newRGBFilters: List[ImageFilter[RGBPixel]]): Unit =
    _RGBFilters = newRGBFilters

  /**
   * GSFilters getter from config.
   * @return GSFilters
   */
  def GSFilters: List[ImageFilter[GSPixel]] = _GSFilters

  /**
   * Function that adds new GSFilter to GSFilters in config.
   * @param newGSFilter GSFilters that must be added
   */
  def addGSFilter(newGSFilter: ImageFilter[GSPixel]): Unit =
    GSFilters = GSFilters :+ newGSFilter

  /**
   * GSFilters setter to config.
   * @param newGSFilters List of GSFilters that must be set
   */
  def GSFilters_=(newGSFilters: List[ImageFilter[GSPixel]]): Unit =
    _GSFilters = newGSFilters

  /**
   * ASCIIFilters getter from config.
   * @return ASCIIFilters
   */
  def ASCIIFilters: List[ImageFilter[ASCIIPixel]] = _ASCIIFilters

  /**
   * Function that adds new ASCIIFilter to ASCIIFilters in config.
   * @param newASCIIFilter ASCIIFilters that must be added
   */
  def addASCIIFilter(newASCIIFilter: ImageFilter[ASCIIPixel]): Unit =
    ASCIIFilters = ASCIIFilters :+ newASCIIFilter

  /**
   * ASCIIFilters setter to config.
   * @param newASCIIFilters List of ASCIIFilters that must be set
   */
  def ASCIIFilters_=(newASCIIFilters: List[ImageFilter[ASCIIPixel]]): Unit =
    _ASCIIFilters = newASCIIFilters

  /**
   * TextExporters getter from config.
   * @return TextExporters
   */
  def textExporters: List[TextExporter] = _textExporters

  /**
   * Function that adds new TextExporter to TextExporters in config.
   * @param newTextExporter TextExporter that must be added
   */
  def addTextExporter(newTextExporter: TextExporter): Unit =
    textExporters = textExporters :+ newTextExporter

  /**
   * TextExporters setter to config.
   * @param newTextExports List of TextExporters that must be set
   */
  def textExporters_=(newTextExports: List[TextExporter]): Unit =
    _textExporters = newTextExports

  /**
   * Char ramp for GS to ASCII conversion.
   * @return Config's char ramp.
   */
  def charRamp: Option[String] = _charRamp

  /**
   * Char ramp setter to config.
   * @param newCharRamp Char ramp that must be set
   */
  def charRamp_=(newCharRamp: Option[String]): Unit =
    _charRamp = newCharRamp
}
