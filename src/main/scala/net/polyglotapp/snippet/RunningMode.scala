package net.polyglotapp.snippet
import net.liftweb.util.Props
import scala.xml.NodeSeq

class RunningMode {
  
  /**
   * changes the background if the application run mode is not production 
   * */
  def adjustBackground(template: NodeSeq): NodeSeq = {
     Props.mode match {
      case Props.RunModes.Development => println("Development")// do what you need to do in test mode 
      case _ => println("Something else")                                       
    }
     template
  }  

}