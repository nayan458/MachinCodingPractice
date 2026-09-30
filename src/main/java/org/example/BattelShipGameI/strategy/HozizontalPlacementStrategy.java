package org.example.BattelShipGameI.strategy;

import java.util.ArrayList;
import java.util.List;

public class HozizontalPlacementStrategy implements IPlacementStrategy {
    @Override
    public List<int[]> getOffSet(int[][] offsets) {
        List<int[]> horizontalOffsets = new ArrayList<>();

        for (int[] offset : offsets) {
            horizontalOffsets.add(new int[]{offset[1], offset[0]});
        }

        return horizontalOffsets;
    }
}