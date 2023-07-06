package net.thumbtack.school.database.mybatis.mappers;

import net.thumbtack.school.database.model.Group;
import net.thumbtack.school.database.model.Trainee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TraineeMapper {
    @Insert("""
            INSERT INTO `trainee` VALUE(null, #{trainee.firstName}, #{trainee.lastName}, #{trainee.rating})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "trainee.id", keyColumn = "id")
    int insert(@Param("trainee") Trainee trainee);



    @Select("""
        SELECT
            `trainee`.id as trainee_id,
            `trainee`.firstname as trainee_firstname,
            `trainee`.lastname as trainee_lastname,
            `trainee`.rating as trainee_rating
        FROM `trainee`
        WHERE `trainee`.id = #{id};
    """)
    @Results({
        @Result(property = "id", column = "trainee_id"),
        @Result(property = "firstName", column = "trainee_firstname"),
        @Result(property = "lastName", column = "trainee_lastname"),
        @Result(property = "rating", column = "trainee_rating")
    })
    Trainee getById(@Param("id") int id);



    @Select("""
        SELECT
            `trainee`.id as trainee_id, 
            `trainee`.firstname as trainee_firstname, 
            `trainee`.lastname as trainee_lastname, 
            `trainee`.rating as trainee_rating
        FROM `trainee`
    """)
    @Results({
            @Result(property = "id", column = "trainee_id"),
            @Result(property = "firstName", column = "trainee_firstname"),
            @Result(property = "lastName", column = "trainee_lastname"),
            @Result(property = "rating", column = "trainee_rating")
    })
    List<Trainee> getAll();



    @Update("""
        UPDATE `trainee`
        SET
            `trainee`.firstname = #{trainee.firstName},
            `trainee`.lastname = #{trainee.lastName},
            `trainee`.rating = #{trainee.rating}
        WHERE `trainee`.id = #{trainee.id};
    """)
    int update(@Param("trainee") Trainee trainee);



    @Select("""
        <script>
            SELECT
                `trainee`.id as trainee_id,
                `trainee`.firstname as trainee_firstName,
                `trainee`.lastname as trainee_lastName,
                `trainee`.rating as trainee_rating
            FROM `trainee`                        
            <where>
                <if test="firstName != null">
                    `trainee`.firstname like #{firstName}
                </if>
                
                <if test="lastName != null">
                    AND `trainee`.lastname like #{lastName}
                </if>
                
                <if test="rating != null">
                    AND `trainee`.rating = #{rating}
                </if>
            </where>
        </script>
    """)
    @Results({
            @Result(property = "id", column = "trainee_id"),
            @Result(property = "firstName", column = "trainee_firstName"),
            @Result(property = "lastName", column = "trainee_lastName"),
            @Result(property = "rating", column = "trainee_rating"),
    })
    List<Trainee> getAllWithParams(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("rating") Integer rating
    );



    @Insert("""
        <script>
            INSERT INTO `trainee` (id, firstname, lastname, rating)
            VALUES
                <foreach item='item' collection='list' separator=','>
                    (null, #{item.firstName}, #{item.lastName}, #{item.rating})
                </foreach>
        </script>        
    """)
    @Options(useGeneratedKeys = true, keyProperty = "list.id", keyColumn = "id")
    void batchInsert(@Param("list") List<Trainee> trainees);



    @Delete("""
        DELETE FROM `trainee` WHERE `trainee`.id = #{trainee.id};   
    """)
    int delete(@Param("trainee") Trainee trainee);



    @Delete("DELETE FROM `trainee`")
    int deleteAll();



    @Select("""
        SELECT
            `trainee`.id as trainee_id,
            `trainee`.firstname as trainee_firstname,
            `trainee`.lastname as trainee_lastname,
            `trainee`.rating as trainee_rating
        FROM `trainee`
        WHERE `trainee`.id IN (
                                SELECT `trainee_group`.traineeid 
                                FROM `trainee_group` 
                                WHERE `trainee_group`.groupid = #{group_id}
                           )
    """)
    @Results({
            @Result(property = "id", column = "trainee_id", id = true),
            @Result(property = "firstName", column = "trainee_firstname"),
            @Result(property = "lastName", column = "trainee_lastname"),
            @Result(property = "rating", column = "trainee_rating")
    })
    List<Trainee> getTraineesByGroupId(@Param("group_id") int id);
}
