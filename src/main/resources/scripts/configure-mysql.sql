## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql:5.7

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE cro_dev;
CREATE DATABASE cro_prod;

#Create database service accounts
CREATE USER 'cro_dev_user'@'localhost' IDENTIFIED BY 'cro';
CREATE USER 'cro_prod_user'@'localhost' IDENTIFIED BY 'cro';
CREATE USER 'cro_dev_user'@'%' IDENTIFIED BY 'cro';
CREATE USER 'cro_prod_user'@'%' IDENTIFIED BY 'cro';

#Database grants
GRANT SELECT ON cro_dev.* to 'cro_dev_user'@'localhost';
GRANT INSERT ON cro_dev.* to 'cro_dev_user'@'localhost';
GRANT DELETE ON cro_dev.* to 'cro_dev_user'@'localhost';
GRANT UPDATE ON cro_dev.* to 'cro_dev_user'@'localhost';
GRANT SELECT ON cro_prod.* to 'cro_prod_user'@'localhost';
GRANT INSERT ON cro_prod.* to 'cro_prod_user'@'localhost';
GRANT DELETE ON cro_prod.* to 'cro_prod_user'@'localhost';
GRANT UPDATE ON cro_prod.* to 'cro_prod_user'@'localhost';
GRANT SELECT ON cro_dev.* to 'cro_dev_user'@'%';
GRANT INSERT ON cro_dev.* to 'cro_dev_user'@'%';
GRANT DELETE ON cro_dev.* to 'cro_dev_user'@'%';
GRANT UPDATE ON cro_dev.* to 'cro_dev_user'@'%';
GRANT SELECT ON cro_prod.* to 'cro_prod_user'@'%';
GRANT INSERT ON cro_prod.* to 'cro_prod_user'@'%';
GRANT DELETE ON cro_prod.* to 'cro_prod_user'@'%';
GRANT UPDATE ON cro_prod.* to 'cro_prod_user'@'%';