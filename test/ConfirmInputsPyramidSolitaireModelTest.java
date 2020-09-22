import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.ConfirmInputsPyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.PlayingCard;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing whether inputs passing in model is correct.
 */
public class ConfirmInputsPyramidSolitaireModelTest {

  @Test
  public void startGame() {
    Reader in = new StringReader("q");
    StringBuilder dontCareOutput = new StringBuilder();
    PyramidSolitaireController controller =
            new PyramidSolitaireTextualController(in, dontCareOutput);

    StringBuilder log = new StringBuilder();
    PyramidSolitaireModel<PlayingCard> mockModel = new ConfirmInputsPyramidSolitaireModel<>(log);

    controller.playGame(mockModel, new BasicPyramidSolitaire().getDeck(), false, 0, 0);
    assertEquals("A♠2♠3♠4♠5♠6♠7♠8♠9♠10♠J♠Q♠K♠A♥2♥3♥4♥5♥6♥7♥8♥9♥10♥J♥Q♥K♥A♦2♦3♦4♦5♦6♦7♦8♦9♦10♦"
            + "J♦Q♦K♦A♣2♣3♣4♣5♣6♣7♣8♣9♣10♣J♣Q♣K♣\nshuffle = false, numRows = 0, "
            + "numDraw = 0\n", log.toString());
  }

  @Test
  public void remove1_1() {
    Reader in = new StringReader("rm1 3 4 q");
    StringBuilder dontCareOutput = new StringBuilder();
    PyramidSolitaireController controller =
            new PyramidSolitaireTextualController(in, dontCareOutput);

    StringBuilder log = new StringBuilder();
    PyramidSolitaireModel<PlayingCard> mockModel = new ConfirmInputsPyramidSolitaireModel<>(log);

    controller.playGame(mockModel, new BasicPyramidSolitaire().getDeck(), false, 0, 0);
    assertEquals("A♠2♠3♠4♠5♠6♠7♠8♠9♠10♠J♠Q♠K♠A♥2♥3♥4♥5♥6♥7♥8♥9♥10♥J♥Q♥K♥A♦2♦3♦4♦5♦6♦7♦8♦9♦10♦"
            + "J♦Q♦K♦A♣2♣3♣4♣5♣6♣7♣8♣9♣10♣J♣Q♣K♣\nshuffle = false, numRows = 0, numDraw = 0\n"
            + "row = 2, card = 3\n", log.toString());
  }

  @Test
  public void remove1_2() {
    Reader in = new StringReader("\n\n asdf e rm1 3 4 q");
    StringBuilder dontCareOutput = new StringBuilder();
    PyramidSolitaireController controller =
            new PyramidSolitaireTextualController(in, dontCareOutput);

    StringBuilder log = new StringBuilder();
    PyramidSolitaireModel<PlayingCard> mockModel = new ConfirmInputsPyramidSolitaireModel<>(log);

    controller.playGame(mockModel, new BasicPyramidSolitaire().getDeck(), false, 0, 0);
    assertEquals("A♠2♠3♠4♠5♠6♠7♠8♠9♠10♠J♠Q♠K♠A♥2♥3♥4♥5♥6♥7♥8♥9♥10♥J♥Q♥K♥A♦2♦3♦4♦5♦6♦7♦8♦9♦10♦"
            + "J♦Q♦K♦A♣2♣3♣4♣5♣6♣7♣8♣9♣10♣J♣Q♣K♣\nshuffle = false, numRows = 0, numDraw = 0\n"
            + "row = 2, card = 3\n", log.toString());
  }

  @Test
  public void remove2_1() {
    Reader in = new StringReader("rm2 3 4 5 6 q");
    StringBuilder dontCareOutput = new StringBuilder();
    PyramidSolitaireController controller =
            new PyramidSolitaireTextualController(in, dontCareOutput);

    StringBuilder log = new StringBuilder();
    PyramidSolitaireModel<PlayingCard> mockModel = new ConfirmInputsPyramidSolitaireModel<>(log);

    controller.playGame(mockModel, new BasicPyramidSolitaire().getDeck(), false, 0, 0);
    assertEquals("A♠2♠3♠4♠5♠6♠7♠8♠9♠10♠J♠Q♠K♠A♥2♥3♥4♥5♥6♥7♥8♥9♥10♥J♥Q♥K♥A♦2♦3♦4♦5♦6♦7♦8♦9♦10♦"
            + "J♦Q♦K♦A♣2♣3♣4♣5♣6♣7♣8♣9♣10♣J♣Q♣K♣\nshuffle = false, numRows = 0, numDraw = 0\n"
            + "row1 = 2, card1 = 3, row2 = 4, card2 = 5\n", log.toString());
  }

