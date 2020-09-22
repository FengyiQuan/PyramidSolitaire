package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represent a {@code Value} of a card.
 */
public enum Value {
  Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10),
  Jack(11), Queen(12), King(13);

  private final int value;

  /**
   * Construct a Value.
   *
   * @param value the value of a card
   */
  Value(int value) {
    this.value = value;
  }

  // get the value of a card
  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    switch (this) {
      case Ace:
        return "A";
      case Jack:
        return "J";
      case Queen:
        return "Q";
      case King:
        return "K";
      default:
        return Integer.toString(value);
    }
  }
}
