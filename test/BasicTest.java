import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

 


    @Before
    public void viderLabase(){

        Fixtures.deleteAll();
    }

   @Test
  public void testCreationProduit(){

        new Produit("Clavier",12).save();


        Produit produitTest=Produit.find("byLibelle","Clavier").first();

        assertNotNull(produitTest);
        assertEquals(12, produitTest.quantiteEnStock);
        assertEquals(1, Produit.count());

  }

     @Test
   public void testCreationCategory(){


       new Categorie("informatique").save();

       Categorie categoryTest= Categorie.find("byInfoCategory","informatique").first();


       assertNotNull(categoryTest);
       assertEquals(1, Categorie.count());

   }
     @Test
     public void testListProduitCategory(){

       Categorie categorie1= new Categorie("informatique").save();
       Categorie categorie2= new Categorie("Livre").save();

       Produit produit1 =new Produit("Clavier",12).save();
       Produit produit2 =new Produit("DVD",124).save();
       Produit produit3 =new Produit("Java par l'exemple",14).save();


       categorie1.ajouterProduit(produit1);
       categorie1.ajouterProduit(produit2);
       categorie2.ajouterProduit(produit3);



       //Test sur  la creation des produits et des categories

       Categorie categorieTemp = Categorie.find("byInfoCategory","informatique").first();
       assertNotNull(categorieTemp);



        assertEquals(2, Categorie.count());

        //test sur les produits crées


        assertEquals(3, Produit.count());

        Produit lePremierProduitCategory1= categorie1.Produits.get(0);

        assertNotNull(lePremierProduitCategory1);
        assertEquals("Clavier",lePremierProduitCategory1.libelle);
        assertEquals(12, lePremierProduitCategory1.quantiteEnStock);

        Produit lePremierProduitCategory2= categorie2.Produits.get(0);

        assertNotNull(lePremierProduitCategory2);
        assertEquals("Java par l'exemple", lePremierProduitCategory2.libelle);
        assertEquals(14, lePremierProduitCategory2.quantiteEnStock);

     }

     @Test
     public void testAvecUnFichierYaml(){


         Fixtures.load("data.yml");


          assertEquals(2, Categorie.count());
          assertEquals(4, Produit.count());


        Categorie categorie= Categorie.find("byInfoCategory", "Infomatique").first();

        Produit  produitTemp = categorie.Produits.get(2);

        assertEquals("DVD16X Lg",produitTemp.libelle);
     
     }



}
