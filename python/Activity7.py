# Activity:7 - List Sum Calculator
# Write a Python program to calculate the sum of all the elements in a list.
numbers = list(input("Enter a sequence of comma separated values: ").split(","))
sum = 0

for number in numbers:
    sum += int(number)

print(sum)