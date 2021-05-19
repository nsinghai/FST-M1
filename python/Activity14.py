# Activity:14 - Fibonacci Numbers
# Write a program that asks the user how many Fibonnaci numbers to generate and then generates them.

def fibonacci(number):
    if number <= 1:
        return number
    else:
        return(fibonacci(number-1) + fibonacci(number-2))

fnumber = int(input("Enter a number: "))

if fnumber <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Series: ")
    for i in range(fnumber):
        print(fibonacci(i))