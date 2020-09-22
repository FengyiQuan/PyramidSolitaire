package cs3500.pyramidsolitaire;

import java.io.InputStreamReader;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;

/**
 * PyramidSolitaire Main class is entry of this program to start game based on command line
 * arguments from user inputs.
 * <p>inputs can be one to represents three kind of game mode ot three which latter two represents
 * row and draw cards configuration to start game.</p>
 * <p>Default: numRow: 7  numDraw: 3</p>
 */
public final class PyramidSolitaire {
  /**
   * main function which is a start entry to this program to configure setting and mode to allowed
   * users to play game.
   *
   * @param args represents user inputs to start game
   *             <b>first argument: mode of the game going to play</b>
   *             <b>second argument: numRow how many rows should be in the pyramid</b>
   *             <b>third argument: numDraw how many draw cards should be in the open pile</b>
   *             <b>default value is numRow: 7  numDraw: 3 if args only has length 1.</b>
   */
  public static void main(String[] args) {

    PyramidSolitaireCreator creator = new PyramidSolitaireCreator();
    PyramidSolitaireController c =
            new PyramidSolitaireTextualController(new InputStreamReader(System.in), System.out);
    creator.chooseToPlay(args, c);
  }
}