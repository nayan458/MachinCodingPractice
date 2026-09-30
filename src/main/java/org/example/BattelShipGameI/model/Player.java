package org.example.BattelShipGameI.model;

import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class Player {
    private final String name;
    private Scanner sc;

    public String getName() { return name; }
    public String makeMove() {
        String move = sc.nextLine();
        return move;
    }
}
