/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author kohan
 */
import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;


@Entity
public class Produit extends Model {


    public String libelle;
    public int  quantiteEnStock;

    @ManyToOne
    public Categorie categoryProduit;

    public Produit(String libelle, int quantiteEnStock) {
        this.libelle = libelle;
        this.quantiteEnStock = quantiteEnStock;
    }


    






}
