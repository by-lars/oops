package de.lars.oop;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("test");

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);


        HBox center = new HBox();
        center.setAlignment(Pos.CENTER);

        root.getChildren().add(center);

        var box = new ComboBox<String>();
        box.getItems().add("Red");
        box.getItems().add("Green");
        box.getItems().add("Blue");

        ToggleGroup tg = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Red");
        RadioButton rb2 = new RadioButton("Green");
        RadioButton rb3 = new RadioButton("Blue");


        box.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                switch (newValue) {
                    case "Red":
                        root.setBackground(new Background(new BackgroundFill(Color.rgb(255,0,0), null,null)));
                        rb1.setSelected(true);
                        break;
                    case "Green":
                        root.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0), null,null)));
                        rb2.setSelected(true);
                        break;
                    case "Blue":
                        root.setBackground(new Background(new BackgroundFill(Color.rgb(0,0,255), null,null)));
                        rb3.setSelected(true);
                        break;
                }
            }
        });


        rb1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setBackground(new Background(new BackgroundFill(Color.rgb(255,0,0), null,null)));
                box.setValue("Red");
            }
        });

        rb2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0), null,null)));
                box.setValue("Green");
            }
        });

        rb3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setBackground(new Background(new BackgroundFill(Color.rgb(0,0,255), null,null)));
                box.setValue("Blue");
            }
        });


        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);

        rb1.setPadding(new Insets(10));
        rb2.setPadding(new Insets(10));
        rb3.setPadding(new Insets(10));

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.add(rb1, 0, 1);
        pane.add(rb2, 0, 2);
        pane.add(rb3, 0, 3);
        pane.add(box, 0, 4);

        TextArea area = new TextArea();
        area.setText("Welcome to my epic JavaFX app!");
        root.getChildren().add(area);


        Image image = new Image("file:resources/main/explo.png");
        ImageView view = new ImageView(image);

        view.setViewport(new Rectangle2D(0, 0, 64, 64));

        SpriteSheetAnimation anim = new SpriteSheetAnimation(view, new Duration(1000), 40,40,64,64);
        anim.setCycleCount(Animation.INDEFINITE);
        anim.play();

        pane.add(view, 0,5);


        Button btn = new Button("YEET");
        pane.add(btn, 0,6);

        btn.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                area.setText("onMousePressed");
            }
        });

        btn.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                area.setText("setOnMouseReleased");
            }
        });

        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                area.setText("onMouseClicked");
            }
        });

        btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                area.setText("onMouseEntered");
                btn.setText(event.getX() + ", " + event.getY());

            }
        });

        btn.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.setText(event.getX() + ", " + event.getY());
            }
        });

        btn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                area.setText("onMouseExited");
                btn.setText("YEET");
            }
        });

        center.getChildren().add(pane);


        Board board = new Board();
        Student a = new Student();
        Student b = new Student();

        board.register(a);
        board.register(b);

        board.changeMessage("Yeet");

        primaryStage.setScene(new Scene(root, 300,250));
        primaryStage.show();
    }
}