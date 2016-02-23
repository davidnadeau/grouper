package com.nadeau.grouper.components

import com.nadeau.grouper.App.{Pages, Groupify}
import com.nadeau.grouper.models.Task
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object TaskList {

  case class State(tasks: List[Task] = List(), newTask: Task = Task())

  class Backend($: BackendScope[Unit, State]) {
    def addTask(newTasks: List[Task]): Callback = {
      $.modState(_.copy(tasks = newTasks, Task()))
    }

    def textChange(e: ReactEventI): Callback = {
      $.modState(_.copy($.state.runNow().tasks, Task(e.target.value)))
    }

    def render(state: State) = <.div(
      <.input(
        ^.placeholder := "Task",
        ^.value := state.newTask.title,
        ^.onChange ==> textChange
      ),
      <.button(
        "Add Task",
        ^.onClick --> addTask(state.newTask :: state.tasks)
      ),
      <.ul(
        for {
          task <- state.tasks
        } yield <.li(task.title)
      )
    )
  }

  def apply(): ReactElement =
    component()

  private val component = ReactComponentB[Unit]("Task List")
    .initialState(State())
    .renderBackend[Backend]
    .buildU

}
