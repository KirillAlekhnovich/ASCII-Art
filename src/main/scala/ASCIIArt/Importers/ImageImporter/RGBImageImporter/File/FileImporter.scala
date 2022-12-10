package ASCIIArt.Importers.ImageImporter.RGBImageImporter.File

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel
import ASCIIArt.Exceptions.{FileCantBeImported, NegativeDimension}
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.RGBImageImporter

import java.awt.Color
import java.awt.image.BufferedImage

/**
 * Interface for importing specific file.
 * @tparam T Type of file
 */
trait FileImporter[T] extends RGBImageImporter {

  /**
   * Converts gotten buffered image into Image model.
   * @param bufferedImage Buffered image
   * @return Image data model
   */
  def toImageEntity(bufferedImage: BufferedImage): Image[RGBPixel] = {
    if (bufferedImage == null) throw new FileCantBeImported()
    val imageHeight = bufferedImage.getHeight()
    val imageWidth = bufferedImage.getWidth()
    var pixelGrid = Seq.empty[Seq[RGBPixel]]

    if (imageHeight <= 0) throw new NegativeDimension()
    if (imageWidth <= 0) throw new NegativeDimension()

    // Filling pixels row by row into pixelGrid variable
    for (height <- 0 until imageHeight) {
      var row = Seq.empty[RGBPixel]
      for (width <- 0 until imageWidth)
        row = row :+ RGBPixel(new Color(bufferedImage.getRGB(width, height)))
      pixelGrid = pixelGrid :+ row
    }

    new Image[RGBPixel](pixelGrid)
  }
}
