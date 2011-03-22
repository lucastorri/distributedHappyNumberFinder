@serializable class HappyNumber(val get: BigInt)

object HappyNumber {
    
    private lazy val squares = (0 until 10).map( c => ( (c + 48).toChar -> c * c ) ).toMap
    
    def unapply(v: BigInt) = {
        var intermediateValues = Set(v)
        def tailRecHappyNumber(i: BigInt): Option[BigInt] = i.toString.foldLeft(0) ( _ + squares(_) ) match {
            case 1 => Some(v)
            case n if intermediateValues.contains(n) => None
            case n => intermediateValues += n; tailRecHappyNumber(n)
        }
        tailRecHappyNumber(v)
    }
    def apply(i: BigInt) = new HappyNumber(i)
}