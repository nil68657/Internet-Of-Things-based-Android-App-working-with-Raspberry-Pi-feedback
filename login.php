<?php
require "new.php";
//$id='3';
$username=$_POST["user_name"];
$password=$_POST["password"];
//$year='2011';
//$city='Dehradun';
$query="select name from login where user_name ='$username' and password ='$password';";
$result=mysqli_query($con,$query);
if(mysqli_num_rows($result)>0){
	$row=mysqli_fetch_assoc($result);
        $name=$row["name"];
        echo "login successful...Welcome ".$name;
}
else
echo "Login failed";
?>