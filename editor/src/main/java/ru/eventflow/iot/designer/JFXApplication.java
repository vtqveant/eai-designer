package ru.eventflow.iot.designer;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import ru.eventflow.iot.designer.ui.presenter.MainPresenter;

public class JFXApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        applicationContext = new SpringApplicationBuilder().sources(Main.class).run(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainPresenter mainPresenter = applicationContext.getBean(MainPresenter.class);
        Parent root = mainPresenter.getRootElement();
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("JavaFX 20 Dependency Injection");
        primaryStage.show();
    }

}