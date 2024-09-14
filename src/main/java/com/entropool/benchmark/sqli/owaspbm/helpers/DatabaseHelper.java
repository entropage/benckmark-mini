package com.entropool.benchmark.sqli.owaspbm.helpers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DatabaseHelper {

    public static org.springframework.jdbc.core.JdbcTemplate JDBCtemplate;

    // If we want SQL Exceptions to be suppressed from being displayed to the user of the web app.
    public static final boolean hideSQLErrors = false;


    @Autowired
    private org.springframework.jdbc.core.JdbcTemplate  conJdbcTemplate;

    @PostConstruct
    public void init() {
        JDBCtemplate = conJdbcTemplate;
        createProcedures();
    }

    private void createProcedures() {
        try {
            JDBCtemplate.execute("DROP PROCEDURE IF EXISTS verifyUserPassword");
            JDBCtemplate.execute(
                    "CREATE PROCEDURE verifyUserPassword(IN username_ varchar(50), IN password_ varchar(50))"
                            + " READS SQL DATA"
                            + " DYNAMIC RESULT SETS 1"
                            + " BEGIN ATOMIC"
                            + " DECLARE resultSet SCROLL CURSOR WITH HOLD WITH RETURN FOR SELECT * FROM USERS WHERE USERNAME = username_ AND PASSWORD = password_;"
                            + " OPEN resultSet;"
                            + "END;");
        } catch (Exception e) {
            if (!hideSQLErrors) {
               log.error("Error creating procedure", e);
            }
        }

        try {
            JDBCtemplate.execute("DROP PROCEDURE IF EXISTS verifyEmployeeSalary");
            JDBCtemplate.execute(
                    "CREATE PROCEDURE verifyEmployeeSalary(IN user_ varchar(50))"
                            + " READS SQL DATA"
                            + " DYNAMIC RESULT SETS 1"
                            + " BEGIN ATOMIC"
                            + " DECLARE resultSet SCROLL CURSOR WITH RETURN FOR SELECT * FROM EMPLOYEE WHERE FIRST_NAME = user_;"
                            + " OPEN resultSet;"
                            + "END;");
        } catch (Exception e) {
            if (!hideSQLErrors) {
                log.error("Error creating procedure", e);
            }
        }

    }
}
