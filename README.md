# springreactive-poc
<H2><b>Instructions to run the project:</b></H2>
This springboot project is dockerized. So you need a docker engine to run the project.
If you want to run it in your local Postgres then change the application.properties to connect to your local Postgres DB.
You can find the application.properties under <code>springreactive-poc/src/main/resources/</code>

 1) Download the project and unzip it
 2) Using terminal 'cd' to springreactive-poc
 3) Execute <code>docker-compose -f docker-compose.yml up</code> (This should build and run the project and Postgres DB in separate containers)
 4) If you want to view inside Postgress container, open a new terminal window then type 
 <b><code>docker exec -it postgres_db psql centraldb -U admin -W admin</code></b>
 5) It will ask for the password. Type "admin" as password.
 6) Now you will be inside the Postgres container's command prompt. 
    6.1) Create a table <code>
    CREATE TABLE IF NOT EXISTS employee (
        id SERIAL PRIMARY KEY,
        employee_name VARCHAR(100),
        employee_salary VARCHAR(100),
        employee_age VARCHAR(100),
        profile_image VARCHAR(100)
       );</code>
    6.2) Type <code>select * from employee;</code>. There will be no rows.
 7) Trigger a POST call using any rest client;
 URI: http://localhost:8080/employee/save <br>
 <code>
   {
	"employee_name":"John",
    "employee_salary":"2000",
    "employee_age":"30",
    "profile_image":"none"
}
 </code>
 8) Trigger a GET call : http://localhost:8080/employee/all will give you the newly inserted record
 9) To trigger a NON-BLOCKING REST call use, <code>http://localhost:8080/external/employee/comments/all</code>
 