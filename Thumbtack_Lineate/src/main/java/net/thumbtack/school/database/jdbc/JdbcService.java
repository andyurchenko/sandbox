package net.thumbtack.school.database.jdbc;

import net.thumbtack.school.database.model.Group;
import net.thumbtack.school.database.model.School;
import net.thumbtack.school.database.model.Subject;
import net.thumbtack.school.database.model.Trainee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcService {
    public static void insertTrainee(Trainee trainee) throws SQLException {
        String insertQuery = "INSERT INTO trainee VALUES(null, ?, ?, ?)";

        try (PreparedStatement stmt = prepareStatementInsertTrainee(insertQuery, trainee)) {
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (!generatedKeys.next()) {
                    throw new SQLException("Creating a new trainee failed.");
                }
                trainee.setId(generatedKeys.getInt(1));
            }
        }
    }

    public static void updateTrainee(Trainee trainee) throws SQLException {
        String updateQuery = "UPDATE trainee SET firstname = ?, lastname = ?, rating= ? WHERE id = ?";
        try (PreparedStatement stmt = prepareStatementUpdateTrainee(updateQuery, trainee)) {
            stmt.setString(1, trainee.getFirstName());
            stmt.setString(2, trainee.getLastName());
            stmt.setInt(3, trainee.getRating());
            stmt.setInt(4, trainee.getId());
            if (stmt.executeUpdate() == 0) {
                throw new SQLException("Updating the trainee info failed.");
            }
        }
    }

    public static Trainee getTraineeByIdUsingColNames(int traineeId) throws SQLException {
        String selectQuery = "SELECT * FROM trainee WHERE id = ?";
        try (PreparedStatement stmt = prepareStatementSelectTraineeById(selectQuery, traineeId)) {
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }

                return new Trainee(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("rating")
                );
            }
        }
    }

    public static Trainee getTraineeByIdUsingColNumbers(int traineeId) throws SQLException {
        String selectQuery = "SELECT * FROM trainee WHERE id = ?";
        try (PreparedStatement stmt = getPreparedStatement(selectQuery)) {
            stmt.setInt(1, traineeId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }

                return new Trainee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                );
            }
        }
    }

    public static List<Trainee> getTraineesUsingColNames() throws SQLException {
        String selectAllQuery = "SELECT * FROM trainee";
        List<Trainee> trainees;
        try (Statement stmt = JdbcUtils.getConnection().createStatement(); ResultSet resultSet = stmt.executeQuery(selectAllQuery)) {
            trainees = aggregateAllTraineesFromResult(resultSet);
        }

        return trainees;
    }

    public static List<Trainee> getTraineesUsingColNumbers() throws SQLException {
        String selectAllQuery = "SELECT * FROM trainee";
        List<Trainee> trainees = new ArrayList<>();
        try (Statement stmt = JdbcUtils.getConnection().createStatement();
             ResultSet resultSet = stmt.executeQuery(selectAllQuery))
        {
            while (resultSet.next()) {
                trainees.add(new Trainee(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getInt(4))
                );
            }
        }

        return trainees;
    }

    public static void deleteTrainee(Trainee trainee) throws SQLException {
        String deleteQuery = "DELETE FROM trainee WHERE id = ?";
        try (PreparedStatement stmt = prepareStatementDeleteTrainee(deleteQuery, trainee)) {
            if (stmt.executeUpdate() != 1) {
                throw new SQLException("Deleting the trainee with id = " + trainee.getId() + " failed.");
            }
        }
    }

    public static void deleteTrainees() throws SQLException {
        String deleteQuery = "DELETE FROM trainee";

        try (Statement stmt = createStatement()) {
            stmt.executeUpdate(deleteQuery);
        }
    }

    public static void insertSubject(Subject subject) throws SQLException {
        String insetQuery = "INSERT INTO subject VALUE(null, ?)";

        try (PreparedStatement stmt = preparedStatementInsertSubject(insetQuery, subject)) {
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (!rs.next()) {
                throw new SQLException("Inserting a new subject " + subject.getName() + " failed.");
            }
            subject.setId(rs.getInt(1));
        }
    }

    public static Subject getSubjectByIdUsingColNames(int subjectId) throws SQLException {
        String selectQuery = "SELECT * FROM subject WHERE id = ?";
        try (PreparedStatement stmt = prepareStatementSelectSubjectById(selectQuery, subjectId)) {
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {

                    return new Subject(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    );
                }
            }
        }

        return null;
    }

    public static Subject getSubjectByIdUsingColNumbers(int subjectId) throws SQLException {
        String selectQuery = "SELECT * FROM subject WHERE id = ?";

        try (PreparedStatement stmt = prepareStatementSelectSubjectById(selectQuery, subjectId)) {
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {

                    return new Subject(
                            resultSet.getInt(1),
                            resultSet.getString(2)
                    );
                }
            }
        }

        return null;
    }

    public static void deleteSubjects() throws SQLException {
        String deleteQuery = "DELETE FROM subject";
        try (Statement stmt = createStatement()) {
            stmt.executeUpdate(deleteQuery);
        }
    }

    public static void insertSchool(School school) throws SQLException {
        String insertQuery = "INSERT INTO school VALUE(null, ?, ?)";
        try (PreparedStatement stmt = prepareStatementInsertSchool(insertQuery, school)) {
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (!rs.next()) {
                throw new SQLException("Inserting a new school " + school.getName() + " failed");
            }
            school.setId(rs.getInt(1));
        }
    }

    public static School getSchoolByIdUsingColNames(int schoolId) throws SQLException {
        String selectQuery = """
            SELECT `school`.id AS schoolid, `school`.name AS schoolname, `school`.year AS schoolyear
            FROM `school`
            WHERE `school`.id = ?
        """;
        School school;
        try (PreparedStatement stmt = prepareStatementSelectSchoolById(selectQuery, schoolId)) {
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (!resultSet.next()) {
                    throw new SQLException("Getting the school with id = " + schoolId + " failed.");
                }
                school = new School(
                        resultSet.getInt("schoolid"),
                        resultSet.getString("schoolname"),
                        resultSet.getInt("schoolyear")
                );
            }
        }

        return school;
    }

    public static School getSchoolByIdUsingColNumbers(int schoolId) throws SQLException {
        String selectQuery = """
            SELECT `school`.id AS schoolid, `school`.name AS schoolname, `school`.year AS schoolyear
            FROM `school`
            WHERE `school`.id = ?
        """;
        School school;
        try (PreparedStatement stmt = prepareStatementSelectSchoolById(selectQuery, schoolId)) {
            stmt.setInt(1, schoolId);
            ResultSet resultSet = stmt.executeQuery();
            school = createSchoolObjFromResultSet(resultSet);
            resultSet.close();
        }

        return school;
    }

    public static void deleteSchools() throws SQLException {
        String deleteQuery = "DELETE FROM school";
        try (Statement stmt = createStatement()) {
            stmt.executeUpdate(deleteQuery);
        }
    }

    public static void insertGroup(School school, Group group) throws SQLException {
        String insertQuery = """
            INSERT INTO `group` VALUE(null, ?, ?, ?)
        """;
        try (PreparedStatement stmt = prepareStatementInsertGroup(insertQuery, school, group) ) {
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (!rs.next()) {
                throw new SQLException("Inserting the new group " + group.getName() + " failed");
            }
            group.setId(rs.getInt(1));
        }
    }

    public static School getSchoolByIdWithGroups(int id) throws SQLException {
        String selectQuery = """
            SELECT `school`.id AS schoolid, `school`.name AS schoolname, `school`.year AS schoolyear,
            `group`.id AS groupid, `group`.name AS groupname, `group`.room AS grouproom
            FROM `school`
            LEFT JOIN `group` ON `school`.id = `group`.schoolid
            WHERE `school`.id = ?
        """;
        School school = null;
        try (PreparedStatement stmt = prepareStatementSelectSchoolByIdWithGroups(selectQuery, id)) {
            ResultSet resultSet = stmt.executeQuery();
            school = createSchoolObjWithGroupsFromResultSet(resultSet);
            resultSet.close();
        }

        return school;
    }



    public static List getSchoolsWithGroups() throws SQLException {
        String selectQuery = """
            SELECT `school`.id AS schoolid, `school`.name AS schoolname, `school`.year AS schoolyear,
            `group`.id AS groupid, `group`.name AS groupname, `group`.room AS grouproom
            FROM `school`
            LEFT JOIN `group` ON `school`.id = `group`.schoolid
            ORDER BY schoolid ASC
        """;
        List<School> school;
        try (PreparedStatement stmt = getPreparedStatement(selectQuery)) {
            ResultSet resultSet = stmt.executeQuery();
            school = createListSchoolsObjFromResultSet(resultSet);
            resultSet.close();
        }

        return school;
    }

    private static Statement createStatement() throws SQLException {
        return JdbcUtils.getConnection().createStatement();
    }

    private static PreparedStatement prepareStatementDeleteTrainee(String query, Trainee trainee) throws SQLException {
        PreparedStatement stmt = getPreparedStatement(query);
        stmt.setInt(1, trainee.getId());

        return stmt;
    }

    private static PreparedStatement preparedStatementInsertSubject(String query, Subject subject) throws SQLException {
        PreparedStatement stmt = getPreparedStatementWithGeneratedKeys(query);
        stmt.setString(1, subject.getName());

        return stmt;
    }

    private static PreparedStatement prepareStatementSelectSubjectById(String query, int subjectId) throws SQLException {
        PreparedStatement stmt = getPreparedStatement(query);
        stmt.setInt(1, subjectId);

        return stmt;
    }

    private static PreparedStatement prepareStatementInsertSchool(String query, School school) throws SQLException {
        PreparedStatement stmt = getPreparedStatementWithGeneratedKeys(query);
        stmt.setString(1, school.getName());
        stmt.setInt(2, school.getYear());

        return stmt;
    }

    private static PreparedStatement prepareStatementSelectSchoolById(String query, int schoolId) throws SQLException {
        PreparedStatement stmt = getPreparedStatement(query);
        stmt.setInt(1, schoolId);

        return stmt;
    }

    private static School createSchoolObjFromResultSet(ResultSet resultSet) throws SQLException {
        School school = null;
        if (resultSet.next()) {
            school = new School(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3)
            );
        }

        return school;
    }

    private static School createSchoolObjWithGroupsFromResultSet(ResultSet resultSet) throws SQLException {
        School school = null;
        if (resultSet.next()) {
            school = new School(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3)
            );
            school.addGroup(new Group(
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            ));
            while (resultSet.next()) {
                school.addGroup(new Group(
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                ));
            }
        }

        return school;
    }

    private static PreparedStatement prepareStatementSelectTraineeById(String query, int traineeId) throws SQLException {
        PreparedStatement stmt = getPreparedStatement(query);
        stmt.setInt(1, traineeId);

        return stmt;
    }

    private static PreparedStatement prepareStatementUpdateTrainee(String query, Trainee trainee) throws SQLException {
        PreparedStatement stmt = getPreparedStatement(query);
        stmt.setString(1, trainee.getFirstName());
        stmt.setString(2, trainee.getLastName());
        stmt.setInt(3, trainee.getRating());
        stmt.setInt(4, trainee.getId());

        return stmt;
    }

    private static PreparedStatement prepareStatementInsertGroup(String query, School school, Group group) throws SQLException {
        PreparedStatement stmt = getPreparedStatementWithGeneratedKeys(query);
        stmt.setString(1, group.getName());
        stmt.setString(2, group.getRoom());
        stmt.setInt(3, school.getId());

        return stmt;
    }

    private static PreparedStatement prepareStatementSelectSchoolByIdWithGroups(String query, int id) throws SQLException {
        PreparedStatement stmt = getPreparedStatement(query);
        stmt.setInt(1, id);

        return stmt;
    }

    private static PreparedStatement prepareStatementInsertTrainee(String query, Trainee trainee) throws SQLException {
        PreparedStatement stmt = getPreparedStatementWithGeneratedKeys(query);
        stmt.setString(1, trainee.getFirstName());
        stmt.setString(2, trainee.getLastName());
        stmt.setInt(3, trainee.getRating());

        return stmt;
    }

    private static List<Trainee> aggregateAllTraineesFromResult(ResultSet resultSet) throws SQLException {
        List<Trainee> trainees = new ArrayList<>();
        while (resultSet.next()) {
            trainees.add(new Trainee(
                    resultSet.getInt("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getInt("rating"))
            );
        }

        return trainees;
    }

    private static List<School> createListSchoolsObjFromResultSet(ResultSet resultSet) throws SQLException {
        List<School> schools = new ArrayList<>();
        School school = null;
        if (resultSet.next()) {
            school = new School(
                    resultSet.getInt("schoolid"),
                    resultSet.getString("schoolname"),
                    resultSet.getInt("schoolyear")
            );
            schools.add(school);
            school.addGroup(new Group(
                    resultSet.getInt("groupid"),
                    resultSet.getString("groupname"),
                    resultSet.getString("grouproom")
            ));
        }
        while (resultSet.next()) {
            if (school != null && school.getId() == resultSet.getInt("schoolid")) {
                school.addGroup(new Group(
                        resultSet.getInt("groupid"),
                        resultSet.getString("groupname"),
                        resultSet.getString("grouproom")
                ));
            } else {
                school = new School(
                        resultSet.getInt("schoolid"),
                        resultSet.getString("schoolname"),
                        resultSet.getInt("schoolyear")
                );
                schools.add(school);
                school.addGroup(new Group(
                        resultSet.getInt("groupid"),
                        resultSet.getString("groupname"),
                        resultSet.getString("grouproom")
                ));
            }
        }

        return schools;
    }

    private static PreparedStatement getPreparedStatement(String query) throws SQLException {
        return JdbcUtils.getConnection().prepareStatement(query);
    }

    private static PreparedStatement getPreparedStatementWithGeneratedKeys(String query) throws SQLException {
        return JdbcUtils.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    }
}
