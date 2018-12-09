// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/thinura/My Documents/IIT/5COSC001W-OOP/Assignments/Library Management System /w1673694_librarymanagementsystem/conf/routes
// @DATE:Sat Dec 08 11:32:17 IST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:9
package controllers {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:15
  class ReverseBookController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def addBook(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "library/book")
    }
  
  }

  // @LINE:18
  class ReverseDVDController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def addDVD(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "library/dvd")
    }
  
  }

  // @LINE:21
  class ReverseReaderController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def addReader(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "library/reader")
    }
  
  }

  // @LINE:12
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def deleteItem(isbn:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "library/delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("isbn", isbn)))
    }
  
    // @LINE:30
    def borrowItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "library/borrow")
    }
  
    // @LINE:12
    def getTotalItem(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "library/total")
    }
  
    // @LINE:24
    def displayItem(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "library/display")
    }
  
    // @LINE:33
    def returnItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "library/return")
    }
  
    // @LINE:39
    def searchTitle(title:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "library/search/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("title", title)))
    }
  
    // @LINE:36
    def generateReport(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "library/generateReport")
    }
  
  }


}
