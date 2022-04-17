package lo3_fp.recursion

object Recursion {


  def computeGeometricSum(n: Int): Int ={
    if(n <= 0){
      0
    }else{
      val recursiveReturn = computeGeometricSum(n - 1)
      n + recursiveReturn
    }
  }


  def main(args: Array[String]): Unit = {
    val result: Int = computeGeometricSum(3)
    println(result)
  }


}
