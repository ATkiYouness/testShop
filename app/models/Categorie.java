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
public class Categorie extends Model {


    public String infoCategory;


    @OneToMany(mappedBy="categoryProduit",cascade=CascadeType.ALL)
    public List<Produit> Produits;


    public Categorie(String infoCategory) {
        this.infoCategory = infoCategory;
        this.Produits = new ArrayList<Produit>();
    }

    public Categorie ajouterProduit(Produit produit){

           produit.save();

        this.Produits.add(produit);

          return this;
    }
    

}
