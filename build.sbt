name := "scala-spring5-regbean"

version := "0.1"

scalaVersion := "2.12.5"

libraryDependencies += "org.springframework.boot" % "spring-boot-starter-webflux" % "2.0.1.RELEASE"
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-data-mongodb" % "2.0.1.RELEASE"
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-security" % "2.0.1.RELEASE"
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-data-jpa" % "2.0.1.RELEASE"
libraryDependencies += "org.hsqldb" % "hsqldb" % "2.3.1"


mainClass in (Compile, run) := Some("com.yunjae.regbean.ApplicationMain")