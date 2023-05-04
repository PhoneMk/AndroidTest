package kotlinbasic

class NullSafety {

    companion object {
        val email:String?=null

        fun getPersonInfo(){

            if (email!=null){
                //null safe
            }

            email?.let {
                //null safe
            }

            val data = email ?: ""
            print(data)
        }
    }
}