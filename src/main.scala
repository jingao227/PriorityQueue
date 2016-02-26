import akka.actor.{Props, ActorSystem}
import com.typesafe.config._
/**
  * Created by Jing Ao on 2016/2/26.
  */
object main {
  def main(args:Array[String]): Unit = {
//    val system = ActorSystem("mySystem",ConfigFactory.load("application.conf"))
//    val conf: Config = ConfigFactory.load()
//    val myActor = system.actorOf(Props(classOf[Logger], this).withDispatcher(
//      "prio-dispatcher"))
    val system = ActorSystem("mySystem")
    val myActor = system.actorOf(Props[Logger], "priomailboxactor")
//    println(conf.root().render())
//    val a = system.actorOf(Props(classOf[Logger]).withDispatcher("prio-dispatcher"))
  }
}
