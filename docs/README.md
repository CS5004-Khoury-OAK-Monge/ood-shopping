## Background
Let's write code to represent the most common things/objects for an online shopping system. 

When you think of online shopping, what things/objects do you find?
1. User 
2. Product 
3. Shopping Cart

There are many more things that need to be represented, such as orders and how to handle payments. For now, let's focus on the three things listed above.
 

We'll work on the above for now, there are others of course, including: Payment Process, Order, etc.

## Design
See `docs/class-diagram.md`

## Module 1 topics used
- OO design in UML
- class definition: fields, constructors, methods
- primitive types
- access modifiers: public and private
- has-a relationship
- unit testing
  - test the Product class
- Java class with `main()`: the start of our program
  - define a class!
- comments and documentation
  - generate Javadoc

## Module 2 topics
TDD: Test-driven development
  1. Brainstorming: to plan a number of tests
  2. Write one test
  3. Write **just enough code** to make the test pass
  4. Refactor/update as you progress
  5. Now repeat steps 2-5 until all tests pass and have completely built the program

Other topics applied in this example
- writing methods
  - `toString()` and `equals()`
- Javadoc
  - Generating it... try: `./gradlew tasks`
- Methods with objects as parameters
- Methods with objects as return values
- Exceptions

## Module 3 topics
- categorical data: `enum` in Java
- the `switch` statement
- protocols: Java interfaces

## Module 4, 5 and 6 topics
- Uses Generics
- `Order` as a record class with fields for the product and the quantity ordered 
- cart as a `List<Order>`
- cart as a `Set<Order>`
- cart as a `Map<Product, Integer>`
- Using `stream()` and higher order functions
- Implementations of `equals()` and `hashCode()` methods
- The `Comparable` interface and implementation of `compare()`
- The `Comparator` interface and implementation of `compareTo()`
