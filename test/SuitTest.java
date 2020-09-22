import org.junit.Test;

import cs3500.pyramidsolitaire.model.hw02.Suit;

import static org.junit.Assert.assertEquals;

/**
 * Test for Suit.
 */
public class SuitTest {
  private Suit s1 = Suit.Club;
  private Suit s2 = null;

  @Test
  public void testToString() {
    assertEquals("♣", s1.toString());
  }

  @Test(expected = NullPointerException.class)
  public void testNull() {
    s2.toString();
  }
}