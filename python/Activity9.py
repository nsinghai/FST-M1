# Activity:9 - Combining Lists
# Given a two list of numbers create a new list 
# such that new list should contain only odd numbers from the first list 
# and even numbers from the second list.

# Given lists
listOne = [11, 12, 13, 14, 15]
listTwo = [16, 17, 18, 19, 20]

# Print the lists
print("Here is your ListOne: " + str(listOne))
print("Here is your ListTwo: " + str(listTwo))

# Declare a third list that will contain the result
ListThree = []

# Iterate through first list to get odd elements
for num in listOne:
    if (num % 2 != 0):
        ListThree.append(num)
        
# Iterate through first list to get even elements
for num in listTwo:
    if (num % 2 == 0):
        ListThree.append(num)

# Print result
print("result List is:")
print(ListThree)