  @Test
  public void remove2_2() {
    Reader in = new StringReader("qe e \n rm2 3 4 \n adsfje 5 6 q");
    StringBuilder dontCareOutput = new StringBuilder();
    PyramidSolitaireController controller =
            new PyramidSolitaireTextualController(in, dontCareOutput);

    StringBuilder log = new StringBuilder();
    PyramidSolitaireModel<PlayingCard> mockModel = new ConfirmInputsPyramidSolitaireModel<>(log);

    controller.playGame(mockModel, new BasicPyramidSolitaire().getDeck(), false, 0, 0);
    assertEquals("A♠2♠3♠4♠5♠6♠7♠8♠9♠10♠J♠Q♠K♠A♥2♥3♥4♥5♥6♥7♥8♥9♥10♥J♥Q♥K♥A♦2♦3♦4♦5♦6♦7♦8♦9♦10♦"
            + "J♦Q♦K♦A♣2♣3♣4♣5♣6♣7♣8♣9♣10♣J♣Q♣K♣\nshuffle = false, numRows = 0, numDraw = 0\n"
            + "row1 = 2, card1 = 3, row2 = 4, card2 = 5\n", log.toString());
  }

  @Test
  public void removeUsingDraw1() {
    Reader in = new StringReader("rmwd 1 3 4 q");
    StringBuilder dontCareOutput = new StringBuilder();
    PyramidSolitaireController controller =
            new PyramidSolitaireTextualController(in, dontCareOutput);

    StringBuilder log = new StringBuilder();
    PyramidSolitaireModel<PlayingCard> mockModel = new ConfirmInputsPyramidSolitaireModel<>(log);

    controller.playGame(mockModel, new BasicPyramidSolitaire().getDeck(), false, 0, 0);
    assertEquals("A♠2♠3♠4♠5♠6♠7♠8♠9♠10♠J♠Q♠K♠A♥2♥3♥4♥5♥6♥7♥8♥9♥10♥J♥Q♥K♥A♦2♦3♦4♦5♦6♦7♦8♦9♦10♦"
            + "J♦Q♦K♦A♣2♣3♣4♣5♣6♣7♣8♣9♣10♣J♣Q♣K♣\nshuffle = false, numRows = 0, numDraw = 0\n"
            + "drawIndex = 0, row = 2, card = 3\n", log.toString());
  }

  @Test
  public void removeUsingDraw2() {
    Reader in = new StringReader("rmwd \n \n\n1 adsj 3 e 4 q");
    StringBuilder dontCareOutput = new StringBuilder();
    PyramidSolitaireController controller =
            new PyramidSolitaireTextualController(in, dontCareOutput);

    StringBuilder log = new StringBuilder();
    PyramidSolitaireModel<PlayingCard> mockModel = new ConfirmInputsPyramidSolitaireModel<>(log);

    controller.playGame(mockModel, new BasicPyramidSolitaire().getDeck(), false, 0, 0);
    assertEquals("A♠2♠3♠4♠5♠6♠7♠8♠9♠10♠J♠Q♠K♠A♥2♥3♥4♥5♥6♥7♥8♥9♥10♥J♥Q♥K♥A♦2♦3♦4♦5♦6♦7♦8♦9♦10♦"
            + "J♦Q♦K♦A♣2♣3♣4♣5♣6♣7♣8♣9♣10♣J♣Q♣K♣\nshuffle = false, numRows = 0, numDraw = 0\n"
            + "drawIndex = 0, row = 2, card = 3\n", log.toString());
  }

  @Test
  public void discardDraw1() {
    Reader in = new StringReader("dd 1 q");
    StringBuilder dontCareOutput = new StringBuilder();
    PyramidSolitaireController controller =
            new PyramidSolitaireTextualController(in, dontCareOutput);

    StringBuilder log = new StringBuilder();
    PyramidSolitaireModel<PlayingCard> mockModel = new ConfirmInputsPyramidSolitaireModel<>(log);

    controller.playGame(mockModel, new BasicPyramidSolitaire().getDeck(), false, 0, 0);
    assertEquals("A♠2♠3♠4♠5♠6♠7♠8♠9♠10♠J♠Q♠K♠A♥2♥3♥4♥5♥6♥7♥8♥9♥10♥J♥Q♥K♥A♦2♦3♦4♦5♦6♦7♦8♦9♦10♦"
            + "J♦Q♦K♦A♣2♣3♣4♣5♣6♣7♣8♣9♣10♣J♣Q♣K♣\nshuffle = false, numRows = 0, numDraw = 0\n"
            + "drawIndex = 0\n", log.toString());
  }

  @Test
  public void discardDraw2() {
    Reader in = new StringReader("dd asdf sadf \n 3 q");
    StringBuilder dontCareOutput = new StringBuilder();
    PyramidSolitaireController controller =
            new PyramidSolitaireTextualController(in, dontCareOutput);

    StringBuilder log = new StringBuilder();
    PyramidSolitaireModel<PlayingCard> mockModel = new ConfirmInputsPyramidSolitaireModel<>(log);

    controller.playGame(mockModel, new BasicPyramidSolitaire().getDeck(), false, 0, 0);
    assertEquals("A♠2♠3♠4♠5♠6♠7♠8♠9♠10♠J♠Q♠K♠A♥2♥3♥4♥5♥6♥7♥8♥9♥10♥J♥Q♥K♥A♦2♦3♦4♦5♦6♦7♦8♦9♦10♦"
            + "J♦Q♦K♦A♣2♣3♣4♣5♣6♣7♣8♣9♣10♣J♣Q♣K♣\nshuffle = false, numRows = 0, numDraw = 0\n"
            + "drawIndex = 2\n", log.toString());
  }
}