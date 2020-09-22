import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PlayingCard;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * Test for BasicPyramidSolitaire.
 */
public class BasicPyramidSolitaireTest {
  private BasicPyramidSolitaire null1;
  private BasicPyramidSolitaire b1;
  private BasicPyramidSolitaire notStart;
  private BasicPyramidSolitaire allUsed;
  private ArrayList<PlayingCard> completeDeck;
  private ArrayList<PlayingCard> duplicateDeck;
  private ArrayList<PlayingCard> newDraw;
  private ArrayList<PlayingCard> originDeck;
  private ArrayList<PlayingCard> originDeck2;
  private ArrayList<PlayingCard> afterShuffle;

  @Before
  public void iniData() {
    this.originDeck =
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
    this.originDeck2 =
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
    this.afterShuffle =
            new ArrayList<>(Arrays.asList(new PlayingCard(Value.Nine, Suit.Club),
                    new PlayingCard(Value.Queen, Suit.Heart),
                    new PlayingCard(Value.King, Suit.Heart),
                    new PlayingCard(Value.Jack, Suit.Diamond),
                    new PlayingCard(Value.Three, Suit.Heart),
                    new PlayingCard(Value.Five, Suit.Club),
                    new PlayingCard(Value.King, Suit.Club),
                    new PlayingCard(Value.Ten, Suit.Spade),
                    new PlayingCard(Value.Jack, Suit.Heart),
                    new PlayingCard(Value.Six, Suit.Spade),
                    new PlayingCard(Value.Nine, Suit.Diamond),
                    new PlayingCard(Value.Six, Suit.Heart),
                    new PlayingCard(Value.Ten, Suit.Club),
                    new PlayingCard(Value.Jack, Suit.Spade),
                    new PlayingCard(Value.Six, Suit.Diamond),
                    new PlayingCard(Value.Five, Suit.Diamond),
                    new PlayingCard(Value.Ace, Suit.Club),
                    new PlayingCard(Value.Three, Suit.Club),
                    new PlayingCard(Value.Four, Suit.Club),
                    new PlayingCard(Value.Eight, Suit.Heart),
                    new PlayingCard(Value.Queen, Suit.Diamond),
                    new PlayingCard(Value.Eight, Suit.Club),
                    new PlayingCard(Value.Two, Suit.Spade),
                    new PlayingCard(Value.King, Suit.Spade),
                    new PlayingCard(Value.Eight, Suit.Spade),
                    new PlayingCard(Value.Ace, Suit.Heart),
                    new PlayingCard(Value.King, Suit.Diamond),
                    new PlayingCard(Value.Two, Suit.Club),
                    new PlayingCard(Value.Seven, Suit.Heart),
                    new PlayingCard(Value.Two, Suit.Heart),
                    new PlayingCard(Value.Seven, Suit.Spade),
                    new PlayingCard(Value.Nine, Suit.Spade),
                    new PlayingCard(Value.Seven, Suit.Diamond),
                    new PlayingCard(Value.Four, Suit.Spade),
                    new PlayingCard(Value.Ace, Suit.Spade),
                    new PlayingCard(Value.Five, Suit.Spade),
                    new PlayingCard(Value.Two, Suit.Diamond),
                    new PlayingCard(Value.Five, Suit.Heart),
                    new PlayingCard(Value.Queen, Suit.Club),
                    new PlayingCard(Value.Eight, Suit.Diamond),
                    new PlayingCard(Value.Four, Suit.Heart),
                    new PlayingCard(Value.Jack, Suit.Club),
                    new PlayingCard(Value.Ace, Suit.Diamond),
                    new PlayingCard(Value.Seven, Suit.Club),
                    new PlayingCard(Value.Nine, Suit.Heart),
                    new PlayingCard(Value.Ten, Suit.Diamond),
                    new PlayingCard(Value.Ten, Suit.Heart),
                    new PlayingCard(Value.Queen, Suit.Spade),
                    new PlayingCard(Value.Three, Suit.Spade),
                    new PlayingCard(Value.Four, Suit.Diamond),
                    new PlayingCard(Value.Three, Suit.Diamond),
                    new PlayingCard(Value.Six, Suit.Club)));
    this.completeDeck =
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

    this.null1 = null;
    this.b1 = new BasicPyramidSolitaire();
    this.b1.startGame(completeDeck, false, 7, 3);
    this.newDraw = new ArrayList<>(Arrays.asList(
            new PlayingCard(Value.Six, Suit.Diamond), new PlayingCard(Value.Four, Suit.Diamond),
            new PlayingCard(Value.Five, Suit.Diamond)));
    this.notStart = new BasicPyramidSolitaire(1, 1, null, this.newDraw, null, 0, false);
    this.allUsed = new BasicPyramidSolitaire();
    this.allUsed.startGame(originDeck1, false, 9, 7);
  }


