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

* Spring
* SpringBoot
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

## DDL

## Javadoc

## Rest Documentation

[Rest Api Documentation](docs/rest/api.md)

## Licenses

## Instructions for Building

## Instructions for Using This Component


