# Activity:21 - Calculator Test
# Using pytest:
# Create a new test file and write test to validate the following cases:
# Sum of two numbers
# Difference of two numbers
# Product of two numbers
# Quotient of two numbers

import pytest

# Additon test
def test_addition():
	
    # Initialize two numbers
	num1 = 15
	num2 = 20
    
	# Add them
	sum = num1 + num2

	# Assertion
	assert sum == 35

# Subtraction test
def test_subtraction():
  
	# Initialize two numbers
	num1 = 50
	num2 = 35
    
	# Subtract them
	diff = num1 - num2

	# Assertion
	assert diff == 15

# Multiplication test
def test_multiplication():
  
	# Initialize two numbers
	num1 = 5
	num2 = 20
    
	# Multiply them
	prod = num1 * num2

	# Assertion
	assert prod == 100

# Division test
def test_division():
  
	# Initialize two numbers
	num1 = 100
	num2 = 5
    
	# Divide them
	quot = num1 / num2

	# Assertion
	assert quot == 20