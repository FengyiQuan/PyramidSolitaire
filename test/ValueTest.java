import org.junit.Test;

import cs3500.pyramidsolitaire.model.hw02.Value;

import static org.junit.Assert.assertEquals;

/**
 * Test for Value.
 */
public class ValueTest {
  private Value v1 = Value.Ace;
  private Value v2 = null;
  private Value v3 = Value.Jack;

  @Test
  public void getValue() {
    assertEquals(1, v1.getValue());
    assertEquals(11, v3.getValue());
  }

  @Test
  public void testToString() {
    assertEquals("A", v1.toString());
    assertEquals("J", v3.toString());
  }

  @Test(expected = NullPointerException.class)
  public void testNull1() {
    v2.getValue();
  }

  @Test(expected = NullPointerException.class)
  public void testNull2() {
    v2.getValue();
  }
}