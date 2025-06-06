import DAO.ConexionBBDD;

import java.sql.ResultSet;
import java.sql.Statement;

public class Main {


    public static void cantidad_incidencias_abiertas(){
        try {

            Statement sentencia = ConexionBBDD.getConnection().createStatement();

            /*Muestra la cantidad de incidencias abiertas en la base de datos */
            ResultSet resultado = sentencia.executeQuery("SELECT COUNT(*) AS Incicendias_abiertas\n" +
                    "FROM incidencia inc, estado_incidencia est\n" +
                    "WHERE inc.id_estado_incidencia = est.id_estado_incidencia\n" +
                    "  AND est.nombre_estado = 'Abierta';");


            while (resultado.next()) {
                System.out.println("Hay " + resultado.getInt("Incicendias_abiertas") + " indicendias abiertas");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }




    public static void main(String[] args) {
        System.out.println("Este codigo es para el proyecto de practicas de programacion");
        System.out.println("===========================================================================");


        /*Muestra la cantidad de incidencias abiertas en la base de datos */
        cantidad_incidencias_abiertas();




    }
}