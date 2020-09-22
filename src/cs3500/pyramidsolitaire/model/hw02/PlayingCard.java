package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represent a card in Pyramid Solitaire Game.
 */
public class PlayingCard {
  private final Value value;
  private final Suit suit;
  private boolean exposed;
  private int row;
  private int column;

  /**
   * Construct a PlayingCard.
   *
   * @param value   the value of a card
   * @param suit    the suit of a card
   * @param exposed determine if a card is exposed
   * @param row     the row position of a card
   * @param column  the column position of a card
   */
  public PlayingCard(Value value, Suit suit, boolean exposed, int row, int column) {
    this.value = value;
    this.suit = suit;
    this.exposed = exposed;
    this.row = row;
    this.column = column;
  }

  public PlayingCard(Value value, Suit suit) {
    this(value, suit, false, 0, 0);
  }

  public Value getValue() {
    return value;
  }

  public Suit getSuit() {
    return suit;
  }

  public boolean isExposed() {
    return exposed;
  }

  public void setExposed(boolean exposed) {
    this.exposed = exposed;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  @Override
  public String toString() {
    return this.value.toString() + this.suit.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof PlayingCard)) {
      return false;
    }
    PlayingCard that = (PlayingCard) obj;
    return this.value.equals(that.value) && this.suit.equals(that.suit)
           && this.exposed == that.exposed && this.row == that.row
           && this.column == that.column;
  }

  @Override
  public int hashCode() {
    switch (suit) {
      case Club:
        return value.hashCode() * 17;
      case Heart:
        return value.hashCode() * 89;
      case Spade:
        return value.hashCode() * 3;
      case Diamond:
        return value.hashCode() * 67;
      default:
        return 0;
    }
  }
}
