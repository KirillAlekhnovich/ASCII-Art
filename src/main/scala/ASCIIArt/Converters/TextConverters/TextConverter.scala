package ASCIIArt.Converters.TextConverters

import ASCIIArt.Converters.Converter
import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.Pixel

/**
 * Interface for all image to String converters.
 * @tparam P Pixel type of image
 */
trait TextConverter[P <: Pixel] extends Converter[Image[P], String] {}
