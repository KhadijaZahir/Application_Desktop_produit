package ma.youcode.dao;

import ma.youcode.model.Produit;

import java.sql.SQLException;
import java.util.List;

public interface ProduitDao {
    public List<Produit> showProduit() throws SQLException, ClassNotFoundException;
    public int ajouterProduit(String nom, int quantite, String marque, int prix) throws SQLException, ClassNotFoundException;
    public void deleteById(int idProduit) throws SQLException, ClassNotFoundException;
    public void modifierProduit(int idProduit, String nom, int quantite, String marque, int prix) throws SQLException, ClassNotFoundException;
}
