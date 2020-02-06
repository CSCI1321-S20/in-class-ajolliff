package basics

object Sorts extends App {
    def bubbleSort(arr:Array[Int]):Unit = {
        for (i <- 0 until arr.length; j <- 0 until arr.length-1-i) {
            if(arr(j) > arr(j+1)) {
                val tmp = arr(j)
                arr(j) = arr(j+1)
                arr(j+1) = tmp
            }
        }
    }

    val nums = Array.fill(20)(util.Random.nextInt(100)) //if you wanted to sort Doubles with bubbleSort, it won't work
    println(nums.mkString(", "))
    bubbleSort(nums)
    println(nums.mkString(", "))


    


    def bubbleSort2[A <% Ordered[A]](arr:Array[A]):Unit = { //<% makes Doubles (which aren't inherently ordered) convert to be implicitly ordered
        for (i <- 0 until arr.length; j <- 0 until arr.length-1-i) {
            if(arr(j) > arr(j+1)) {
                val tmp = arr(j)
                arr(j) = arr(j+1)
                arr(j+1) = tmp
            }
        }
    }

    val nums2 = Array.fill(20)(util.Random)
    println(nums2.mkString(", "))
    bubbleSort2(nums2)
    println(nums2.mkString(", "))





    def bubbleSort3[A](arr:Array[A])(gt: (A,A) => Boolean):Unit = { 
        for (i <- 0 until arr.length; j <- 0 until arr.length-1-i) {
            if(gt(arr(j), arr(j+1))) {
                val tmp = arr(j)
                arr(j) = arr(j+1)
                arr(j+1) = tmp
            }
        }
    }

    val nums3 = Array.fill(20)(util.Random)
    println(nums3.mkString(", "))
    bubbleSort3(nums3)(_ > _)   //can change the function here to sort in different ways
    println(nums3.mkString(", "))
}