name := "Polyglot_test_app"

version := "1.0"
//liftVersion <<= liftVersion ?? "2.4"
//version <<= liftVersion apply { _ + "-0.6.0-SNAPSHOT" }

scalaVersion := "2.9.1"

resolvers ++= Seq(
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"
)

//Test
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.8" % "test",
  "org.scalatest" % "scalatest_2.9.0" % "1.6.1" % "test",
  "org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725" % "test"
)


//Main
libraryDependencies ++= {
  val liftVersion = "2.5-SNAPSHOT"//"2.4-M4"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion,
    "net.liftweb" %% "lift-mapper" % liftVersion,
    "net.liftweb" %% "lift-wizard" % liftVersion,
    "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
    "net.liftweb" %% "lift-textile" % liftVersion % "compile->default",
	"net.liftmodules" %% "polyglot" % (liftVersion+"-0.1-SNAPSHOT")   
  )
}



seq(webSettings :_*)

// If using JRebel
scanDirectories in Compile := Nil

libraryDependencies += "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"

