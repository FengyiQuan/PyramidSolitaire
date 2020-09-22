import org.junit.Test;

import cs3500.pyramidsolitaire.model.hw02.PlayingCard;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

/**
 * Test for PlayingCard class.
 */
public class PlayingCardTest {
  private PlayingCard c1 = new PlayingCard(Value.Ace, Suit.Spade);
  private PlayingCard c1_1 = new PlayingCard(Value.Ace, Suit.Spade, false, 0, 0);
  private PlayingCard c2 = new PlayingCard(Value.Two, Suit.Spade);
  private PlayingCard c3 = new PlayingCard(Value.Three, Suit.Spade);

  @Test
  public void getValue() {
    assertEquals(Value.Ace, c1.getValue());
    assertEquals(Value.Two, c2.getValue());
  }

  @Test
  public void getSuit() {
    assertEquals(Suit.Spade, c1.getSuit());
    assertEquals(Suit.Spade, c2.getSuit());
  }

  @Test
  public void isExposed() {
    assertFalse(c1.isExposed());
  }

  @Test
  public void setExposed() {
    c1.setExposed(true);
    assertTrue(c1.isExposed());
  }

  @Test
  public void getRow() {
    assertEquals(0, c1.getRow());
  }

  @Test
  public void setRow() {
    c1.setRow(10);
    assertEquals(10, c1.getRow());
  }

  @Test
  public void getColumn() {
    assertEquals(0, c1.getColumn());
  }

  @Test
  public void setColumn() {
    c1.setColumn(5);
    assertEquals(5, c1.getColumn());
  }

  @Test
  public void testToString() {
    assertEquals("A♠", c1.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(c1, c1);
    assertEquals(c1, c1_1);
    assertNotEquals(c1, c2);
  }

}