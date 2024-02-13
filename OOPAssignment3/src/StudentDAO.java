import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    private static final String INSERT_QUERY = "INSERT INTO students (id, name) VALUES (?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM students WHERE id = ?";

    public void addStudent(Student student) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    public Student getStudentById(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_QUERY)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new Student(studentId, name);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving student: " + e.getMessage());
        }
        return null;
    }
}