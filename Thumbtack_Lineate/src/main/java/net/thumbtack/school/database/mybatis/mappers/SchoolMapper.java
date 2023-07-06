package net.thumbtack.school.database.mybatis.mappers;

import net.thumbtack.school.database.model.School;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface SchoolMapper {

    @Insert("""
        INSERT INTO `school` VALUE(null, #{school.name}, #{school.year})        
    """)
    @Options(useGeneratedKeys = true, keyProperty = "school.id", keyColumn = "id")
    int insert(@Param("school") School school);



    @Select("""
        SELECT
            `school`.id AS school_id,
            `school`.name AS school_name,
            `school`.year AS school_year
        FROM `school`
        WHERE `school`.id = #{id}
    """)
    @Results({
            @Result(property = "id", column = "school_id"),
            @Result(property = "name", column = "school_name"),
            @Result(property = "year", column = "school_year"),
            @Result(property = "groups",
                    column = "school_id",
                    javaType = List.class,
                    many = @Many(select = "net.thumbtack.school.database.mybatis.mappers.GroupMapper.getGroupsBySchoolId", fetchType = FetchType.LAZY)
            )
    })
    School getById(@Param("id") int id);



    @Select("""
        SELECT 
            `school`.id AS school_id,
            `school`.name AS school_name,
            `school`.year AS school_year
        FROM `school`
    """)
    @Results({
            @Result(property = "id", column = "school_id"),
            @Result(property = "name", column = "school_name"),
            @Result(property = "year", column = "school_year"),
            @Result(property = "groups",
                    column = "school_id",
                    javaType = List.class,
                    many = @Many(select = "net.thumbtack.school.database.mybatis.mappers.GroupMapper.getGroupsBySchoolId", fetchType = FetchType.LAZY)
            )
    })
    List<School> getAllLazy();



    // получает список всех School вместе с Group, Subject, и Trainee, используя JOIN подход. Если БД не содержит ни одной School, метод должен возвращать пустой список
    List<School> getAllUsingJoin();



    @Update("""
        UPDATE `school`
        SET
            `school`.name = #{school.name},
            `school`.year = #{school.year}
        WHERE `school`.id = #{school.id}
    """)
    int update(@Param("school") School school);



    @Delete("""
        DElETE FROM `school`
        WHERE `school`.id = #{school.id}
    """)
    int delete(@Param("school") School school);




    @Delete("""
        DElETE FROM `school`
    """)
    int deleteAll();

    // трансакционно вставляет School вместе с ее Group, со всеми Trainee этих Group, и привязывает все Subject для этих Group
    // предполагается, что сами Subject были вставлены раньше
    School insertSchoolTransactional(School school);
}
