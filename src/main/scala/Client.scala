import scala.actors.Actor._
import scala.actors.remote._
import scala.actors.remote.RemoteActor._

object NumberMatcherClient {
    
    def main(args: Array[String]): Unit = actor {
        val server = select(Node(args(0), 9010), 'happynumserver)
        loop {
            server !? 'next match {
                case HappyNumber(a: BigInt) => server ! HappyNumber(a)
                case _ => None
            }
        }
    }
}
