package org.example.CardGameI.strategy.evaluationStrategy;

import java.util.Map;

import org.example.CardGameI.model.card.Card;
import org.example.CardGameI.model.deck.Deck;
import org.example.CardGameI.model.player.Player;
import org.example.CardGameI.model.round.Round;
import org.example.CardGameI.type.GameResult;
import org.example.CardGameI.type.Rank;
import org.example.CardGameI.type.Suit;

public class LastCardWinStrategy implements IRoundEvaluationStrategy {
    @Override
    public GameResult evaluate(Round round) {

        Map<Player, Deck> hm = round.getCardsPlayed();
        Card max = new Card(Suit.DUMMY, Rank.MIN);
        Player maxCardPlayer = null;
        
        for(Map.Entry<Player, Deck> entry: hm.entrySet()) {
            Player player = entry.getKey();
            try {
                Card card = entry.getValue().getLast();
                if(card.compareTo(max) > 0) {
                    max = card;
                    maxCardPlayer = player;
                } else if(card.compareTo(max) == 0) {
                    maxCardPlayer = null;
                }
            } catch (Exception e) {

            }
        }

        if(maxCardPlayer != null) {
            round.setRoundWinner(maxCardPlayer);
            round.setStatus(GameResult.WIN);
        } else {
            round.setStatus(GameResult.TIE);
        }


        return round.getStatus();
    }
}
