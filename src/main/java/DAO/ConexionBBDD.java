package DAO;

import java.sql.*;

public class ConexionBBDD {


    //Creo las variables con los datos necesarios para meterse en la base de datos
    static Connection conexion = null;

    //la /Ejercicio_parque es el nombre de la base de datos
    private static final String URL = "jdbc:mysql://192.168.1.130:3306/incidencias_info";
    private static final String USER = "felipe";
    private static final String PASSWORD = "felipe10";
    private static final String driver="com.mysql.cj.jdbc.Driver";





    private ConexionBBDD(){
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }




    public static Connection getConnection() throws SQLException {
        if (conexion == null){


            //Hace conexion con la base de datos
            new ConexionBBDD();

            //coge el nombre de la base de datos
            String nombre_bbdd = conexion.getCatalog();

            System.out.println("Bienvenido a la base de datos: " + nombre_bbdd);
            System.out.println("Usuario: " + USER);

        }
        return conexion;
    }


    //Cierra la conexion a la base de datos
    public static void closeConnection() {
        try{
            if (conexion != null){
                System.out.println("Cerrando la conexion");
                conexion.close();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }








}