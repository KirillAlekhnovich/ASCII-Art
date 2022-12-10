package ASCIIArt.Importers.ImageImporter.RGBImageImporter.Generated.NoiseFunction

import ASCIIArt.Data.Image.Image
import ASCIIArt.Data.Pixel.RGBPixel.RGBPixel
import ASCIIArt.Importers.ImageImporter.RGBImageImporter.Generated.ImageGenerator

/**
 * Class that use some noise function to generate random image.
 */
class NoiseFunctionImporter extends ImageGenerator {

  /**
   * Function that generates random image.
   * @return Random image
   */
  override def load(): Image[RGBPixel] = {
    randomizeDimensions()
    var grid = Seq.empty[Seq[RGBPixel]]
    // Your cool implementation of noise function generator
    new Image[RGBPixel](grid)
  }
}
