package vues;

import javafx.scene.Scene;
import javafx.stage.Stage;

abstract class Vue {

    private Stage stage;
    private Scene scene;


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void show(){
        stage.setScene(scene);
        stage.show();
    }
}
