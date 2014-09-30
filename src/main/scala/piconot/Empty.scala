package piconot

import java.io.File

import picolib.maze.Maze
import picolib.semantics.GUIDisplay
import picolib.semantics.Picobot
import picolib.semantics.TextDisplay
import picolib.semantics.Rule

import scalafx.application.JFXApp

object Empty extends JFXApp {
  val emptyMaze = Maze("resources" + File.separator + "empty.txt")
  
  val rules = makeRules(
	N ->(F, R, L, B),
	S ->(F, L, B, R),
	E ->(R, L, F, B),
	W ->(F, L, R, B)
  )
    
  object EmptyBot extends Picobot(emptyMaze, rules)
  		with TextDisplay with GUIDisplay

  stage = EmptyBot.mainStage
}