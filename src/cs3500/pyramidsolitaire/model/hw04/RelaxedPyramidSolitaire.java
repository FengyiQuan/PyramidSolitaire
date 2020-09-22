package cs3500.pyramidsolitaire.model.hw04;

import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.PlayingCard;

/**
 * RelaxedPyramidSolitaire class which can produce one cascades game mode with easy rule game mode.
 */
public class RelaxedPyramidSolitaire extends AbstractPyramidSolitaire {


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
  public RelaxedPyramidSolitaire(int numDraw, int numRows, List<PlayingCard> stock,
                                 List<PlayingCard> draws, List<PlayingCard> triangle,
                                 int score, boolean isStart) {
    super(numDraw, numRows, stock, draws, triangle, score, isStart);
  }

  /**
   * Empty argument constructor.
   */
  public RelaxedPyramidSolitaire() {
    this(3, 7, null, null, null, 0, false);
  }

  @Override
  public void remove(int row1, int card1, int row2, int card2) throws IllegalStateException {

    checkStart();

    PlayingCard c1 = this.getCardAt(row1, card1);
    PlayingCard c2 = this.getCardAt(row2, card2);

    removeCheck(c1, c2);

    boolean sumIs13 = c1.getValue().getValue() + c2.getValue().getValue() == 13;

    if (!sumIs13) {
      throw new IllegalArgumentException("Sum isn't 13. ");
    }

    // two exposed or one exposed and one is covered by another
    if ((isOneCoverAnother(row1, card1, row2, card2) && (c1.isExposed() || c2.isExposed()))
        || (c1.isExposed() && c2.isExposed())) {

      score = score - 13;

      triangle.remove(c1);
      triangle.remove(c2);
      updateExposed(row1, card1);
      updateExposed(row2, card2);
    } else {
      throw new IllegalArgumentException("Coordinate invalid. ");
    }
  }


  private boolean isOneCoverAnother(int row1, int card1, int row2, int card2) {
    // the second card is on the top
    if (row1 == row2 + 1) {
      if (card1 == card2) {
        PlayingCard right = this.getCardAt(row1, card1 + 1);
        // Top card is covered by two cards.
        return right == null;
      } else if (card1 == card2 + 1) {
        PlayingCard left = this.getCardAt(row1, card1 - 1);
        // Top card is covered by two cards.
        return left == null;
      }
    }
    // the first card is on the top
    else if (row1 + 1 == row2) {
      if (card1 == card2) {
        PlayingCard right = this.getCardAt(row2, card2 + 1);
        // Top card is covered by two cards.
        return right == null;
      } else if (card1 + 1 == card2) {
        PlayingCard left = this.getCardAt(row2, card2 - 1);
        // Top card is covered by two cards.
        return left == null;
      }
    }
    // coordinate doesn't match
    return false;
  }

  protected boolean noMoreMove() {
    boolean noMoreMove;
    boolean any13 = false;
    List<PlayingCard> exposedCards = getExposedCards();

    // any exposed card can be removed using draw or stock or some cards in pyramid
    for (PlayingCard p : exposedCards) {
      for (PlayingCard c : exposedCards) {
        any13 = any13 || ((p.getValue().getValue() + c.getValue().getValue()) == 13)
                || p.getValue().getValue() == 13;
      }

      int bottomRow = p.getRow();
      int bottomCol = p.getColumn();
      if (bottomRow > 0 && bottomRow < numRows) {
        if (bottomCol > 0) {
          PlayingCard topCardLeft = getCardAt(bottomRow - 1, bottomCol - 1);
          PlayingCard checkLeft = getCardAt(bottomRow, bottomCol - 1);


          if (checkLeft == null) {
            any13 = any13 || (p.getValue().getValue() + topCardLeft.getValue().getValue() == 13);
          }
        }
        if (bottomCol < bottomRow) {
          PlayingCard topCardRight = getCardAt(bottomRow - 1, bottomCol);
          PlayingCard checkRight = getCardAt(bottomRow, bottomCol + 1);
          if (checkRight == null) {
            any13 = any13 || (p.getValue().getValue() + topCardRight.getValue().getValue() == 13);
          }
        }
      }
    }
    noMoreMove = any13 || (hasAnyDraws(draws));
    return !noMoreMove;
  }


}
