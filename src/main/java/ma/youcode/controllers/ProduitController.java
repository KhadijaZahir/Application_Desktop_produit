package ma.youcode.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import ma.youcode.dao.ProduitDaoImpl;
import ma.youcode.model.Produit;

import javax.security.auth.callback.Callback;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProduitController implements Initializable {
    ObservableList<Produit> addproduits = FXCollections.observableArrayList();
    ProduitDaoImpl produitDao=new ProduitDaoImpl();


    @FXML
    private Button btnModifier;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnAffficher;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfQuantite;

    @FXML
    private TextField tfPrix;

    @FXML
    private TextField tfMarque;

    @FXML
    private TableView<Produit> tableViewProduit;

    @FXML
    private TableColumn<Produit, Integer> colId;

    @FXML
    private TableColumn<Produit, String> colNom;

    @FXML
    private TableColumn<Produit, Integer> colQuantite;

    @FXML
    private TableColumn<Produit, String> colMarque;

    @FXML
    private TableColumn<Produit, Integer> colPrix;
    int index = -1;
    @FXML
    public void getSelected(javafx.scene.input.MouseEvent mouseEvent) {
        index = tableViewProduit.getSelectionModel().getSelectedIndex();

        if (index <= -1){
            return;
        }else {
            tfId.setText(String.valueOf(colId.getCellData(index)));
            tfNom.setText(colNom.getCellData(index));
            tfQuantite.setText(String.valueOf(colQuantite.getCellData(index)));
            tfMarque.setText(colMarque.getCellData(index));
            tfPrix.setText(String.valueOf(colPrix.getCellData(index)));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            showProduct();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void insertProduct() throws SQLException, ClassNotFoundException {
        String inputNom = tfNom.getText();
        int inputQuantite= Integer.parseInt(tfQuantite.getText());
        String inputMarque = tfMarque.getText();
        int inputPrix= Integer.parseInt(tfPrix.getText());
        int id = produitDao.ajouterProduit(inputNom, inputQuantite, inputMarque, inputPrix);
        Produit test = new Produit(id, inputNom, inputQuantite, inputMarque, inputPrix);
        addproduits.add(test);
        showProduct();
    }


    public void modifierProduct() throws SQLException, ClassNotFoundException {
        produitDao.modifierProduit(Integer.parseInt(tfId.getText()), tfNom.getText(), Integer.parseInt(tfQuantite.getText()), tfMarque.getText(), Integer.parseInt(tfPrix.getText()));
        showProduct();

//        ObservableList<Produit> applist = FXCollections.observableArrayList();
//
//        tableViewProduit.getItems().clear();
//        //Set cell values to tableview.
//        tableViewProduit.setEditable(true);
//        tableViewProduit.getSelectionModel().setCellSelectionEnabled(true);
//         //makes columns editable
//        colId.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
//        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//        colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
//        colMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
//        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
//
//        tableViewProduit.getColumns().addAll(colId, colNom, colQuantite, colMarque, colPrix);
//        tableViewProduit.getItems().addAll(applist);
//        ///
//        tableViewProduit.setItems(applist);

    }


    public void showProduct() throws SQLException, ClassNotFoundException {
        ObservableList<Produit> applist= produitDao.showProduit();
        colId.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        colMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        // seting data in list
        tableViewProduit.setItems(applist);
        //ObservableList<Produit> applist = FXCollections.observableArrayList(produitDao.showProduit());

    }
    public void deletProduct() throws SQLException, ClassNotFoundException {
        produitDao.deleteById(Integer.parseInt(tfId.getText()));
        showProduct();

    }

}
