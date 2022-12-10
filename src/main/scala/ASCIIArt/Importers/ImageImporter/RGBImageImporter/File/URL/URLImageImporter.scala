package ASCIIArt.Importers.ImageImporter.RGBImageImporter.File.URL

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel
import ASCIIArt.Exceptions.FileCantBeImported
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.File.FileImporter

import java.net.URL
import javax.imageio.ImageIO

/**
 * Class for loading images from url.
 * @param url Url with image ending with its extension
 */
class URLImageImporter(private val url: String) extends FileImporter[URL] {

  /**
   * Loading image from url.
   * @return Image model
   */
  override def load(): Image[RGBPixel] =
    try {
      val bufferedImage = ImageIO.read(new URL(url))
      toImageEntity(bufferedImage)
    } catch {
      case _: Exception => throw new FileCantBeImported()
    }
}
