import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActzHrsModulo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/instituto";
        String user = "alumno";
        String password = "alumno";

        int idProfesor = 1;
        String nuevoDepartamento = "Matemáticas";

        String sql = "UPDATE profesores SET departamento = ? WHERE id = ?";

        try(Connection conexion = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nuevoDepartamento);
            ps.setInt(2, idProfesor);

            int filas = ps.executeUpdate();
            System.out.println("Filas actualizadas " + filas);
        }catch(SQLException e) {
            System.out.println("Error en el UPDATE");
            e.printStackTrace();
        }
    }
}
