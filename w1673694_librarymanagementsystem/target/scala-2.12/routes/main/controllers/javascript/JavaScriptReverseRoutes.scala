// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/thinura/My Documents/IIT/5COSC001W-OOP/Assignments/Library Management System /w1673694_librarymanagementsystem/conf/routes
// @DATE:Sat Dec 08 11:32:17 IST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:9
package controllers.javascript {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseBookController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def addBook: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.addBook",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "library/book"})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseDVDController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def addDVD: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DVDController.addDVD",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "library/dvd"})
        }
      """
    )
  
  }

  // @LINE:21
  class ReverseReaderController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def addReader: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ReaderController.addReader",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "library/reader"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def deleteItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.deleteItem",
      """
        function(isbn0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "library/delete/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("isbn", isbn0))})
        }
      """
    )
  
    // @LINE:30
    def borrowItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.borrowItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "library/borrow"})
        }
      """
    )
  
    // @LINE:12
    def getTotalItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getTotalItem",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "library/total"})
        }
      """
    )
  
    // @LINE:24
    def displayItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.displayItem",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "library/display"})
        }
      """
    )
  
    // @LINE:33
    def returnItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.returnItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "library/return"})
        }
      """
    )
  
    // @LINE:39
    def searchTitle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.searchTitle",
      """
        function(title0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "library/search/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("title", title0))})
        }
      """
    )
  
    // @LINE:36
    def generateReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.generateReport",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "library/generateReport"})
        }
      """
    )
  
  }


}
