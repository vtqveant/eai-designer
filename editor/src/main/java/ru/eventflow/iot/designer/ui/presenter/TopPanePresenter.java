package ru.eventflow.iot.designer.ui.presenter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class TopPanePresenter implements Presenter {

    @FXML
    private Parent topPaneViewParent;

    @FXML
    private Button topPaneButton;

    @FXML
    private AnchorPane leftAnchorPane;

    public TopPanePresenter() {
        try (InputStream in = getClass().getResourceAsStream("/fxml/TopPaneView.fxml")) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setController(this);
            fxmlLoader.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Parent getRootElement() {
        return topPaneViewParent;
    }

    public Button getTopPaneButton() {
        return topPaneButton;
    }

}
