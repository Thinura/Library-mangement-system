// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/thinura/My Documents/IIT/5COSC001W-OOP/Assignments/Library Management System /w1673694_librarymanagementsystem/conf/routes
// @DATE:Sat Dec 08 11:32:17 IST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:9
  Assets_4: controllers.Assets,
  // @LINE:12
  HomeController_1: controllers.HomeController,
  // @LINE:15
  BookController_0: controllers.BookController,
  // @LINE:18
  DVDController_3: controllers.DVDController,
  // @LINE:21
  ReaderController_2: controllers.ReaderController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:9
    Assets_4: controllers.Assets,
    // @LINE:12
    HomeController_1: controllers.HomeController,
    // @LINE:15
    BookController_0: controllers.BookController,
    // @LINE:18
    DVDController_3: controllers.DVDController,
    // @LINE:21
    ReaderController_2: controllers.ReaderController
  ) = this(errorHandler, Assets_4, HomeController_1, BookController_0, DVDController_3, ReaderController_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_4, HomeController_1, BookController_0, DVDController_3, ReaderController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """library/total""", """controllers.HomeController.getTotalItem"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """library/book""", """controllers.BookController.addBook()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """library/dvd""", """controllers.DVDController.addDVD()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """library/reader""", """controllers.ReaderController.addReader()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """library/display""", """controllers.HomeController.displayItem()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """library/delete/""" + "$" + """isbn<[^/]+>""", """controllers.HomeController.deleteItem(isbn:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """library/borrow""", """controllers.HomeController.borrowItem()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """library/return""", """controllers.HomeController.returnItem()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """library/generateReport""", """controllers.HomeController.generateReport()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """library/search/""" + "$" + """title<[^/]+>""", """controllers.HomeController.searchTitle(title:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:9
  private[this] lazy val controllers_Assets_versioned0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned0_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_getTotalItem1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("library/total")))
  )
  private[this] lazy val controllers_HomeController_getTotalItem1_invoker = createInvoker(
    HomeController_1.getTotalItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getTotalItem",
      Nil,
      "GET",
      this.prefix + """library/total""",
      """ To return total amount item""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_BookController_addBook2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("library/book")))
  )
  private[this] lazy val controllers_BookController_addBook2_invoker = createInvoker(
    BookController_0.addBook(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "addBook",
      Nil,
      "POST",
      this.prefix + """library/book""",
      """ Add book to library""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_DVDController_addDVD3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("library/dvd")))
  )
  private[this] lazy val controllers_DVDController_addDVD3_invoker = createInvoker(
    DVDController_3.addDVD(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DVDController",
      "addDVD",
      Nil,
      "POST",
      this.prefix + """library/dvd""",
      """ Add DVD to library""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_ReaderController_addReader4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("library/reader")))
  )
  private[this] lazy val controllers_ReaderController_addReader4_invoker = createInvoker(
    ReaderController_2.addReader(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReaderController",
      "addReader",
      Nil,
      "POST",
      this.prefix + """library/reader""",
      """ Add reader to library""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_HomeController_displayItem5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("library/display")))
  )
  private[this] lazy val controllers_HomeController_displayItem5_invoker = createInvoker(
    HomeController_1.displayItem(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "displayItem",
      Nil,
      "GET",
      this.prefix + """library/display""",
      """ To return all the data""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_HomeController_deleteItem6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("library/delete/"), DynamicPart("isbn", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_deleteItem6_invoker = createInvoker(
    HomeController_1.deleteItem(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "deleteItem",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """library/delete/""" + "$" + """isbn<[^/]+>""",
      """ Delete an Item""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_HomeController_borrowItem7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("library/borrow")))
  )
  private[this] lazy val controllers_HomeController_borrowItem7_invoker = createInvoker(
    HomeController_1.borrowItem(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "borrowItem",
      Nil,
      "POST",
      this.prefix + """library/borrow""",
      """ Borrow an Item""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_HomeController_returnItem8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("library/return")))
  )
  private[this] lazy val controllers_HomeController_returnItem8_invoker = createInvoker(
    HomeController_1.returnItem(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "returnItem",
      Nil,
      "POST",
      this.prefix + """library/return""",
      """ Return an Item""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_HomeController_generateReport9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("library/generateReport")))
  )
  private[this] lazy val controllers_HomeController_generateReport9_invoker = createInvoker(
    HomeController_1.generateReport(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "generateReport",
      Nil,
      "GET",
      this.prefix + """library/generateReport""",
      """ Generate a report""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_HomeController_searchTitle10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("library/search/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_searchTitle10_invoker = createInvoker(
    HomeController_1.searchTitle(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "searchTitle",
      Seq(classOf[String]),
      "GET",
      this.prefix + """library/search/""" + "$" + """title<[^/]+>""",
      """ Search by Title""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:9
    case controllers_Assets_versioned0_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned0_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:12
    case controllers_HomeController_getTotalItem1_route(params@_) =>
      call { 
        controllers_HomeController_getTotalItem1_invoker.call(HomeController_1.getTotalItem)
      }
  
    // @LINE:15
    case controllers_BookController_addBook2_route(params@_) =>
      call { 
        controllers_BookController_addBook2_invoker.call(BookController_0.addBook())
      }
  
    // @LINE:18
    case controllers_DVDController_addDVD3_route(params@_) =>
      call { 
        controllers_DVDController_addDVD3_invoker.call(DVDController_3.addDVD())
      }
  
    // @LINE:21
    case controllers_ReaderController_addReader4_route(params@_) =>
      call { 
        controllers_ReaderController_addReader4_invoker.call(ReaderController_2.addReader())
      }
  
    // @LINE:24
    case controllers_HomeController_displayItem5_route(params@_) =>
      call { 
        controllers_HomeController_displayItem5_invoker.call(HomeController_1.displayItem())
      }
  
    // @LINE:27
    case controllers_HomeController_deleteItem6_route(params@_) =>
      call(params.fromPath[String]("isbn", None)) { (isbn) =>
        controllers_HomeController_deleteItem6_invoker.call(HomeController_1.deleteItem(isbn))
      }
  
    // @LINE:30
    case controllers_HomeController_borrowItem7_route(params@_) =>
      call { 
        controllers_HomeController_borrowItem7_invoker.call(HomeController_1.borrowItem())
      }
  
    // @LINE:33
    case controllers_HomeController_returnItem8_route(params@_) =>
      call { 
        controllers_HomeController_returnItem8_invoker.call(HomeController_1.returnItem())
      }
  
    // @LINE:36
    case controllers_HomeController_generateReport9_route(params@_) =>
      call { 
        controllers_HomeController_generateReport9_invoker.call(HomeController_1.generateReport())
      }
  
    // @LINE:39
    case controllers_HomeController_searchTitle10_route(params@_) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_HomeController_searchTitle10_invoker.call(HomeController_1.searchTitle(title))
      }
  }
}
