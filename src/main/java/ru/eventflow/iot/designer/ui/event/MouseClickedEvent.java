package ru.eventflow.iot.designer.ui.event;

import javafx.scene.Node;
import org.springframework.context.ApplicationEvent;

public class MouseClickedEvent extends ApplicationEvent {

    public MouseClickedEvent(Node source) {
        super(source);
    }

}
