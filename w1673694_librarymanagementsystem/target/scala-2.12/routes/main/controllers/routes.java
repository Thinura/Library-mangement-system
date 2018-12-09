// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/thinura/My Documents/IIT/5COSC001W-OOP/Assignments/Library Management System /w1673694_librarymanagementsystem/conf/routes
// @DATE:Sat Dec 08 11:32:17 IST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseBookController BookController = new controllers.ReverseBookController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseDVDController DVDController = new controllers.ReverseDVDController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseReaderController ReaderController = new controllers.ReverseReaderController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseBookController BookController = new controllers.javascript.ReverseBookController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseDVDController DVDController = new controllers.javascript.ReverseDVDController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseReaderController ReaderController = new controllers.javascript.ReverseReaderController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
