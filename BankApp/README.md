# Java Bank Accounts Android Application

A Tutorial on Java object oriented Android Application that demonstrates  Inheritance,  Is-a Relationship and Polymorphism

## Java Inheritance: Is-a Relationship

Is-a relationship indicates that A class Is a subclass of another class. Is-a relationship promotes code reuse that is the basic advantage of Object Oriented Programming.

For example: A Person is a base class, A Student is a subclass. Now the student is a Person also.

Polymorphism provides another advantage where child classes can override the base class methods and provide their own functionality.

## Android Bank Account Application

BankAccount abstract class – Fields balance, account number
CheckingAccount class – Subclass of Account class. Transaction fee
SavingsAccount class – subclass of Account class. Yearly Interest Rate for profit.
Bank Class - represents aggregation and manages the bank accounts.
App - Android app implemented using Constraint Layout. Single Activity
