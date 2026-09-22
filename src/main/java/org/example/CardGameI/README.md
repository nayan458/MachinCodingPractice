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

## Design overview

- `type/` — `Suit`, `Rank` (rank carries its comparison value), `GameStatus`.
- `model/` — `Card` (immutable, `Comparable`), `Deck` (interface) + `StandardDeck` (52-card impl),
  `Player` (holds hand, `receiveCard`/`showCards`), `Dealer` (single responsibility: distribute cards).
- `strategy/` — `IWinningStrategy` (Strategy pattern) with `HighestCardWinningStrategy` and
  `HighestHandSumWinningStrategy` as interchangeable scoring mechanisms.
- `rule/` — `GameRule` (one rule per class, e.g. `PlayerCountRule`, `SufficientDeckSizeRule`) composed
  by `RuleValidator`, which `Game.start()` runs before dealing.
- `game/Game` — built via a `Builder` (players, deck, dealer, rule validator, winning strategy all
  injectable), owns `GameStatus` transitions (`NOT_STARTED -> IN_PROGRESS -> COMPLETED`).

Extending the game (new rules, new scoring, new deck types, bot players, etc.) means adding a new
class that implements `GameRule`, `IWinningStrategy`, or `Deck` — `Game` never needs to change.


////////
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


p1,p2 
- > enter
- > dealer deals crd
- > both p1 and p2 put their card and revils the card simultaniously.
- > switch () {
    Normal: 
        if (p1.card > p2.card) {
            p1 wins
        } else if (p1.card < p2.card) {
            p2 wins
        } else {
            war: 
                -> both players put down three cards face down and one card face up.
                -> compare the face up cards again.
                -> continue this process until one player wins the war or runs out of cards.
        }
} 
- > continue playing until one player has all the cards or a predetermined number of rounds is reached.