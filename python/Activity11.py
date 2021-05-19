# Activity:11 - Fruit Shop
# Create a Python dictionary that contains a bunch of fruits and their prices.
# Write a program that checks if a certain fruit is available or not.
 
fruit_shop = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}

key_to_check = input("What are you looking for? ").lower()

if(key_to_check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")
