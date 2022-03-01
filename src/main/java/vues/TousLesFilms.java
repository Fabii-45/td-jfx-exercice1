package vues;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modeleCreaFilm.Film;

import java.io.IOException;
import java.util.Collection;

public class TousLesFilms extends Vue implements VueInteractive {

    private Controleur controleur;

    public static TousLesFilms creerVue(Controleur controleur, Stage stage) {
        TousLesFilms tousLesFilms = new TousLesFilms();
        return tousLesFilms;
    }

    @Override
    public void setControleur(Controleur controleur) {
        this.controleur=controleur;
    }

    public void show() {
    }
}
