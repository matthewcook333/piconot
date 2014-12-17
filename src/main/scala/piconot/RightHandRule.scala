package piconot

import java.io.File

import picolib.maze.Maze
import picolib.semantics.GUIDisplay
import picolib.semantics.Picobot
import picolib.semantics.TextDisplay
import picolib.semantics.Rule

import scalafx.application.JFXApp

object RightHandRule extends JFXApp {
  val emptyMaze = Maze("resources" + File.separator + "maze.txt")
  
  val rules = makeRules(
	N ->(R, F, L, B),
	S ->(R, F, L, B),
	E ->(R, F, L, B),
	W ->(R, F, L, B)
  )
    
  object RightHandBot extends Picobot(emptyMaze, rules)
  		with TextDisplay with GUIDisplay

  stage = RightHandBot.mainStage
}