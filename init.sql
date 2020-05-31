CREATE TABLE IF NOT EXISTS employee (
       id SERIAL PRIMARY KEY,
       employee_name VARCHAR(100),
       employee_salary VARCHAR(100),
       employee_age VARCHAR(100),
       profile_image VARCHAR(100)
      );
CREATE TABLE IF NOT EXISTS comments (
   id SERIAL PRIMARY KEY,
   postid VARCHAR(1000),
   name VARCHAR(1000),
   email VARCHAR(1000),
   body VARCHAR(1000)
  );