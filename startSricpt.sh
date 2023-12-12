#!/bin/zsh

docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=Secure123." -p 1433:1433 -v /Users/Schule/IdeaProjects/stundenplaner/stundenplaner-db:/var/opt/mssql --rm -d --name MSSQL mcr.microsoft.com/mssql/server:2022-latest

exec java -jar stundenplaner.jar

docker stop MSSQL
