
# Java Fundamentals

![a](https://img.shields.io/badge/-Java-orange?logo=openjdk)

Object Oriented Programming in Java. Repository with exercises from the TUL laboratories.


## 1) Quadratic Equation

Write a program that solves the quadratic equation `ax^2 + bx + c = 0`. The coefficients `a`, `b`, and `c` are passed as command-line arguments. Consider the case where the user provides an incorrect number of parameters.

**Guidelines:**
- Assume that `a`, `b`, and `c` are integers.
- Consult the `Integer` class API and find suitable functions.
- Learn the differences between `Integer` and `int`.

---

## 2) String Operations

Write a program that takes two numbers (`a` and `b`) and a string as command-line arguments. The program should extract a substring from the given string starting at index `a` (inclusive) and ending at index `b` (exclusive).

**Example:**
```shell
java Substring Welcome 2 4
```
This should output: `elc`.  
The program should then display the original string without the extracted substring. For the given example, it should output: `Wome`.

**Guidelines:**
- Consider and list all possible incorrect ways of providing arguments.
- Any sequence of parameters other than two natural numbers and a string, where the first number is less than the second and both are less than the length of the string, should generate a precise error message explaining why the parameter set is incorrect.

---

## 3) Loops

Write a program that generates a random number between 0 and 100. The program then prompts the user to guess the number. If the guess is incorrect, the program provides feedback by indicating whether the correct number is higher or lower than the user's guess. If the user guesses correctly, the program displays the number of attempts made and asks if the user would like to play again.

---

## 4) Regular Expressions

Write a program that verifies whether the parentheses in a given arithmetic expression are correctly matched. The expression is provided as a single string of characters, using standard arithmetic operators. The program should display a message indicating whether the parentheses are matched or not.

**Guidelines:** Refer to the `java.util.regex` package.

---

## 5) Shopping List

Write a program for creating a shopping list in text mode. The program reads a text file containing product categories and their items.

**Example File:**
```plaintext
Groceries:
    Bread
    Butter
    Milk
    Cheese
Cleaning Supplies:
    Soap
    Dishwashing liquid
Automotive:
    Air freshener
    Windshield washer fluid
```
The product list file is prepared by the user and not modified by the program. Consider using CSV format.

**Program Features:**
- Load the product list from the file.
- Allow adding products by selecting a category and item.
- Display all products on the shopping list.
- Remove specific products by category and item.
- Save the shopping list to disk.

**User Experience:** Provide clear instructions and menus for easy use.

**Guidelines:** Explore the differences between `java.io` and `java.nio` packages for file operations.

---

## 6) Collections Framework

Create a class `TelephoneNumber` with fields for country code and local number, implementing the `Comparable` interface.  
Define an abstract class `TelephoneEntry` with an abstract method `description`. Inherit classes `Person` and `Company` from `TelephoneEntry`.  
Class `Person` should contain information about name, last name, and address (including `TelephoneNumber`).  
Class `Company` should have name and address (including `TelephoneNumber`).  
Create additional classes if necessary based on OOP principles.  
Compose objects of `Person` and `Company` and place them in a `TreeMap` container, using `TelephoneNumber` as the key.  
Then, list the created directory using an `Iterator`.

**Guidelines:**
- Refer to the `java.util` package.
- Consider whether the given set of classes is sufficient for a correct object model.

---

## 7) Exceptions

Write a program that asks for vectors (in the mathematical sense) as input. The end of the vector is marked by the enter key. Ignore non-numeric elements. Try to add vectors if their lengths are equal.

**Example input:**
```plaintext
A,5,8 - length is 2
1,9,10a,11 - length is 3
2,3,5,6,$% - length is 4
```
If the vector lengths are not equal, throw a `DifferentVectorsLengthsException` (you'll need to create this exception), with which you can specify and later (after catching the exception) read the length of the vectors.

If vectors are equal, display the result of the addition.  
If vectors are not equal, you should be able to formulate each of the example sentences without changing your code, using only the `catch` clause:

```plaintext
(first, second, ..., last) the vector length is ...
(first, second, ..., last) the vector length is (lower/bigger) than (first, second, ..., last) vector length.
```

The tutor will give the exact sentence to display during evaluation.

Finally, if the vectors are not equal, prompt the user to re-enter the vectors.

**Guidelines:**
- Propose a class and method structure where an exception is thrown in one class/method and caught in another class/method.
- The catching class/method should not have access to any variables of the first class.
- The given example sentences must be formulated solely based on the data read from the exception object.

---

## 8) Project: File-Based Database

Develop a simple file-based database application offering functionalities like `Select`, `Insert`, `Update`, and `Delete` commands.  
Use JSON format for the database.  
Implement a command-line interface and a proper SQL syntax parser (a MySQL command-line client can be used as an example).

**Optional components:**
- `WHERE` clause implementation
- `JOIN` clause implementatio
- GUI in Vaadin

**Guidelines:**
- Explore the most convenient ways to handle JSON format in Java.
- A database operation that involves selecting items from a menu is not sufficient for project completion.
