package net.thumbtack.school.database.mybatis.daoimpl;

import net.thumbtack.school.database.model.Group;
import net.thumbtack.school.database.model.School;
import net.thumbtack.school.database.model.Trainee;
import net.thumbtack.school.database.mybatis.dao.SchoolDao;
import net.thumbtack.school.database.mybatis.mappers.*;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SchoolDaoImpl extends DaoImplBase implements SchoolDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolDaoImpl.class);

    @Override
    public School insert(School school) {
        LOGGER.warn("Trying to insert the school - {}.", school.getName());
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SchoolMapper mapper = session.getMapper(SchoolMapper.class);
            LOGGER.debug("SchoolMapper created successfully.");
            mapper.insert(school);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot insert the school - {}.", school.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return school;
    }

    @Override
    public School getById(int id) {
        LOGGER.warn("Trying to select a school with ID - {}.", id);
        School school;
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SchoolMapper mapper = session.getMapper(SchoolMapper.class);
            LOGGER.debug("SchoolMapper created successfully.");
            school = mapper.getById(id);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot select a school with ID - {}.", id);
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return school;
    }

    @Override
    public List<School> getAllLazy() {
        LOGGER.warn("Trying to select all schools(LAZY).");
        List<School> schools;
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SchoolMapper mapper = session.getMapper(SchoolMapper.class);
            LOGGER.debug("SchoolMapper created successfully.");
            schools = mapper.getAllLazy();
            session.close();
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot select all schools.");
            session.close();
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return schools;
    }

    @Override
    public List<School> getAllUsingJoin() {
        LOGGER.warn("Trying to select all schools(JOIN).");
        List<School> schools;
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SchoolMapper mapper = session.getMapper(SchoolMapper.class);
            LOGGER.debug("SchoolMapper created successfully.");
            schools = mapper.getAllUsingJoin();
            session.close();
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot select all schools.");
            session.close();
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return schools;
    }

    @Override
    public void update(School school) {
        LOGGER.warn("Trying to update the school - {}.", school.getName());
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SchoolMapper mapper = session.getMapper(SchoolMapper.class);
            LOGGER.debug("SchoolMapper created successfully.");
            mapper.update(school);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot update the school - {}.", school.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");
    }

    @Override
    public void delete(School school) {
        LOGGER.warn("Trying to delete the school - {}.", school.getName());
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SchoolMapper mapper = session.getMapper(SchoolMapper.class);
            LOGGER.debug("SchoolMapper created successfully.");
            mapper.delete(school);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot delete the school - {}.", school.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");
    }

    @Override
    public void deleteAll() {
        LOGGER.warn("Trying to delete all schools.");
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SchoolMapper mapper = session.getMapper(SchoolMapper.class);
            LOGGER.debug("SchoolMapper created successfully.");
            mapper.deleteAll();
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot delete all schools.");
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");
    }

    @Override
    public School insertSchoolTransactional(School school) {
        LOGGER.warn("Trying to insert the school - {}. (Full insert with groups, trainees, etc).", school.getName());
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SchoolMapper schoolMapper = session.getMapper(SchoolMapper.class);
            LOGGER.debug("SchoolMapper created successfully.");
            schoolMapper.insert(school);

            GroupMapper groupMapper = session.getMapper(GroupMapper.class);
            LOGGER.debug("GroupMapper created successfully.");
            TraineeMapper traineeMapper = session.getMapper(TraineeMapper.class);
            LOGGER.debug("TraineeMapper created successfully.");
            TraineeGroupMapper traineeGroupMapper = session.getMapper(TraineeGroupMapper.class);
            LOGGER.debug("TraineeGroupMapper created successfully.");

            groupMapper.batchInsert(school.getGroups(), school.getId());
            for (Group group : school.getGroups()) {
                groupMapper.batchAddingSubjectsToGroup(group.getId(), group.getSubjects());
                traineeMapper.batchInsert(group.getTrainees());
                traineeGroupMapper.batchInsertTraineesToGroup(group.getId(), group.getTrainees());
            }
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot insert the school - {}. (Full insert with groups, trainees, etc).", school.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return school;
    }
}
