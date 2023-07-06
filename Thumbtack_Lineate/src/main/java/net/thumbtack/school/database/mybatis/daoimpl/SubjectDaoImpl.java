package net.thumbtack.school.database.mybatis.daoimpl;

import net.thumbtack.school.database.model.Subject;
import net.thumbtack.school.database.mybatis.dao.SubjectDao;
import net.thumbtack.school.database.mybatis.mappers.SubjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl extends DaoImplBase implements SubjectDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectDaoImpl.class);

    @Override
    public Subject insert(Subject subject) {
        LOGGER.debug("Trying to insert a subject - {}.", subject.getName());
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);
            LOGGER.debug("SubjectMapper created successfully.");
            subjectMapper.insert(subject);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot insert a subject - {}.", subject.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return subject;
    }

    @Override
    public Subject getById(int id) {
        LOGGER.debug("Trying to select a subject with id = {}.", id);
        Subject subject;
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);
            LOGGER.debug("SubjectMapper created successfully.");
            subject = subjectMapper.getById(id);
            session.close();
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot select a subject by id = {}.", id);
            session.close();
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return subject;
    }

    @Override
    public List<Subject> getAll() {
        LOGGER.debug("Trying to select all subjects.");
        List<Subject> subjects;
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);
            LOGGER.debug("SubjectMapper created successfully.");
            subjects = new ArrayList<>(subjectMapper.getAll());
            session.close();
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot select all subjects.");
            session.close();
            throw e;
        }
        LOGGER.debug("Method has been executed without any errors.");

        return subjects;
    }

    @Override
    public Subject update(Subject subject) {
        LOGGER.debug("Trying to update a subject: {}.", subject.getName());
        SqlSession session = getSession();
        try {
            LOGGER.debug("SqlSession is opened successfully.");
            SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);
            LOGGER.debug("SubjectMapper created successfully.");
            subjectMapper.update(subject);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.debug("Error updating a subject: {}.", subject.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("Method has been executed without any errors.");

        return subject;
    }

    @Override
    public void delete(Subject subject) {
        LOGGER.debug("Trying to delete a subject: {}.", subject.getName());
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);
            LOGGER.debug("SubjectMapper created successfully.");
            subjectMapper.delete(subject);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.debug("Error deleting a subject: {}.", subject.getName());
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("Method has been executed without any errors.");
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("Trying to delete all subjects.");
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);
            LOGGER.debug("SubjectMapper created successfully.");
            subjectMapper.deleteAll();
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.debug("Error deleting all subjects.");
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("Method has been executed without any errors.");
    }
}
