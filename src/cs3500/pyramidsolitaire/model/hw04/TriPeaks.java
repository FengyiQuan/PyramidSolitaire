package cs3500.pyramidsolitaire.model.hw04;

import java.util.ArrayList;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.PlayingCard;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;

/**
 * TriPeaks class which can produce three cascades game mode.
 */
public class TriPeaks extends AbstractPyramidSolitaire {
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
  public TriPeaks(int numDraw, int numRows, List<PlayingCard> stock,
                  List<PlayingCard> draws, List<PlayingCard> triangle,
                  int score, boolean isStart) {
    super(numDraw, numRows, stock, draws, triangle, score, isStart);
  }

  /**
   * Empty argument constructor.
   */
  public TriPeaks() {
    this(3, 7, null, null, null, 0, false);
  }

  /**
   * Generate a double deck.
   *
   * @return a double deck, containing 104 cards (two of each unique card)
   */
  @Override
  public List<PlayingCard> getDeck() {
    List<PlayingCard> result = new ArrayList<>();
    for (Suit s : Suit.values()) {
      for (Value v : Value.values()) {
        PlayingCard card1 = new PlayingCard(v, s);
        PlayingCard card2 = new PlayingCard(v, s);
        result.add(card1);
        result.add(card2);
      }
    }
    return result;
  }


  //check if no three card are the same
  protected boolean duplicateCardsInDeck(List<PlayingCard> deck) {
    ArrayList<PlayingCard> temp = new ArrayList<>();

    // copy
    for (PlayingCard c : deck) {
      PlayingCard newCard =
              new PlayingCard(c.getValue(), c.getSuit());
      temp.add(newCard);
    }

    while (temp.size() > 0) {
      PlayingCard card = temp.remove(0);
      boolean hasOneMore = false;
      for (int i = 0; i < temp.size(); i++) {
        PlayingCard cd = temp.get(i);
        if (cd.equals(card)) {
          temp.remove(cd);
          hasOneMore = true;
          break;
        }
      }
      if (!hasOneMore) {
        throw new IllegalArgumentException("Deck has a single card. ");
      }
      for (PlayingCard rest : temp) {
        if (rest.equals(card)) {
          throw new IllegalArgumentException("Deck has a triple card. ");
        }
      }
    }
    return false;
  }

  @Override
  public int getRowWidth(int row) {
    checkStart();
    if (row >= numRows || row < 0) {
      throw new IllegalArgumentException("The coordinates are invalid. ");
    }

    int numRowIndividual = numRows / 2;
    int totalCardsOnLastIndividual = numRowIndividual * 3;
    if (row < numRowIndividual) {
      return totalCardsOnLastIndividual - (numRowIndividual - row - 1);
    } else {
      return totalCardsOnLastIndividual + row - numRowIndividual + 1;
    }
  }


  protected int countTotalCardInOnePyramid(int numRows) {
    if (numRows < 0) {
      throw new IllegalArgumentException("Row number is invalid. ");
    }
    int numRowIndividual = numRows / 2;

    int res = 0;
    int currentRowCardNum = 0;
    for (int r = 1; r <= numRows; r++) {
      if (r <= numRowIndividual) {
        currentRowCardNum += 3;
      } else {
        currentRowCardNum += 1;
      }
      res += currentRowCardNum;
    }
    return res;
  }

  protected void assignPosition(List<PlayingCard> temp) {
    // assign position
    int numRowIndividual = this.numRows / 2;


    // assign individual row cards
    for (int row = 0; row < numRowIndividual; row++) {
      for (int col = 0; col < getRowWidth(row); col++) {
        if (col % numRowIndividual < row + 1) {
          temp.get(0).setRow(row);
          temp.get(0).setColumn(col);
          triangle.add(temp.remove(0));
        }
      }
    }

    // assign overlap row cards
    for (int row = numRowIndividual; row < this.numRows; row++) {
      for (int col = 0; col < getRowWidth(row); col++) {
        temp.get(0).setRow(row);
        temp.get(0).setColumn(col);
        triangle.add(temp.remove(0));
      }
    }
  }
}