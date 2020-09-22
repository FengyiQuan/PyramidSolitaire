package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represent a {@code Color} of a card.
 */
public enum Suit {
  Spade('♠'), Heart('♥'), Diamond('♦'), Club('♣');

  private final char suit;

  /**
   * Construct a {@code Color} class.
   *
   * @param suit the color of a card
   */
  Suit(char suit) {
    this.suit = suit;
  }

  @Override
  public String toString() {
    return Character.toString(this.suit);
  }
}
