package cs3500.pyramidsolitaire.model.hw04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.PlayingCard;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;

/**
 * Abstract class of PyramidSolitaire which is extended by Basic, Relaxed and Tripeaks. Three
 * concrete pyramid class to play.
 */
public abstract class AbstractPyramidSolitaire implements PyramidSolitaireModel<PlayingCard> {

  protected int numDraw;
  protected int numRows;
  private List<PlayingCard> stock;
  List<PlayingCard> draws;
  List<PlayingCard> triangle;
  protected int score;
  private boolean isStart;

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
  protected AbstractPyramidSolitaire(int numDraw, int numRows, List<PlayingCard> stock,
                                     List<PlayingCard> draws, List<PlayingCard> triangle,
                                     int score, boolean isStart) {
    this.numDraw = numDraw;
    this.numRows = numRows;
    this.stock = stock;
    this.draws = draws;
    this.triangle = triangle;
    this.score = score;
    this.isStart = isStart;
  }


  @Override
  public List<PlayingCard> getDeck() {
    List<PlayingCard> result = new ArrayList<>();
    for (Suit s : Suit.values()) {
      for (Value v : Value.values()) {
        PlayingCard card = new PlayingCard(v, s);
        result.add(card);
      }
    }
    return result;
  }

  /**
   * {@code throw IllegalArgumentException} if deck is invalid.
   *
   * <p>Deck is invalid when:</p>
   * <b>1. deck is null</b>
   * <b>2. the size of deck is not 52</b>
   * <b>3. there is some duplicate cards in the deck</b>
   */
  @Override
  public void startGame(List<PlayingCard> deck, boolean shouldShuffle, int numRows, int numDraw) {
    if (deck == null || deck.size() != getDeck().size() || this.duplicateCardsInDeck(deck)) {
      throw new IllegalArgumentException("Deck isn't valid. ");
    }


    if ((this.countTotalCardInOnePyramid(numRows)) + numDraw > getDeck().size()) {
      throw new IllegalArgumentException("Not valid argument. ");
    }
    if (numRows < 1 || numDraw < 0) {
      throw new IllegalArgumentException("Not valid argument. ");
    }


    this.isStart = true;
    this.numDraw = numDraw;
    this.numRows = numRows;

    ArrayList<PlayingCard> temp = new ArrayList<>();
    for (PlayingCard c : deck) {
      PlayingCard newCard =
              new PlayingCard(c.getValue(), c.getSuit(), c.isExposed(), c.getRow(), c.getColumn());
      temp.add(newCard);
    }

    // shuffle the deck
    if (shouldShuffle) {
      Collections.shuffle(temp);
    }

    this.triangle = new ArrayList<>();

    assignPosition(temp);

    //mutate the bottom line of cards to exposed
    for (PlayingCard c : triangle) {
      if (c.getRow() == this.numRows - 1) {
        c.setExposed(true);
      }
    }

    this.draws = new ArrayList<>();
    //remove start draw cards from deck
    for (int i = 0; i < this.numDraw; i++) {
      draws.add(temp.remove(0));
    }

    this.stock = temp;
    this.score = getScore();

  }


  /**
   * not for RelaxedPyramidSolitaire.
   */
  @Override
  public void remove(int row1, int card1, int row2, int card2) throws IllegalStateException {
    checkStart();

    PlayingCard c1 = this.getCardAt(row1, card1);
    PlayingCard c2 = this.getCardAt(row2, card2);


    removeCheck(c1, c2);

    boolean sumIs13 = c1.getValue().getValue() + c2.getValue().getValue() == 13;

    if (sumIs13) {
      score = score - 13;
      triangle.remove(c1);
      triangle.remove(c2);
      updateExposed(row1, card1);
      updateExposed(row2, card2);
    } else {
      throw new IllegalArgumentException("Sum isn't 13. ");
    }
  }

  @Override
  public void remove(int row, int card) throws IllegalStateException {
    checkStart();

    PlayingCard c1 = this.getCardAt(row, card);

    if (c1 == null) {
      throw new IllegalArgumentException("Card doesn't exist. ");
    }

    if (!c1.isExposed()) {
      throw new IllegalArgumentException("Card isn't exposed. ");
    }

    if (c1.getValue().getValue() == 13) {
      score = score - 13;
      triangle.remove(c1);
      updateExposed(row, card);
    } else {
      throw new IllegalArgumentException("Card cannot be eliminated by itself. ");
    }
  }

