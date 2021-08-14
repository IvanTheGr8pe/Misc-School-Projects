<!DOCTYPE html>
<!--	Author: Ivan Nataren
		Date:	/2019/
		Purpose:Exam 2
-->
<html>
<head>
	<title>View Rentals</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>

<body>

	<?php
        print("<p><form action=\"tasks.html\"><input type=\"submit\" value=\"go back\" /></form></p>");
       $mysqli = new mysqli("localhost", "root", "", "sakila");
        if($mysqli->connect_error) {
          exit('Error connecting to database'); //Should be a message a typical user could understand in production
        }
        mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
        $mysqli->set_charset("utf8mb4");
        
		$result = mysqli_query($mysqli,"select c.first_name, c.last_name, f.title, i.inventory_id, r.rental_date, r.return_date
					from rental r
					join customer c
					on r.customer_id = c.customer_id
					join inventory i
					on r.inventory_id = i.inventory_id
					join film f
					on i.film_id = f.film_id
					order by c.last_name;") OR die(mysqli_error());
        if($result->num_rows === 0) exit('No rows');
		
       
        print("<h1>Table of Rentals</h1>");
		
        print("<table border='1'>");
        print("<tr><th>First name</th><th>Last Name</th><th>Film Title</th><th>Inventory ID</th><th>Rental Date</th><th>Return Date</th></tr>");
        
        $i = 0;
        while($row = mysqli_fetch_assoc($result)) {
          $customer_names[$i][] = $row['first_name'];
          $customer_names[$i][] = $row['last_name'];
		  $customer_names[$i][] = $row['title'];
		  $customer_names[$i][] = $row['inventory_id'];
		  $customer_names[$i][] = $row['rental_date'];
		  $customer_names[$i][] = $row['return_date'];
		  
          print ("<tr><td>".$row['first_name']."</td><td>".$row['last_name']."</td><td>".$row['title']."</td><td>".$row['inventory_id']."</td><td>".$row['rental_date']."</td><td>".$row['return_date']."</td></tr>");
          $i++;
        }
        print("</table>");
        /*print("<pre>");
        var_export($customer_names);
        print_r($customer_names);
        print("</pre>");*/
        //$stmt->close();
        print("<p><form action=\"tasks.html\"><input type=\"submit\" value=\"go back\" /></form></p>");
        $mysqli->close();
        
        
        
        
	?>
</body>
</html>