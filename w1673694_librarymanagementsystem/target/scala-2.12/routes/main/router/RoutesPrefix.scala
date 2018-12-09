// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/thinura/My Documents/IIT/5COSC001W-OOP/Assignments/Library Management System /w1673694_librarymanagementsystem/conf/routes
// @DATE:Sat Dec 08 11:32:17 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
