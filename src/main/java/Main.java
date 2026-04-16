import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url =
                "jdbc:mysql://localhost:3306/instituto?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String usuario = "alumno";
        String password = "alumno"; //OJO AQUI CON EL USUARIO Y LA CONTRASEÑA!!!

        String nombre = "Pedro";
        int edad = 21;
        String curso = "1DAW";
        double notaMedia = 6.75;

        String sql = "INSERT INTO alumnos (nombre, edad, curso, nota_media) VALUES (?, ?, ?, ?)";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
            PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setString()

        } catch (SQLException e) {
            System.out.println("Error en el SELECT");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
}