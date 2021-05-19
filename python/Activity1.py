# Activity 1
# Write a program that asks the user to enter their name and their age.
# Print out a message addressed to them that tells them the year that they will turn 100 years old.
username = input("enter your name: ")
age = input("enter your age: ")
diff = (100-int(age))
year = (2021+int(diff))
print ("username is " + username)
print ("age: " + age)
print ("Hello " + username + " you will be 100 years old in " + str(year))