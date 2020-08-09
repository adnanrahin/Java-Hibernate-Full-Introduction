# What is Hibernate
A framework for persisting or saving Java objects in a database.

# What are the benefits of Hibernate?
Hibernate handles all of the low-level SQL code
Minimizes the amount of JDBC code have to develop
Hibernate provides the Object-to-Relational Mapping (ORM)

# Object-to-Relational-Mapping:
	The developer mapping between Java class and database table.

# Hibernate CRUD Apps
Create Objects
Read Objects
Update Objects
Delete Objects

# Relationship Between Hibernate and JDBC
Hibernate uses JDBC to all database communication. Hibernate is another layer of abstraction top of JDBC. Hibernate does all the low-level JDBC work, but in the background, it all goes thru standard JDBC API.

Note: Hibernate Uses JDBC API in Background to communicate with DataBase. 

# Steps of Hibernate:
# Create Hibernate Configuration File
The configuration file tells hibernate how to connect to the database. Hibernate uses JDBC in the background for communication with databases. 
# Annotate Java Class
	# Entity Class: Hibernate has Concept of Entity Class, Java Class that is mapped to a database table. It’s a plain old java class, that simply adds annotations in it to communicate with the database table. @Entity annotations are used for an entity class. 
	Step 1: Map class to database table. Annotations @Table(name = “table_name”)
	Step 2: Map Fields to the database columns.
# Developed Java code to perform database operations.
 
# SessionFactory
SessionFactory is an interface. SessionFactory can be created by providing a Configuration object, which will contain all the databases related property details pulled from either hibernate.cfg.xml file or hibernate.properties file. 
Read the hibernate config file.
Create Session Objects.
SessionFactory is Heavy Weight Object.
Only Create once in Application, and reuse the same SessionFactory Object use over and over again. 
# Session
Wraps a JDBC Connection to the DataBases.
The session object is used to save and retrieve objects.
A session object is a Short-Lived object. 

# Hibernate Annotations: 
	ID Generation Strategies: @GeneratedValue(strategy = “stratigie_name”)
GenerationType.AUTO: Pick an appropriate strategy for the particular database.
GenerationType.IDENTITY: Assign Primary Keys using the database identity column.
GenerationType.SEQUENCE: Assign primary keys using database sequence.
GenerationType.TABLE: Assing primary keys using an underlying database table to ensure uniqueness.

 
# Java Persistence API: 
Java Persistence API provides Java developers with an object/relational mapping facility for managing relational data in Java Applications. JPA is no more than an API and thus doesn’t provide any implementation but solely defines and standardizes the concepts of ORM in java. In order to use it, we must provide an implementation of the API. Java Persistence API allows us to map our domain model directly to the database structure and then giving us the flexibility of only manipulating objects in our code. 

# Entities:
An entity is a lightweight persistence domain object. Typical, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table. 
# Requirements for the Entity Class: 
The class must be annotated with Entity annotation.
The class must have a public or protected, no-argument constructor.
The class must not be declared final. 
If an entity instance is passed by value as a detached object, such as through a session bean’s remote business interface, the class must implement the Serializable interface. 
Entities may extend both entity and non-entity classes, and non-entity classes may extend entity classes.
Persistent instance variables must be declared private, protected, or package-private and can be accessed directly only by the entity class’s methods. Clients must access the entity’s state through accessor or business methods. 

# Hibernate Mappings: 
Hibernate Mappings are one of the key features of Hibernate. They establish the relationship between two database tables as attributes in models. We can be established either unidirectional or bidirectional relationships. The relationship that can be established between entities are:
@OneToOne - it represents the one to one relationship between two tables/Entities. 
@OneToMany - it represents the one to many relationships between two tables/Entities.
@ManyToOne - it represents the many to one relationship between two tables/Entities.
@ManyToMany - it represents the many to many relationships between two tables/Entities. 
