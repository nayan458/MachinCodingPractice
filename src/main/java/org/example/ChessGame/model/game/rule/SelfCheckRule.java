package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.IllegalMoveException;
import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.factory.MoveFactory;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.model.game.gameEvaluator.AttackDetector;
import org.example.ChessGame.model.game.move.Move;
import org.example.ChessGame.utils.MoveTypeEvaluator;
import org.example.ChessGame.utils.NotationUtils;

public class SelfCheckRule extends Rule {

    @Override
    protected void validate(GameContext ctx, Board board) throws RuleViolationException, IllegalMoveException {
        System.out.println("Validator: Self check rule triggered");
        Board simulation = board.cloneObject();

        Cell simulatedFrom = simulation.getCell(NotationUtils.getIndex(ctx.getFrom()));
        Cell simulatedTo = simulation.getCell(NotationUtils.getIndex(ctx.getTo()));

        GameContext simulatedCtx = new GameContext(
            ctx.getPlayer(),
            simulatedFrom.getPiece(),
            simulatedFrom,
            simulatedTo,
            ctx.getMove(),
            ctx.getPrevious()
        );

        Move move = MoveFactory.getMove(MoveTypeEvaluator.evaluateMoveType(simulatedCtx), simulatedCtx);
        move.apply(simulation);
        if(AttackDetector.isAttacked(simulation.findKing(move.getPlayer().getColor()), move.getPlayer().getColor(), simulation)) {
            throw new RuleViolationException("Illegal move, after the move your king is in check");
        }
        System.out.println("Self check Rule: Passed ✅ ");
    }
}
