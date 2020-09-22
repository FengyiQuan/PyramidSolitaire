import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import cs3500.pyramidsolitaire.model.hw02.PlayingCard;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class for RelaxedPyramidSolitaire.
 */
public class RelaxedPyramidSolitaireTest {
  private RelaxedPyramidSolitaire null1;
  private RelaxedPyramidSolitaire r1;
  private RelaxedPyramidSolitaire allUsed;
  private RelaxedPyramidSolitaire notStart;
  private ArrayList<PlayingCard> noChange;
  private ArrayList<PlayingCard> duplicateDeck;
  private ArrayList<PlayingCard> newDraw;
  private ArrayList<PlayingCard> deck1;

  @Before
  public void iniData() {
    ArrayList<PlayingCard> originDeck1 =
            new ArrayList<>(Arrays.asList(
                    new PlayingCard(Value.Ace, Suit.Spade),
                    new PlayingCard(Value.Two, Suit.Spade),
                    new PlayingCard(Value.Three, Suit.Spade),
                    new PlayingCard(Value.Four, Suit.Spade),
                    new PlayingCard(Value.Five, Suit.Spade),
                    new PlayingCard(Value.Six, Suit.Spade),
                    new PlayingCard(Value.Seven, Suit.Spade),
                    new PlayingCard(Value.Eight, Suit.Spade),
                    new PlayingCard(Value.Nine, Suit.Spade),
                    new PlayingCard(Value.Ten, Suit.Spade),
                    new PlayingCard(Value.Jack, Suit.Spade),
                    new PlayingCard(Value.Queen, Suit.Spade),
                    new PlayingCard(Value.King, Suit.Spade),
                    new PlayingCard(Value.Ace, Suit.Heart),
                    new PlayingCard(Value.Two, Suit.Heart),
                    new PlayingCard(Value.Three, Suit.Heart),
                    new PlayingCard(Value.Four, Suit.Heart),
                    new PlayingCard(Value.Five, Suit.Heart),
                    new PlayingCard(Value.Six, Suit.Heart),
                    new PlayingCard(Value.Seven, Suit.Heart),
                    new PlayingCard(Value.Eight, Suit.Heart),
                    new PlayingCard(Value.Nine, Suit.Heart),
                    new PlayingCard(Value.Ten, Suit.Heart),
                    new PlayingCard(Value.Jack, Suit.Heart),
                    new PlayingCard(Value.Queen, Suit.Heart),
                    new PlayingCard(Value.King, Suit.Heart),
                    new PlayingCard(Value.Ace, Suit.Diamond),
                    new PlayingCard(Value.Two, Suit.Diamond),
                    new PlayingCard(Value.Three, Suit.Diamond),
                    new PlayingCard(Value.Four, Suit.Diamond),
                    new PlayingCard(Value.Five, Suit.Diamond),
                    new PlayingCard(Value.Six, Suit.Diamond),
                    new PlayingCard(Value.Seven, Suit.Diamond),
                    new PlayingCard(Value.Eight, Suit.Diamond),
                    new PlayingCard(Value.Nine, Suit.Diamond),
                    new PlayingCard(Value.Ten, Suit.Diamond),
                    new PlayingCard(Value.Jack, Suit.Diamond),
                    new PlayingCard(Value.Queen, Suit.Diamond),
                    new PlayingCard(Value.King, Suit.Diamond),
                    new PlayingCard(Value.Ace, Suit.Club),
                    new PlayingCard(Value.Two, Suit.Club),
                    new PlayingCard(Value.Three, Suit.Club),
                    new PlayingCard(Value.Four, Suit.Club),
                    new PlayingCard(Value.Five, Suit.Club),
                    new PlayingCard(Value.Six, Suit.Club),
                    new PlayingCard(Value.Seven, Suit.Club),
                    new PlayingCard(Value.Eight, Suit.Club),
                    new PlayingCard(Value.Nine, Suit.Club),
                    new PlayingCard(Value.Ten, Suit.Club),
                    new PlayingCard(Value.Jack, Suit.Club),
                    new PlayingCard(Value.Queen, Suit.Club),
                    new PlayingCard(Value.King, Suit.Club)));
    this.duplicateDeck =
            new ArrayList<>(Arrays.asList(new PlayingCard(Value.Ace, Suit.Spade),
                    new PlayingCard(Value.Two, Suit.Spade),
                    new PlayingCard(Value.Three, Suit.Spade),
                    new PlayingCard(Value.Four, Suit.Spade),
                    new PlayingCard(Value.Five, Suit.Spade),
                    new PlayingCard(Value.Six, Suit.Spade),
                    new PlayingCard(Value.Seven, Suit.Spade),
                    new PlayingCard(Value.Eight, Suit.Spade),
                    new PlayingCard(Value.Nine, Suit.Spade),
                    new PlayingCard(Value.Ten, Suit.Spade),
                    new PlayingCard(Value.Jack, Suit.Spade),
                    new PlayingCard(Value.Queen, Suit.Spade),
                    new PlayingCard(Value.King, Suit.Spade),
                    new PlayingCard(Value.Ace, Suit.Heart),
                    new PlayingCard(Value.Ace, Suit.Spade),
                    new PlayingCard(Value.Three, Suit.Heart),
                    new PlayingCard(Value.Four, Suit.Heart),
                    new PlayingCard(Value.Five, Suit.Heart),
                    new PlayingCard(Value.Six, Suit.Heart),
                    new PlayingCard(Value.Seven, Suit.Heart),
                    new PlayingCard(Value.Eight, Suit.Heart),
                    new PlayingCard(Value.Nine, Suit.Heart),
                    new PlayingCard(Value.Ten, Suit.Heart),
                    new PlayingCard(Value.Jack, Suit.Heart),
                    new PlayingCard(Value.Queen, Suit.Heart),
                    new PlayingCard(Value.King, Suit.Heart),
                    new PlayingCard(Value.Ace, Suit.Diamond),
                    new PlayingCard(Value.Two, Suit.Diamond),
                    new PlayingCard(Value.Three, Suit.Diamond),
                    new PlayingCard(Value.Four, Suit.Diamond),
                    new PlayingCard(Value.Five, Suit.Diamond),
                    new PlayingCard(Value.Six, Suit.Diamond),
                    new PlayingCard(Value.Seven, Suit.Diamond),
                    new PlayingCard(Value.Eight, Suit.Diamond),
                    new PlayingCard(Value.Nine, Suit.Diamond),
                    new PlayingCard(Value.Ten, Suit.Diamond),
                    new PlayingCard(Value.Jack, Suit.Diamond),
                    new PlayingCard(Value.Queen, Suit.Diamond),
                    new PlayingCard(Value.King, Suit.Diamond),
                    new PlayingCard(Value.Ace, Suit.Club),
                    new PlayingCard(Value.Two, Suit.Club),
                    new PlayingCard(Value.Three, Suit.Club),
                    new PlayingCard(Value.Four, Suit.Club),
                    new PlayingCard(Value.Five, Suit.Club),
                    new PlayingCard(Value.Six, Suit.Club),
                    new PlayingCard(Value.Seven, Suit.Club),
                    new PlayingCard(Value.Eight, Suit.Club),
                    new PlayingCard(Value.Nine, Suit.Club),
                    new PlayingCard(Value.Ten, Suit.Club),
                    new PlayingCard(Value.Jack, Suit.Club),
                    new PlayingCard(Value.Queen, Suit.Club),
                    new PlayingCard(Value.King, Suit.Club)));
    this.noChange =
            new ArrayList<>(Arrays.asList(new PlayingCard(Value.Ace, Suit.Spade),
                    new PlayingCard(Value.Two, Suit.Spade),
                    new PlayingCard(Value.Three, Suit.Spade),
                    new PlayingCard(Value.Four, Suit.Spade),
                    new PlayingCard(Value.Five, Suit.Spade),
                    new PlayingCard(Value.Six, Suit.Spade),
                    new PlayingCard(Value.Seven, Suit.Spade),
                    new PlayingCard(Value.Eight, Suit.Spade),
                    new PlayingCard(Value.Nine, Suit.Spade),
                    new PlayingCard(Value.Ten, Suit.Spade),
                    new PlayingCard(Value.Jack, Suit.Spade),
                    new PlayingCard(Value.Queen, Suit.Spade),
                    new PlayingCard(Value.King, Suit.Spade),
                    new PlayingCard(Value.Ace, Suit.Heart),
                    new PlayingCard(Value.Two, Suit.Heart),
                    new PlayingCard(Value.Three, Suit.Heart),
                    new PlayingCard(Value.Four, Suit.Heart),
                    new PlayingCard(Value.Five, Suit.Heart),
                    new PlayingCard(Value.Six, Suit.Heart),
                    new PlayingCard(Value.Seven, Suit.Heart),
                    new PlayingCard(Value.Eight, Suit.Heart),
                    new PlayingCard(Value.Nine, Suit.Heart),
                    new PlayingCard(Value.Ten, Suit.Heart),
                    new PlayingCard(Value.Jack, Suit.Heart),
                    new PlayingCard(Value.Queen, Suit.Heart),
                    new PlayingCard(Value.King, Suit.Heart),
                    new PlayingCard(Value.Ace, Suit.Diamond),
                    new PlayingCard(Value.Two, Suit.Diamond),
                    new PlayingCard(Value.Three, Suit.Diamond),
                    new PlayingCard(Value.Four, Suit.Diamond),
                    new PlayingCard(Value.Five, Suit.Diamond),
                    new PlayingCard(Value.Six, Suit.Diamond),
                    new PlayingCard(Value.Seven, Suit.Diamond),
                    new PlayingCard(Value.Eight, Suit.Diamond),
                    new PlayingCard(Value.Nine, Suit.Diamond),
                    new PlayingCard(Value.Ten, Suit.Diamond),
                    new PlayingCard(Value.Jack, Suit.Diamond),
                    new PlayingCard(Value.Queen, Suit.Diamond),
                    new PlayingCard(Value.King, Suit.Diamond),
                    new PlayingCard(Value.Ace, Suit.Club),
                    new PlayingCard(Value.Two, Suit.Club),
                    new PlayingCard(Value.Three, Suit.Club),
                    new PlayingCard(Value.Four, Suit.Club),
                    new PlayingCard(Value.Five, Suit.Club),
                    new PlayingCard(Value.Six, Suit.Club),
                    new PlayingCard(Value.Seven, Suit.Club),
                    new PlayingCard(Value.Eight, Suit.Club),
                    new PlayingCard(Value.Nine, Suit.Club),
                    new PlayingCard(Value.Ten, Suit.Club),
                    new PlayingCard(Value.Jack, Suit.Club),
                    new PlayingCard(Value.Queen, Suit.Club),
                    new PlayingCard(Value.King, Suit.Club)));
    this.deck1 =
            new ArrayList<>(Arrays.asList(new PlayingCard(Value.Ace, Suit.Spade),
                    new PlayingCard(Value.Two, Suit.Spade),
                    new PlayingCard(Value.Three, Suit.Spade),
                    new PlayingCard(Value.Four, Suit.Spade),
                    new PlayingCard(Value.Five, Suit.Spade),
                    new PlayingCard(Value.Six, Suit.Spade),
                    new PlayingCard(Value.Seven, Suit.Spade),
                    new PlayingCard(Value.Eight, Suit.Spade),
                    new PlayingCard(Value.Nine, Suit.Spade),
                    new PlayingCard(Value.Ten, Suit.Spade),
                    new PlayingCard(Value.Jack, Suit.Spade),
                    new PlayingCard(Value.Queen, Suit.Spade),
                    new PlayingCard(Value.King, Suit.Spade),
                    new PlayingCard(Value.Ace, Suit.Heart),
                    new PlayingCard(Value.Two, Suit.Heart),
                    new PlayingCard(Value.Three, Suit.Heart),
                    new PlayingCard(Value.Four, Suit.Heart),
                    new PlayingCard(Value.Ace, Suit.Diamond),
                    new PlayingCard(Value.Six, Suit.Heart),
                    new PlayingCard(Value.Seven, Suit.Heart),
                    new PlayingCard(Value.Eight, Suit.Heart),
                    new PlayingCard(Value.Nine, Suit.Heart),
                    new PlayingCard(Value.Ten, Suit.Heart),
                    new PlayingCard(Value.Jack, Suit.Heart),
                    new PlayingCard(Value.Queen, Suit.Heart),
                    new PlayingCard(Value.King, Suit.Heart),
                    new PlayingCard(Value.Five, Suit.Heart),
                    new PlayingCard(Value.Two, Suit.Diamond),
                    new PlayingCard(Value.Three, Suit.Diamond),
                    new PlayingCard(Value.Four, Suit.Diamond),
                    new PlayingCard(Value.Five, Suit.Diamond),
                    new PlayingCard(Value.Six, Suit.Diamond),
                    new PlayingCard(Value.Seven, Suit.Diamond),
                    new PlayingCard(Value.Eight, Suit.Diamond),
                    new PlayingCard(Value.Nine, Suit.Diamond),
                    new PlayingCard(Value.Ten, Suit.Diamond),
                    new PlayingCard(Value.Jack, Suit.Diamond),
                    new PlayingCard(Value.Queen, Suit.Diamond),
                    new PlayingCard(Value.King, Suit.Diamond),
                    new PlayingCard(Value.Ace, Suit.Club),
                    new PlayingCard(Value.Two, Suit.Club),
                    new PlayingCard(Value.Three, Suit.Club),
                    new PlayingCard(Value.Four, Suit.Club),
                    new PlayingCard(Value.Five, Suit.Club),
                    new PlayingCard(Value.Six, Suit.Club),
                    new PlayingCard(Value.Seven, Suit.Club),
                    new PlayingCard(Value.Eight, Suit.Club),
                    new PlayingCard(Value.Nine, Suit.Club),
                    new PlayingCard(Value.Ten, Suit.Club),
                    new PlayingCard(Value.Jack, Suit.Club),
                    new PlayingCard(Value.Queen, Suit.Club),
                    new PlayingCard(Value.King, Suit.Club)));
    this.newDraw = new ArrayList<>(Arrays.asList(
            new PlayingCard(Value.Six, Suit.Diamond), new PlayingCard(Value.Four, Suit.Diamond),
            new PlayingCard(Value.Five, Suit.Diamond)));
    this.null1 = null;
    this.r1 = new RelaxedPyramidSolitaire();
    this.r1.startGame(deck1, false, 7, 3);
    this.allUsed = new RelaxedPyramidSolitaire();
    this.allUsed.startGame(originDeck1, false, 9, 7);
    this.notStart = new RelaxedPyramidSolitaire(1, 1, null, this.newDraw, null, 0, false);
  }


