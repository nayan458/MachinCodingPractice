package org.example.BattelShipGameI.strategy;

import java.util.List;

public interface IPlacementStrategy {
    List<int[]> getOffSet(int[][] offset);
}
