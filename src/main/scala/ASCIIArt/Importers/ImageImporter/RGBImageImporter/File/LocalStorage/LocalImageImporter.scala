package ASCIIArt.Importers.ImageImporter.RGBImageImporter.File.LocalStorage

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel
import ASCIIArt.Exceptions.FileCantBeImported
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.File.FileImporter

import java.io.File
import javax.imageio.ImageIO

/**
 * Class that loads image from local storage.
 * @param path Path to the file on your local machine
 */
class LocalImageImporter(private val path: String) extends FileImporter[File] {

  /**
   * Loads an image from local storage.
   * @return Image model
   */
  override def load(): Image[RGBPixel] =
    try {
      val bufferedImage = ImageIO.read(new File(path))
      toImageEntity(bufferedImage)
    } catch {
      case _: Exception => throw new FileCantBeImported()
    }
}