  @Test
  public void testGetDeck() {
    assertArrayEquals(originDeck.toArray(), b1.getDeck().toArray());
    assertArrayEquals(originDeck.toArray(), allUsed.getDeck().toArray());
  }

  @Test(expected = NullPointerException.class)
  public void testGetDeckNull() {
    null1.getDeck();
  }

  @Test
  public void testStartGame() {
    assertEquals(3, b1.getNumDraw());
    assertEquals(7, b1.getNumRows());
    assertEquals(185, b1.getScore());
    assertEquals(2, b1.getRowWidth(1));
  }

  @Test
  public void testRandom() {
    assertArrayEquals(originDeck2.toArray(), originDeck2.toArray());
    Collections.shuffle(originDeck2, new Random(0));
    assertArrayEquals(afterShuffle.toArray(), originDeck2.toArray());
  }

  @Test(expected = NullPointerException.class)
  public void testStartGameENull() {
    null1.startGame(null, false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException1() {
    b1.startGame(null, false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException2() {
    b1.startGame(duplicateDeck, false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException3() {
    b1.startGame(b1.getDeck().subList(0, 5), false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException4() {
    b1.startGame(b1.getDeck(), false, 7, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException5() {
    b1.startGame(b1.getDeck(), false, -1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException6() {
    b1.startGame(b1.getDeck(), false, 5, -100);
  }

  @Test
  public void testRemove() {
    b1.remove(6, 3, 6, 5);
    assertNull(b1.getCardAt(6, 3));
    assertNull(b1.getCardAt(6, 5));
    assertEquals(new PlayingCard(Value.King, Suit.Heart, true, 6, 4),
            b1.getCardAt(6, 4));
    b1.remove(6, 4);
    assertNull(b1.getCardAt(6, 3));
    assertNull(b1.getCardAt(6, 4));
    assertNull(b1.getCardAt(6, 5));
    assertEquals(new PlayingCard(Value.Six, Suit.Heart, true, 5, 3), b1.getCardAt(5, 3));
    assertEquals(new PlayingCard(Value.Seven, Suit.Heart, true, 5, 4), b1.getCardAt(5, 4));
    b1.removeUsingDraw(1, 6, 0);
    b1.removeUsingDraw(0, 6, 1);
    assertNull(b1.getCardAt(6, 0));
    assertNull(b1.getCardAt(6, 1));
    assertEquals(new PlayingCard(Value.Three, Suit.Heart, true, 5, 0), b1.getCardAt(5, 0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException1() {
    b1.remove(7, 7, 8, 8);
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
    b1.remove(6, 1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException5() {
    b1.remove(6, 1, 6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException6() {
    b1.remove(6, 1);
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
    b1.remove(4, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException10() {
    b1.remove(9, 1);
  }


  @Test
  public void removeUsingDraw() {
    b1.removeUsingDraw(0, 6, 1);
    assertNull(b1.getCardAt(6, 1));
    assertEquals(newDraw, b1.getDrawCards());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException1() {
    b1.removeUsingDraw(10, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException2() {
    b1.removeUsingDraw(10, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException3() {
    b1.removeUsingDraw(0, 8, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException4() {
    b1.removeUsingDraw(0, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException5() {
    b1.removeUsingDraw(0, 6, 2);
  }

  @Test(expected = IllegalStateException.class)
  public void testRemoveUsingDrawException6() {
    notStart.removeUsingDraw(0, 6, 1);
  }

  @Test
  public void testDiscardDraw() {
    b1.discardDraw(0);
    assertEquals(newDraw, b1.getDrawCards());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawException1() {
    b1.discardDraw(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawException2() {
    b1.discardDraw(-1);
  }

  @Test(expected = IllegalStateException.class)
  public void testDiscardDrawException3() {
    notStart.discardDraw(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawException4() {
    for (int i = 0; i < 25; i++) {
      b1.discardDraw(0);
    }
  }

  @Test
  public void testGetNumRows() {
    assertEquals(7, b1.getNumRows());
    assertEquals(-1, notStart.getNumRows());
  }

  @Test
  public void testGetNumDraw() {
    assertEquals(52, completeDeck.size());
    assertEquals(3, b1.getNumDraw());
    assertEquals(-1, notStart.getNumDraw());
  }

  @Test
  public void testGetRowWidth() {
    assertEquals(1, b1.getRowWidth(0));
    assertEquals(7, b1.getRowWidth(6));
  }

  @Test(expected = IllegalStateException.class)
  public void testGetRowWidthException1() {
    notStart.getRowWidth(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthException2() {
    b1.getRowWidth(7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthException3() {
    b1.getRowWidth(-1);
  }

  @Test
  public void isGameOver() {
    assertFalse(b1.isGameOver());
    b1.remove(6, 3, 6, 5);
    b1.remove(6, 2, 6, 6);
    b1.remove(6, 4);
    assertFalse(b1.isGameOver());
    b1.removeUsingDraw(0, 6, 1);
    b1.remove(6, 0, 5, 1);
    b1.remove(5, 2, 5, 5);
    b1.removeUsingDraw(0, 5, 4);
    b1.removeUsingDraw(0, 5, 3);
    assertFalse(b1.isGameOver());
    b1.remove(4, 2);
    b1.remove(4, 1, 4, 3);
    b1.removeUsingDraw(1, 3, 2);
    b1.removeUsingDraw(2, 3, 1);
    b1.removeUsingDraw(2, 5, 0);
    b1.remove(4, 0, 4, 4);
    b1.removeUsingDraw(0, 2, 1);
    assertFalse(b1.isGameOver());
    for (int i = 0; i < 15; i++) {
      b1.discardDraw(0);
    }
    b1.discardDraw(1);
    b1.discardDraw(2);
    assertTrue(b1.isGameOver());
    assertEquals(33, b1.getScore());
  }

  @Test(expected = IllegalStateException.class)
  public void testIsGameOverException() {
    notStart.isGameOver();
  }

  @Test
  public void getScore() {
    assertEquals(185, b1.getScore());
    b1.remove(6, 3, 6, 5);
    assertEquals(172, b1.getScore());
    b1.discardDraw(0);
    assertEquals(172, b1.getScore());
    b1.removeUsingDraw(1, 6, 0);
    assertEquals(163, b1.getScore());
  }

  @Test(expected = IllegalStateException.class)
  public void testGetScore() {
    notStart.getScore();
  }

  @Test
  public void getCardAt() {
    assertEquals(new PlayingCard(Value.Ace, Suit.Spade), b1.getCardAt(0, 0));
  }

  @Test(expected = IllegalStateException.class)
  public void testGetCardAtException1() {
    notStart.getCardAt(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException2() {
    b1.getCardAt(10, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException3() {
    b1.getCardAt(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException4() {
    b1.getCardAt(1, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException5() {
    b1.getCardAt(1, -10);
  }

  @Test
  public void getDrawCards() {
    assertEquals(new ArrayList<>(Arrays.asList(
            new PlayingCard(Value.Three, Suit.Diamond), new PlayingCard(Value.Four, Suit.Diamond),
            new PlayingCard(Value.Five, Suit.Diamond))), b1.getDrawCards());
    b1.discardDraw(0);
    assertEquals(newDraw, b1.getDrawCards());
  }

  @Test(expected = IllegalStateException.class)
  public void testGetDrawCardsException() {
    notStart.getDrawCards();
  }
}