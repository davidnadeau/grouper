enablePlugins(ScalaJSPlugin)

name := "grouper"

version := "1.0"

scalaVersion := "2.11.7"

scalaJSUseRhino in Global := false
skip in packageJSDependencies := false

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.8.1"
libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.4.6"