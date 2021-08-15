# EasyEats

JavaBackEnd for - Ann app that digitizes the ordering process of food at the NextGen Mall, whereby a client would go to the food court then place an order using a mobile web application right from their table.

## Getting Started

Ensure to follow these instructions to set upa and run successfully.

## Setup Instructions

* Ensure gradle is installed, synced and all dependencies downloaded.
* Run this command to clone into your local repo
```
git clone https://github.com/OderoOluoch/EasyEats-BackEnd.git

```

## Database set up Instructions



run

 ```
 $ psql < create.sql
 ```

if this doesn't work, go and do this manually. as below

```
CREATE DATABASE easyeats;

```

```
\c easyeats;

```

```
SET MODE PostgreSQL;

CREATE DATABASE easyeats;

CREATE TABLE IF NOT EXISTS shops (
  id serial PRIMARY KEY,
  name VARCHAR,
  tagline VARCHAR,
  image VARCHAR
);

CREATE TABLE IF NOT EXISTS waiter (
  id serial PRIMARY KEY,
  name VARCHAR,
  shop_id INTEGER
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
  name VARCHAR,
  description VARCHAR,
  shop_id INTEGER
);

CREATE TABLE IF NOT EXISTS cuisines(
id serial PRIMARY KEY,
food VARCHAR,
image VARCHAR,
price INTEGER,
menu_id INTEGER
);
```



* Navigate to the root folder of the repo via your terminal.
* Run this command to start gradle via the terminal

```
$ gradle run

```

* Use this URL on your browser `localhost:4567/api/v1` , you will see
  `{
  "Welcome to nextGen API"
  }`




| URL end point | Description |
        |:---        |          ---: |

``api/v1/menus - GET - Get a list of all menu Items``

``api/v1/menus/new  - POST - send an object with menu name, description and shop_id .``

``api/v1/menus/{id}    - GET - Get a menu item by id.``

``api/v1/menus/{id}/cuisines - GET - Get a list of all food cuisines of a specific menu category item``

``api/v1/waiters - GET - Get a list of all waiter Items``

``api/v1/waiters/new  - POST - send an object with waiter name and shop_id ``

``api/v1/waiters/{id}    - GET - Get a waiter item by id.``

``api/v1/shops - GET - Get a list of all shops Items``

``api/v1/shop/new  - POST - send an object with shop name.``

``api/v1/shops/{id}    - GET - Get a shop item by id.``

``api/v1/shops/{id}/menus    - GET - Get a list of all menu category items in a specific shop.``

``api/v1/shops/{id}/waiters    - GET - Get all waiters in a specific shop.``

``api/v1/tables - GET - Get a list of all tables``

``api/v1/tables/new  - POST - send an object with table name.``

``api/v1/tables/{id}    - GET - Get a table item by id.``

``api/v1/order_types - GET - Get a list of all order type Items``

``api/v1/order_types/new  - POST - send an object with order type name.``

``api/v1/order_types/{id}    - GET - Get an order type item by id.``

``api/v1/cuisines - GET - Get a list of all food and cusines available``

``api/v1/cuisines/new  - POST - send an object with food, image url , price and menu_id``

``api/v1/cuisines/{id}    - GET - Get an order type item by id.``


* when testing with postman, use as the base URL.


```
easyeatsodero.herokuapp.com/api/v1/

```

 



## Technologies used
- Java
- Gradle
- J-Unit5
- GSON


## Bugs being worked on
- It is open for critique and improvements

## Support and contact details
To help grow and make this product better, reach out to [email](mailto:oderoluoch@gmail.com).
### LICENSE
[![License: ISC](https://img.shields.io/badge/License-ISC-yellow.svg)](/LICENSE)

## Contributors 
**[Odero Oluoch](www.github.com/OderoOluoch)** ,
**[Allan Mughus](www.github.com/Allantoizmughus)** ,
**[Quieenzy Ong'eye](www.github.com/Queen-01)**,
**[Joseph Wangare](www.github.com/kabue-moringa)**
