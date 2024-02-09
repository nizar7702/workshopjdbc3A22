package tn.esprit;

import tn.esprit.model.personne;
import tn.esprit.utils.myDataBase;

import java.sql.Connection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
        public static void main(String[] args) {
            // Créer une instance unique de MyDataBase
            myDataBase db = myDataBase.getInstance();
            personne p=new personne(1,3,"nizar","boussabat");
            personne p1=new personne(1,4,"meher","boussabat");
            personne p2=new personne(1,5,"yassine","boussabat");
            db.add(p);
            db.add(p1);
            db.add(p2);
            db.getall();
        }

}