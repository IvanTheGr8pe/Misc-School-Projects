<!DOCTYPE html>
<!--	Author: Ivan Nataren
		Date:	/2019/
		Purpose:Exam 2
-->
<html>
<head>
	<title>View Films</title>
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
        
		$result = mysqli_query($mysqli,"select f.title, f.description, f.rental_duration, f.rental_rate, f.`length`, fl.category, count(*) as copies
			from film f, film_list fl , inventory i
			where i.film_id = f.film_id and fl.`FID`= i.film_id
			group by f.title;") OR die(mysqli_error());
        if($result->num_rows === 0) exit('No rows');
		
       
        print("<h1>Table of Films</h1>");
		
        print("<table border='1'>");
        print("<tr><th>Film Title</th><th>Description</th><th>Rental Duration</th><th>Rental Rate</th><th>Length</th><th>Genre</th><th>Copies in Inventory</th></tr>");
        
        $i = 0;
        while($row = mysqli_fetch_assoc($result)) {
          $film_names[$i][] = $row['title'];
          $film_names[$i][] = $row['description'];
		  $film_names[$i][] = $row['rental_duration'];
		  $film_names[$i][] = $row['rental_rate'];
		  $film_names[$i][] = $row['length'];
		  $film_names[$i][] = $row['category'];
		  $film_names[$i][] = $row['copies'];
          print ("<tr><td>".$row['title']."</td><td>".$row['description']."</td><td>".$row['rental_duration']."</td><td>".$row['rental_rate']."</td><td>".$row['length']."</td><td>".$row['category']."</td><td>".$row['copies']."</td></tr>");
          $i++;
        }
        print("</table>");
        /*print("<pre>");
        var_export($film_names);
        print_r($film_names);
        print("</pre>");*/
        //$stmt->close();
        print("<p><form action=\"tasks.html\"><input type=\"submit\" value=\"go back\" /></form></p>");
        $mysqli->close();
        
        
        
        
	?>
</body>
</html>