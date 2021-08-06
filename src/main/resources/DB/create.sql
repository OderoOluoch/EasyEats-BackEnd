SET MODE PostgreSQL;

CREATE DATABASE easyeats;

CREATE TABLE IF NOT EXISTS shops (
  id serial PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS waiter (
  id serial PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS order_type (
  id serial PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS next_gen_table (
  id serial PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS menu (
  id serial PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS cuisines(
id serial PRIMARY KEY,
foodType VARCHAR,
price INTEGER,
menuId INTEGER
);