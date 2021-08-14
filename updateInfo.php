<!DOCTYPE html>
<!--	Author: Ivan Nataren
		Date:	09/30/2019
		File:	updateInfo.php
		Purpose: Test1 
-->
<html>
<head>
	<title>User REPORT</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>

<body>

	<?php
		
			function emailCheck($email) {
				if(stristr($email,".com")!= false )
					return (stristr($email,".com"));
				else if(stristr($email,".edu")!= false   )
					return stristr($email,".edu");
				else 
					return false;}
	
        $First = $_POST['first'];
        $Last = $_POST['last'];
		$phone = $_POST['phone'];
		$email = $_POST['email'];
		
		$invalid = false;
		$a = stripos($email,"@")+1;
		$something = substr($email,$a,stripos($email ,(stristr($email,emailCheck($email))) ) -$a   );
		
		
		if(ctype_alpha ( $First) == false or ctype_alpha($Last)== false ){
			print( "<p>Error. Please use only letter for you first and Last name.</p>");
			$invalid = true;}
		if(ctype_digit( substr($phone,0,3)) == false  or ctype_digit(substr($phone,4,3)) == false or ctype_digit((substr($phone,8))) == false or substr($phone,3,1)!= "-" or substr($phone,7,1) != "-")
			{print("<p>Error. Please follow the proper format for phone number</p>");
			$invalid = true;}
		if (stripos($email,"@")== false or ctype_alnum(substr($email,0,stripos($email,"@")))==false  or ctype_alpha($something )== false)
			{print("<p>Error. invalid email</p>");
			$invalid =true;}
			
		

		if ($invalid == false){
			$userData[$Last] = array($First,$Last, $phone, $email); // inserts input into array
		
		
			if(!file_exists("userInfo.txt")) {
				//file does not exist
				print("<p>File does not exist</p>");
            
			} 
		
			else {
				print("<p>File already exists! Reading file ... </p>");
            
				$userFile =fopen("userInfo.txt","r");
				
        
				while (!feof($userFile)) {
					$name = fgets($userFile); //read a  line.
					$name = str_replace(array("\n", "\r"), '', $name);  //remove newlines
					$allData = explode(":", $name);
					if(!feof($userFile)) 
						{
							$userData[$allData[1]] = $allData; //
                    			
						}
				}
				fclose($userFile);

				ksort($userData);
				
				print("<pre>");
				print_r($userData);
				print("</pre>");
			
				$fileWriter = fopen("userInfo.txt","w");

			print("<table border = '3'><tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Phone</th>
				<th>Email</th></tr>");
            
            foreach($userData as $key=>$user){
                print("<tr>\n");
                $userInfo = '';

                foreach($user as $k=>$v){
                    print("<td>$v</td>");
                    $userInfo = $userInfo.$v.":";
                }

                print("</tr>\n");
                fwrite($fileWriter, rtrim($userInfo, ":")."\r\n");
            }

            print("</table>");

            fclose($fileWriter);
			
		}
			
		}	
			
	     print("<p><a href=\"userInfo.html\">Return to homepage</a></p>");
			
	?>

		
		
		
		</body>
</html>
			