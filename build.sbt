name := "untitled3"

version := "0.1"

scalaVersion := "2.11.8"

val sparkVersion = "2.1.0"

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/",
  "DefaultMavenRepository" at "http://repo1.maven.org/maven2/"
)

resolvers += Resolver.url("sbt-plugin-releases",
  new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)

resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

val specs2Version = "3.9.1"


libraryDependencies ++= Seq(
  "com.jsuereth" %% "scala-arm" % "2.0",
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-graphx" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "org.specs2" %% "specs2-core" % specs2Version,
  "org.specs2" %% "specs2-junit" % specs2Version,
  "org.specs2" %% "specs2-mock" % specs2Version,
  "org.scalacheck" %% "scalacheck" % "1.14.0",
  "org.scalatest" %% "scalatest" % "3.0.5",
  "net.liftweb" %% "lift-json" % "3.3.0-M1",
  "com.google.code.gson" % "gson" % "2.8.2",
  "org.json4s" %% "json4s-native" % "3.6.0-M2",
  "org.json4s" %% "json4s-jackson" % "3.6.0-M2",
  "com.typesafe.akka" %% "akka-actor" % "2.4.0",
  "org.scalactic" %% "scalactic" % "2.2.0-M1",
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.2.0",
  "org.scala-lang.modules" %% "scala-async" % "0.9.7",
  "com.chuusai" %% "shapeless" % "2.3.3"
)



libraryDependencies += "joda-time" % "joda-time" % "2.1"

libraryDependencies += "org.joda" % "joda-convert" % "1.3"