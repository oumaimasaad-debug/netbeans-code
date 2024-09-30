/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Test {
    public static void save(Site s){
    String user= "root";
    String password= "";
    String url= "jdbc:mysql://localhost/db";
    Connection cn = null;
    Statement st = null;
    try{
        //Etape1
        Class.forName("com.mysql.jdbc.Driver");
        //Etape2
        cn=DriverManager.getConnection(url, user, password);
        //Etape3
        st=cn.createStatement();
        String req= "insert into site values(null,'" +s.getNom()+ "')";
        //Etape4
        st.executeUpdate(req);
    }catch(SQLException e){
        System.out.println("Erreur SQL");
    }catch(ClassNotFoundException ex){
        System.out.println("impossible de charger le driver");
    }finally{
        try{
            //Etape 5
            st.close();
            cn.close();
        }catch (SQLException ex){
 System.out.println("Impossible de libérer les ressource");
    }
        }
}
  
     public static void load() {
 //Information d'accès à la base de données
 String user = "root";
 String password = "";
 String url = "jdbc:mysql://localhost/db";
 Connection cn = null;
 Statement st = null;
 ResultSet rs = null;
 try {
 //Etape 1 : Chargement du driver
 Class.forName("com.mysql.jdbc.Driver");
 //Etape 2 : Récupération de la connexion
 cn = DriverManager.getConnection(url, user, password);
 //Etape 3 : Création d'un statement
 st = cn.createStatement();
 String req = "select * from site";
 //Etape 4 : Exécution de la requête
 rs = st.executeQuery(req);
 //Etape 5 : Parcours de ResultSet
 while (rs.next()) {
 System.out.println(rs.getInt(1) + " " + rs.getString(2));
 }
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 } catch (ClassNotFoundException ex) {
 System.out.println("Impossible de charger le driver");
 } finally {
 try {
 //Etape 6 : Libérer les ressources de la mémoire
 st.close();
 cn.close();
 } catch (SQLException ex) {
 System.out.println("Impossible de libérer les ressources");
 }
 }
 }
       public static void main(String[] args){
        save( new Site("SAFI"));
        save( new Site("MARRAKECH"));
        save( new Site ("EL JADIDA"));
        load();
    }

    
}
