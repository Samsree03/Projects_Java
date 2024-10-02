# Projects_Java

# Design Patterns in Java_Exercise 1

This repository demonstrates the implementation of six different software design patterns in Java, showcasing both behavioral, creational, and structural patterns. Each pattern is encapsulated in its own Java file, with clear examples and explanations of how they work.

## Table of Contents
- [Introduction](#introduction)
- [Design Patterns Implemented](#design-patterns-implemented)
  - [Behavioral Patterns](#behavioral-patterns)
  - [Creational Patterns](#creational-patterns)
  - [Structural Patterns](#structural-patterns)
- [Project Structure](#project-structure)
- [How to Run the Code](#how-to-run-the-code)
- [Contributing](#contributing)
- [License](#license)

## Introduction
Design patterns are proven solutions to common problems in software design. This project aims to provide clear and concise implementations of various design patterns to help developers understand their application and use in real-world scenarios.

## Design Patterns Implemented

### Behavioral Patterns
1. **Observer Pattern**: 
   - This pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. 
   - **File**: `ObserverPattern.java`

2. **Strategy Pattern**:
   - This pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern lets the algorithm vary independently from clients that use it.
   - **File**: `StrategyPattern.java`

### Creational Patterns
1. **Factory Pattern**:
   - This pattern provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
   - **File**: `FactoryPattern.java`

2. **Singleton Pattern**:
   - This pattern ensures that a class has only one instance and provides a global point of access to it.
   - **File**: `SingletonPattern.java`

### Structural Patterns
1. **Adapter Pattern**:
   - This pattern allows the interface of an existing class to be used as another interface. It acts as a bridge between two incompatible interfaces.
   - **File**: `AdapterPattern.java`

2. **Decorator Pattern**:
   - This pattern allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class.
   - **File**: `DecoratorPattern.java`

## Project Structure

DesignPatterns/
│
├── behavioral/
│   ├── ObserverPattern.java
│   └── StrategyPattern.java
│
├── creational/
│   ├── FactoryPattern.java
│   └── SingletonPattern.java
│
└── structural/
    ├── AdapterPattern.java
    └── DecoratorPattern.java


# Astronaut Scheduler- Exercise 2

## Project Overview

The Astronaut Scheduler is a console-based application designed to help astronauts manage their daily schedules efficiently. It allows users to add, view, edit, and remove tasks, with a focus on clean code practices and the implementation of various software design patterns. The application incorporates features like task visualization and priority management.

## Features

- **Add Tasks**: Users can add tasks with descriptions, start times, end times, and priority levels (High, Medium, Low).
- **View Tasks**: Users can view a list of all scheduled tasks, sorted by start time.
- **Edit Tasks**: Users can modify existing tasks, changing their details as necessary.
- **Remove Tasks**: Users can delete tasks from their schedule.
- **Visualize Schedule**: A text-based visualization provides a timeline view of the day, displaying tasks in an easily readable format.

## Technologies Used

- Java SE
- Object-Oriented Programming principles
- Design Patterns (Singleton, Factory, Observer, etc.)

## Folder Structure (main folders , classes included)
AstronautScheduler/
├── Main.java 
├── ScheduleManager.java 
└── Task.java
