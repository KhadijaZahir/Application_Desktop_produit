package ma.youcode.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.youcode.model.Produit;
import ma.youcode.connexion.FileConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProduitDaoImpl implements ProduitDao {
    Statement statement = null;
    ResultSet rs = null;
    FileConnection conn;
    /* @Override
     public void ajouterProduit() throws SQLException, ClassNotFoundException {
         /*String query = "insert into produit(id_produit,nom,quantite, marque, prix) values(4,'PC', '50', 'accer', '60000')";
         statement = FileConnection.getConnexion().createStatement();
         int nmb = statement.executeUpdate(query);
     }*/

    @Override
    public int ajouterProduit(String nom, int quantite, String marque, int prix) throws SQLException, ClassNotFoundException {
         /*String query = "insert into produit(idProduit,nom,quantite, marque, prix) values(4,'PC', '50', 'accer', '60000')";
        statement = FileConnection.getConnexion().createStatement();
        int nmb = statement.executeUpdate(query);*/
        String query = "INSERT INTO produit (nom, quantite, marque, prix)" +
                "VALUES(?,?,?,?)";
        PreparedStatement prepstatement = FileConnection.getConnexion().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        //prepstatement.setInt (1,idProduit);
        prepstatement.setString   (1, nom);
        prepstatement.setInt(2,quantite);
        prepstatement.setString    (3,marque);
        prepstatement.setInt   (4,prix);
        int n = prepstatement.executeUpdate();
        ResultSet res = prepstatement.getGeneratedKeys();
        int id = 0;
        while (res.next()) {
            id = res.getInt(1);
        }
        System.out.println("added");
        return  id;
    }
    @Override
    public ObservableList<Produit> showProduit() throws SQLException, ClassNotFoundException {
        ObservableList<Produit> produiss = FXCollections.observableArrayList();
        String query = "SELECT * FROM produit";
        PreparedStatement prepstatement = FileConnection.getConnexion().prepareStatement(query);
        ResultSet rs = prepstatement.executeQuery();
        Produit produits;
        while (rs.next()) {
            produits = new Produit(rs.getInt("id_produit"), rs.getString("nom"), rs.getInt("quantite"), rs.getString("marque"), rs.getInt("prix"));
            produiss.add(produits);

        }
        return produiss;


    }

    @Override
    public void deleteById(int idProduit) throws SQLException, ClassNotFoundException {
        String query = "delete from produit where id_produit = ?";
        PreparedStatement prepstatement = FileConnection.getConnexion().prepareStatement(query);
        prepstatement.setInt (1,idProduit);
        prepstatement.executeUpdate();
        System.out.println("the product " + idProduit +" was deleted");

    }

    @Override
    public void modifierProduit(int idProduit, String nom, int quantite, String marque, int prix) throws SQLException, ClassNotFoundException {
        //String query = "UPDATE produit SET nom=?, quantite = ?, marque =?, prix = ? WHERE id_produit = ?";
        String query = "UPDATE `produit` SET `nom`= ?,`quantite`= ?,`marque`= ?,`prix`= ? WHERE id_produit = ?";
        PreparedStatement prepstatement = FileConnection.getConnexion().prepareStatement(query);
        //idProduit = rs.getInt("id_produit");
        prepstatement.setString(1, nom);
        prepstatement.setInt   (2, quantite);
        prepstatement.setString(3, marque);
        prepstatement.setInt   (4, prix);
        prepstatement.setInt   (5,idProduit);
        prepstatement.executeUpdate();
        System.out.println("update done");

        System.out.println("the product was updated" +"\t\t"+ nom+"\t\t" + quantite + "\t\t"+marque + "\t\t"+prix );
    }


}
