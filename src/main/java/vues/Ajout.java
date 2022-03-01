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
        Ajout ajout = new Ajout();
        return ajout;
    }

    @Override
    public void setControleur(Controleur controleur) {
        this.controleur=controleur;
    }

    public void show() {

    }

    public void afficherErreur(String erreur_de_genre, String s) {
    }

    public void viderChamps() {
    }
}
