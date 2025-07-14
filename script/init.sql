CREATE ROLE myappuser WITH LOGIN PASSWORD 'mypassword';
CREATE DATABASE supportclientdb OWNER myappuser;
GRANT ALL PRIVILEGES ON DATABASE supportclientdb TO myappuser;
GRANT ALL PRIVILEGES ON DATABASE postgresml TO myappuser;
GRANT USAGE ON SCHEMA public TO myappuser;
GRANT CREATE ON SCHEMA public TO myappuser;
GRANT USAGE ON SCHEMA public TO myappuser;
GRANT CREATE ON SCHEMA pgml TO myappuser;
GRANT USAGE ON SCHEMA pgml TO myappuser;
