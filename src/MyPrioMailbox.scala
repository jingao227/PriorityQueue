/**
  * Created by Jing Ao on 2016/2/26.
  */

import java.util.Comparator

import akka.actor.{PoisonPill, ActorSystem}
import akka.dispatch.{Envelope, PriorityGenerator, UnboundedStablePriorityMailbox}
import com.typesafe.config.Config
// We inherit, in this case, from UnboundedStablePriorityMailbox
// and seed it with the priority generator
class MyPrioMailbox(settings: ActorSystem.Settings, config: Config)
  extends UnboundedStablePriorityMailbox(
    // Create a new PriorityGenerator, lower prio means more important
    PriorityGenerator {
    // ’highpriority messages should be treated first if possible
      case 'highpriority => 0
      // ’lowpriority messages should be treated last if possible
      case 'lowpriority => 2
      // PoisonPill when no other left
      case PoisonPill => 3
      // We default to 1, which is in between high and low
      case otherwise => 1
//      case "first" => 0
//      case "second" => 1
//      case _ => 2
    }) {
}