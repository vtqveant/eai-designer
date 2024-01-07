package ru.eventflow.iot.designer.ui.presenter;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.eventflow.iot.designer.ui.event.MouseClickedEvent;

import java.io.IOException;
import java.io.InputStream;

@Component
public class MainPresenter implements Presenter, ApplicationListener<MouseClickedEvent> {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane topPane;

    @FXML
    private AnchorPane bottomPane;

    @FXML
    private Text bottomText;

    @Autowired
    public MainPresenter(ApplicationEventPublisher eventPublisher, TopPanePresenter topPanePresenter) {
        try (InputStream in = getClass().getResourceAsStream("/fxml/MainView.fxml")) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setController(this);
            fxmlLoader.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // letting know globally which node was clicked, see https://stackoverflow.com/a/38139005
        rootPane.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Node source = e.getPickResult().getIntersectedNode();
            eventPublisher.publishEvent(new MouseClickedEvent(source));
        });

        bottomText.setText("Some text");

        topPane.getChildren().add(topPanePresenter.getRootElement());
    }

    @Override
    public void onApplicationEvent(MouseClickedEvent event) {
        bottomText.setText(event.getSource().getClass().getCanonicalName());
    }

    @Override
    public AnchorPane getRootElement() {
        return rootPane;
    }

    public AnchorPane getTopPane() {
        return topPane;
    }

    public AnchorPane getBottomPane() {
        return bottomPane;
    }
}
