# Activity:13 - Adding List Numbers
# Write a function sum() such that it can accept a list of elements
# and print the sum of all elements

# Custom function to calculate sum
def sum(numbers):
	sum = 0
	for number in numbers:
		sum += number
	return sum

# Define the list of numbers
numList = [10, 20, 30, 40, 50]

print("Entered List: " + str(numList))

# Call the sum() function with numList as argument
result = sum(numList)

# Print result with message
print("The sum of all the elements is: " + str(result))