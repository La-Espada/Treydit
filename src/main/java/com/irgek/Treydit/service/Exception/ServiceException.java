package com.irgek.Treydit.service.Exception;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.PersistenceException;

public class ServiceException extends RuntimeException {
    private static final String CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS = "Cannot create entity of type %s %s due to database problems!";
    private static final String CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS_WITH_NULL_ENTITY = "Cannot create entity  due to database problems!";
    private static final String CANNOT_DELETE_DUE_TO_EXISTENCE_PROBLEMS = "Cannot delete the entity of type %s (%s) due to existence problems!";
    private static final String CANNOT_UPDATE_DUE_TO_ENTRY_PROBLEMS ="Cannot update the entity of type %s (%s) due to to entry problems!";
    private static final String CANNOT_FIND_USER_BY_EMAIL ="Cannot find the user by email!";

    private ServiceException (String message, Throwable rootCause){
        super(message,rootCause);
    }
    private ServiceException (String message){
        super(message);
    }

    public static <T extends AbstractPersistable<?>> ServiceException cannotCreateEntity(T entity, PersistenceException pEx){
        String msg = (entity == null)
                ? CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS_WITH_NULL_ENTITY.formatted(entity.getClass().getSimpleName(), entity)
                : CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS.formatted(entity.getClass().getSimpleName(), entity);
        return  new ServiceException(msg, pEx);
    }

    public static <T extends AbstractPersistable<?>> ServiceException cannotDeleteEntity(T entity, PersistenceException pEx){
        String msg = (entity == null)
                ? CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS_WITH_NULL_ENTITY.formatted(entity.getClass().getSimpleName(), entity)
                : CANNOT_DELETE_DUE_TO_EXISTENCE_PROBLEMS.formatted(entity.getClass().getSimpleName(), entity);
        return new ServiceException(msg,pEx);
    }

    public static <T extends AbstractPersistable<?>> ServiceException cannotUpdateEntity(T entity, PersistenceException pEx){
        String msg = (entity == null)
                ? CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS_WITH_NULL_ENTITY.formatted(entity.getClass().getSimpleName(), entity)
                : CANNOT_UPDATE_DUE_TO_ENTRY_PROBLEMS.formatted(entity.getClass().getSimpleName(), entity);
        return new ServiceException(msg,pEx);
    }

    public static <T extends AbstractPersistable<?>> ServiceException cannotFindUserbyEmail(String s){
        String msg = (s == null)
                ? CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS_WITH_NULL_ENTITY.formatted(s)
                : CANNOT_UPDATE_DUE_TO_ENTRY_PROBLEMS.formatted(s);
        return new ServiceException(msg);
    }
}
