import akka.actor.{ActorSystem, Props, PoisonPill, Actor}
import akka.event.{Logging, LoggingAdapter}

/**
  * Created by Jing Ao on 2016/2/26.
  */
// We create a new Actor that just prints out what it processes
class Logger extends Actor {
  val log: LoggingAdapter = Logging(context.system, this)
  self ! 'lowpriority
  self ! 'lowpriority
  self ! 'highpriority
  self ! 'pigdog
  self ! 'pigdog2
  self ! 'pigdog3
  self ! 'highpriority
  self ! PoisonPill
//  self ! "first"
//  self ! "second"
//  self ! "first"
  def receive = {
    case x => log.info(x.toString)
//    case x => println(x)
  }
}
//val system = ActorSystem("mySystem")
//val a = system.actorOf(Props(classOf[Logger], this).withDispatcher("prio-dispatcher"))