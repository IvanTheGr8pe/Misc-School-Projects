#Ivan Nataren CRC549 Assignment 3 question 3
"""Write a program that randomly selects a number from 1 through 100 and asks
the user to guess the number. At each guess the user should be told if the
guess is proper, and if so, whether it is too high or too low. The user
should be told of number of guesses when finally guessing the correct number.
import random"""


number = random.randint(1,100) #chooses random number
count =0 #keeps track of guesses

guess = 0 #initializes the guess

while guess != number:
    try : 
        guess = eval(input("Please enter an integer from 1 to 100 : "))
        count +=1
        if guess == number:
                print("Congratulations! The number was ", number)
        elif guess > number:
                print("Your guess is too high")
        else:
                print("Your guess is too low")
   #catches any exception in case user does not input a number             
    except:
        print("Not a valid guess")
print("It took you ", count, " guesses.")
    
    

