package vues;

import controleur.Controleur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modeleCreaFilm.Film;
import modeleCreaFilm.GenreFilm;

import java.io.IOException;
import java.util.Collection;

public class TousLesFilms extends Vue implements VueInteractive {

    private Controleur controleur;

    @FXML
    VBox mainbox;

    @FXML
    ListView listeFilms;

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

    public void chargerFilms() {
        ObservableList<Film> lesFilms = FXCollections.observableArrayList(controleur.getFilms());
        listeFilms.setItems(lesFilms);
        listeFilms.setCellFactory(param -> new ListCell<Film>() {
            @Override
            protected void updateItem(Film item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getTitre() == null) {
                    setText(" ");
                } else {
                    setText(item.getTitre()+" | " + item.getGenre()+" | " + item.getRealisateur());
                }
            }
        });
        listeFilms.getSelectionModel().selectFirst();
    }

    public void retourMenu(ActionEvent actionEvent) {
        controleur.gotoMenu();
    }
}
