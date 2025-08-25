# Elevator System

This project simulates a multi-elevator system using object-oriented design principles in Java. It demonstrates how elevators, floors, controllers, and dispatchers interact to handle both internal and external requests efficiently.

## Features
- **Internal and External Requests:**
  - Internal requests (from inside the elevator) are sent to the ElevatorController, which manages a queue and processes requests when the elevator is idle.
  - External requests (from floors) are dispatched using strategies defined in dispatcher classes (e.g., LookDispatcher).
- **Controllers:**
  - Each elevator has an ElevatorController that manages its movement and request queues.
- **Dispatchers:**
  - The ExternalButtonDispatcher base class can be extended to implement custom elevator selection strategies. For example, LookDispatcher overrides the selection logic to assign requests based on elevator direction and status.
- **Extensible Design:**
  - Easily add new dispatching strategies by extending ExternalButtonDispatcher and overriding selectBestElevator.

## Main Components
- `Elevator`: Represents an elevator, tracks its state, and executes movement commands.
- `ElevatorController`: Handles internal and external requests for an elevator, manages request queues, and coordinates elevator actions.
- `ExternalButtonDispatcher`: Base class for dispatching external requests; child classes can implement custom selection logic.
- `LookDispatcher`: Example of a custom dispatcher that selects elevators based on direction and status.
- `InternalButton`/`ExternalButton`: Buttons for making requests from inside the elevator or from a floor.
- `Floor`: Represents a floor with an external button.
- `Main`: Entry point for simulation, sets up elevators, controllers, floors, and dispatchers.

## How It Works
1. **Initialization:**
   - Floors and elevators are created.
   - Each elevator is assigned an ElevatorController and an InternalButton.
   - Each floor is assigned an ExternalButton, which is connected to a dispatcher.
2. **Request Handling:**
   - Internal requests are sent to the controller, queued, and processed when the elevator is idle.
   - External requests are dispatched to the best elevator using the dispatcher strategy.
3. **Extensibility:**
   - To add new dispatching strategies, extend ExternalButtonDispatcher and override selectBestElevator.
   - To add new features, modify controllers or elevator logic as needed.

## Example Simulation
The `Main` class demonstrates how requests are routed and processed:
- External requests are made from floors and assigned to elevators by the dispatcher.
- Internal requests are made from inside elevators and managed by controllers.

## How to Run
1. Compile the project using your preferred Java IDE or command line.
2. Run the `Main` class to start the simulation.

## Extending the System
- Implement new dispatcher strategies by extending `ExternalButtonDispatcher`.
- Add features like request prioritization, error handling, or advanced scheduling in controllers or dispatchers.

## Design Principles
- **Separation of Concerns:** Controllers manage elevator logic; dispatchers handle assignment strategies.
- **Open/Closed Principle:** Easily extend dispatching logic without modifying existing code.
- **Maintainability:** Centralized request handling and clear object responsibilities.

---
Feel free to explore and extend the system to fit more complex elevator scenarios!