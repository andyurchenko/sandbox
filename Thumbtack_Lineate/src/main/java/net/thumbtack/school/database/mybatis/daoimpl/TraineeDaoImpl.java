package net.thumbtack.school.database.mybatis.daoimpl;

import net.thumbtack.school.database.model.Group;
import net.thumbtack.school.database.model.Trainee;
import net.thumbtack.school.database.mybatis.dao.TraineeDao;
import net.thumbtack.school.database.mybatis.mappers.GroupMapper;
import net.thumbtack.school.database.mybatis.mappers.SubjectMapper;
import net.thumbtack.school.database.mybatis.mappers.TraineeGroupMapper;
import net.thumbtack.school.database.mybatis.mappers.TraineeMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TraineeDaoImpl extends DaoImplBase implements TraineeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraineeDaoImpl.class);

    @Override
    public Trainee insert(Group group, Trainee trainee) {
        LOGGER.debug("Trying to insert the trainee - {}.", getTraineeFullName(trainee));
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            TraineeMapper traineeMapper = session.getMapper(TraineeMapper.class);
            LOGGER.debug("TraineeMapper created successfully.");
            traineeMapper.insert(trainee);
            if (group != null && group.getId() > 0) {
                TraineeGroupMapper traineeGroupMapper = session.getMapper(TraineeGroupMapper.class);
                LOGGER.debug("TraineeGroupMapper created successfully.");
                traineeGroupMapper.insert(trainee.getId(), group.getId());
            }
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot insert the trainee - {}.", getTraineeFullName(trainee));
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return trainee;
    }

    @Override
    public Trainee getById(int id) {
        LOGGER.debug("Trying to select a trainee with ID - {}.", id);
        Trainee trainee;
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            TraineeMapper mapper = session.getMapper(TraineeMapper.class);
            LOGGER.debug("TraineeMapper created successfully.");
            trainee = mapper.getById(id);
            session.close();
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot select a trainee with ID - {}.", id);
            session.close();
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return trainee;
    }

    @Override
    public List<Trainee> getAll() {
        LOGGER.debug("Trying to select all trainees.");
        List<Trainee> trainees;
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            TraineeMapper mapper = session.getMapper(TraineeMapper.class);
            LOGGER.debug("TraineeMapper created successfully.");
            trainees = mapper.getAll();
            session.close();
        } catch (RuntimeException e) {
            LOGGER.warn("Cannot select all trainees.");
            session.close();
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return trainees;
    }

    @Override
    public Trainee update(Trainee trainee) {
        LOGGER.debug("Trying to update info about the trainee - {}.", getTraineeFullName(trainee));
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            TraineeMapper mapper = session.getMapper(TraineeMapper.class);
            LOGGER.debug("TraineeMapper created successfully.");
            mapper.update(trainee);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Error updating the trainee {}", getTraineeFullName(trainee));
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return trainee;
    }

    @Override
    public List<Trainee> getAllWithParams(String firstName, String lastName, Integer rating) {
        LOGGER.debug("Trying to select trainees with parameters.");
        List<Trainee> trainees;
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            TraineeMapper mapper = session.getMapper(TraineeMapper.class);
            LOGGER.debug("TraineeMapper created successfully.");
            trainees = mapper.getAllWithParams(firstName, lastName, rating);
            session.close();
        } catch (RuntimeException e) {
            LOGGER.warn("Error getting trainees with params: Firstname -  {}, Lastname - {}, rating - {}.",
                    firstName,
                    lastName,
                    rating);
            session.close();
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");

        return trainees;
    }

    @Override
    public void batchInsert(List<Trainee> trainees) {
        LOGGER.debug("Trying to insert batch of trainees.");
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            TraineeMapper mapper = session.getMapper(TraineeMapper.class);
            LOGGER.debug("TraineeMapper created successfully.");
            mapper.batchInsert(trainees);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Error inserting batch of trainees.");
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");
    }

    @Override
    public void delete(Trainee trainee) {
        LOGGER.debug("Trying to delete the trainee - {}.", getTraineeFullName(trainee));
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            TraineeMapper mapper = session.getMapper(TraineeMapper.class);
            LOGGER.debug("TraineeMapper created successfully.");
            mapper.delete(trainee);
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Error deleting the trainee - {}.", getTraineeFullName(trainee));
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("Trying to delete all trainees");
        SqlSession session = getSession();
        LOGGER.debug("SqlSession is opened successfully.");
        try {
            TraineeMapper mapper = session.getMapper(TraineeMapper.class);
            LOGGER.debug("TraineeMapper created successfully.");
            mapper.deleteAll();
            commitAndCloseSession(session);
        } catch (RuntimeException e) {
            LOGGER.warn("Error deleting all trainees.");
            rollbackAndCloseSession(session);
            throw e;
        }
        LOGGER.debug("The method has been executed without any errors.");
    }

    private String getTraineeFullName(Trainee trainee) {
        return trainee.getFirstName() + " " + trainee.getLastName();
    }
}
