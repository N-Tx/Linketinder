package database

import groovy.sql.Sql

interface ConnectionProvider {
    Sql getConnection()
}