package lo3_fp.immutability

import javax.management.ImmutableDescriptor

object CounterExample {

  def updateCounter(n: Int, counter: ImmutableCounter): ImmutableCounter = {
    if(n==0){
      counter
    }else if(n < 0){
      updateCounter(n+1, counter.decrease())
    }else{
      updateCounter(n-1, counter.increase())
    }
  }

  def main(args: Array[String]): Unit = {
    val immutObj: ImmutableCounter = new ImmutableCounter(3)
    immutObj.increase()
    println(immutObj)
    immutObj.printCount() // this is still 3 because, immutObj can't change


    val newImmutObj = immutObj.increase()
    newImmutObj.printCount()

//    val counter: ImmutableCounter = new ImmutableCounter(10)

//    val counter2: ImmutableCounter = updateCounter(5000, counter)
//    val counter3: ImmutableCounter = updateCounter(-50, counter)

 //   counter.printCount()

//
//    // Will this work? Give it a try!
//    val counter4: ImmutableCounter = updateCounter(1000000000, counter)
//    val counter42: ImmutableCounter = updateCounter(1000000000, counter)
//    val counter43: ImmutableCounter = updateCounter(1000000000, counter)
//    val counter44: ImmutableCounter = updateCounter(1000000000, counter)
//    val counter45: ImmutableCounter = updateCounter(1000000000, counter)
//    val counter46: ImmutableCounter = updateCounter(1000000000, counter)
//    val counter48: ImmutableCounter = updateCounter(1000000000, counter)
//    val counter47: ImmutableCounter = updateCounter(1000000000, counter)
//    counter4.printCount()
  }

}
