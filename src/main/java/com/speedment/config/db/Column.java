package com.speedment.config.db;

import com.speedment.config.Document;
import com.speedment.config.db.trait.HasAlias;
import com.speedment.config.db.trait.HasEnabled;
import com.speedment.config.db.trait.HasName;
import com.speedment.config.db.trait.HasParent;
import com.speedment.config.db.mapper.TypeMapper;
import com.speedment.exception.SpeedmentException;

/**
 *
 * @author Emil Forslund
 */
public interface Column extends Document, HasParent<Table>, HasEnabled, HasName, HasAlias {

    final String 
        NULLABLE       = "nullable",
        AUTO_INCREMENT = "autoIncrement",
        TYPE_MAPPER    = "typeMapper",
        DATABASE_TYPE  = "databaseType";
    
    /**
     * Returns whether or not this column can hold <code>null</code> values.
     * 
     * @return  <code>true</code> if null values are tolerated, else 
     *          <code>false</code>
     */
    default boolean isNullable() {
        return getAsBoolean(NULLABLE).orElse(true);
    }
    
    /**
     * Returns whether or not this column will auto increment when new values
     * are added to the table.
     * 
     * @return  <code>true</code> if the column auto increments, else 
     *          <code>false</code>
     */
    default boolean isAutoIncrement() {
        return getAsBoolean(AUTO_INCREMENT).orElse(false);
    }
    
    /**
     * Returns the mapper class that will be used to generate a java 
     * representation of the database types.
     * 
     * @return  the mapper class
     */
    default TypeMapper<?, ?> findTypeMapper() {
        final String name = getTypeMapper();
        
        try {
            @SuppressWarnings("unchecked")
            final TypeMapper<?, ?> mapper = (TypeMapper<?, ?>) Class.forName(name).newInstance();
            return mapper;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            throw new SpeedmentException("Could not instantiate TypeMapper: '" + name + "'.", ex);
        }
    }

    /**
     * Returns the name of the mapper class that will be used to generate a java 
     * representation of the database types.
     * 
     * @return  the mapper class
     */
    default String getTypeMapper() {
        return getAsString(TYPE_MAPPER).get();
    }
    
    /**
     * Returns the name of the class that represents the database type.
     * 
     * @return  the database type class
     */
    default String getDatabaseType() {
        return getAsString(DATABASE_TYPE).get();
    }
    
    /**
     * Returns the class that represents the database type.
     * 
     * @return  the database type
     */
    default Class<?> findDatabaseType() {
        final String name = getDatabaseType();
        
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException ex) {
            throw new SpeedmentException("Could not find database type: '" + name + "'.", ex);
        }
    }
}