class Calculator {

    fun main(args: Array<String>){

        println("<><><>< The Kotlin Calculator 0.1 ><><><>")

        var aArray : IntArray
        var bArray : IntArray
        var operatorArray : CharArray

        while(true){

            var userInput = readLine()
            try{
                var sb = StringBuilder(userInput)
                for(i in 0..userInput!!.length){
                    if(userInput.elementAt(i) == ' '){
                        println("Success!")
                    }
                }

            } catch (e : Exception){
                println("Wrong input. Try again:")
            }
        }
    }

    fun process(a : Double, b : Double, operator : Char) : Double {
        when(operator){
            '+' -> a + b
            '-' -> a - b
            '/' -> a / b
            '*' -> a * b
            else -> println("Something went wrong")
        }
        return 0.0
    }
}