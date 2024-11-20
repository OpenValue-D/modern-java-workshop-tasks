package de.openvalue.modernjava.kotlin.examples

// 1. use string templates: ${variable-name}
// 2. write the function with '=' instead of '{}'
// 3. use a multiline string
fun main() {
    println(greet("Alice"))
    doSomething("Bob", ::println)
}

fun greet(name: String): String {
    return "Hello, " + name
}

fun doSomething(parameter: String, method: (parameter: String) -> Unit){
    method(parameter);
}