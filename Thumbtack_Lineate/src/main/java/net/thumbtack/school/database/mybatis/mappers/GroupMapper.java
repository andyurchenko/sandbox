package net.thumbtack.school.database.mybatis.mappers;

import net.thumbtack.school.database.model.Group;
import net.thumbtack.school.database.model.School;
import net.thumbtack.school.database.model.Subject;
import net.thumbtack.school.database.model.Trainee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface GroupMapper {

    @Insert("""
        INSERT INTO `group`
        VALUE(null, #{group.name}, #{group.room}, #{school.id})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "group.id", keyColumn = "id")
    int insert(@Param("school") School school, @Param("group") Group group);



    @Insert("""
        <script>
            INSERT INTO `group` (id, name, room, schoolid)
            VALUES
                <foreach item='item' collection='list' separator=','>
                    (null, #{item.name}, #{item.room}, #{school_id})
                </foreach>
        </script>
    """)
    @Options(useGeneratedKeys = true, keyProperty = "list.id", keyColumn = "id")
    void batchInsert(@Param("list") List<Group> groups, @Param("school_id") int schoolId);



    @Update("""
        UPDATE `group`
        SET
            `group`.name = #{group.name},
            `group`.room = #{group.room}
        WHERE `group`.id = #{group.id}
            """)
    int update(@Param("group") Group group);



    @Select("""
        SELECT
            `group`.id AS group_id,
            `group`.name AS group_name,
            `group`.room AS group_room
        FROM `group`
    """)
    @Results({
            @Result(property = "id", column = "group_id", id = true),
            @Result(property = "name", column = "group_name"),
            @Result(property = "room", column = "group_room")
    })
    List<Group> getAll();



    @Delete("""
        DELETE FROM `group`
        WHERE `group`.id = #{group.id}
    """)
    int delete(@Param("group") Group group);



    @Delete("""
        DELETE FROM `trainee_group`
        WHERE `trainee_group`.traineeid = #{trainee.id}
    """)
    int deleteTraineeFromGroup(@Param("trainee") Trainee trainee);



    @Insert("""
        INSERT INTO `trainee_group` VALUE(null, #{trainee.id}, #{group.id})
    """)
    int addTraineeToGroup(@Param("group") Group group, @Param("trainee") Trainee trainee);



    @Insert("""
        INSERT INTO `subject_group` VALUE(null, #{subject.id}, #{group.id})
    """)
    int addSubjectToGroup(@Param("group") Group group, @Param("subject") Subject subject);



    @Insert("""
        <script>
            INSERT INTO `subject_group` (id, subjectid, groupid)
            VALUES
                <foreach item="item" index="index" collection="list" separator=",">
                    (null, #{item.id}, #{group_id})
                </foreach>
        </script>
            """)
    void batchAddingSubjectsToGroup(@Param("group_id") int groupId, @Param("list") List<Subject> subjects);


    @Select("""
        SELECT
            `group`.id AS group_id,
            `group`.name AS group_name,
            `group`.room AS group_room
        FROM `group`
        WHERE `group`.schoolid = #{groupId};
    """)
    @Results({
            @Result(property = "id", column = "group_id", id = true),
            @Result(property = "name", column = "group_name"),
            @Result(property = "room", column = "group_room"),
            @Result(
                    property = "trainees",
                    column = "group_id",
                    javaType = List.class,
                    many = @Many(
                            select = "net.thumbtack.school.database.mybatis.mappers.TraineeMapper.getTraineesByGroupId",
                            fetchType = FetchType.LAZY)
            ),
            @Result(
                    property = "subjects",
                    column = "group_id",
                    javaType = List.class,
                    many = @Many(
                            select = "net.thumbtack.school.database.mybatis.mappers.SubjectMapper.getSubjectsByGroupId",
                            fetchType = FetchType.LAZY
                    )
            )
    })
    List<Group> getGroupsBySchoolId(@Param("groupId") int id);
}