  @Test
  public void testGetDeck() {
    assertArrayEquals(noChange.toArray(), r1.getDeck().toArray());
    assertArrayEquals(noChange.toArray(), allUsed.getDeck().toArray());
  }

  @Test(expected = NullPointerException.class)
  public void testGetDeckNull() {
    null1.getDeck();
  }

  @Test
  public void testStartGame() {
    assertEquals(3, r1.getNumDraw());
    assertEquals(7, r1.getNumRows());
    assertEquals(185, r1.getScore());
    assertEquals(2, r1.getRowWidth(1));
  }

  @Test(expected = NullPointerException.class)
  public void testStartGameENull() {
    null1.startGame(null, false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException1() {
    r1.startGame(null, false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException2() {
    r1.startGame(duplicateDeck, false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException3() {
    r1.startGame(r1.getDeck().subList(0, 5), false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException4() {
    r1.startGame(r1.getDeck(), false, 7, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException5() {
    r1.startGame(r1.getDeck(), false, -1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException6() {
    r1.startGame(r1.getDeck(), false, 5, -100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException7() {
    r1.startGame(r1.getDeck(), false, 100, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException1() {
    r1.remove(7, 7, 8, 8);
  }

  @Test(expected = IllegalStateException.class)
  public void testRemoveException2() {
    notStart.remove(7, 7, 8, 8);
  }

  @Test(expected = NullPointerException.class)
  public void testRemoveException3() {
    null1.remove(7, 7, 8, 8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException4() {
    r1.remove(6, 1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException5() {
    r1.remove(6, 1, 6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException6() {
    r1.remove(6, 1);
  }

  @Test(expected = NullPointerException.class)
  public void testRemoveException7() {
    null1.remove(6, 1);
  }

  @Test(expected = IllegalStateException.class)
  public void testRemoveException8() {
    notStart.remove(6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException9() {
    r1.remove(4, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException10() {
    r1.remove(9, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException11() {
    r1.remove(6, 2, 6, 6);
    r1.remove(5, 5, 6, 5);
    r1.remove(6, 4);
    r1.remove(6, 3, 5, 2);
    r1.removeUsingDraw(0, 6, 1);
    r1.remove(6, 0, 5, 1);
    r1.remove(5, 4, 5, 3);
    r1.remove(4, 2);
    r1.remove(4, 1, 4, 3);
    r1.remove(5, 0, 3, 3);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException1() {
    r1.removeUsingDraw(10, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException2() {
    r1.removeUsingDraw(10, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException3() {
    r1.removeUsingDraw(0, 8, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException4() {
    r1.removeUsingDraw(0, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException5() {
    r1.removeUsingDraw(0, 6, 2);
  }

  @Test(expected = IllegalStateException.class)
  public void testRemoveUsingDrawException6() {
    notStart.removeUsingDraw(0, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawException1() {
    r1.discardDraw(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawException2() {
    r1.discardDraw(-1);
  }

  @Test(expected = IllegalStateException.class)
  public void testDiscardDrawException3() {
    notStart.discardDraw(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawException4() {
    for (int i = 0; i < 25; i++) {
      r1.discardDraw(0);
    }
  }

  @Test(expected = IllegalStateException.class)
  public void testGetRowWidthException1() {
    notStart.getRowWidth(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthException2() {
    r1.getRowWidth(7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthException3() {
    r1.getRowWidth(-1);
  }

  @Test(expected = IllegalStateException.class)
  public void testIsGameOverException() {
    notStart.isGameOver();
  }

  @Test(expected = IllegalStateException.class)
  public void testGetScore() {
    notStart.getScore();
  }

  @Test(expected = IllegalStateException.class)
  public void testGetCardAtException1() {
    notStart.getCardAt(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException2() {
    r1.getCardAt(10, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException3() {
    r1.getCardAt(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException4() {
    r1.getCardAt(1, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException5() {
    r1.getCardAt(1, -10);
  }

  @Test(expected = IllegalStateException.class)
  public void testGetDrawCardsException() {
    notStart.getDrawCards();
  }

  @Test
  public void remove1() {
    r1.remove(6, 2, 6, 6);
    assertNull(r1.getCardAt(6, 2));
    assertNull(r1.getCardAt(6, 6));
    r1.remove(6, 5, 5, 5);
    assertNull(r1.getCardAt(6, 5));
    assertNull(r1.getCardAt(5, 5));
  }

  @Test
  public void remove2() {
    r1.remove(6, 2, 6, 6);
    assertNull(r1.getCardAt(6, 2));
    assertNull(r1.getCardAt(6, 6));
    r1.remove(5, 5, 6, 5);
    assertNull(r1.getCardAt(6, 5));
    assertNull(r1.getCardAt(5, 5));
  }

  @Test
  public void removeUsingDraw() {
    r1.removeUsingDraw(0, 6, 1);
    assertNull(r1.getCardAt(6, 1));
    assertEquals(newDraw, r1.getDrawCards());
  }

  @Test
  public void testDiscardDraw() {
    r1.discardDraw(0);
    assertEquals(newDraw, r1.getDrawCards());
  }


  @Test
  public void testGetNumRows() {
    assertEquals(7, r1.getNumRows());
    assertEquals(-1, notStart.getNumRows());
  }

  @Test
  public void testGetNumDraw() {
    assertEquals(52, deck1.size());
    assertEquals(3, r1.getNumDraw());
    assertEquals(-1, notStart.getNumDraw());
  }

  @Test
  public void testGetRowWidth() {
    assertEquals(1, r1.getRowWidth(0));
    assertEquals(7, r1.getRowWidth(6));
  }

  @Test
  public void isGameOver() {
    assertFalse(r1.isGameOver());
    r1.remove(6, 2, 6, 6);
    r1.remove(5, 5, 6, 5);
    r1.remove(6, 4);
    r1.remove(6, 3, 5, 2);
    assertFalse(r1.isGameOver());
    r1.removeUsingDraw(0, 6, 1);
    r1.remove(6, 0, 5, 1);
    r1.remove(5, 4, 5, 3);
    r1.remove(4, 1, 4, 3);
    r1.remove(4, 2);
    r1.removeUsingDraw(1, 3, 2);
    r1.remove(3, 1, 2, 1);
    assertFalse(r1.isGameOver());
    for (int i = 0; i < 20; i++) {
      r1.discardDraw(0);
    }
    assertFalse(r1.isGameOver());
    r1.discardDraw(1);
    r1.discardDraw(2);
    assertTrue(r1.isGameOver());
  }

  @Test
  public void getScore() {
    assertEquals(185, r1.getScore());
    r1.remove(6, 2, 6, 6);
    assertEquals(172, r1.getScore());
    r1.discardDraw(0);
    assertEquals(172, r1.getScore());
    r1.removeUsingDraw(1, 6, 0);
    assertEquals(163, r1.getScore());
  }

  @Test
  public void getCardAt() {
    assertEquals(new PlayingCard(Value.Ace, Suit.Spade), r1.getCardAt(0, 0));
  }

  @Test
  public void getDrawCards() {
    assertEquals(new ArrayList<>(Arrays.asList(
            new PlayingCard(Value.Three, Suit.Diamond), new PlayingCard(Value.Four, Suit.Diamond),
            new PlayingCard(Value.Five, Suit.Diamond))), r1.getDrawCards());
    r1.discardDraw(0);
    assertEquals(newDraw, r1.getDrawCards());
  }
}