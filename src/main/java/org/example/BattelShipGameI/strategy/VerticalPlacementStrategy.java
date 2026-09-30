package org.example.BattelShipGameI.strategy;

import java.util.ArrayList;
import java.util.List;

public class VerticalPlacementStrategy implements IPlacementStrategy {
    @Override
    public List<int[]> getOffSet(int[][] offsets) {
        List<int[]> verticalOffsets = new ArrayList<>();

        for(int[] offset: offsets) 
            verticalOffsets.add(offset);
        return verticalOffsets;
    }
}
