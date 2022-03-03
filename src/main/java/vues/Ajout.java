package vues;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modeleCreaFilm.Film;

import java.io.IOException;
import java.util.Collection;

public class Ajout extends Vue implements VueInteractive {

    private Controleur controleur;
    @FXML
    VBox mainbox;

    @FXML
    TextField titre;
    @FXML
    TextField genre;
    @FXML
    TextField realisateur;



    public static Ajout creerVue(Controleur controleur, Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(Ajout.class.getResource("ajout.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException("Probleme de construction de vue Ajout");
        }
        Ajout vue = fxmlLoader.getController();
        vue.setControleur(controleur);
        vue.setStage(stage);
        vue.setScene(new Scene(vue.mainbox,600,700));
        return vue;
    }

    @Override
    public void setControleur(Controleur controleur) {
        this.controleur=controleur;
    }

    public void afficherErreur(String erreur_de_genre, String s) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("ERREUR DE GENRE");
            alert.setContentText("On peut que mettre les genres ACTION | COMEDIE | THRILLER | AVENTURE.");
            alert.showAndWait();
    }

    public void viderChamps() {
        titre.clear();
        realisateur.clear();
        genre.clear();

    }

    public void creerFilm(ActionEvent actionEvent) {
        controleur.creerFilm(titre.getText(), genre.getText(),realisateur.getText());
    }

    public void retourMenu(ActionEvent actionEvent) {
        controleur.gotoMenu();
    }
}
