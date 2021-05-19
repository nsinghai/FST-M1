# Activity 3 - Rock-Paper-Scissors
# Make a two-player Rock-Paper-Scissors game.
# Remember the rules:
# Rock beats scissors
# Scissors beats paper
# Paper beats rock
user1 = input("what is player 1's name? ")
user2 = input("what is player 2's name? ")
user1Ans = input(user1 + ", please choose rock, paper or scissors: ").lower()
user2Ans = input(user2 + ", please choose rock, paper or scissors: ").lower()

if user1Ans == user2Ans:
    print("Its a Tie!!!")
elif user1Ans == 'rock':
    if user2Ans == 'scissors':
        print(user1 + " wins")
    else :
        print (user2 + " wins")
elif user1Ans == 'paper':
    if user2Ans == 'rock':
        print (user1 + " wins")
    else:
        print (user2 + " wins")
elif user1Ans == 'scissors':
    if user2Ans == 'paper':
        print (user1 + " wins")
    else:
        print (user2 + " wins")
else:
    print("Invalid Input. Please try again...")

