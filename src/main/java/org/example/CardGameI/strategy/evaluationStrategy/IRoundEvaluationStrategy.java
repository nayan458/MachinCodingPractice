package org.example.CardGameI.strategy.evaluationStrategy;

import org.example.CardGameI.model.round.Round;
import org.example.CardGameI.type.GameResult;

public interface IRoundEvaluationStrategy {
    public GameResult evaluate (Round round);
}
