package piconot

import java.io.File
import picolib.maze.Maze
import picolib.semantics.Anything
import picolib.semantics.Blocked
import picolib.semantics.East
import picolib.semantics.GUIDisplay
import picolib.semantics.North
import picolib.semantics.Open
import picolib.semantics.Picobot
import picolib.semantics.Rule
import picolib.semantics.South
import picolib.semantics.State
import picolib.semantics.Surroundings
import picolib.semantics.TextDisplay
import picolib.semantics.West
import scalafx.application.JFXApp
import scala.collection.mutable.MutableList

/* This is an intentionally GOOD internal language */

object PriorityBotAPI extends JFXApp {

}


class PriorityRule {  
  def ->()
  
  
  
  
}

// state we are in
abstract class CardinalState(val name: Char)

object N extends CardinalState('N') {
  def ->(directions: List[RelativeDirection]) {
    // have a nice requires here for 4 directions
    
    var listOfRules = new MutableList[Rule]
    var blockedDirs = new Surroundings(Anything, Anything, Anything, Anything)
    directions.foreach(direction => direction match {
      case F => 
        listOfRules += new Rule(State("0"),
            Surroundings(Open, blockedDirs.east, blockedDirs.west, blockedDirs.south),
            North,
            State("0"))
        blockedDirs = new Surroundings(Blocked, blockedDirs.east, blockedDirs.west, blockedDirs.south)
      case B =>
      case L =>
      case R =>
      case _ =>
    }
    )
    
  } 
}
// make a mapping of this, and make the states the "MoveDirection". That way
// we can generalize to just implement in cardinal state
map ((cardinalState, direction) => (MoveDirection)

object S extends CardinalState('S')

object E extends CardinalState('E')

object W extends CardinalState('W')

// direction moving relative
abstract class RelativeDirection(val name: Char)

object F extends RelativeDirection('F')

object B extends RelativeDirection('B')

object L extends RelativeDirection('L')

object R extends RelativeDirection('R')




