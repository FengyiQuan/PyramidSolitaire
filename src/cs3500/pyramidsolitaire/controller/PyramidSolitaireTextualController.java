package cs3500.pyramidsolitaire.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import cs3500.pyramidsolitaire.view.PyramidSolitaireView;

/**
 * Controller for Pyramid Solitaire interface to pass the user inputs to model to allow player to
 * play game via console. The value is greater 1 than actual value which passing in in the model.
 */
public class PyramidSolitaireTextualController implements PyramidSolitaireController {
  private final Readable in;
  private final Appendable out;


  /**
   * Construct PyramidSolitaireTextualController.
   *
   * @param rd readable input
   * @param ap appendable output
   * @throws IllegalArgumentException if {@code rd or ap} is {@code null}
   */
  public PyramidSolitaireTextualController(Readable rd, Appendable ap)
          throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Arguments are null. ");
    }
    this.in = rd;
    this.out = ap;
  }

  @Override
  public <K> void playGame(PyramidSolitaireModel<K> model, List<K> deck,
                           boolean shuffle, int numRows, int numDraw) {
    if (model == null) {
      throw new IllegalArgumentException("Model is null. ");
    }
    PyramidSolitaireView view = new PyramidSolitaireTextualView(model, out);
    try {
      model.startGame(deck, shuffle, numRows, numDraw);
    } catch (IllegalArgumentException e) {
      throw new IllegalStateException("Game cannot start. ");
    }
    try {
      view.render();
      out.append("\n");
      out.append("Score: ").append(Integer.toString(model.getScore())).append("\n");
    } catch (IOException e) {
      throw new IllegalStateException("Unable to transmit output or input. ");
    }

    Scanner scan = new Scanner(this.in);
    String arg1;
    String arg2;
    String arg3;
    String arg4;

    while (!model.isGameOver()) {
      try {
        String command = nextCommand(scan);
        switch (command) {
          case "q":
          case "Q":
            whenQuit(model, out);
            return;
          case "rm1":
            arg1 = retry(scan);
            if (PyramidSolitaireTextualController.checkIfQuit(arg1)) {
              whenQuit(model, out);
              return;
            }
            arg2 = retry(scan);
            if (PyramidSolitaireTextualController.checkIfQuit(arg2)) {
              whenQuit(model, out);
              return;
            } else {
              model.remove(Integer.parseInt(arg1) - 1, Integer.parseInt(arg2) - 1);
            }
            break;
          case "rm2":
            arg1 = retry(scan);
            if (PyramidSolitaireTextualController.checkIfQuit(arg1)) {
              whenQuit(model, out);
              return;
            }
            arg2 = retry(scan);
            if (PyramidSolitaireTextualController.checkIfQuit(arg2)) {
              whenQuit(model, out);
              return;
            }
            arg3 = retry(scan);
            if (PyramidSolitaireTextualController.checkIfQuit(arg3)) {
              whenQuit(model, out);
              return;
            }
            arg4 = retry(scan);
            if (PyramidSolitaireTextualController.checkIfQuit(arg4)) {
              whenQuit(model, out);
              return;
            } else {
              model.remove(Integer.parseInt(arg1) - 1, Integer.parseInt(arg2) - 1,
                      Integer.parseInt(arg3) - 1, Integer.parseInt(arg4) - 1);
            }
            break;
          case "rmwd":
            arg1 = retry(scan);
            if (PyramidSolitaireTextualController.checkIfQuit(arg1)) {
              whenQuit(model, out);
              return;
            }
            arg2 = retry(scan);
            if (PyramidSolitaireTextualController.checkIfQuit(arg2)) {
              whenQuit(model, out);
              return;
            }
            arg3 = retry(scan);
            if (PyramidSolitaireTextualController.checkIfQuit(arg3)) {
              whenQuit(model, out);
              return;
            } else {
              model.removeUsingDraw(Integer.parseInt(arg1) - 1, Integer.parseInt(arg2) - 1,
                      Integer.parseInt(arg3) - 1);
            }
            break;
          case "dd":
            arg1 = retry(scan);
            if (PyramidSolitaireTextualController.checkIfQuit(arg1)) {
              whenQuit(model, out);
              return;
            } else {
              model.discardDraw(Integer.parseInt(arg1) - 1);
            }
            break;
          default:
            out.append("No such command, please re-enter. \n");
            break;
        }
        view.render();
        out.append("\n");
        if (!model.isGameOver()) {
          out.append("Score: ").append(Integer.toString(model.getScore())).append("\n");
        }
      } catch (IOException e) {
        throw new IllegalStateException("Unable to transmit output or input. ");
      } catch (IllegalArgumentException e) {
        try {
          out.append("Invalid move. Play again. ").append(e.getMessage()).append("\n");
          view.render();
          out.append("\n");
          out.append("Score: ").append(Integer.toString(model.getScore())).append("\n");
        } catch (IOException ex) {
          throw new IllegalStateException("IOException");
        }
      }
    }
  }

  //check if given string array has "q" or "Q" to indicate quit operation
  private static boolean checkIfQuit(String str) {
    return (str.equals("q") || str.equals("Q"));
  }

  // read a int value from Readable until get a int or quit
  private static String retry(Scanner in) {
    while (true) {
      if (in.hasNextInt()) {
        return in.next();
      } else if (in.hasNext()) {
        String ifQuit = in.next();
        if (PyramidSolitaireTextualController.checkIfQuit(ifQuit)) {
          return "q";
        }
      }
    }
  }

  // return the next valid command
  private String nextCommand(Scanner in) throws IOException {
    while (in.hasNext()) {
      String n = in.next();
      switch (n) {
        case ("q"):
        case ("Q"):
        case ("rm1"):
        case ("rm2"):
        case ("rmwd"):
        case ("dd"):
          return n;
        default:
      }
    }
    throw new IOException("No such command. ");
  }

  // append some string to indicate when game quit
  private void whenQuit(PyramidSolitaireModel model, Appendable out) throws IOException {
    PyramidSolitaireView view = new PyramidSolitaireTextualView(model, out);
    out.append("Game quit!\nState of game when quit:\n");
    view.render();
    out.append("\n");
    out.append("Score: ").append(Integer.toString(model.getScore())).append("\n");
  }
}