  void removeCheck(PlayingCard c1, PlayingCard c2) {
    if (c1 == null || c2 == null) {
      throw new IllegalArgumentException("Card doesn't exist.  ");
    }

    if (!c1.isExposed() && !c2.isExposed()) {
      throw new IllegalArgumentException("Card isn't exposed. ");
    }
  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card) throws IllegalStateException {
    if (drawIndex >= numDraw || drawIndex < 0) {
      throw new IllegalArgumentException("Draw index is invalid. ");
    }
    checkStart();

    PlayingCard usingDraw = draws.get(drawIndex);
    PlayingCard c1 = this.getCardAt(row, card);

    if (c1 == null || usingDraw == null) {
      throw new IllegalArgumentException("Move is invalid. ");
    }

    if (!c1.isExposed()) {
      throw new IllegalArgumentException("Card isn't exposed. ");
    }

    boolean sumIs13 = c1.getValue().getValue() + usingDraw.getValue().getValue() == 13;
    if (sumIs13) {
      score = score - c1.getValue().getValue();
      triangle.remove(c1);
      discardDraw(drawIndex);
      updateExposed(row, card);
    } else {
      throw new IllegalArgumentException("Sum isn't 13. ");
    }
  }

  @Override
  public void discardDraw(int drawIndex) throws IllegalStateException {
    if (drawIndex >= numDraw || drawIndex < 0) {
      throw new IllegalArgumentException("The index is invalid. ");
    } else if (draws.get(drawIndex) == null) {
      throw new IllegalArgumentException("No card is present there. ");
    }
    checkStart();
    autoFillDrawFromStock(drawIndex);
  }

  @Override
  public int getNumRows() {
    if (!isStart) {
      return -1;
    }
    return numRows;
  }

  @Override
  public int getNumDraw() {
    if (!isStart) {
      return -1;
    }
    return numDraw;
  }

  /**
   * not for TriPeaks.
   */
  @Override
  public int getRowWidth(int row) {
    checkStart();
    if (row >= numRows || row < 0) {
      throw new IllegalArgumentException("The coordinates are invalid. ");
    }
    return row + 1;
  }

  @Override
  public boolean isGameOver() throws IllegalStateException {
    checkStart();
    return getScore() == 0 || noMoreMove();
  }

  @Override
  public int getScore() throws IllegalStateException {
    checkStart();
    int res = 0;
    for (PlayingCard c : triangle) {
      res += c.getValue().getValue();
    }
    return res;
  }

  @Override
  public PlayingCard getCardAt(int row, int card) throws IllegalStateException {
    if (row >= numRows || card < 0 || card > getRowWidth(row)) {
      throw new IllegalArgumentException("The coordinates are invalid. ");
    }
    checkStart();

    PlayingCard c1 = null;

    for (PlayingCard c : triangle) {
      if (c.getRow() == row && c.getColumn() == card && c1 == null) {
        c1 = new PlayingCard(c.getValue(), c.getSuit(), c.isExposed(), c.getRow(), c.getColumn());
      }
    }
    return c1;
  }

  @Override
  public List<PlayingCard> getDrawCards() throws IllegalStateException {
    checkStart();

    List<PlayingCard> res = new ArrayList<>();
    for (PlayingCard draw : draws) {
      if (draw != null) {
        PlayingCard card = new PlayingCard(draw.getValue(), draw.getSuit(),
                draw.isExposed(), draw.getRow(), draw.getColumn());
        res.add(card);
      } else {
        res.add(null);
      }
    }
    return res;
  }


  /**
   * Determine if a game has move to play.
   * <p>There is no any pair of {@code exposed} cards or single card can be removed in pyramid and
   * no card left in the stock.</p>
   *
   * @return {@code true} if there is no more move, {@code false} if there are some move to play
   */
  protected boolean noMoreMove() {
    boolean noMoreMove = false;
    List<PlayingCard> exposedCards = getExposedCards();

    // any exposed card can be removed using draw or stock or some cards in pyramid
    for (PlayingCard p : exposedCards) {
      for (PlayingCard c : exposedCards) {
        noMoreMove = noMoreMove || ((p.getValue().getValue() + c.getValue().getValue()) == 13)
                     || p.getValue().getValue() == 13;
      }
    }
    noMoreMove = noMoreMove || (hasAnyDraws(draws));
    return !noMoreMove;
  }

