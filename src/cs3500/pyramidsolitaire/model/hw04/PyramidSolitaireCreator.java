package cs3500.pyramidsolitaire.model.hw04;

import java.util.List;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PlayingCard;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;


/**
 * PyramidSolitaireCreator is to create a model to play.
 */
public final class PyramidSolitaireCreator {

  /**
   * main entry subtract from main function in order to test. Details explanation see {@link
   * cs3500.pyramidsolitaire.PyramidSolitaire}
   *
   * @param args inheritance from user inputs from main functions to start game based on these value
   *             to configure the setting.
   * @param c    controller which control the user inputs from console to interactive with gamers.
   */
  public void chooseToPlay(String[] args, PyramidSolitaireController c) {
    int length = args.length;
    GameType gtp = getGameType(args[0]);
    int rowNum = 7;
    int drawNum = 3;
    if (length != 1) {
      try {
        rowNum = Integer.parseInt(args[1]);
        drawNum = Integer.parseInt(args[2]);
      } catch (NumberFormatException ignored) {
        System.err.print("Should enter Integer. \n");
        System.exit(1);
      }
    }
    PyramidSolitaireModel<PlayingCard> m = PyramidSolitaireCreator.create(gtp);
    c.playGame(m, m.getDeck(), false, rowNum, drawNum);
  }


  private GameType getGameType(String args) {
    switch (args.toUpperCase()) {
      case "BASIC":
        return GameType.BASIC;
      case "RELAXED":
        return GameType.RELAXED;
      case "TRIPEAKS":
        return GameType.TRIPEAKS;
      default:
        throw new IllegalArgumentException("No such GameType. ");
    }
  }


  /**
   * GameType to represent which game mode should be play.
   *
   * <br> BASIC: BasicPyramidSolitaire
   * <br> RELAXED: RelaxedPyramidSolitaire
   * <br> TRIPEAKS: TriPeaks
   */
  public enum GameType {
    BASIC, RELAXED, TRIPEAKS
  }

  /**
   * Create a game to play based on passing {@code type} choice.
   *
   * @param type the game mode will be play.
   * @return PyramidSolitaireModel to play
   */
  public static PyramidSolitaireModel<PlayingCard> create(GameType type) {
    switch (type) {
      case BASIC:
        return new BasicPyramidSolitaire();//builder().buildBasic();
      case RELAXED:
        return new RelaxedPyramidSolitaire();//builder().buildRelaxed();
      case TRIPEAKS:
        return new TriPeaks();//builder().buildTriPeaks();
      default:
        throw new IllegalArgumentException("No such GameType. ");
    }
  }

  /**
   * Constructs a builder for configuring and then creating a game model instance. Defaults to a
   * game of PyramidSolitaire with numDraw 3 and numRows 7.
   *
   * @return the new builder
   */
  public static Builder builder() {
    return new Builder();
  }


  /**
   * Builder Pattern class.
   */
  public static final class Builder {
    // default value
    private int numDraw = 3;
    private int numRows = 7;
    private List<PlayingCard> stock = null;
    private List<PlayingCard> draws = null;
    private List<PlayingCard> triangle = null;
    private int score = 0;
    private boolean isStart = false;

    /**
     * build a BasicPyramidSolitaire via Builder Pattern.
     *
     * @return build a BasicPyramidSolitaire instance to play
     */
    public BasicPyramidSolitaire buildBasic() {
      return new BasicPyramidSolitaire(numDraw, numRows, stock, draws, triangle, score, isStart);
    }

    /**
     * build a RelaxedPyramidSolitaire via Builder Pattern.
     *
     * @return build a RelaxedPyramidSolitaire instance to play
     */
    public RelaxedPyramidSolitaire buildRelaxed() {
      return new RelaxedPyramidSolitaire(numDraw, numRows, stock, draws, triangle, score, isStart);
    }

    /**
     * build a TriPeaks via Builder Pattern.
     *
     * @return build a TriPeaks instance to play
     */
    public TriPeaks buildTriPeaks() {
      return new TriPeaks(numDraw, numRows, stock, draws, triangle, score, isStart);
    }


    /**
     * Sets the number of draw for the game.
     *
     * @param numDraw the number of draws (non-negative)
     * @return {@code this}, for method chaining
     */
    public Builder numDraw(int numDraw) {
      if (numDraw < 0) {
        throw new IllegalArgumentException("numDraw must be non-negative. ");
      }

      this.numDraw = numDraw;
      return this;
    }


    /**
     * Sets the number of rows for the game.
     *
     * @param numRows the number of rows (positive)
     * @return {@code this}, for method chaining
     */
    public Builder numRows(int numRows) {
      if (numRows < 1) {
        throw new IllegalArgumentException("numRows must be positive. ");
      }
      this.numRows = numRows;
      return this;
    }

    /**
     * Sets the stock  for the game.
     *
     * @param stock the stock
     * @return {@code this}, for method chaining
     */
    public Builder stock(List<PlayingCard> stock) {
      this.stock = stock;
      return this;
    }

    /**
     * Sets the draws for the game.
     *
     * @param draws draws
     * @return {@code this}, for method chaining
     */
    public Builder draws(List<PlayingCard> draws) {
      this.draws = draws;
      return this;
    }

    /**
     * Sets the triangle for the game.
     *
     * @param triangle triangle
     * @return {@code this}, for method chaining
     */
    public Builder triangle(List<PlayingCard> triangle) {
      this.triangle = triangle;
      return this;
    }

    /**
     * Sets the score for the game.
     *
     * @param score score
     * @return {@code this}, for method chaining
     */
    public Builder score(int score) {
      this.score = score;
      return this;
    }

    /**
     * Sets the isStart for the game.
     *
     * @param isStart isStart
     * @return {@code this}, for method chaining
     */
    public Builder isStart(boolean isStart) {
      this.isStart = isStart;
      return this;
    }
  }
}




