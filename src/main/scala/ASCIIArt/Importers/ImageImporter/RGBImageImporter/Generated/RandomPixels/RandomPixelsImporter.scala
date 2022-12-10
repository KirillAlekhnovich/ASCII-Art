package ASCIIArt.Importers.ImageImporter.RGBImageImporter.Generated.RandomPixels

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.Generated.ImageGenerator

import java.awt.Color

/**
 * Generates and loads random image using full pixel randomness.
 */
class RandomPixelsImporter extends ImageGenerator {

  /**
   * Function that generates randomized image.
   * @return Randomized image
   */
  override def load(): Image[RGBPixel] = {
    randomizeDimensions()
    new Image[RGBPixel](randomizeGrid())
  }

  /**
   * Generates grid with random pixels.
   * @return Random grid
   */
  private def randomizeGrid(): Seq[Seq[RGBPixel]] = {
    var grid = Seq.empty[Seq[RGBPixel]]
    for (height <- 0 until randomizedHeight) {
      var row = Seq.empty[RGBPixel]
      for (width <- 0 until randomizedWidth)
        row = row :+ randomizePixel()
      grid = grid :+ row
    }
    grid
  }

  /**
   * Randomize specific RGB pixel.
   * @return Randomized pixel
   */
  private def randomizePixel(): RGBPixel =
    RGBPixel(new Color(randomInt(0, 255), randomInt(0, 255), randomInt(0, 255)))
}
