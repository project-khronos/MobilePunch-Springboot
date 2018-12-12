# MobilePunch-Springboot

## Motivation
* Project management and event tracking all in one place

* Accessable up to date logs

* Quick and easy to use interface

* Accurate and with you all the time

## Functional Inventory
* Implements the backend database
* Implements the server with REST API



## Project Kronos Team Members

* Alex Benedict - Database, OAuth2 
* Travis Decker - Database, Rest API, Json serialization

## Service Endpoints

Server base URL: [https://straylense.space/projectkhronos](https://straylense.space/projectkhronos)

* /clients
* /clients/{clientId}
* /clients/{clientId}/projects
* /equipment
* /equipment/{equipmentId}
* /events/{eventId}
* /events/{eventId}/equipment
* /projects
* /projects/{projectId}
* /projects/{projectId}/clients
* /projects/{projectId}/events

## Current State

The basic enitities used by the frontend application can be saved and retrieved with user based authentication.  The main unimplemented feature is the storage, retrival, and association of images, however it is equally unimplemented on the frontend so the prototype works.

## Platforms
We have run the server on a virtualized host from A2 hosting.  The host was running a Centos 6 kernel and a Centos 7 userland.  We have also tested the server running locally on MacOS and Ubuntu 18.04 on a Macbook Pro and a ThinkPad.

## Third Party Libraries

* Spring-Boot
* Hibernate
* Jackson
* Derby
* Swagger
* Swagger Maven Plugin by kongchen

## External Services

Google OAuth2

## Stretch Goals

Allow users to save images with events. 

## Aesthic improvements

Not Applicable.

## Wireframes and User Stories

Not Applicable.

## ERD 

[ERD](DetailedERD.pdf)

## DDL

```
CREATE TABLE client_entity
  (
     client_id   CHAR(16) FOR bit DATA NOT NULL,
     address     VARCHAR(255),
     alt_address VARCHAR(255),
     alt_phone   VARCHAR(255),
     email       VARCHAR(255),
     name        VARCHAR(255),
     notes       VARCHAR(4096),
     phone       VARCHAR(255),
     user_id     VARCHAR(255),
     PRIMARY KEY (client_id)
  )
  CREATE TABLE equipment_entity
  (
     equipment_id   CHAR(16) FOR bit DATA NOT NULL,
     description    VARCHAR(255),
     identification VARCHAR(255),
     make           VARCHAR(255),
     mfcyear        VARCHAR(255),
     model          VARCHAR(255),
     name           VARCHAR(255),
     user_id        VARCHAR(255),
     PRIMARY KEY (equipment_id)
  )
  CREATE TABLE event_entity
  (
     event_id               CHAR(16) FOR bit DATA NOT NULL,
     description            VARCHAR(255),
     end_time               TIMESTAMP,
     expenses               DECIMAL(19, 2),
     income                 DECIMAL(19, 2),
     latitude               DOUBLE NOT NULL,
     longitude              DOUBLE NOT NULL,
     start_time             TIMESTAMP,
     user_id                VARCHAR(255),
     equipment_equipment_id CHAR(16) FOR bit DATA,
     project_id             CHAR(16) FOR bit DATA,
     PRIMARY KEY (event_id)
  )
  CREATE TABLE image_entity
  (
     image_id    CHAR(16) FOR bit DATA NOT NULL,
     description VARCHAR(255),
     PRIMARY KEY (image_id)
  )
  CREATE TABLE project_entity
  (
     project_id        CHAR(16) FOR bit DATA NOT NULL,
     description       VARCHAR(255),
     end_time          TIMESTAMP,
     expected_end_time TIMESTAMP,
     name              VARCHAR(255),
     start_time        TIMESTAMP,
     user_id           VARCHAR(255),
     client_client_id  CHAR(16) FOR bit DATA,
     PRIMARY KEY (project_id)
  )
ALTER TABLE event_entity
  ADD CONSTRAINT fkn17760wpa8iik6n3chbsdyf0j FOREIGN KEY (equipment_equipment_id
  ) REFERENCES equipment_entity

ALTER TABLE event_entity
  ADD CONSTRAINT fkm6o0pmsmtunwww5uwwp3yfxte FOREIGN KEY (project_id) REFERENCES
  project_entity

ALTER TABLE project_entity
  ADD CONSTRAINT fkjuu4wqlebuwb93pr1hukwag01 FOREIGN KEY (client_client_id)
  REFERENCES client_entity  

```


## Javadoc

[Javadoc](/docs/api/index.html)

## Rest Documentation

[Rest Api Documentation](docs/rest/api.md)

## Licenses

[Spring-boot](https://github.com/spring-projects/spring-boot/blob/master/LICENSE.txt)

[Hibernate](http://hibernate.org/community/license/)

[Jackson](http://www.apache.org/licenses/LICENSE-2.0.txt)

[Derby](http://www.apache.org/licenses/LICENSE-2.0)

[Swagger](https://swagger.io/license/)

[Swagger Maven Plugin by kongchen](https://github.com/kongchen/swagger-maven-plugin/blob/master/LICENSE)


## Instructions for Building




## Instructions for Using This Component
After building the jar file,





