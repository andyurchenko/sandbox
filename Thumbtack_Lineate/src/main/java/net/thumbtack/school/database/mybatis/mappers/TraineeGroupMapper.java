package net.thumbtack.school.database.mybatis.mappers;

import net.thumbtack.school.database.model.Trainee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TraineeGroupMapper {

    @Insert("""
           INSERT INTO `trainee_group` VALUE(null, #{trainee_id}, #{group_id})
    """)
    int insert(@Param("trainee_id") int traineeId, @Param("group_id") int groupId);



    @Insert("""
       <script>
           INSERT INTO `trainee_group` (id, traineeid, groupid)
           VALUES
                <foreach item="item" index="index" collection="list" separator=",">
                    (null, #{item.id}, #{group_id})
                </foreach>
       </script>
    """)
    int batchInsertTraineesToGroup(@Param("group_id") int groupId, @Param("list") List<Trainee> trainees);
}
