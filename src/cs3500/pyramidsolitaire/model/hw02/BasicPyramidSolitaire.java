package cs3500.pyramidsolitaire.model.hw02;

import java.util.List;

import cs3500.pyramidsolitaire.model.hw04.AbstractPyramidSolitaire;

/**
 * BasicPyramidSolitaire class which can produce one cascades game mode with classic mode.
 */
public class BasicPyramidSolitaire extends AbstractPyramidSolitaire {
  /**
   * Construct BasicPyramidSolitaire class.
   *
   * @param numDraw  the number of draw cards to start a game
   * @param numRows  the number of rows in the pyramid
   * @param stock    a stock in a game
   * @param draws    a list of draw card that players can use
   * @param triangle the list of {@code PlayingCard} in the triangle
   * @param score    the score that player gets
   * @param isStart  determine if the game starts
   */
  public BasicPyramidSolitaire(int numDraw, int numRows, List<PlayingCard> stock,
                               List<PlayingCard> draws, List<PlayingCard> triangle,
                               int score, boolean isStart) {
    super(numDraw, numRows, stock, draws, triangle, score, isStart);
  }

  public BasicPyramidSolitaire() {
    this(7, 7, null, null, null, 0, false);
  }

}
