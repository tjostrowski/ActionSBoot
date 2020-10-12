1. mvn clean install
2. docker build -t action-app .
3. docker pull mysql:5.6
4. docker run --name action-mysql -e MYSQL_USER=user -e MYSQL_ROOT_PASSWORD=password -e MYSQL_PASSWORD=password -e MYSQL_DATABASE=action -d mysql:5.6
5. docker run -d -p 8091:8091 --name action-app --link action-mysql:mysql action-app
6. Run post to: http://localhost:8091/create with content {"userId": 2, "gameId": 3, "action": "ADD"} and content type "application/json"

