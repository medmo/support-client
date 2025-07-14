#!/usr/bin/env bash

# PGPASSWORD=mypassword psql -U myappuser -h localhost -p 5433 postgresml
cat init.sql |  psql -U postgresml  -h localhost -p 5435 postgresml

