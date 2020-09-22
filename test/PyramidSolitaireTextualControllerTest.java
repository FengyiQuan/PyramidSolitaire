import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PlayingCard;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;

import static org.junit.Assert.assertEquals;

/**
 * Test for PyramidSolitaireTextualController.
 */
public class PyramidSolitaireTextualControllerTest {
  private ArrayList<PlayingCard> originDeck;
  private PyramidSolitaireModel<PlayingCard> m = new BasicPyramidSolitaire();

  private Interaction[] interactions1;
  private Interaction[] interactions2;
  private Interaction[] interactions3;
  private Interaction[] interactions4;
  private Interaction[] interactions5;
  private Interaction[] interactions6;
  private Interaction[] interactions7;
  private Interaction[] interactions8;
  private Interaction[] interactions9;
  private Interaction[] interactions10;
  private Interaction[] interactions11;


  /**
   * Test.
   *
   * @param model        PyramidSolitaireModel that to use
   * @param interactions the pair of input and output
   * @param <K>          card
   */
  private <K> void testRun(PyramidSolitaireModel<K> model, Interaction... interactions) {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireController controller =
            new PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, model.getDeck(), false, 7, 3);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Before
  public void initData() {
    String startState = "            A♠\n"
                        + "          2♠  3♠\n"
                        + "        4♠  5♠  6♠\n"
                        + "      7♠  8♠  9♠  10♠\n"
                        + "    J♠  Q♠  K♠  A♥  2♥\n"
                        + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                        + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                        + "Draw: 3♦, 4♦, 5♦\n"
                        + "Score: 185";
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

    this.interactions1 = new Interaction[]{
      new PrintInteraction(startState),
      new InputInteraction("rm1 7 5\n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥      A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 172"),
      new InputInteraction("q\n"),
      new PrintInteraction("Game quit!\n"
                                 + "State of game when quit:\n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥      A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 172"),};
    this.interactions2 = new Interaction[]{
      new PrintInteraction(startState),
      new InputInteraction("Q"),
      new PrintInteraction("Game quit!\n"
                                 + "State of game when quit:" + "\n"
                                 + startState),};
    this.interactions3 = new Interaction[]{
      new PrintInteraction(startState),
      new InputInteraction("rm2 7 4 7 6\nq"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥      K♥      2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 172\n"
                                 + "Game quit!\n"
                                 + "State of game when quit:\n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥      K♥      2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 172"),};
    this.interactions4 = new Interaction[]{
      new PrintInteraction(startState),
      new InputInteraction("dd 1 q"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                                 + "Draw: 6♦, 4♦, 5♦\n"
                                 + "Score: 185\n"
                                 + "Game quit!\n"
                                 + "State of game when quit:\n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                                 + "Draw: 6♦, 4♦, 5♦\n"
                                 + "Score: 185"),};

    this.interactions5 = new Interaction[]{
      new PrintInteraction(startState),
      new InputInteraction("rm1 7 5 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥      A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 172"),
      new InputInteraction("rm2 7 4 7 6 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥              2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 159"),
      new InputInteraction("rm2 7 3 7 7      \n\n\n "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 146"),
      new InputInteraction("rmwd asdlfj \n\n          1 7 2 \n\n  "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥\n"
                                 + "Draw: 6♦, 4♦, 5♦\n"
                                 + "Score: 136"),
      new InputInteraction("    \n rmwd asdfj\n 2 7 1 aasf 34 5"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "\n"
                                 + "Draw: 6♦, 7♦, 5♦\n"
                                 + "Score: 127"),
      new InputInteraction("\n\n\n"),
      new InputInteraction("rm2 asdfjkaewoi \n asef \n"),
      new InputInteraction("6 asdf 3 asf\n 6 6"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥      6♥  7♥\n"
                                 + "\n"
                                 + "Draw: 6♦, 7♦, 5♦\n"
                                 + "Score: 114"),
      new InputInteraction("   powef we rm asdf rm2\n"),
      new InputInteraction("6 4 fpdogjaopdrjg     6 5\n\n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥\n"
                                 + "\n"
                                 + "Draw: 6♦, 7♦, 5♦\n"
                                 + "Score: 101"),
      new InputInteraction("rm1 \n asfjo 5 3 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠      A♥  2♥\n"
                                 + "  3♥  4♥\n"
                                 + "\n"
                                 + "Draw: 6♦, 7♦, 5♦\n"
                                 + "Score: 88"),
      new InputInteraction("dd 1\n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠      A♥  2♥\n"
                                 + "  3♥  4♥\n"
                                 + "\n"
                                 + "Draw: 8♦, 7♦, 5♦\n"
                                 + "Score: 88"),
      new InputInteraction("dd 1 \n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠      A♥  2♥\n"
                                 + "  3♥  4♥\n"
                                 + "\n"
                                 + "Draw: 9♦, 7♦, 5♦\n"
                                 + "Score: 88"),
      new InputInteraction("rmwd poij rmwd dd dd\n rm 1 rm2 \n\nfg 6 2 \n\n\n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠      A♥  2♥\n"
                                 + "  3♥\n"
                                 + "\n"
                                 + "Draw: 10♦, 7♦, 5♦\n"
                                 + "Score: 84"),
      new InputInteraction("rmwd 1 dd dd \n6 dd rm 1 \n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠      A♥  2♥\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: J♦, 7♦, 5♦\n"
                                 + "Score: 81"),
      new InputInteraction("rm2 5 2 5 4 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠              2♥\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: J♦, 7♦, 5♦\n"
                                 + "Score: 68"),
      new InputInteraction("\n\n\n       rm2     5   1   5     5 \n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: J♦, 7♦, 5♦\n"
                                 + "Score: 55"),
      new InputInteraction("rmwd 3 4 2 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: J♦, 7♦, Q♦\n"
                                 + "Score: 47"),
      new InputInteraction("dd 1 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: K♦, 7♦, Q♦\n"
                                 + "Score: 47"),
      new InputInteraction("dd 1  "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: A♣, 7♦, Q♦\n"
                                 + "Score: 47"),
      new InputInteraction("dd 1d\n1 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 2♣, 7♦, Q♦\n"
                                 + "Score: 47"),
      new InputInteraction("dd 1"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 3♣, 7♦, Q♦\n"
                                 + "Score: 47"),
      new InputInteraction(" rmwd 1 4 4 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 4♣, 7♦, Q♦\n"
                                 + "Score: 37"),
      new InputInteraction("rmwd 1 4 3 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 5♣, 7♦, Q♦\n"
                                 + "Score: 28"),
      new InputInteraction("rm2 4 1 3 3 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 5♣, 7♦, Q♦\n"
                                 + "Score: 15"),
      new InputInteraction("dd 1 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 6♣, 7♦, Q♦\n"
                                 + "Score: 15"),
      new InputInteraction("dd 1"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 7♣, 7♦, Q♦\n"
                                 + "Score: 15"),
      new InputInteraction("\n\n dd 1 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 8♣, 7♦, Q♦\n"
                                 + "Score: 15"),
      new InputInteraction("rmwd 1 3 2 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 9♣, 7♦, Q♦\n"
                                 + "Score: 10"),
      new InputInteraction("rmwd 1 3 1 \n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 10♣, 7♦, Q♦\n"
                                 + "Score: 6"),
      new InputInteraction("rmwd 1 2  2  "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: J♣, 7♦, Q♦\n"
                                 + "Score: 3"),
      new InputInteraction("rmwd 1 2 1 "),
      new PrintInteraction("            A♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: Q♣, 7♦, Q♦\n"
                                 + "Score: 1"),
      new InputInteraction("rmwd 1 1 1 "),
      new PrintInteraction("You win!")
    };
    this.interactions6 = new Interaction[]{
      new PrintInteraction(startState),
      new InputInteraction("asdf ")
    };
    this.interactions7 = new Interaction[]{
      new PrintInteraction(startState),
      new InputInteraction("rm1 1 100\nrm2 -1 1\n 4 4 dd 0 rmwd *&^%$ 999 3 3 Q"),
      new PrintInteraction("Invalid move. Play again. The coordinates are invalid. \n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 185\n"
                                 + "Invalid move. Play again. The coordinates are invalid. \n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 185\n"
                                 + "Invalid move. Play again. The index is invalid. \n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 185\n"
                                 + "Invalid move. Play again. Draw index is invalid. \n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 185\n"
                                 + "Game quit!\n"
                                 + "State of game when quit:\n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 185"),};
    this.interactions8 = new Interaction[]{
      new PrintInteraction(startState),
      new InputInteraction("dd 100 q"),
      new PrintInteraction("Invalid move. Play again. The index is invalid. \n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 185\n"
                                 + "Game quit!\n"
                                 + "State of game when quit:\n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 185")};
    this.interactions9 = new Interaction[]{
      new PrintInteraction(startState),
      new InputInteraction("q"),
      new PrintInteraction("Game quit!\n"
                                 + "State of game when quit:\n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 185")};
    this.interactions10 = new Interaction[]{
      new PrintInteraction(startState),
      new InputInteraction("rm1 q"),
      new PrintInteraction("Game quit!\n"
                                 + "State of game when quit:\n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥  K♥  A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 185")};
    this.interactions11 = new Interaction[]{
      new PrintInteraction(startState),
      new InputInteraction("rm1 7 5 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥      A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 172"),
      new InputInteraction("rm2 10 1239 123409 adsjf 3 \n "),
      new PrintInteraction("Invalid move. Play again. The coordinates are invalid. \n"
                                 + "            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥  Q♥      A♦  2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 172"),
      new InputInteraction("rm2 7 4 7 6 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥ J♥              2♦\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 159"),
      new InputInteraction("rm2 7 3 7 7      \n\n\n "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥  10♥\n"
                                 + "Draw: 3♦, 4♦, 5♦\n"
                                 + "Score: 146"),
      new InputInteraction("rmwd asdlfj \n\n          1 7 2 \n\n  "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "9♥\n"
                                 + "Draw: 6♦, 4♦, 5♦\n"
                                 + "Score: 136"),
      new InputInteraction("    \n rmwd asdfj\n 2 7 1 aasf 34 5"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
                                 + "\n"
                                 + "Draw: 6♦, 7♦, 5♦\n"
                                 + "Score: 127"),
      new InputInteraction("\n\n\n"),
      new InputInteraction("rm2 asdfjkaewoi \n asef \n"),
      new InputInteraction("6 asdf 3 asf\n 6 6"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥      6♥  7♥\n"
                                 + "\n"
                                 + "Draw: 6♦, 7♦, 5♦\n"
                                 + "Score: 114"),
      new InputInteraction("   powef we rm asdf rm2\n"),
      new InputInteraction("6 4 fpdogjaopdrjg     6 5\n\n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠  K♠  A♥  2♥\n"
                                 + "  3♥  4♥\n"
                                 + "\n"
                                 + "Draw: 6♦, 7♦, 5♦\n"
                                 + "Score: 101"),
      new InputInteraction("rm1 \n asfjo 5 3 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠      A♥  2♥\n"
                                 + "  3♥  4♥\n"
                                 + "\n"
                                 + "Draw: 6♦, 7♦, 5♦\n"
                                 + "Score: 88"),
      new InputInteraction("dd 1\n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠      A♥  2♥\n"
                                 + "  3♥  4♥\n"
                                 + "\n"
                                 + "Draw: 8♦, 7♦, 5♦\n"
                                 + "Score: 88"),
      new InputInteraction("dd 1 \n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠      A♥  2♥\n"
                                 + "  3♥  4♥\n"
                                 + "\n"
                                 + "Draw: 9♦, 7♦, 5♦\n"
                                 + "Score: 88"),
      new InputInteraction("rmwd poij rmwd dd dd\n rm 1 rm2 \n\nfg 6 2 \n\n\n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠      A♥  2♥\n"
                                 + "  3♥\n"
                                 + "\n"
                                 + "Draw: 10♦, 7♦, 5♦\n"
                                 + "Score: 84"),
      new InputInteraction("rmwd 1 dd dd \n6 dd rm 1 \n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠  Q♠      A♥  2♥\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: J♦, 7♦, 5♦\n"
                                 + "Score: 81"),
      new InputInteraction("rm2 5 2 5 4 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "    J♠              2♥\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: J♦, 7♦, 5♦\n"
                                 + "Score: 68"),
      new InputInteraction("\n\n\n       rm2     5   1   5     5 \n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠  8♠  9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: J♦, 7♦, 5♦\n"
                                 + "Score: 55"),
      new InputInteraction("rmwd 3 4 2 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: J♦, 7♦, Q♦\n"
                                 + "Score: 47"),
      new InputInteraction("dd 1 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: K♦, 7♦, Q♦\n"
                                 + "Score: 47"),
      new InputInteraction("dd 1  "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: A♣, 7♦, Q♦\n"
                                 + "Score: 47"),
      new InputInteraction("dd 1d\n1 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 2♣, 7♦, Q♦\n"
                                 + "Score: 47"),
      new InputInteraction("dd 1"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠  10♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 3♣, 7♦, Q♦\n"
                                 + "Score: 47"),
      new InputInteraction(" rmwd 1 4 4 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠      9♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 4♣, 7♦, Q♦\n"
                                 + "Score: 37"),
      new InputInteraction("rmwd 1 4 3 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠  6♠\n"
                                 + "      7♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 5♣, 7♦, Q♦\n"
                                 + "Score: 28"),
      new InputInteraction("rm2 4 1 3 3 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 5♣, 7♦, Q♦\n"
                                 + "Score: 15"),
      new InputInteraction("dd 1 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 6♣, 7♦, Q♦\n"
                                 + "Score: 15"),
      new InputInteraction("dd 1"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 7♣, 7♦, Q♦\n"
                                 + "Score: 15"),
      new InputInteraction("\n\n dd 1 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠  5♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 8♣, 7♦, Q♦\n"
                                 + "Score: 15"),
      new InputInteraction("rmwd 1 3 2 "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "        4♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 9♣, 7♦, Q♦\n"
                                 + "Score: 10"),
      new InputInteraction("rmwd 1 3 1 \n"),
      new PrintInteraction("            A♠\n"
                                 + "          2♠  3♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: 10♣, 7♦, Q♦\n"
                                 + "Score: 6"),
      new InputInteraction("rmwd 1 2  2  "),
      new PrintInteraction("            A♠\n"
                                 + "          2♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: J♣, 7♦, Q♦\n"
                                 + "Score: 3"),
      new InputInteraction("rmwd 1 2 1 "),
      new PrintInteraction("            A♠\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "\n"
                                 + "Draw: Q♣, 7♦, Q♦\n"
                                 + "Score: 1"),
      new InputInteraction("rmwd 1 1 1 "),
      new PrintInteraction("You win!")
    };


  }


  @Test
  public void rm1_7_5() {
    testRun(m, interactions1);
  }

  @Test
  public void quit() {
    testRun(m, interactions2);
  }

  @Test
  public void rm2_7_4_7_6() {
    testRun(m, interactions3);
  }

  @Test
  public void dd1() {
    testRun(m, interactions4);
  }


  @Test
  public void testGame1() {
    testRun(m, interactions5);
  }

  @Test(expected = IllegalStateException.class)
  public void testGame2() {
    testRun(m, interactions6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGame3() {
    PyramidSolitaireController c = new PyramidSolitaireTextualController(null, new StringBuilder());
    c.playGame(m, originDeck, true, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGame4() {
    PyramidSolitaireController c = new PyramidSolitaireTextualController(null, null);
    c.playGame(null, originDeck, true, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGame5() {
    PyramidSolitaireController c = new PyramidSolitaireTextualController(null, null);
    c.playGame(m, originDeck, true, 10, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGame6() {
    PyramidSolitaireController c = new PyramidSolitaireTextualController(null, null);
    c.playGame(m, originDeck, true, -10, -1);
  }

  @Test
  public void testGame7() {
    testRun(m, interactions7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGame8() {
    PyramidSolitaireController c = new PyramidSolitaireTextualController(
            new StringReader(""), null);
    c.playGame(m, originDeck, true, 1, 1);
  }

  @Test
  public void testGame9() {
    testRun(m, interactions8);
  }

  @Test
  public void testGame10() {
    testRun(m, interactions9);
  }

  @Test
  public void testGame11() {
    testRun(m, interactions10);
  }

  @Test
  public void testGame12() {
    testRun(m, interactions11);
  }
}