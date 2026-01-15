## Background
Let's write code to represent the most common things/objects for an online shopping system. 

When you think of online shopping, what things/objects do you find?
1. User 
2. Product 
3. Shopping Cart

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
  - TODO: test the Product class
- Java class with `main()`: the start of our program
  - TODO: define a class!
- comments and documentation
  - TODO: generate Javadoc

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