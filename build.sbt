ThisBuild / tlBaseVersion := "0.0"

ThisBuild / developers := List(
  tlGitHubDev("BalmungSan", "Luis Miguel Mejía Suárez"),
  tlGitHubDev("armanbilge", "Arman Bilge"),
)
ThisBuild / startYear := Some(2022)

ThisBuild / crossScalaVersions := Seq("3.2.1", "2.13.10")

val http4sVersion = "0.23.16"
val munitCEVersion = "2.0.0-M3"

lazy val root = project.in(file(".")).enablePlugins(NoPublishPlugin).aggregate(monadicDsl)

lazy val monadicDsl = project
  .in(file("monadic-dsl"))
  .settings(
    name := "monadic-dsl",
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-core" % http4sVersion,
      "org.typelevel" %%% "munit-cats-effect" % munitCEVersion % Test,
    ),
  )
