//import sbt.Keys._
//import sbt.{Credentials, _}
//import sbtrelease.ReleasePlugin.autoImport.{releaseProcess, ReleaseStep}
//import sbtrelease.ReleaseStateTransformations._
//
//object Publish {
//  val user = sys.env.getOrElse("GITHUB_USER", "")
//  val token = sys.env.getOrElse("GITHUB_TOKEN", "")
//  val realm = "GitHub audienseco Apache Maven Packages"
//
//  val settings = Seq(
//    publishTo := Some(realm at "https://maven.pkg.github.com/audienseco/scalafmt"),
//    credentials += Credentials("GitHub Package Registry", "maven.pkg.github.com", user, token),
//    publishMavenStyle := true,
//    releaseProcess := Seq[ReleaseStep](
//      checkSnapshotDependencies, // : ReleaseStep
//      inquireVersions, // : ReleaseStep
//      setReleaseVersion, // : ReleaseStep
//      commitReleaseVersion, // : ReleaseStep, performs the initial git checks
//      tagRelease, // : ReleaseStep
//      publishArtifacts, // : ReleaseStep, checks whether `publishTo` is properly set up
//      setNextVersion, // : ReleaseStep
//      commitNextVersion // : ReleaseStep
//    )
//  )
//}

import sbt.Keys._
import sbt._
import sbtrelease.ReleasePlugin.autoImport.{ReleaseStep, releaseCrossBuild, releaseProcess}
import sbtrelease.ReleaseStateTransformations._

object Publish {
  val realm = "GitHub audienseco Apache Maven Packages"
  def createPublisherSettings(githubUrl: String) = {
    Seq(
      publishTo := Some(realm at githubUrl),
      publishMavenStyle := true,
      releaseCrossBuild := true,
      releaseProcess := Seq[ReleaseStep](
        checkSnapshotDependencies, // : ReleaseStep
        inquireVersions, // : ReleaseStep
        setReleaseVersion, // : ReleaseStep
        commitReleaseVersion, // : ReleaseStep, performs the initial git checks
        tagRelease, // : ReleaseStep
        publishArtifacts, // : ReleaseStep, checks whether `publishTo` is properly set up
        setNextVersion, // : ReleaseStep
        commitNextVersion // : ReleaseStep
      )
    )
  }
}