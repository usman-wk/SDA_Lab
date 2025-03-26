Understanding the Subject Class
The Subject class is a key part of the Observer Pattern. It keeps track of observers and notifies them when its state changes.

How It Works
Observers register themselves using the attach() method.

When the subject's state changes, the notifyAllObservers() method updates all registered observers.

Main Functions
getState() - Returns the current state of the subject.

setState(int state) - Updates the state and calls notifyAllObservers().

attach(Observer observer) - Adds an observer to the list.

detach(Observer observer) - Removes an observer so it no longer receives updates.

notifyAllObservers() - Calls the update() method on all registered observers.

Why It’s Important
Useful when multiple objects need to stay updated with changes in another object’s state.

Promotes loose coupling, meaning the subject does not need to know details about its observers.

Understanding the Observer Class
The Observer class listens for updates from the Subject and reacts accordingly.

How It Works
Observers register with a Subject.

When the subject's state changes, it calls the update() method on all observers.

Main Functions
update() - Called when the subject changes. Each observer handles the update in its own way.

Constructor - Observers usually get a reference to the subject when created, allowing them to register themselves.

Why It’s Important
Ensures a one-to-many relationship where changes in the subject automatically update all observers.

Helps keep all dependent objects synchronized.

Notification Message
A notification message has been added to handle cases where the message length exceeds 160 characters.

A warning system is now included for such cases.
