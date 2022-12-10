package ASCIIArt.UI

/**
 * Interface for all input handlers.
 * @tparam T Type of input
 */
trait InputHandler[T] {

  /**
   * Function that reads user input.
   * @param input User input
   */
  def readInput(input: T): Unit
}
