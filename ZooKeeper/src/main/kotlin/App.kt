package org.muhammedoguz.zookeeper

public var zoo = arrayListOf<String>()

fun main() {
    println("Welcome to your Zoo")
    while (true) {
        menu()
        val input = readln().toIntOrNull() ?: 0
        when (input) {
            1 -> importAnimal()
            2 -> removeAnimal()
            3 -> printAnimals()
            4 -> break
            else -> {
                println("Please select a valid function...")
                println("Press enter to continue...")
            }
        }
    }
    println("Goodbye...")
    println("Press enter to quit...")
    readln()
}

fun menu() {
    println("\n---")
    println("Welcome to your Zoo")
    println("1. Importing Animal")
    println("2. Removing Animal")
    println("3. Printing The Animals")
    println("4. Quit")
    println("---")
    print("Select the option that you want to do in your zoo: ")
}

fun importAnimal() {
    println("Enter the animal which you want to add:")
    val importingAnimal = readln().trim()
    if (importingAnimal.isEmpty()) {
        println("Animal name cannot be empty!")
        println("Press enter to continue...")
        readln()
    } else {
        zoo.add(importingAnimal)
        println("$importingAnimal added to the zoo.")
    }
}

fun removeAnimal() {
    println("Enter the animal number that you want to remove:")
    val removingAnimal = readln().toIntOrNull() ?: 0
    if (zoo.isEmpty()) {
        println("The zoo is empty, nothing to remove.")
        println("Press enter to continue...")
        readln()
        return
    } else {
        if (removingAnimal != 0 && removingAnimal in 1..zoo.size) {
            val willRemove = zoo.removeAt(removingAnimal - 1)
            println("$willRemove removed from zoo")
        } else {
            println("Selection not valid. Please select a number between 1 and ${zoo.size + 1}")
            println("Press enter to continue...")
            readln()
        }
    }
}

fun printAnimals() {
    if (zoo.isEmpty()) {
        println("The zoo is empty, nothing to print.")
        println("Press enter to continue...")
        readln()
    } else {
        for ((index, animal) in zoo.withIndex()) {
            println("${index + 1}- $animal")
        }
    }
}
