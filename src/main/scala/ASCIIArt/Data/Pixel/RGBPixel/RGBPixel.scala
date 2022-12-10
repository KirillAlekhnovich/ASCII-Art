package ASCIIArt.Data.Pixel.RGBPixel

import ASCIIArt.Data.Pixel.Pixel

import java.awt.Color

/**
 * RGB pixel model.
 * @param value Pixel RGB representation
 */
case class RGBPixel(value: Color) extends Pixel {}
