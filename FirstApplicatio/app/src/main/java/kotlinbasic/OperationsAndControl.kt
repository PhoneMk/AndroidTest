package kotlinbasic

fun main () {

    val age = 1

    when (age){
        1->{
            print("Age is 1")
        }
        in 0..15->{
            print("Under 16")
        }
        in 16..30->{
            print("Under 30")
        }
        else->{
            print("Over 30")
        }
    }

    println()

    val numbers = listOf(10,20,30,40,50)

    for (i in numbers) {
        print("$i ")
    }

    println()

//    val numbers = listOf(10,20,30,40,50)

    for (i in numbers.indices) {
        print("$i ")
    }

    println()

    for ((i,v) in numbers.withIndex()) {
        print("$i , $v ")
    }

    println()

    for (i in 0..6) {
        print("$i ")
    }

    println()

    for (i in 0..10 step 3) {
        print("$i ")
    }

    println()

    for (i in 10 downTo 5) {
        print("$i ")
    }
}