import sbt.Keys._
import sbt.librarymanagement.ivy.Credentials

object CredentialsManager {
  private val readOnlyUser = "deploy-systems"
  private val readOnlyToken = "0fdedf9430c0a1fc530904933eb7bab9d61ee114"

  def githubCredentials() = {
    var user = sys.env.getOrElse("GITHUB_USER", "")
    var token = sys.env.getOrElse("GITHUB_TOKEN", "")
    if (token == "") {
      user = readOnlyUser
      token = readOnlyToken
    }
    credentials += Credentials("GitHub Package Registry", "maven.pkg.github.com", user, token)
  }
}