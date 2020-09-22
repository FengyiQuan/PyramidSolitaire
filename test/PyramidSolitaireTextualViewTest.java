import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PlayingCard;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.TriPeaks;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for PyramidSolitaireTextualView.
 */
public class PyramidSolitaireTextualViewTest {

  private BasicPyramidSolitaire basic1;
  private BasicPyramidSolitaire basic2;
  private BasicPyramidSolitaire basic3;
  private RelaxedPyramidSolitaire relaxed1;
  private TriPeaks tri1;
  private TriPeaks tri2;
  private PyramidSolitaireTextualView ns;
  private PyramidSolitaireTextualView test1;
  private PyramidSolitaireTextualView test2;
  private PyramidSolitaireTextualView webTest;

  @Before
  public void initData() {
    this.relaxed1 = new RelaxedPyramidSolitaire();
    relaxed1.startGame(relaxed1.getDeck(), false, 7, 3);
    this.tri1 = new TriPeaks();
    tri1.startGame(tri1.getDeck(), false, 7, 3);
    this.tri2 = new TriPeaks();
    tri2.startGame(tri2.getDeck(), false, 8, 3);
    ArrayList<PlayingCard> completeDeck = new ArrayList<>(Arrays.asList(
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
    BasicPyramidSolitaire notStart = new BasicPyramidSolitaire(1, 1,
            completeDeck, null, null, 10, false);
    ArrayList<PlayingCard> webDeck = new ArrayList<>(Arrays.asList(
            new PlayingCard(Value.Ace, Suit.Club),
            new PlayingCard(Value.Two, Suit.Club),
            new PlayingCard(Value.Three, Suit.Club),
            new PlayingCard(Value.Four, Suit.Club),
            new PlayingCard(Value.Five, Suit.Club),
            new PlayingCard(Value.Six, Suit.Club),
            new PlayingCard(Value.Seven, Suit.Club),
            new PlayingCard(Value.Eight, Suit.Club),
            new PlayingCard(Value.Ten, Suit.Spade),
            new PlayingCard(Value.Ten, Suit.Club),
            new PlayingCard(Value.Jack, Suit.Club),
            new PlayingCard(Value.Queen, Suit.Club),
            new PlayingCard(Value.King, Suit.Club),
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
            new PlayingCard(Value.Ace, Suit.Heart),
            new PlayingCard(Value.Two, Suit.Heart),
            new PlayingCard(Value.Ace, Suit.Spade),
            new PlayingCard(Value.Eight, Suit.Spade),
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
            new PlayingCard(Value.Two, Suit.Spade),
            new PlayingCard(Value.Three, Suit.Spade),
            new PlayingCard(Value.Four, Suit.Spade),
            new PlayingCard(Value.Five, Suit.Spade),
            new PlayingCard(Value.Six, Suit.Spade),
            new PlayingCard(Value.Seven, Suit.Spade),
            new PlayingCard(Value.Nine, Suit.Spade),
            new PlayingCard(Value.Nine, Suit.Club),
            new PlayingCard(Value.Jack, Suit.Spade),
            new PlayingCard(Value.Queen, Suit.Spade),
            new PlayingCard(Value.King, Suit.Spade)));
    basic1 = new BasicPyramidSolitaire();
    basic2 = new BasicPyramidSolitaire();
    basic3 = new BasicPyramidSolitaire();
    basic1.startGame(completeDeck, false, 7, 3);
    basic2.startGame(completeDeck, false, 1, 11);
    basic3.startGame(webDeck, false, 7, 1);
    ns = new PyramidSolitaireTextualView(notStart);
    test1 = new PyramidSolitaireTextualView(basic1);
    test2 = new PyramidSolitaireTextualView(basic2);
    webTest = new PyramidSolitaireTextualView(basic3);
  }

  @Test
  public void testToString1() {
    assertEquals(
            "            A♠\n"
            + "          2♠  3♠\n"
            + "        4♠  5♠  6♠\n"
            + "      7♠  8♠  9♠  10♠\n"
            + "    J♠  Q♠  K♠  A♥  2♥\n"
            + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
            + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
            + "Draw: 3♦, 4♦, 5♦", test1.toString());
    assertEquals("", ns.toString());
    basic1.remove(6, 3, 6, 5);
    basic1.remove(6, 2, 6, 6);
    basic1.remove(6, 4);
    basic1.removeUsingDraw(0, 6, 1);
    basic1.remove(6, 0, 5, 1);
    basic1.remove(5, 2, 5, 5);
    basic1.removeUsingDraw(0, 5, 4);
    basic1.removeUsingDraw(0, 5, 3);
    basic1.remove(4, 2);
    basic1.remove(4, 1, 4, 3);
    basic1.removeUsingDraw(1, 3, 2);
    basic1.removeUsingDraw(2, 3, 1);
    basic1.removeUsingDraw(2, 5, 0);
    basic1.remove(4, 0, 4, 4);
    basic1.removeUsingDraw(0, 2, 1);
    for (int i = 0; i < 15; i++) {
      basic1.discardDraw(0);
    }
    assertEquals("            A♠\n"
                 + "          2♠  3♠\n"
                 + "        4♠      6♠\n"
                 + "      7♠          10♠\n"
                 + "\n" + "\n" + "\n"
                 + "Draw: 9♦, J♦", test1.toString());
    basic1.discardDraw(1);
    basic1.discardDraw(2);
    assertTrue(basic1.isGameOver());
    assertEquals("Game over. Score: 33", test1.toString());

  }


  @Test
  public void testToString2() {
    basic2.removeUsingDraw(10, 0, 0);
    assertEquals("You win!", test2.toString());
  }

  @Test
  public void testOnWeb() {
    assertEquals("            A♣\n"
                 + "          2♣  3♣\n"
                 + "        4♣  5♣  6♣\n"
                 + "      7♣  8♣  10♠ 10♣\n"
                 + "    J♣  Q♣  K♣  A♦  2♦\n"
                 + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
                 + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
                 + "Draw: A♠", webTest.toString());
    basic3.remove(6, 2, 6, 6);
    basic3.removeUsingDraw(0, 6, 3);
    basic3.removeUsingDraw(0, 5, 2);
    basic3.discardDraw(0);
    basic3.discardDraw(0);
    assertEquals("            A♣\n"
                 + "          2♣  3♣\n"
                 + "        4♣  5♣  6♣\n"
                 + "      7♣  8♣  10♠ 10♣\n"
                 + "    J♣  Q♣  K♣  A♦  2♦\n"
                 + "  3♦  4♦      6♦  7♦  8♦\n"
                 + "9♦  10♦         K♦  A♥\n"
                 + "Draw: 5♥", webTest.toString());
    for (int i = 0; i < 20; i++) {
      basic3.discardDraw(0);
    }
    assertEquals("            A♣\n"
                 + "          2♣  3♣\n"
                 + "        4♣  5♣  6♣\n"
                 + "      7♣  8♣  10♠ 10♣\n"
                 + "    J♣  Q♣  K♣  A♦  2♦\n"
                 + "  3♦  4♦      6♦  7♦  8♦\n"
                 + "9♦  10♦         K♦  A♥\n"
                 + "Draw:", webTest.toString());
  }

  @Test
  public void testRelaxed() {
    assertEquals("            A♠\n"
                 + "          2♠  3♠\n"
                 + "        4♠  5♠  6♠\n"
                 + "      7♠  8♠  9♠  10♠\n"
                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                 + "Draw: 3♦, 4♦, 5♦", new PyramidSolitaireTextualView(relaxed1).toString());
  }

  @Test
  public void testTri1() {
    assertEquals("            A♠          A♠          2♠\n"
                 + "          2♠  3♠      3♠  4♠      4♠  5♠\n"
                 + "        5♠  6♠  6♠  7♠  7♠  8♠  8♠  9♠  9♠\n"
                 + "      10♠ 10♠ J♠  J♠  Q♠  Q♠  K♠  K♠  A♥  A♥\n"
                 + "    2♥  2♥  3♥  3♥  4♥  4♥  5♥  5♥  6♥  6♥  7♥\n"
                 + "  7♥  8♥  8♥  9♥  9♥  10♥ 10♥ J♥  J♥  Q♥  Q♥  K♥\n"
                 + "K♥  A♦  A♦  2♦  2♦  3♦  3♦  4♦  4♦  5♦  5♦  6♦  6♦\n"
                 + "Draw: 7♦, 7♦, 8♦", new PyramidSolitaireTextualView(tri1).toString());
  }

  @Test
  public void testTri2() {
    assertEquals("              A♠              A♠              2♠\n"
                 + "            2♠  3♠          3♠  4♠          4♠  5♠\n"
                 + "          5♠  6♠  6♠      7♠  7♠  8♠      8♠  9♠  9♠\n"
                 + "        10♠ 10♠ J♠  J♠  Q♠  Q♠  K♠  K♠  A♥  A♥  2♥  2♥\n"
                 + "      3♥  3♥  4♥  4♥  5♥  5♥  6♥  6♥  7♥  7♥  8♥  8♥  9♥\n"
                 + "    9♥  10♥ 10♥ J♥  J♥  Q♥  Q♥  K♥  K♥  A♦  A♦  2♦  2♦  3♦\n"
                 + "  3♦  4♦  4♦  5♦  5♦  6♦  6♦  7♦  7♦  8♦  8♦  9♦  9♦  10♦ 10♦\n"
                 + "J♦  J♦  Q♦  Q♦  K♦  K♦  A♣  A♣  2♣  2♣  3♣  3♣  4♣  4♣  5♣  5♣\n"
                 + "Draw: 6♣, 6♣, 7♣", new PyramidSolitaireTextualView(tri2).toString());
  }
}