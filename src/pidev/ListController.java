/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import entite.categorie;
import entite.forum;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;
import service.CategorieService;
import service.ForumService;

/**
 *
 * @author Moez
 */
public class ListController implements Initializable {

    @FXML
    private TableView<categorie> listeCategorie;

    @FXML
    private TableColumn<?, ?> nom;

    @FXML
    private TableColumn<?, ?> id;
    
    @FXML
    private TableColumn<?, ?> title;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> date;
    public TableView<forum> listPosts;

    public static categorie e = new categorie();
    CategorieService categorieService = new CategorieService();
    @FXML
    private BorderPane borderpane;
    ForumService forumService = new ForumService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ForumService forumService = new ForumService();
        ArrayList arrayList1 = (ArrayList) forumService.ListQuestion();
        
   
        
        ObservableList observableList1 = FXCollections.observableArrayList(arrayList1);
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        listPosts.setItems(observableList1);
        
        
        
        
        
        
        ///////////////////////////

        CategorieService categorieService = new CategorieService();
        ArrayList arrayList = (ArrayList) categorieService.selectAll2();

        ObservableList observableList = FXCollections.observableArrayList(arrayList);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        listeCategorie.setItems(observableList);

        listeCategorie.setOnMouseClicked((MouseEvent event) -> {
            categorie cat = listeCategorie.getSelectionModel().getSelectedItem();
            try {
                afficherParCategorie(event, cat);
            } catch (IOException ex) {
                Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

    }

    private int index() {
        int selectedItem = listeCategorie.getSelectionModel().getSelectedItem().getId();
        int selectedIndex = listeCategorie.getSelectionModel().getSelectedIndex();
        System.out.println(selectedItem);
        return selectedItem;
    }

    private void afficherParCategorie(MouseEvent event, categorie cat) throws IOException {
        ForumService fs = new ForumService();
        categorie c = listeCategorie.getSelectionModel().getSelectedItem();
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("ListPosts.fxml"));
                Parent root = loader.load();
                ListPostsController controller = (ListPostsController) loader.getController();
                controller.idCategorieRecuperer = c.getId();

                controller.listPosts.getItems().setAll(fs.selectAll(c.getId()));
                /*
                Stage primaryStage = new Stage();
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.show();
                 */
                borderpane.setCenter(root);
            }
        }

    }
    
    
    /////////////////////////
    private int index1() {
        int selectedItem = listPosts.getSelectionModel().getSelectedItem().getId();
        int selectedIndex = listPosts.getSelectionModel().getSelectedIndex();
        System.out.println(selectedItem);
        return selectedItem;
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int x = index1();
        Alert a1 = new Alert(Alert.AlertType.WARNING);
        a1.setTitle("Supprimer post");
        a1.setContentText("Vous voulez vraiment supprimer cet post?");
        Optional<ButtonType> result = a1.showAndWait();
        if (result.get() == ButtonType.OK) {
            forumService.supprimer(x);
            Alert a2 = new Alert(Alert.AlertType.INFORMATION);
            a2.setTitle("Supprimer post");
            a2.setContentText("Post supprimé avec succés!");
            a2.show();

            listPosts.getItems().clear();
            listPosts.getItems().addAll(forumService.ListQuestion());

        } else {
            a1.close();
        }
    }
@FXML
    private void modifier(ActionEvent event) throws IOException {

        forum fo = listPosts.getSelectionModel().getSelectedItem();
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("ModifierPost.fxml"));
        Parent p = Loader.load();

        ModifierPostController display = Loader.getController();
        display.setForum(fo);
        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(p);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.show();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AjouterPosts.fxml"));
        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(root);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.show();
    }

}
