package tn.esprit.utils;

import tn.esprit.IServices.IService;
import tn.esprit.model.personne;

import java.sql.*;

public class myDataBase implements IService<personne> {
    private static myDataBase instance;
    private final String URL="jdbc:mysql://127.0.0.1:3306/3a22";
    private final String USERNAME="root";
    private final String PASSWORD="";
    private Connection cnx;


    private myDataBase (){
        try {
            cnx= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("connected....");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("----- not connected");
        }
    }

    public static myDataBase getInstance() {
        if(instance ==null) //lena idha ma3andouch instance yasna3o sinn yraj3o lel instance cree

            instance = new myDataBase();
        return instance;
    }
    public void add(personne p) {
        try {
            // Préparer la requête SQL
            String sql = "INSERT INTO 3a22 (nom, prenom, age) VALUES (?, ?, ?)";
            PreparedStatement ps = cnx.prepareStatement(sql);
            // Remplacer les paramètres par les valeurs de l'objet Personne
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setInt(3, p.getAge());
            // Exécuter la requête
            ps.executeUpdate();
            // Fermer le PreparedStatement
            ps.close();
            // Afficher un message de confirmation
            System.out.println("Personne ajoutée avec succès");
        } catch (SQLException e) {
            // Afficher un message d'erreur
            System.out.println(e.getMessage());
            System.out.println("Erreur lors de l'ajout de la personne");
        }
    }
    public void getall(){
        try {
            cnx= DriverManager.getConnection(URL,USERNAME,PASSWORD);

        String selectQuery = "SELECT * FROM 3a22";
        PreparedStatement preparedStatement = cnx.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            int age = resultSet.getInt(4);

            System.out.println("ID: " + id + ", Name: " + firstName + " " + lastName + ", Age: " + age);
        }

        resultSet.close();
        preparedStatement.close();
        cnx.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

}