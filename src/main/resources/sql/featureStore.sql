DROP SCHEMA IF EXISTS feature_store CASCADE;

CREATE SCHEMA IF NOT EXISTS feature_store;

SET search_path TO feature_store;

CREATE TABLE users (
                       id_users SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE datasets (
                          id_datasets SERIAL PRIMARY KEY,
                          id_creator INT REFERENCES users (id_users),
                          description VARCHAR(1000) NOT NULL,
                          date_hour TIMESTAMP DEFAULT NOW(),
                          source VARCHAR(100)
);

CREATE TABLE version (
                         id_version SERIAL PRIMARY KEY,
                         id_dataset INT REFERENCES datasets (id_datasets),
                         id_creator INT REFERENCES users (id_users),
                         id_version_base INT REFERENCES version (id_version),
                         creation_date TIMESTAMP DEFAULT NOW(),
                         archive_path VARCHAR(500) NOT NULL,
                         changes TEXT
);

CREATE TABLE log_access (
                            id_log_access SERIAL PRIMARY KEY,
                            id_user INT REFERENCES users (id_users),
                            id_current_version INT REFERENCES version (id_version),
                            type_access VARCHAR(8),
                            date_access TIMESTAMP DEFAULT NOW()
);

ALTER TABLE log_access
    ADD CONSTRAINT check_type_access
        CHECK (type_access IN ('VIEW', 'DOWNLOAD'));