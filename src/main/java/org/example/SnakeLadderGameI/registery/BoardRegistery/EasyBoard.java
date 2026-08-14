package org.example.SnakeLadderGameI.registery.BoardRegistery;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.example.SnakeLadderGameI.abstractModel.Board;
import org.example.SnakeLadderGameI.util.RandomUtil;

public class EasyBoard extends Board {
	public EasyBoard() {
		super(30, buildJumps(30, 2, 6));
	}

	private static Map<Integer, Integer> buildJumps(int size, int snakes, int ladders) {
		Map<Integer, Integer> j = new HashMap<>();
		Set<Integer> used = new HashSet<>();

		// ladders: start < end
		for (int i = 0; i < ladders; i++) {
			int start, end;
			do {
				start = RandomUtil.randomInt(2, size - 2);
				end = RandomUtil.randomInt(start + 1, size - 1);
			} while (used.contains(start) || used.contains(end));
			used.add(start); used.add(end);
			j.put(start, end);
		}

		// snakes: start > end
		for (int i = 0; i < snakes; i++) {
			int start, end;
			do {
				start = RandomUtil.randomInt(3, size - 1);
				end = RandomUtil.randomInt(2, start - 1);
			} while (used.contains(start) || used.contains(end));
			used.add(start); used.add(end);
			j.put(start, end);
		}

		return j;
	}
}
