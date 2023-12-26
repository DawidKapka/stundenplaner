FROM mysql/mysql-server
USER root

EXPOSE 3306

RUN chown -R mysql:root /var/lib/mysql/

ENV MYSQL_DATABASE=stundenplaner
ENV MYSQL_USER=stundenplaner
ENV MYSQL_PASSWORD=Verygoodpassword123
ENV MYSQL_ROOT_PASSWORD=Verygoodpassword123

ADD create-db.sql /etc/mysql/create-db.sql

RUN sed -i 's/MYSQL_DATABASE/'$MYSQL_DATABASE'/g' /etc/mysql/create-db.sql
RUN cp /etc/mysql/create-db.sql /docker-entrypoint-initdb.d