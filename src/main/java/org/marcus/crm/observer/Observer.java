package org.marcus.crm.observer;

public interface Observer {

    /**
     * The observer's update method, which is called, when the subject
     * changes. The subject is provided as a parameter in order to
     * use the same observer object as an observer for many different
     * subjects.
     *
     * @param subject the subject which changed
     */
    void update(Subject subject);

}
