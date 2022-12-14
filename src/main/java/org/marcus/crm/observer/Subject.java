package org.marcus.crm.observer;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class Subject {

    private Set<Observer> observers =
            Collections.newSetFromMap(new WeakHashMap<>());
    // Note: In JavaFX, the views do not have a way to know when they are
    // removed from the window, and therefore cannot always unregister
    // themselves from subjects they observe before the views become garbage.
    // Therefore, the set of observers are maintained as a weak set, so
    // that these observers are implicitly removed, when the observers
    // would be garbage (if not for these references)!

    /**
     * This methods allows an observer to register with the subject
     * for update notifications when the subject changes.
     *
     * @param observer the observer who registers
     */
    final public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * This methods allows an observer to unregister from the subject
     * again.
     *
     * @param observer the observer who unregisters
     */
    final public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * This method must be called from methods of concrete subclasses
     * of this subject class whenever its state is changed (in a way
     * relevant for the observer).
     */
    final protected void notifyChange() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }

}
