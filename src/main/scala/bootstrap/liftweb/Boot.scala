package bootstrap.liftweb

// framework imports
import net.liftweb.common._
import net.liftweb.util._
import net.liftweb.util.Helpers._
import net.liftweb.http._
import net.liftweb.sitemap._
import net.liftweb.sitemap.Loc._
import net.liftweb.mapper.{DB,Schemifier,DefaultConnectionIdentifier,StandardDBVendor,MapperRules}
import net.liftmodules.polyglot
import net.liftmodules.polyglot.Polyglot


class Boot extends Loggable {
  def boot {

    LiftRules.addToPackages("net.liftmodules")
    LiftRules.addToPackages("net.polyglotapp")
  

    /**** user experience settings ****/

    // set the time that notices should be displayed and then fadeout
    LiftRules.noticesAutoFadeOut.default.set((notices: NoticeType.Value) => Full(2 seconds, 2 seconds))
   
    //Initialize the polyglot module
    Polyglot.init
    
    /**** request settings ****/
    def sitemap(): SiteMap = SiteMap(
       Menu("Polyglot test app") / "index" >> LocGroup("public"),
       Menu("Admin") / "admin" / "localization" / "index" >> LocGroup("admin") >> Polyglot.AddPolyglotMenusAfter
    )
    LiftRules.setSiteMapFunc(() => Polyglot.sitemapMutator(sitemap()))  
  
     // admin
      /* 
      Menu("Admin") / "admin" / "index" >> LocGroup("admin"),
        /*Added for localization*/
      Menu("View Resource") / "admin" / "localization" / "viewResource" >> LocGroup("admin")  >> Hidden,
      Menu("Edit Resource") / "admin" / "localization" / "editResource" >> LocGroup("admin")  >> Hidden,
      Menu("Delete Resource") / "admin" / "localization" / "deleteResource" >> LocGroup("admin")  >> Hidden,
      Menu("Add Resource") / "admin" / "localization" / "addResource" >> LocGroup("admin")  >> Hidden,
      Menu("Add Localization") / "admin" / "localization" / "addLocalization" >> LocGroup("admin")  >> Hidden,
      Menu("Add Localization") / "admin" / "localization" / "addLocalization" >> LocGroup("admin")  >> Hidden, 
      Menu("Add Resource Group") / "admin" / "localization" / "addResourceGroup" >> LocGroup("admin")  >> Hidden, 
      Menu("Edit Resource Group") / "admin" / "localization" / "editResourceGroup" >> LocGroup("admin")  >> Hidden, 
      Menu("Delete Resource Group") / "admin" / "localization" / "deleteResourceGroup" >> LocGroup("admin")  >> Hidden,
      Menu("Localization") / "admin" / "localization" / "index" >> LocGroup("admin")
      /*End of localization sitemap entries*/  
     )*/
    
  

    // setup the 404 handler 
    LiftRules.uriNotFound.prepend(NamedPF("404handler"){
      case (req,failure) => NotFoundAsTemplate(ParsePath(List("404"),"html",false,false))
    })

    // make requests utf-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))
    
     
    //Initialize the localization module

  
  }

  
}
