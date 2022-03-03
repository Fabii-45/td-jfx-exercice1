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

    @FXML
    VBox mainbox;

    @FXML
    TextArea listeFilms;

    public static TousLesFilms creerVue(Controleur controleur, Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(Ajout.class.getResource("tousLesFilms.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException("Probleme de construction de vue Tous Les Films");
        }
        TousLesFilms vue = fxmlLoader.getController();
        vue.setControleur(controleur);
        vue.setStage(stage);
        vue.setScene(new Scene(vue.mainbox,600,700));
        return vue;
    }

    @Override
    public void setControleur(Controleur controleur) {
        this.controleur=controleur;
    }

    public void show() {
        Collection<Film> films = controleur.getFilms();
        String affichageFilms = " ";
        for(Film f:films){
            affichageFilms += "Titre : "+f.getTitre()+" Genre : "+f.getGenre()+" Réalisateur : "+f.getRealisateur()+" \n ";
        }
        listeFilms.setText(affichageFilms);
        super.show();
    }

    public void retourMenu(ActionEvent actionEvent) {
        controleur.gotoMenu();
    }
}
