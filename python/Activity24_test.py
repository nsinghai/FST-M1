# Activity:24 - Parameterization
# Parameterization
# Activity 24
# Using pytest:
# Create a new test file and do the following:
#     Create a fixture named wallet() that initializes the variable 'amount' with 0
#     Create a test with the following parameters:

import pytest

# Define a fixture for the wallet amount
@pytest.fixture
def wallet_amount():
   amount = 0
   return amount

# Set up the paremeterized test method
@pytest.mark.parametrize("earned, spent, expected", [ (30, 10, 20), (20, 2, 18), ])
def test_transactions(wallet_amount, earned, spent, expected):
	
    # Add money to your wallet
    wallet_amount += earned

    # Subtract amount from wallet
    wallet_amount -= spent

    # Assertion
    assert wallet_amount == expected