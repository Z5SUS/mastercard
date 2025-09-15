import scala.io.StdIn
import scala.util.Random

/**
 * A simple number guessing game. The computer picks a random number
 * and the player has to guess it.
 */
object NumberGuessingGame {
  def main(args: Array[String]): Unit = {
    // Generate a random integer between 1 and 100 (inclusive)
    val secretNumber = Random.nextInt(100) + 1
    
    println("Welcome to the Number Guessing Game!")
    println("I have picked a number between 1 and 100. Can you guess it?")
    
    var numberOfGuesses = 0
    var guessedCorrectly = false
    
    // The game loop continues until the correct number is guessed
    while (!guessedCorrectly) {
      print("Enter your guess: ")
      
      // Use a try-catch block to handle invalid input (e.g., non-numeric)
      try {
        val playerGuess = StdIn.readInt()
        numberOfGuesses += 1
        
        // Provide hints based on the player's guess
        if (playerGuess < secretNumber) {
          println("Too low! Try again.")
        } else if (playerGuess > secretNumber) {
          println("Too high! Try again.")
        } else {
          // The player guessed the number correctly
          println(s"\nCongratulations! You guessed the number in $numberOfGuesses tries.")
          println(s"The secret number was $secretNumber.")
          guessedCorrectly = true
        }
      } catch {
        case _: NumberFormatException => 
          println("Invalid input. Please enter a whole number.")
      }
    }
  }
}