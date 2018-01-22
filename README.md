# **GUI Chess** By Jerry Sun and Weiwen Zhou Pd 9 #

# Instructions

The basic goal of Chess is to capture the enemy's king. Each piece has a different set of possible
moves that allow players to play strategically. It's no wonder Chess has become a popular worldwide
strategy game. For a more in-depth guide, please click [here](http://www.chesscorner.com/tutorial/learn.htm).

# How To Play

![GUI](Icons/GUI.png "GUI")

1. Grab a friend. You're gonna need someone to play against (unless you're confident you can beat yourself!)
2. Compile and run Main.java. javac Main.java 
    Possible commands to run. 
    a. java Main [WhitePlayerName] [BlackPlayerName] [width] [height] [timer]
    b. java Main [width] [height] [timer]
    c. java Main [WhitePlayerName] [BlackPlayerName] 
    d. java Main [timer]
3. Your timer has started! Click one of your colored pieces, then click on one of the highlighted tiles to move/capture an enemy.
Click on the selected piece or an unhighlighted tile to cancel.
4. Play through the game. Beware, there are a bunch of additionals features, like Checkmate and Promotion, to read about below.
5. Capture the enemy king or your opponent runs out of time and you win! Pat yourself on the back and take a break. 

# Features

## Gameplay ##
- Movable pieces with available moves highlighted
- Check: you can only move your king
- Promotion: when a pawn reaches the opposite side of the board, can be "promoted" to a selected piece

## GUI ##
- Piece icons
- Highlighting possible moves
- Window size that is in ratio to user full screen size
- Alternating colored tiles
- Top bar and left bar for easy coordinate locations
- Individual timers for each player
- Top level menu with:
- "Options" drop down
1. "New Game" button to reset board
2. "Save" to write current piece placement into a txt file
1. "Load" to read a txt file and place pieces in saved locations
- "Help" drop down
1. "View Help" for brief instructions

# To Be Added
- Separate buffer on the right side to show what pieces are selected, what move just happened, if check, etc.
- Title screen!
- Checkmate
- Castling

# Bugs/Limitations
- Checkmate is not functional: game ends by killing the enemy king or running out of time
- Cancelling a save/load will close the entire window
- Saving into an existing, non-empty txt file will cause an arrow, as save overwrite as opposed to rewrites

# **Testing**
Load these files to test certain features:
- Default.txt for the basic setup
- Move.txt for all the piece movements
- Check.txt for an enemy check situation
- Promotion.txt for a pawn promotion

