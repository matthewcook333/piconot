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
  
  val rules = List(
	N arrow(F, R, L, B),
	S arrow(F, L, B, R),
	E arrow(R, L, F, B),
	W arrow(F, L, R, B)
  ).flatten
  
  object EmptyBot extends Picobot(emptyMaze, rules)
  		with TextDisplay with GUIDisplay

  stage = EmptyBot.mainStage
}