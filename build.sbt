name := "event-collector-lambda"

version := "0.1"

scalaVersion := "2.12.8"

enablePlugins(ScalaJSPlugin)

resolvers += Resolver.jcenterRepo

//scalaJSUseMainModuleInitializer := true

// ECMAScript
scalaJSLinkerConfig ~= {
  _.withModuleKind(ModuleKind.ESModule)
}

val circeVersion = "0.10.0"

libraryDependencies ++= Seq(
  "org.typelevel" %%% "cats-effect" % "1.2.0",
  "io.circe" %%% "circe-core" % circeVersion,
  "io.circe" %%% "circe-generic" % circeVersion,
  "io.circe" %%% "circe-parser" % circeVersion,
)