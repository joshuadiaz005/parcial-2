import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ServicioFormulario  {
    public static ArrayList<Formularios> listarFormularioss() {
        Connection conexion = ServicioBaseDatos.getInstancia().getConexion();
        ArrayList<Formularios> formularios = new ArrayList<>();

        try {
            String formulariosQuery = "SELECT * FROM formulario ORDER BY fecha DESC;";

            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(formulariosQuery);

            while(resultado.next()) {
                formularios.add(
                    new Formularios(
                        resultado.getNString("nombre"),
                        resultado.getNString("sector"),
                        resultado.getNString("nivelEscolar"),
                        resultado.getNString("latitud"),
                        resultado.getNString("longitud")
                    )
                );
            }

            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return formularios;
    }

    public static Formularios buscarFormularios(long id) {
        Formularios formularios = null;
        Connection conexion = ServicioBaseDatos.getInstancia().getConexion();

        try {
            String articuloEncontrado = "SELECT * FROM formularios WHERE id = " + id + ";";

            PreparedStatement prepareStatement = conexion.prepareStatement(articuloEncontrado);
            ResultSet rs = prepareStatement.executeQuery();

            while(rs.next()) {

                formularios = new Formularios(
                        rs.getNString("nombre"),
                        rs.getNString("sector"),
                        rs.getNString("nivelEscolar"),
                        rs.getNString("latitud"),
                        rs.getNString("longitud")
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return formularios;
    }

    public static boolean crearFormularios(long id, String nombre, String sector, String nivelEscolar, String latitud, String longitud) {
        boolean creadoCorrectamente = false;
        Connection conexion = ServicioBaseDatos.getInstancia().getConexion();

        try {

            String articuloNuevo = "MERGE INTO formularios \n" +
                    "KEY(ID) \n" +
                    "VALUES (" + id + ",'" + nombre + "','" + sector + "'," + nivelEscolar + ",'" + latitud + ",'"+longitud+");";

            PreparedStatement prepareStatement = conexion.prepareStatement(articuloNuevo);

            int fila = prepareStatement.executeUpdate();
            creadoCorrectamente = fila > 0 ;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return creadoCorrectamente;
    }

    public static void eliminarFormularios(Long id) {
        Connection conexion = ServicioBaseDatos.getInstancia().getConexion();
        ArrayList<Formularios> formularios = new ArrayList<>();
        boolean creadoCorrectamente;

        try {
            String eliminarFormulariosQuery = "DELETE FROM formularios where ID = " + id + ";";

            PreparedStatement prepareStatement = conexion.prepareStatement(eliminarFormulariosQuery);

             int fila = prepareStatement.executeUpdate();
            creadoCorrectamente = fila > 0 ;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Long conseguirTamano() {
        Long ultimoID = new Long(0);
        Connection conexion = ServicioBaseDatos.getInstancia().getConexion();

        try {
            String conseguirTamanoTabla = "SELECT TOP 1 * FROM formularios ORDER BY ID DESC;";

            PreparedStatement prepareStatement = conexion.prepareStatement(conseguirTamanoTabla);
            ResultSet resultado = prepareStatement.executeQuery();
            while(resultado.next()){
                ultimoID = resultado.getLong("id");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return ultimoID;
    }
}
