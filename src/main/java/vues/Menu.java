package vues;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Menu extends Vue implements VueInteractive {

    private Controleur controleur;
    private BorderPane borderPaneMenu;
    private Button ajouter;
    private Button consulter;

    public static Menu creerVue(Controleur controleur, Stage stage) {
        Menu menu = new Menu();
        menu.initialiserVue();
        menu.setControleur(controleur);
        menu.setStage(stage);
        return menu;
    }

    private void initialiserVue() {
        this.borderPaneMenu = new BorderPane();
        this.ajouter = new Button("Ajouter");
        this.consulter = new Button("Consulter");



        this.ajouter.setMaxWidth(Double.MAX_VALUE);
        this.consulter.setMaxWidth(Double.MAX_VALUE);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.getChildren().addAll(this.consulter,this.ajouter);
        this.borderPaneMenu.setCenter(vBox);

        Label label = new Label("Les Films");
        label.setFont(Font.font(32));
        this.borderPaneMenu.setTop(label);

        BorderPane.setAlignment(label, Pos.CENTER);
        BorderPane.setAlignment(vBox, Pos.CENTER);

        this.ajouter.setOnAction(actionEvent -> controleur.showAjout());
        this.consulter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.showFilms();
            }
        });

        this.setScene(new Scene(this.borderPaneMenu, 600, 700));

    }

    @Override
    public void setControleur(Controleur controleur) {
        this.controleur=controleur;
    }


}
