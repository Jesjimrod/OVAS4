import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url =
                "jdbc:mysql://localhost:3306/instituto?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String usuario = "alumno";
        String password = "alumno"; //OJO AQUI CON EL USUARIO Y LA CONTRASEÑA!!!

        //Scanner sc = new Scanner(System.in);

        int idAlumno = 1;
        double nuevaNota = 8.90;

        String sql = "UPDATE alumnos SET nota_media = ? WHERE id = ?";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
            PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setDouble(1, nuevaNota);
            ps.setInt(2, idAlumno);

            int filas = ps.executeUpdate();
            System.out.println("Filas actualizadas: " + filas);

        } catch (SQLException e) {
            System.out.println("Error en el UPDATE");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
}