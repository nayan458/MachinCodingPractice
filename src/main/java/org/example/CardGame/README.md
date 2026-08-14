Q4. Card Game Class Diagram Design

Design class diagram for a simple card game.

A standard deck of cards consists of 52 cards, divided into four suits: Hearts, Diamonds, Clubs, and Spades. Each suit has 13 ranks: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, and Ace.

Requirements:

Model the following entities: Card, Deck, Player, and Game.
Each Card has a suit and a rank.
Deck should support the following operations:
Shuffle the cards.
Deal a card to a player.
Return the number of remaining cards.
The game supports multiple players, but for simplicity, assume a maximum of 4 players.
Each Player has:
A hand of cards.
An operation to receive a card.
An operation to show their cards.
Game should be able to:
Start a new game.
Distribute cards to players.
Declare a winner based on some simple criteria (e.g., the player with the highest card).
The game should have a state, such as NOT_STARTED, IN_PROGRESS, or COMPLETED.
Design flexibility to add new rules or scoring mechanisms in the future.
There should be a class or method to validate the game rules.