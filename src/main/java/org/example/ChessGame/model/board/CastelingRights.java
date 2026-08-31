package org.example.ChessGame.model.board;

import org.example.genericUtils.interfaces.Clonable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CastelingRights implements Clonable<CastelingRights> {
    private boolean kingSideCastelingRight;
    private boolean queenSideCastelingRight;

    public CastelingRights() {
        this.kingSideCastelingRight = false;
        this.queenSideCastelingRight = false;
    }

    public CastelingRights(CastelingRights rights) {
        this.kingSideCastelingRight = rights.kingSideCastelingRight;
        this.queenSideCastelingRight = rights.queenSideCastelingRight;
    }

    @Override
    public CastelingRights cloneObject() {
        return new CastelingRights(this);
    }
    
    public void revokeQueenSideCastelingRight () { queenSideCastelingRight = false; }
    public void revokeKingSideCastelingRight () { kingSideCastelingRight = false; }
}
