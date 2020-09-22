package cs3500.pyramidsolitaire.model.hw02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Mock model to test.
 *
 * @param <K> represents Card class.
 */
public class ConfirmInputsPyramidSolitaireModel<K> implements PyramidSolitaireModel<K> {
  private final StringBuilder log;

  public ConfirmInputsPyramidSolitaireModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }


  @Override
  public List<K> getDeck() {
    return null;
  }

  @Override
  public void startGame(List<K> deck, boolean shuffle, int numRows, int numDraw) {
    String deckString = "";
    for (K card : deck) {
      deckString = deckString.concat(card.toString());
    }
    log.append(String.format("%s\nshuffle = %s, numRows = %s, numDraw = %s\n",
            deckString, shuffle, numRows, numDraw));
  }

  @Override
  public void remove(int row1, int card1, int row2, int card2) throws IllegalStateException {
    log.append(String.format("row1 = %d, card1 = %d, row2 = %d, card2 = %d\n",
            row1, card1, row2, card2));
  }

  @Override
  public void remove(int row, int card) throws IllegalStateException {
    log.append(String.format("row = %d, card = %d\n", row, card));
  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card) throws IllegalStateException {
    log.append(String.format("drawIndex = %d, row = %d, card = %d\n", drawIndex, row, card));
  }

  @Override
  public void discardDraw(int drawIndex) throws IllegalStateException {
    log.append(String.format("drawIndex = %d\n", drawIndex));
  }

  @Override
  public int getNumRows() {
    return 0;
  }

  @Override
  public int getNumDraw() {
    return 0;
  }

  @Override
  public int getRowWidth(int row) {
    return 0;
  }

  @Override
  public boolean isGameOver() throws IllegalStateException {
    return false;
  }

  @Override
  public int getScore() throws IllegalStateException {
    return 0;
  }

  @Override
  public K getCardAt(int row, int card) throws IllegalStateException {
    return null;
  }

  @Override
  public List<K> getDrawCards() throws IllegalStateException {
    return new ArrayList<>();
  }
}
