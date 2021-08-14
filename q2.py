#Ivan Nataren CRC549 Assignment 3 question 2
"""Write a program that requests a sentence as input and then displays the
letters in the sentence along with their frequencies. The letters should be
ordered by their frequencies."""

sentence = input("Please input a sentence: " )  #Gets the input from the user
letters = {}                                    # Creates empty dictionary


for a in range (len(sentence)):
    
    #iterates through every character in sentence and adds the alphabets to the dictionary

    if sentence[a].isalpha():


        #these two statements keep track of how many times each letter is in the string
        if sentence[a].upper() in letters:
            letters[sentence[a].upper()] += 1 
        else :
            letters [sentence[a].upper()] = 1

for letter in letters:                          #display each letter
    print(letter ,":", letters[letter])
