# Activity 2 - Odd or Even Numbers
# Ask the user for a number.
# Depending on what number they enter, tell them if the number is an even or odd number.

Number = input("Enter a number: ")
Mod = (int(Number)%2)
if (Mod>0):
    print("Number entered " + str(Number) + " is Odd")
else:
    print("Number entered " + str(Number) + " is an Even Number")