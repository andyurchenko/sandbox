package net.thumbtack.school.database.mybatis.daoimpl;

import net.thumbtack.school.database.model.Group;
import net.thumbtack.school.database.model.School;
import net.thumbtack.school.database.model.Subject;
import net.thumbtack.school.database.model.Trainee;
import net.thumbtack.school.database.mybatis.dao.GroupDao;
import net.thumbtack.school.database.mybatis.mappers.GroupMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GroupDaoImpl extends DaoImplBase implements GroupDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupDaoImpl.class);

    @Override
    public Group insert(School school, Group group) {
        LOGGER.warn("Trying to insert the group - {}.", group.getName());
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            GroupMapper mapper = session.getMapper(GroupMapper.class);
            LOGGER.debug("GroupMapper created successfully.");
            mapper.insert(school, group);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot insert the group - {}.", group.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return group;
    }

    @Override
    public Group update(Group group) {
        LOGGER.warn("Trying to update the group - {}.", group.getName());
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            GroupMapper mapper = session.getMapper(GroupMapper.class);
            LOGGER.debug("GroupMapper created successfully.");
            mapper.update(group);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot update the group - {}.", group.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return group;
    }

    @Override
    public List<Group> getAll() {
        LOGGER.warn("Trying to select all groups.");
        List<Group> groups;
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            GroupMapper mapper = session.getMapper(GroupMapper.class);
            LOGGER.debug("GroupMapper created successfully.");
            groups = mapper.getAll();
            session.close();
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot select all groups.");
            session.close();
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return groups;
    }

    @Override
    public void delete(Group group) {
        LOGGER.warn("Trying to delete the group - {}.", group.getName());
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            GroupMapper mapper = session.getMapper(GroupMapper.class);
            LOGGER.debug("GroupMapper created successfully.");
            mapper.delete(group);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot delete the group - {}.", group.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");
    }

    @Override
    public Trainee moveTraineeToGroup(Group group, Trainee trainee) {
        LOGGER.warn("Trying to move the trainee - {} to the group - {}.", getTraineeFullName(trainee), group.getName());
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            GroupMapper mapper = session.getMapper(GroupMapper.class);
            LOGGER.debug("GroupMapper created successfully.");
            mapper.deleteTraineeFromGroup(trainee);
            mapper.addTraineeToGroup(group, trainee);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot move the trainee - {} to the group - {}.", getTraineeFullName(trainee), group.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return trainee;
    }

    @Override
    public void deleteTraineeFromGroup(Trainee trainee) {
        LOGGER.warn("Trying to delete the trainee - {} from all groups.", getTraineeFullName(trainee));
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            GroupMapper mapper = session.getMapper(GroupMapper.class);
            LOGGER.debug("GroupMapper created successfully.");
            mapper.deleteTraineeFromGroup(trainee);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot delete the trainee - {} from all groups.", getTraineeFullName(trainee));
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");
    }

    @Override
    public void addSubjectToGroup(Group group, Subject subject) {
        LOGGER.warn("Trying to add the subject - {} to the group - {}.", subject.getName(), group.getName());
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            GroupMapper mapper = session.getMapper(GroupMapper.class);
            LOGGER.debug("GroupMapper created successfully.");
            mapper.addSubjectToGroup(group, subject);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot add the subject - {} to the group - {}.", subject.getName(), group.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");
    }

    private String getTraineeFullName(Trainee trainee) {
        return trainee.getFirstName() + " " + trainee.getLastName();
    }
}
