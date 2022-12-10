package ASCIIArt.Importers.ImageImporter.RGBImageImporter.Generated

import ASCIIArt.Importers.ImageImporter.RGBImageImporter.RGBImageImporter

import scala.util.Random

/**
 * Common abstract class for all random image generators.
 */
abstract class ImageGenerator extends RGBImageImporter {

  private val minDimensionSize = 200
  private val maxDimensionSize = 400
  protected var randomizedHeight: Int = 0
  protected var randomizedWidth: Int = 0

  /**
   * Function that randomizes image dimensions in range: [minDimensionSize - maxDimensionSize]
   */
  def randomizeDimensions(): Unit = {
    randomizedHeight = randomInt(minDimensionSize, maxDimensionSize)
    randomizedWidth = randomInt(minDimensionSize, maxDimensionSize)
  }

  /**
   * Function to randomize integer number in given range.
   * @param from Min random value
   * @param until Max random value
   * @return Randomized integer
   */
  protected def randomInt(from: Int, until: Int): Int = new Random().between(from, until + 1)
}
