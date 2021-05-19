# Activity:8 - List checker
# Given a list of numbers, return True if first and last number of a list is same.

# Enter numbers to create a list separated by comma
numlist = list(input("Enter the numbers to the List: ").split(","))

print("Here is your List: " + str(numlist))

# Get first element in list
firstElement = numlist[0]
# Get last element in list
lastElement = numlist[-1]

# Check if first and last element are equal
if (firstElement == lastElement):
    print(True)
else:
    print(False)