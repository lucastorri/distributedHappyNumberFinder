case class HappyNumber(val get: BigInt)
object IsAHappyNumber {    
    def unapply(v: BigInt) = {var i=v;var s=Set[BigInt]();while(i!=1&& !s(i)){s+=i;i=(""+i).map(a=>(a+"").toInt).map(n=>n*n).sum};if(i==1)Some(v)else None}
}