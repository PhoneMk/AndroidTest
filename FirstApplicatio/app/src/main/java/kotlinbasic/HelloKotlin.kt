package kotlinbasic

lateinit var value3 :String

fun main(){
    print("Hello Kotlin")

    val value = "Read only"
//    value = "write"

    var value1 = "Read and write"
    value1 = "Assign"

    value3 = "NewValue"
    print(value3)

    NullSafety.getPersonInfo()
    //val person = Person()
    val person2 = Person(name = "Aung Aung")
}