  /**
   * Counts the total number of cards.
   * <p> Only for one pyramid! Not for {@code Tripeaks}.</p>
   *
   * @param numRows number of rows in a pyramid game
   * @return the total number of cards in a pyramid game
   */
  protected int countTotalCardInOnePyramid(int numRows) {
    if (numRows < 0) {
      throw new IllegalArgumentException("Row number is invalid. ");
    }
    int res = 0;
    for (int r = 1; r <= numRows; r++) {
      res += r;
    }
    return res;
  }

  /**
   * Auto fill a draw card from the stock when it has been discard. Fill {@code null} if no cards in
   * the stock.
   *
   * @param drawIndex index of a draw card
   */
  private void autoFillDrawFromStock(int drawIndex) {
    if (drawIndex >= draws.size()) {
      throw new IllegalArgumentException("Index is not valid.");
    }
    if (!(stock.isEmpty())) {
      draws.set(drawIndex, stock.remove(0));
    } else {
      draws.set(drawIndex, null);
    }
  }

  /**
   * Set upper card exposed if it exposed. Only works in one pyramid.
   *
   * @param bottomRow bottom index of row (0-index)
   * @param bottomCol bottom index of column(0-index)
   */
  void updateExposed(int bottomRow, int bottomCol) {
    if (bottomRow > 0 && bottomRow < numRows) {
      if (bottomCol > 0) {
        PlayingCard topCardLeft = getCardAt(bottomRow - 1, bottomCol - 1);
        if (topCardLeft != null) {

          PlayingCard checkLeft = getCardAt(bottomRow, bottomCol - 1);
          if (checkLeft == null) {

            PlayingCard realCard = triangle.get(triangle.indexOf(topCardLeft));
            realCard.setExposed(true);
          }
        }
      }


      if (bottomCol < getRowWidth(bottomRow)) {
        PlayingCard topCardRight = getCardAt(bottomRow - 1, bottomCol);
        if (topCardRight != null) {

          PlayingCard checkRight = getCardAt(bottomRow, bottomCol + 1);
          if (checkRight == null) {

            PlayingCard realCard = triangle.get(triangle.indexOf(topCardRight));
            realCard.setExposed(true);
          }
        }
      }
    }
  }


  /**
   * Get a list of all exposed cards from game.
   *
   * @return a list of all exposed cards
   */
  List<PlayingCard> getExposedCards() {
    ArrayList<PlayingCard> res = new ArrayList<>();
    for (PlayingCard p : triangle) {
      if (p.isExposed()) {
        res.add(p);
      }
    }
    return res;
  }

  /**
   * Check if a given {@code deck} has duplicated cards.
   *
   * @param deck a list of deck
   * @return if there are some duplicated cards in a {@code deck}
   */
  protected boolean duplicateCardsInDeck(List<PlayingCard> deck) {
    boolean res = false;
    List<PlayingCard> temp = new ArrayList<>(deck);
    for (int i = 0; i < temp.size(); i++) {
      PlayingCard card = temp.remove(0);
      for (PlayingCard c : temp) {
        res = res || (c.equals(card));
      }
    }

    return res;
  }

  /**
   * Check if a draws is empty.
   *
   * @param draws a list of draw cards
   * @return true if draws isn't empty, false if draws is empty.
   */
  static boolean hasAnyDraws(List<PlayingCard> draws) {
    for (PlayingCard p : draws) {
      if (p != null) {
        return true;
      }
    }
    return false;
  }


  protected void assignPosition(List<PlayingCard> temp) {
    // assign position
    for (int row = 0; row < this.numRows; row++) {
      for (int col = 0; col <= row; col++) {
        temp.get(0).setRow(row);
        temp.get(0).setColumn(col);
        triangle.add(temp.remove(0));
      }
    }
  }


  void checkStart() {
    if (!isStart) {
      throw new IllegalStateException("The game hasn't been started yet. ");
    }
  }

}
