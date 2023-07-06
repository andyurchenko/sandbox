package net.thumbtack.school.database.mybatis.mappers;

import net.thumbtack.school.database.model.Subject;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface SubjectMapper {

    @Insert("INSERT INTO `subject` VALUE(null, #{subject.name})")
    @Options(useGeneratedKeys = true, keyProperty = "subject.id", keyColumn = "id")
    Integer insert(@Param("subject")Subject subject);



    @Insert("""
       <script>
           INSERT INTO `subject` (id, name)
           VALUES
                <foreach item="item" index="index" collection="list" separator=",">
                    (null, #{item.name}, #{group_id})
                </foreach>
       </script>
    """)
    @Options(useGeneratedKeys = true, keyProperty = "list.id", keyColumn = "id")
    int batchInsertTrainees(@Param("list") List<Subject> subjects);



    @Select("SELECT * FROM `subject` WHERE `subject`.id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    Subject getById(@Param("id") int id);



    @Select("""
        SELECT
            `subject`.id as subject_id, `subject`.name as subject_name
        FROM `subject`
    """)
    @Results({
        @Result(property = "id", column = "subject_id"),
        @Result(property = "name", column = "subject_name")
    })
    List<Subject> getAll();



    @Update("""
            UPDATE `subject`
            SET `subject`.name = #{subject.name}
            WHERE `subject`.id = #{subject.id}
    """)
    int update(@Param("subject") Subject subject);



    @Delete("DELETE FROM `subject` WHERE `subject`.id = #{subject.id}")
    int delete(@Param("subject") Subject subject);



    @Delete("DELETE FROM `subject`")
    int deleteAll();


    @Select("""
        SELECT
            `subject`.id AS subject_id,
            `subject`.name AS subject_name
        FROM `subject`
        WHERE `subject`.id IN (
                                SELECT `subject_group`.subjectid
                                FROM `subject_group`
                                WHERE `subject_group`.groupid = #{group_id}
                            )
    """)
    @Results({
        @Result(property = "id", column = "subject_id", id = true),
        @Result(property = "name", column = "subject_name")
    })
    List<Subject> getSubjectsByGroupId(@Param("group_id") int id);
}
