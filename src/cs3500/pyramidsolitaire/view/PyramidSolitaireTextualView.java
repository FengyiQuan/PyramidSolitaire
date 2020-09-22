package cs3500.pyramidsolitaire.view;

import java.io.IOException;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * PyramidSolitaireTextualView class to visualize game.
 */
public class PyramidSolitaireTextualView implements PyramidSolitaireView {
  private final PyramidSolitaireModel model;
  private final Appendable out;

  public PyramidSolitaireTextualView(PyramidSolitaireModel model) {
    this.model = model;
    this.out = new StringBuilder();
  }


  /**
   * Construct a PyramidSolitaireTextualView.
   *
   * @param model a PyramidSolitaireModel to be draw
   * @param out   output
   */
  public PyramidSolitaireTextualView(PyramidSolitaireModel model, Appendable out) {
    this.model = model;
    this.out = out;
  }

  @Override
  public void render() throws IOException {
    try {
      out.append(toString());
    } catch (IOException e) {
      throw new IOException("The rendering fails for some reason. ");
    }
  }

  @Override
  public String toString() {
    if (model.getNumRows() == -1) {
      return "";
    } else if (model.isGameOver()) {
      if (model.getScore() == 0) {
        return "You win!";
      } else {
        return "Game over. Score: " + model.getScore();
      }
    } else {
      return renderCards(model);
    }
  }

  // generate one row string
  private String renderCards(PyramidSolitaireModel<?> model) {
    String res = "";

    for (int i = 0; i < model.getNumRows(); i++) {
      String renderRow = "";
      for (int j = 0; j < model.getRowWidth(i); j++) {
        Object target = model.getCardAt(i, j);
        if (target == null) {
          renderRow = renderRow + "    ";
        } else {
          renderRow = renderRow + convertTo3Char(target.toString()) + " ";
        }
      }

      // pad space before each line
      int numberOfWhiteSpacePadding = (model.getNumRows() - i - 1) << 1;
      String emptyString = "";
      for (int half = 0; half < numberOfWhiteSpacePadding; half++) {
        emptyString = emptyString + " ";
      }
      renderRow = emptyString + renderRow;
      renderRow = PyramidSolitaireTextualView.rtrim(renderRow);
      res = res + renderRow + "\n";
    }

    res = res + "Draw: ";
    if (areDrawsNull(model.getDrawCards())) {
      return res.substring(0, res.length() - 1);
    } else {
      for (Object c : model.getDrawCards()) {
        if (c != null) {
          res = res + c.toString() + ", ";
        }
      }
      res = res.substring(0, res.length() - 2);
      return res;
    }
  }

  // determine if all draws are null
  private static boolean areDrawsNull(List<?> draws) {
    boolean result = true;
    for (Object o : draws) {
      result = result && (o == null);
    }
    return result;
  }


  private static String convertTo3Char(String s) {
    while (s.length() < 3) {
      s = s.concat(" ");
    }
    return s;
  }

  // delete the white space on the right side of a string
  private static String rtrim(String s) {
    return ("A" + s).trim().substring(1);
  }
}
