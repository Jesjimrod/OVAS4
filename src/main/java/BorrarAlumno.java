import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BorrarAlumno {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/instituto";
        String usuario = "alumno";
        String password = "alumno";

        int idAlumno = 4;
        String sql = "DELETE FROM alumnos WHERE id = ?";

        try(Connection conexion =  DriverManager.getConnection(url, usuario, password);
        PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idAlumno);

            int filas= ps.executeUpdate();
            System.out.println("Filas borradas: " + filas);
        } catch(SQLException e) {
            System.out.println("Error en el DELETE");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
}
