fun main(args: Array<String>){

        println("<--- The Kotlin Calculator --- ('e/exit' to stop the program) --->")

        while(true){

            val aArray: ArrayList<Double> = ArrayList()
            val operatorArray: ArrayList<Char> = ArrayList()

            val userInput = readLine()
            if(userInput == "e" || userInput == "exit"){
                break
            }
            var numberBuilder = StringBuilder("")

            try {
                for (i in 0 until userInput!!.length) {

                    // Basic case
                    if(userInput.length == 1){
                        if (userInput.elementAt(0).isDigit()) {
                            aArray.add(userInput.elementAt(i).toString().toDouble())
                            break

                        } else {
                            break
                        }
                    }

                    // Last character case
                    if (i == userInput.length - 1 && userInput.elementAt(i).isDigit()) {
                        if (!userInput.elementAt(i - 1).isDigit()) {
                            if (userInput.elementAt(i - 1) == '.') {

                                if (numberBuilder.toString() != "") {
                                    numberBuilder.append(userInput.elementAt(i))
                                    aArray.add(numberBuilder.toString().toDouble())
                                    break
                                }

                            } else {
                                aArray.add(userInput.elementAt(i).toString().toDouble())
                            }

                        } else {
                            if (numberBuilder.toString() != "") {
                                numberBuilder.append(userInput.elementAt(i))
                                aArray.add(numberBuilder.toString().toDouble())
                                break
                            }
                        }

                    // Percent recognition
                    } else if (userInput.elementAt(i) == '%'){
                        aArray[aArray.size - 1] = percent(aArray[aArray.size - 1])
                        // Other cases
                    } else if (userInput.elementAt(i).isDigit() || userInput.elementAt(i) == '.') {
                        numberBuilder.append(userInput.elementAt(i))

                    } else if (!userInput.elementAt(i).isDigit() || userInput.elementAt(i) != '.') {

                        if (numberBuilder.toString() != "") {
                            aArray.add(numberBuilder.toString().toDouble())
                            numberBuilder = StringBuilder("")

                        }
                    }

                    // Operators recognition
                    if (userInput.elementAt(i) == '+' || userInput.elementAt(i) == '-' ||
                            userInput.elementAt(i) == '/' || userInput.elementAt(i) == '*')
                        operatorArray.add(userInput.elementAt(i))
                }

                // Output
                println("Result: ${process(aArray, operatorArray)}")

            } catch(e : Exception){
                println("Wrong input, try again:")
            }
        }
    }

    fun process(a : ArrayList<Double>, operators : ArrayList<Char>) : Double {

        var result = 0.0
        var temp = 0.0

        if(operators.size > 0) {
            for (i in 0 until operators.size) {

                if (i == 0) {
                    when (operators[i]) {
                        '+' -> result = (a[i] + a[i + 1])
                        '-' -> result = (a[i] - a[i + 1])
                        '/' -> result = (a[i] / a[i + 1])
                        '*' -> result = (a[i] * a[i + 1])
                    }

                } else {
                    when (operators[i]) {
                        '+' -> result += a[i + 1]
                        '-' -> result -= a[i + 1]
                        '/' -> result /= a[i + 1]
                        '*' -> result *= a[i + 1]
                    }
                }
            }

        } else {
            result = a[0]
        }

        return result
    }

fun percent(a : Double) : Double{
    return a * 0.01
}