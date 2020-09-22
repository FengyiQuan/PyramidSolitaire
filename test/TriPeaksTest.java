import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import cs3500.pyramidsolitaire.model.hw02.PlayingCard;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw04.TriPeaks;
import cs3500.pyramidsolitaire.model.hw02.Value;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


/**
 * Test for TriPeaks.
 */
public class TriPeaksTest {
  private TriPeaks null1;
  private TriPeaks t1;
  private TriPeaks notStart;
  private ArrayList<PlayingCard> noChange;
  private ArrayList<PlayingCard> duplicate1;
  private ArrayList<PlayingCard> duplicate2;
  private ArrayList<PlayingCard> newDraw;
  private ArrayList<PlayingCard> deck1;
  private ArrayList<PlayingCard> deck2;
  private ArrayList<PlayingCard> afterShuffle;

  @Before
  public void initData() {
    this.noChange = new ArrayList<>(Arrays.asList(
            new PlayingCard(Value.Ace, Suit.Spade), new PlayingCard(Value.Ace, Suit.Spade),
            new PlayingCard(Value.Two, Suit.Spade), new PlayingCard(Value.Two, Suit.Spade),
            new PlayingCard(Value.Three, Suit.Spade), new PlayingCard(Value.Three, Suit.Spade),
            new PlayingCard(Value.Four, Suit.Spade), new PlayingCard(Value.Four, Suit.Spade),
            new PlayingCard(Value.Five, Suit.Spade), new PlayingCard(Value.Five, Suit.Spade),
            new PlayingCard(Value.Six, Suit.Spade), new PlayingCard(Value.Six, Suit.Spade),
            new PlayingCard(Value.Seven, Suit.Spade), new PlayingCard(Value.Seven, Suit.Spade),
            new PlayingCard(Value.Eight, Suit.Spade), new PlayingCard(Value.Eight, Suit.Spade),
            new PlayingCard(Value.Nine, Suit.Spade), new PlayingCard(Value.Nine, Suit.Spade),
            new PlayingCard(Value.Ten, Suit.Spade), new PlayingCard(Value.Ten, Suit.Spade),
            new PlayingCard(Value.Jack, Suit.Spade), new PlayingCard(Value.Jack, Suit.Spade),
            new PlayingCard(Value.Queen, Suit.Spade), new PlayingCard(Value.Queen, Suit.Spade),
            new PlayingCard(Value.King, Suit.Spade), new PlayingCard(Value.King, Suit.Spade),
            new PlayingCard(Value.Ace, Suit.Heart), new PlayingCard(Value.Ace, Suit.Heart),
            new PlayingCard(Value.Two, Suit.Heart), new PlayingCard(Value.Two, Suit.Heart),
            new PlayingCard(Value.Three, Suit.Heart), new PlayingCard(Value.Three, Suit.Heart),
            new PlayingCard(Value.Four, Suit.Heart), new PlayingCard(Value.Four, Suit.Heart),
            new PlayingCard(Value.Five, Suit.Heart), new PlayingCard(Value.Five, Suit.Heart),
            new PlayingCard(Value.Six, Suit.Heart), new PlayingCard(Value.Six, Suit.Heart),
            new PlayingCard(Value.Seven, Suit.Heart), new PlayingCard(Value.Seven, Suit.Heart),
            new PlayingCard(Value.Eight, Suit.Heart), new PlayingCard(Value.Eight, Suit.Heart),
            new PlayingCard(Value.Nine, Suit.Heart), new PlayingCard(Value.Nine, Suit.Heart),
            new PlayingCard(Value.Ten, Suit.Heart), new PlayingCard(Value.Ten, Suit.Heart),
            new PlayingCard(Value.Jack, Suit.Heart), new PlayingCard(Value.Jack, Suit.Heart),
            new PlayingCard(Value.Queen, Suit.Heart), new PlayingCard(Value.Queen, Suit.Heart),
            new PlayingCard(Value.King, Suit.Heart), new PlayingCard(Value.King, Suit.Heart),
            new PlayingCard(Value.Ace, Suit.Diamond), new PlayingCard(Value.Ace, Suit.Diamond),
            new PlayingCard(Value.Two, Suit.Diamond), new PlayingCard(Value.Two, Suit.Diamond),
            new PlayingCard(Value.Three, Suit.Diamond), new PlayingCard(Value.Three, Suit.Diamond),
            new PlayingCard(Value.Four, Suit.Diamond), new PlayingCard(Value.Four, Suit.Diamond),
            new PlayingCard(Value.Five, Suit.Diamond), new PlayingCard(Value.Five, Suit.Diamond),
            new PlayingCard(Value.Six, Suit.Diamond), new PlayingCard(Value.Six, Suit.Diamond),
            new PlayingCard(Value.Seven, Suit.Diamond), new PlayingCard(Value.Seven, Suit.Diamond),
            new PlayingCard(Value.Eight, Suit.Diamond), new PlayingCard(Value.Eight, Suit.Diamond),
            new PlayingCard(Value.Nine, Suit.Diamond), new PlayingCard(Value.Nine, Suit.Diamond),
            new PlayingCard(Value.Ten, Suit.Diamond), new PlayingCard(Value.Ten, Suit.Diamond),
            new PlayingCard(Value.Jack, Suit.Diamond), new PlayingCard(Value.Jack, Suit.Diamond),
            new PlayingCard(Value.Queen, Suit.Diamond), new PlayingCard(Value.Queen, Suit.Diamond),
            new PlayingCard(Value.King, Suit.Diamond), new PlayingCard(Value.King, Suit.Diamond),
            new PlayingCard(Value.Ace, Suit.Club), new PlayingCard(Value.Ace, Suit.Club),
            new PlayingCard(Value.Two, Suit.Club), new PlayingCard(Value.Two, Suit.Club),
            new PlayingCard(Value.Three, Suit.Club), new PlayingCard(Value.Three, Suit.Club),
            new PlayingCard(Value.Four, Suit.Club), new PlayingCard(Value.Four, Suit.Club),
            new PlayingCard(Value.Five, Suit.Club), new PlayingCard(Value.Five, Suit.Club),
            new PlayingCard(Value.Six, Suit.Club), new PlayingCard(Value.Six, Suit.Club),
            new PlayingCard(Value.Seven, Suit.Club), new PlayingCard(Value.Seven, Suit.Club),
            new PlayingCard(Value.Eight, Suit.Club), new PlayingCard(Value.Eight, Suit.Club),
            new PlayingCard(Value.Nine, Suit.Club), new PlayingCard(Value.Nine, Suit.Club),
            new PlayingCard(Value.Ten, Suit.Club), new PlayingCard(Value.Ten, Suit.Club),
            new PlayingCard(Value.Jack, Suit.Club), new PlayingCard(Value.Jack, Suit.Club),
            new PlayingCard(Value.Queen, Suit.Club), new PlayingCard(Value.Queen, Suit.Club),
            new PlayingCard(Value.King, Suit.Club), new PlayingCard(Value.King, Suit.Club)));
    this.duplicate1 = new ArrayList<>(Arrays.asList(new PlayingCard(Value.Ace, Suit.Spade),
            new PlayingCard(Value.Three, Suit.Spade),
            new PlayingCard(Value.Three, Suit.Spade),
            new PlayingCard(Value.Three, Suit.Spade),
            new PlayingCard(Value.Five, Suit.Spade),
            new PlayingCard(Value.Six, Suit.Spade),
            new PlayingCard(Value.Six, Suit.Spade),
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
            new PlayingCard(Value.King, Suit.Club),
            new PlayingCard(Value.Ace, Suit.Club),
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
    this.duplicate2 = new ArrayList<>(Arrays.asList(new PlayingCard(Value.Ace, Suit.Spade),
            new PlayingCard(Value.Jack, Suit.Club),
            new PlayingCard(Value.Ace, Suit.Spade),
            new PlayingCard(Value.Ace, Suit.Spade),
            new PlayingCard(Value.Five, Suit.Spade),
            new PlayingCard(Value.Six, Suit.Spade),
            new PlayingCard(Value.Six, Suit.Spade),
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
            new PlayingCard(Value.King, Suit.Club),
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
            new PlayingCard(Value.Ace, Suit.Spade)));
    this.deck1 = new ArrayList<>(Arrays.asList(
            new PlayingCard(Value.Ace, Suit.Spade), new PlayingCard(Value.Ace, Suit.Spade),
            new PlayingCard(Value.Two, Suit.Spade), new PlayingCard(Value.Two, Suit.Spade),
            new PlayingCard(Value.Three, Suit.Spade), new PlayingCard(Value.Three, Suit.Spade),
            new PlayingCard(Value.Four, Suit.Spade), new PlayingCard(Value.Four, Suit.Spade),
            new PlayingCard(Value.Five, Suit.Spade), new PlayingCard(Value.Five, Suit.Spade),
            new PlayingCard(Value.Six, Suit.Spade), new PlayingCard(Value.Six, Suit.Spade),
            new PlayingCard(Value.Seven, Suit.Spade), new PlayingCard(Value.Seven, Suit.Spade),
            new PlayingCard(Value.Eight, Suit.Spade), new PlayingCard(Value.Eight, Suit.Spade),
            new PlayingCard(Value.Nine, Suit.Spade), new PlayingCard(Value.Nine, Suit.Spade),
            new PlayingCard(Value.Ten, Suit.Spade), new PlayingCard(Value.Ten, Suit.Spade),
            new PlayingCard(Value.Jack, Suit.Spade), new PlayingCard(Value.Jack, Suit.Spade),
            new PlayingCard(Value.Queen, Suit.Spade), new PlayingCard(Value.Queen, Suit.Spade),
            new PlayingCard(Value.King, Suit.Spade), new PlayingCard(Value.King, Suit.Spade),
            new PlayingCard(Value.Ace, Suit.Heart), new PlayingCard(Value.Ace, Suit.Heart),
            new PlayingCard(Value.Two, Suit.Heart), new PlayingCard(Value.Two, Suit.Heart),
            new PlayingCard(Value.Three, Suit.Heart), new PlayingCard(Value.Three, Suit.Heart),
            new PlayingCard(Value.Four, Suit.Heart), new PlayingCard(Value.Four, Suit.Heart),
            new PlayingCard(Value.Five, Suit.Heart), new PlayingCard(Value.Five, Suit.Heart),
            new PlayingCard(Value.Six, Suit.Heart), new PlayingCard(Value.Six, Suit.Heart),
            new PlayingCard(Value.Seven, Suit.Heart), new PlayingCard(Value.Seven, Suit.Heart),
            new PlayingCard(Value.Eight, Suit.Heart), new PlayingCard(Value.Eight, Suit.Heart),
            new PlayingCard(Value.Nine, Suit.Heart), new PlayingCard(Value.Nine, Suit.Heart),
            new PlayingCard(Value.Ten, Suit.Heart), new PlayingCard(Value.Ten, Suit.Heart),
            new PlayingCard(Value.Jack, Suit.Heart), new PlayingCard(Value.Jack, Suit.Heart),
            new PlayingCard(Value.Queen, Suit.Heart), new PlayingCard(Value.Queen, Suit.Heart),
            new PlayingCard(Value.King, Suit.Heart), new PlayingCard(Value.King, Suit.Heart),
            new PlayingCard(Value.Ace, Suit.Diamond), new PlayingCard(Value.Ace, Suit.Diamond),
            new PlayingCard(Value.Two, Suit.Diamond), new PlayingCard(Value.Two, Suit.Diamond),
            new PlayingCard(Value.Three, Suit.Diamond), new PlayingCard(Value.Three, Suit.Diamond),
            new PlayingCard(Value.Four, Suit.Diamond), new PlayingCard(Value.Four, Suit.Diamond),
            new PlayingCard(Value.Five, Suit.Diamond), new PlayingCard(Value.Five, Suit.Diamond),
            new PlayingCard(Value.Six, Suit.Diamond), new PlayingCard(Value.Six, Suit.Diamond),
            new PlayingCard(Value.Seven, Suit.Diamond), new PlayingCard(Value.Seven, Suit.Diamond),
            new PlayingCard(Value.Eight, Suit.Diamond), new PlayingCard(Value.Eight, Suit.Diamond),
            new PlayingCard(Value.Nine, Suit.Diamond), new PlayingCard(Value.Nine, Suit.Diamond),
            new PlayingCard(Value.Ten, Suit.Diamond), new PlayingCard(Value.Ten, Suit.Diamond),
            new PlayingCard(Value.Jack, Suit.Diamond), new PlayingCard(Value.Jack, Suit.Diamond),
            new PlayingCard(Value.Queen, Suit.Diamond), new PlayingCard(Value.Queen, Suit.Diamond),
            new PlayingCard(Value.King, Suit.Diamond), new PlayingCard(Value.King, Suit.Diamond),
            new PlayingCard(Value.Ace, Suit.Club), new PlayingCard(Value.Ace, Suit.Club),
            new PlayingCard(Value.Two, Suit.Club), new PlayingCard(Value.Two, Suit.Club),
            new PlayingCard(Value.Three, Suit.Club), new PlayingCard(Value.Three, Suit.Club),
            new PlayingCard(Value.Four, Suit.Club), new PlayingCard(Value.Four, Suit.Club),
            new PlayingCard(Value.Five, Suit.Club), new PlayingCard(Value.Five, Suit.Club),
            new PlayingCard(Value.Six, Suit.Club), new PlayingCard(Value.Six, Suit.Club),
            new PlayingCard(Value.Seven, Suit.Club), new PlayingCard(Value.Seven, Suit.Club),
            new PlayingCard(Value.Eight, Suit.Club), new PlayingCard(Value.Eight, Suit.Club),
            new PlayingCard(Value.Nine, Suit.Club), new PlayingCard(Value.Nine, Suit.Club),
            new PlayingCard(Value.Ten, Suit.Club), new PlayingCard(Value.Ten, Suit.Club),
            new PlayingCard(Value.Jack, Suit.Club), new PlayingCard(Value.Jack, Suit.Club),
            new PlayingCard(Value.Queen, Suit.Club), new PlayingCard(Value.Queen, Suit.Club),
            new PlayingCard(Value.King, Suit.Club), new PlayingCard(Value.King, Suit.Club)));
    this.deck2 = new ArrayList<>(Arrays.asList(
            new PlayingCard(Value.Ace, Suit.Spade), new PlayingCard(Value.Ace, Suit.Spade),
            new PlayingCard(Value.Two, Suit.Spade), new PlayingCard(Value.Two, Suit.Spade),
            new PlayingCard(Value.Three, Suit.Spade), new PlayingCard(Value.Three, Suit.Spade),
            new PlayingCard(Value.Four, Suit.Spade), new PlayingCard(Value.Four, Suit.Spade),
            new PlayingCard(Value.Five, Suit.Spade), new PlayingCard(Value.Five, Suit.Spade),
            new PlayingCard(Value.Six, Suit.Spade), new PlayingCard(Value.Six, Suit.Spade),
            new PlayingCard(Value.Seven, Suit.Spade), new PlayingCard(Value.Seven, Suit.Spade),
            new PlayingCard(Value.Eight, Suit.Spade), new PlayingCard(Value.Eight, Suit.Spade),
            new PlayingCard(Value.Nine, Suit.Spade), new PlayingCard(Value.Nine, Suit.Spade),
            new PlayingCard(Value.Ten, Suit.Spade), new PlayingCard(Value.Ten, Suit.Spade),
            new PlayingCard(Value.Jack, Suit.Spade), new PlayingCard(Value.Jack, Suit.Spade),
            new PlayingCard(Value.Queen, Suit.Spade), new PlayingCard(Value.Queen, Suit.Spade),
            new PlayingCard(Value.King, Suit.Spade), new PlayingCard(Value.King, Suit.Spade),
            new PlayingCard(Value.Ace, Suit.Heart), new PlayingCard(Value.Ace, Suit.Heart),
            new PlayingCard(Value.Two, Suit.Heart), new PlayingCard(Value.Two, Suit.Heart),
            new PlayingCard(Value.Three, Suit.Heart), new PlayingCard(Value.Three, Suit.Heart),
            new PlayingCard(Value.Four, Suit.Heart), new PlayingCard(Value.Four, Suit.Heart),
            new PlayingCard(Value.Five, Suit.Heart), new PlayingCard(Value.Five, Suit.Heart),
            new PlayingCard(Value.Six, Suit.Heart), new PlayingCard(Value.Six, Suit.Heart),
            new PlayingCard(Value.Seven, Suit.Heart), new PlayingCard(Value.Seven, Suit.Heart),
            new PlayingCard(Value.Eight, Suit.Heart), new PlayingCard(Value.Eight, Suit.Heart),
            new PlayingCard(Value.Nine, Suit.Heart), new PlayingCard(Value.Nine, Suit.Heart),
            new PlayingCard(Value.Ten, Suit.Heart), new PlayingCard(Value.Ten, Suit.Heart),
            new PlayingCard(Value.Jack, Suit.Heart), new PlayingCard(Value.Jack, Suit.Heart),
            new PlayingCard(Value.Queen, Suit.Heart), new PlayingCard(Value.Queen, Suit.Heart),
            new PlayingCard(Value.King, Suit.Heart), new PlayingCard(Value.King, Suit.Heart),
            new PlayingCard(Value.Ace, Suit.Diamond), new PlayingCard(Value.Ace, Suit.Diamond),
            new PlayingCard(Value.Two, Suit.Diamond), new PlayingCard(Value.Two, Suit.Diamond),
            new PlayingCard(Value.Three, Suit.Diamond), new PlayingCard(Value.Three, Suit.Diamond),
            new PlayingCard(Value.Four, Suit.Diamond), new PlayingCard(Value.Four, Suit.Diamond),
            new PlayingCard(Value.Five, Suit.Diamond), new PlayingCard(Value.Five, Suit.Diamond),
            new PlayingCard(Value.Six, Suit.Diamond), new PlayingCard(Value.Six, Suit.Diamond),
            new PlayingCard(Value.Seven, Suit.Diamond), new PlayingCard(Value.Seven, Suit.Diamond),
            new PlayingCard(Value.Eight, Suit.Diamond), new PlayingCard(Value.Eight, Suit.Diamond),
            new PlayingCard(Value.Nine, Suit.Diamond), new PlayingCard(Value.Nine, Suit.Diamond),
            new PlayingCard(Value.Ten, Suit.Diamond), new PlayingCard(Value.Ten, Suit.Diamond),
            new PlayingCard(Value.Jack, Suit.Diamond), new PlayingCard(Value.Jack, Suit.Diamond),
            new PlayingCard(Value.Queen, Suit.Diamond), new PlayingCard(Value.Queen, Suit.Diamond),
            new PlayingCard(Value.King, Suit.Diamond), new PlayingCard(Value.King, Suit.Diamond),
            new PlayingCard(Value.Ace, Suit.Club), new PlayingCard(Value.Ace, Suit.Club),
            new PlayingCard(Value.Two, Suit.Club), new PlayingCard(Value.Two, Suit.Club),
            new PlayingCard(Value.Three, Suit.Club), new PlayingCard(Value.Three, Suit.Club),
            new PlayingCard(Value.Four, Suit.Club), new PlayingCard(Value.Four, Suit.Club),
            new PlayingCard(Value.Five, Suit.Club), new PlayingCard(Value.Five, Suit.Club),
            new PlayingCard(Value.Six, Suit.Club), new PlayingCard(Value.Six, Suit.Club),
            new PlayingCard(Value.Seven, Suit.Club), new PlayingCard(Value.Seven, Suit.Club),
            new PlayingCard(Value.Eight, Suit.Club), new PlayingCard(Value.Eight, Suit.Club),
            new PlayingCard(Value.Nine, Suit.Club), new PlayingCard(Value.Nine, Suit.Club),
            new PlayingCard(Value.Ten, Suit.Club), new PlayingCard(Value.Ten, Suit.Club),
            new PlayingCard(Value.Jack, Suit.Club), new PlayingCard(Value.Jack, Suit.Club),
            new PlayingCard(Value.Queen, Suit.Club), new PlayingCard(Value.Queen, Suit.Club),
            new PlayingCard(Value.King, Suit.Club), new PlayingCard(Value.King, Suit.Club)));
    this.afterShuffle =
            new ArrayList<>(Arrays.asList(new PlayingCard(Value.Two, Suit.Diamond),
                    new PlayingCard(Value.Eight, Suit.Diamond),
                    new PlayingCard(Value.King, Suit.Club),
                    new PlayingCard(Value.Eight, Suit.Club),
                    new PlayingCard(Value.Six, Suit.Heart),
                    new PlayingCard(Value.Seven, Suit.Club),
                    new PlayingCard(Value.Three, Suit.Club),
                    new PlayingCard(Value.Three, Suit.Heart),
                    new PlayingCard(Value.Nine, Suit.Diamond),
                    new PlayingCard(Value.Four, Suit.Spade),
                    new PlayingCard(Value.Six, Suit.Spade),
                    new PlayingCard(Value.Two, Suit.Heart),
                    new PlayingCard(Value.Five, Suit.Spade),
                    new PlayingCard(Value.King, Suit.Heart),
                    new PlayingCard(Value.King, Suit.Spade),
                    new PlayingCard(Value.King, Suit.Club),
                    new PlayingCard(Value.Nine, Suit.Spade),
                    new PlayingCard(Value.Ten, Suit.Heart),
                    new PlayingCard(Value.Seven, Suit.Diamond),
                    new PlayingCard(Value.Two, Suit.Diamond),
                    new PlayingCard(Value.Queen, Suit.Club),
                    new PlayingCard(Value.Ten, Suit.Heart),
                    new PlayingCard(Value.Six, Suit.Spade),
                    new PlayingCard(Value.Ten, Suit.Spade),
                    new PlayingCard(Value.Ace, Suit.Diamond),
                    new PlayingCard(Value.Ten, Suit.Diamond),
                    new PlayingCard(Value.Ten, Suit.Club),
                    new PlayingCard(Value.King, Suit.Spade),
                    new PlayingCard(Value.Two, Suit.Club),
                    new PlayingCard(Value.Ace, Suit.Heart),
                    new PlayingCard(Value.Ace, Suit.Club),
                    new PlayingCard(Value.Seven, Suit.Club),
                    new PlayingCard(Value.Three, Suit.Spade),
                    new PlayingCard(Value.Five, Suit.Club),
                    new PlayingCard(Value.Three, Suit.Club),
                    new PlayingCard(Value.Three, Suit.Diamond),
                    new PlayingCard(Value.Eight, Suit.Spade),
                    new PlayingCard(Value.Ten, Suit.Diamond),
                    new PlayingCard(Value.Ten, Suit.Spade),
                    new PlayingCard(Value.Five, Suit.Spade),
                    new PlayingCard(Value.Queen, Suit.Spade),
                    new PlayingCard(Value.Seven, Suit.Spade),
                    new PlayingCard(Value.Ace, Suit.Diamond),
                    new PlayingCard(Value.Two, Suit.Spade),
                    new PlayingCard(Value.Eight, Suit.Diamond),
                    new PlayingCard(Value.Queen, Suit.Diamond),
                    new PlayingCard(Value.Nine, Suit.Heart),
                    new PlayingCard(Value.Three, Suit.Diamond),
                    new PlayingCard(Value.Seven, Suit.Heart),
                    new PlayingCard(Value.Four, Suit.Spade),
                    new PlayingCard(Value.Seven, Suit.Diamond),
                    new PlayingCard(Value.Ace, Suit.Spade),
                    new PlayingCard(Value.Nine, Suit.Club),
                    new PlayingCard(Value.Nine, Suit.Diamond),
                    new PlayingCard(Value.Five, Suit.Club),
                    new PlayingCard(Value.Queen, Suit.Heart),
                    new PlayingCard(Value.Queen, Suit.Diamond),
                    new PlayingCard(Value.Five, Suit.Heart),
                    new PlayingCard(Value.Jack, Suit.Spade),
                    new PlayingCard(Value.Jack, Suit.Diamond),
                    new PlayingCard(Value.Ace, Suit.Heart),
                    new PlayingCard(Value.Three, Suit.Heart),
                    new PlayingCard(Value.Two, Suit.Club),
                    new PlayingCard(Value.Nine, Suit.Club),
                    new PlayingCard(Value.Jack, Suit.Club),
                    new PlayingCard(Value.Jack, Suit.Heart),
                    new PlayingCard(Value.King, Suit.Diamond),
                    new PlayingCard(Value.Queen, Suit.Heart),
                    new PlayingCard(Value.Six, Suit.Diamond),
                    new PlayingCard(Value.Four, Suit.Heart),
                    new PlayingCard(Value.Four, Suit.Club),
                    new PlayingCard(Value.Queen, Suit.Club),
                    new PlayingCard(Value.Four, Suit.Diamond),
                    new PlayingCard(Value.Ace, Suit.Spade),
                    new PlayingCard(Value.Ace, Suit.Club),
                    new PlayingCard(Value.Four, Suit.Club),
                    new PlayingCard(Value.Eight, Suit.Club),
                    new PlayingCard(Value.Seven, Suit.Heart),
                    new PlayingCard(Value.Queen, Suit.Spade),
                    new PlayingCard(Value.Seven, Suit.Spade),
                    new PlayingCard(Value.Eight, Suit.Heart),
                    new PlayingCard(Value.King, Suit.Diamond),
                    new PlayingCard(Value.Four, Suit.Heart),
                    new PlayingCard(Value.Nine, Suit.Heart),
                    new PlayingCard(Value.Eight, Suit.Heart),
                    new PlayingCard(Value.Jack, Suit.Diamond),
                    new PlayingCard(Value.Five, Suit.Diamond),
                    new PlayingCard(Value.Two, Suit.Heart),
                    new PlayingCard(Value.Six, Suit.Club),
                    new PlayingCard(Value.Five, Suit.Heart),
                    new PlayingCard(Value.Jack, Suit.Club),
                    new PlayingCard(Value.Nine, Suit.Spade),
                    new PlayingCard(Value.Jack, Suit.Heart),
                    new PlayingCard(Value.Five, Suit.Diamond),
                    new PlayingCard(Value.Four, Suit.Diamond),
                    new PlayingCard(Value.Six, Suit.Diamond),
                    new PlayingCard(Value.Six, Suit.Club),
                    new PlayingCard(Value.King, Suit.Heart),
                    new PlayingCard(Value.Two, Suit.Spade),
                    new PlayingCard(Value.Eight, Suit.Spade),
                    new PlayingCard(Value.Three, Suit.Spade),
                    new PlayingCard(Value.Six, Suit.Heart),
                    new PlayingCard(Value.Jack, Suit.Spade),
                    new PlayingCard(Value.Ten, Suit.Club)));

    this.newDraw = new ArrayList<>(Arrays.asList(
            new PlayingCard(Value.Eight, Suit.Diamond), new PlayingCard(Value.Seven, Suit.Diamond),
            new PlayingCard(Value.Eight, Suit.Diamond)));
    this.null1 = null;
    this.t1 = new TriPeaks();
    t1.startGame(deck1, false, 7, 3);
    notStart = new TriPeaks(1, 1, null, this.newDraw, null, 0, false);
  }

  @Test(expected = NullPointerException.class)
  public void testStartGameENull() {
    null1.startGame(null, false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException1() {
    t1.startGame(null, false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException2() {
    t1.startGame(duplicate1, false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException3() {
    t1.startGame(t1.getDeck().subList(0, 5), false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException4() {
    t1.startGame(t1.getDeck(), false, 7, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException5() {
    t1.startGame(t1.getDeck(), false, -1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException6() {
    t1.startGame(t1.getDeck(), false, 5, -100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException7() {
    t1.startGame(t1.getDeck(), false, 100, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException8() {
    t1.startGame(duplicate2, false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException1() {
    t1.remove(7, 7, 8, 8);
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
    t1.remove(6, 1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException5() {
    t1.remove(6, 1, 6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException6() {
    t1.remove(6, 1);
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
    t1.remove(4, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException10() {
    t1.remove(9, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveException11() {
    t1.remove(6, 2, 6, 6);
    t1.remove(5, 5, 6, 5);
    t1.remove(6, 4);
    t1.remove(6, 3, 5, 2);
    t1.removeUsingDraw(0, 6, 1);
    t1.remove(6, 0, 5, 1);
    t1.remove(5, 4, 5, 3);
    t1.remove(4, 2);
    t1.remove(4, 1, 4, 3);
    t1.remove(5, 0, 3, 3);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException1() {
    t1.removeUsingDraw(10, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException2() {
    t1.removeUsingDraw(10, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException3() {
    t1.removeUsingDraw(0, 8, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException4() {
    t1.removeUsingDraw(0, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException5() {
    t1.removeUsingDraw(0, 6, 2);
  }

  @Test(expected = IllegalStateException.class)
  public void testRemoveUsingDrawException6() {
    notStart.removeUsingDraw(0, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawException1() {
    t1.discardDraw(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawException2() {
    t1.discardDraw(-1);
  }

  @Test(expected = IllegalStateException.class)
  public void testDiscardDrawException3() {
    notStart.discardDraw(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawException4() {
    for (int i = 0; i < 200; i++) {
      t1.discardDraw(0);
    }
  }

  @Test(expected = IllegalStateException.class)
  public void testGetRowWidthException1() {
    notStart.getRowWidth(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthException2() {
    t1.getRowWidth(7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthException3() {
    t1.getRowWidth(-1);
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
    t1.getCardAt(10, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException3() {
    t1.getCardAt(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException4() {
    t1.getCardAt(1, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException5() {
    t1.getCardAt(1, -10);
  }

  @Test(expected = IllegalStateException.class)
  public void testGetDrawCardsException() {
    notStart.getDrawCards();
  }

  @Test
  public void getRowWidth() {
    assertEquals(7, t1.getRowWidth(0));
    assertEquals(8, t1.getRowWidth(1));
    assertEquals(9, t1.getRowWidth(2));
    assertEquals(10, t1.getRowWidth(3));
    assertEquals(11, t1.getRowWidth(4));
    assertEquals(12, t1.getRowWidth(5));
    assertEquals(13, t1.getRowWidth(6));
  }

  @Test(expected = IllegalStateException.class)
  public void getRowWidthException1() {
    notStart.getRowWidth(5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getRowWidthException2() {
    t1.getRowWidth(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getRowWidthException3() {
    t1.getRowWidth(100);
  }

  @Test
  public void getDeck() {
    assertArrayEquals(noChange.toArray(), t1.getDeck().toArray());
  }

  @Test(expected = NullPointerException.class)
  public void testGetDeckNull() {
    null1.getDeck();
  }

  @Test
  public void startGame() {
    assertEquals(3, t1.getNumDraw());
    assertEquals(7, t1.getNumRows());
    assertEquals(406, t1.getScore());
    assertEquals(7, t1.getRowWidth(0));
    assertEquals(8, t1.getRowWidth(1));
  }

  @Test
  public void remove1() {
    t1.remove(6, 0);
    assertNull(t1.getCardAt(6, 0));
    for (int i = 0; i < 9; i++) {
      t1.discardDraw(0);
    }
    t1.removeUsingDraw(0, 6, 1);
    assertNull(t1.getCardAt(6, 1));
    t1.remove(5, 0, 6, 12);
    assertNull(t1.getCardAt(6, 0));
    assertNull(t1.getCardAt(6, 12));
  }

  @Test(expected = IllegalArgumentException.class)
  public void remove2() {
    t1.remove(6, 6, 7, 6);
  }

  @Test
  public void testDiscardDraw() {
    t1.discardDraw(0);
    assertEquals(newDraw, t1.getDrawCards());
  }

  @Test
  public void testGetNumRows() {
    assertEquals(7, t1.getNumRows());
    assertEquals(-1, notStart.getNumRows());
  }

  @Test
  public void testGetNumDraw() {
    assertEquals(104, deck1.size());
    assertEquals(3, t1.getNumDraw());
    assertEquals(-1, notStart.getNumDraw());
  }

  @Test
  public void getScore() {
    assertEquals(406, t1.getScore());
    t1.remove(6, 0);
    assertEquals(393, t1.getScore());
    for (int i = 0; i < 9; i++) {
      t1.discardDraw(0);
    }
    assertEquals(393, t1.getScore());
    t1.removeUsingDraw(0, 6, 1);
    assertEquals(392, t1.getScore());
  }


  @Test
  public void getCardAt() {
    assertEquals(new PlayingCard(Value.Ace, Suit.Spade), t1.getCardAt(0, 0));
  }

  @Test
  public void getDrawCards() {
    assertEquals(new ArrayList<>(Arrays.asList(
            new PlayingCard(Value.Seven, Suit.Diamond), new PlayingCard(Value.Seven, Suit.Diamond),
            new PlayingCard(Value.Eight, Suit.Diamond))), t1.getDrawCards());
    t1.discardDraw(0);
    assertEquals(newDraw, t1.getDrawCards());
  }

  @Test
  public void testRandom() {
    assertArrayEquals(noChange.toArray(), deck2.toArray());
    Collections.shuffle(deck2, new Random(0));
    assertArrayEquals(afterShuffle.toArray(), deck2.toArray());
  }

  @Test
  public void isGameOver() {
    assertFalse(t1.isGameOver());
    t1.remove(6, 0);
    for (int i = 0; i < 9; i++) {
      t1.discardDraw(0);
    }
    assertFalse(t1.isGameOver());
    t1.removeUsingDraw(0, 6, 1);
    t1.remove(5, 0, 6, 12);
    for (int j = 0; j < 28; j++) {
      t1.discardDraw(0);
    }
    t1.discardDraw(1);
    t1.discardDraw(2);
    assertTrue(t1.isGameOver());
  }
}