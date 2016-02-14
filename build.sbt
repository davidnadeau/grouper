enablePlugins(ScalaJSPlugin)

name := "grouper"

version := "1.0"

scalaVersion := "2.11.7"

scalaJSUseRhino in Global := false
skip in packageJSDependencies := false

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.2"
libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.4.6"