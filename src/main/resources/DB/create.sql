SET MODE PostgreSQL;

CREATE DATABASE easyeats;

CREATE TABLE IF NOT EXISTS shops (
  id serial PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS waiters (
  id serial PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS order_types (
  id serial PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS next_gen_tables (
  id serial PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS menus (
  id serial PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS cuisines(
id serial PRIMARY KEY,
foodType VARCHAR,
price INTEGER,
menuId INTEGER
);