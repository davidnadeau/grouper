enablePlugins(ScalaJSPlugin)

name := "grouper"

version := "1.0"

scalaVersion := "2.11.7"

scalaJSUseRhino in Global := false
skip in packageJSDependencies := false

// core = essentials only. No bells or whistles.
libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "0.10.4"
libraryDependencies += "com.github.japgolly.scalajs-react" %%% "extra" % "0.10.4"
libraryDependencies += "com.lihaoyi" %%% "upickle" % "0.2.7"

// React JS itself (Note the filenames, adjust as needed, eg. to remove addons.)
jsDependencies ++= Seq(
  "org.webjars.bower" % "react" % "0.14.3"
    / "react-with-addons.js"
    minified "react-with-addons.min.js"
    commonJSName "React",

  "org.webjars.bower" % "react" % "0.14.3"
    / "react-dom.js"
    minified "react-dom.min.js"
    dependsOn "react-with-addons.js"
    commonJSName "ReactDOM"
)
