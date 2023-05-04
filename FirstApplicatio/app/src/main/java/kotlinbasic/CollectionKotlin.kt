package kotlinbasic

val myList = listOf(1,2,3)
val myMutableList = mutableListOf<Int>(1,2,3)

val myMap = mapOf<Int,String>(1 to "a",2 to "b",3 to "c")
val myMutableMap = mutableMapOf("a" to "apple","b" to "banana")

val mySet = setOf<Int>()
val myMutableSet = mutableSetOf("a","b","c")

fun main() {
    myMutableList.add(4)
//    print(myList)

    myMutableMap["c"] = "cow"
    myMutableMap.put("c","coconut")
    print(myMutableMap.entries)
}