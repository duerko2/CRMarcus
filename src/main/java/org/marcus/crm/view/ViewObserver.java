package org.marcus.crm.view;

import javafx.application.Platform;
import org.marcus.crm.observer.*;

public interface ViewObserver extends Observer {

    void updateView(Subject subject);

    @Override
    default void update(Subject subject) {
        // This default implementation of the update method makes sure that ViewObserver implementations
        // are doing the update only in the FX application thread. The update of the view is instead
        // done in the updateView() method;
        if (Platform.isFxApplicationThread()) {
            updateView(subject);
        } else {
            Platform.runLater(() -> updateView(subject));
        }
    }

}

