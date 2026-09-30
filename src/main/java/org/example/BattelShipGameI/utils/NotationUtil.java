package org.example.BattelShipGameI.utils;

import org.example.BattelShipGameI.exception.IndexOutOfBoundsException;
import org.example.BattelShipGameI.exception.InvalidNotaionException;

public final class NotationUtil {
    public static int[] resolveCellIndex(String notation) throws Exception {
        String[] indices = validateNotation(notation);
        
        int row = Integer.valueOf(indices[0]);
        int col = Integer.valueOf(indices[1]);

        return new int[]{row, col};
    }

    public static String getNotation(int row, int col) throws IndexOutOfBoundsException {
        if(row < 0 || col < 0)
            throw new IndexOutOfBoundsException("Index cannot be negative");
        return String.valueOf(row) + "," + String.valueOf(col);
    }

    private static String[] validateNotation(String notation) throws InvalidNotaionException {
        String[] indices = notation.split(",");
        
        if(indices.length != 2)
            throw new InvalidNotaionException("A valid notation consist of row and col seperated by comma");
        
        for(String s: indices) {
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch < 0 || ch > 9)
                    throw new InvalidNotaionException("Index should be numeric");
            }
        }

        return indices;
    }
}
