package lo3_fp.functions

object Polynomial {

  def costFunction(points: List[Point]): Polynomial => Double = {
    polynomial: Polynomial => {
      points.foldLeft(0.0)((distance: Double, point: Point) => distance + Math.pow(polynomial.evaluate(point.x) - point.y, 2.0)) / points.length
    }
  }

  def incubator(genes: List[Double]): Polynomial = {
    new Polynomial(genes)
  }

  def main(args: Array[String]): Unit = {
    val newPoint: Point = new Point(2.0, 2.3)
    val newPoint2: Point = new Point(3.0, 1.4)
    val listoPoint: List[Point] = List(newPoint, newPoint2)
    val costFunctionReturnVal: Polynomial => Double = costFunction(listoPoint)
    val newPoly: Polynomial = new Polynomial(List(3.0,3.0,3.4))
    println(costFunctionReturnVal(newPoly))
  }

}


/**
  * Represents a polynomial ending with the constant coefficient
  *
  * Ex. new Polynomial(List(1.5, -2.2, 5)) represents 1.5*pow(x, 2) - 2.2*x + 5
  *
  */
class Polynomial(val coefficients: List[Double]) {

  def evaluate(x: Double): Double = {
    coefficients.reduce((acc: Double, coefficient: Double) => acc * x + coefficient)
  }

  override def toString: String = {
    coefficients.toString
  }

}

