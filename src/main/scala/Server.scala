import scala.actors.Actor._
import scala.actors.remote._
import scala.actors.remote.RemoteActor._

object NumberServer {
    
    private var nextTry = BigInt(1)
    private var foundNums = Set[BigInt]()
    
    def main(args: Array[String]): Unit = actor {
        alive(9010); register('happynumserver, self)
        loop {
            receive {
                case 'next => reply(nextTry); nextTry += 1
                case h: HappyNumber => println(h.get); foundNums += h.get
            }
        }
    }
}