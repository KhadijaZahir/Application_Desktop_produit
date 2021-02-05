package ma.youcode.model;

public class Produit {
    private int id_produit;
    private String nom;
    private int quantite;
    private String marque;
    private int prix;

    public Produit(int id_produit, String nom, int quantite, String marque, int prix) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.quantite = quantite;
        this.marque = marque;
        this.prix = prix;
    }
    public Produit(String nom, int quantite, String marque, int prix) {
        this.nom = nom;
        this.quantite = quantite;
        this.marque = marque;
        this.prix = prix;
    }

    public Produit() {
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
