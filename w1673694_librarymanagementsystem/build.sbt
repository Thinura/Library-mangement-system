name := """w1673694_LibraryManagementSystem"""
organization := "Westminster"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.12.7"

libraryDependencies += guice

libraryDependencies += javaJdbc
libraryDependencies += jdbc
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"