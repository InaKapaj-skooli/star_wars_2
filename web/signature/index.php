<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<form  name="form" action="apply.php" enctype="multipart/form-data" method="POST">
    <table >
    <tr>
        <td><b>Candidate Name<i style="color: red; background-color: white; font-size: 20px;">*</i></b></td>
        <td><input type="text" name="c_name" placeholder="Candidate Name" required/></td>
    </tr>
    <tr>
        <td><b>E-mail ID <i style="color: red; background-color: white; font-size: 20px;">*</i></b></td>
        <td><input type="email" name="email_id"   pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" placeholder="E-mail ID" required/></td>
    </tr>
    <tr>
        <td><b>Mobile Number<i style="color: red; background-color: white; font-size: 20px;">*</i></b></td>
        <td><input type="text" name="mob_number"  placeholder="Mobile Number" required/></td>
    </tr>
         <tr>                                                                                                                                    
    <td><b>Attach Your CV <i style="color: red; background-color: white; font-size: 20px;">*</i></b></td>
    <td>
        <div class="form-group">                                                
        <input type="file" style="width:100%;" name = "cv" id = "logo" required/></br>                                            
        </div>                                            
    </td>
    </tr>                                                                        
    <tr>
        <td colspan="2" style="text-align:center"><button type="submit" name="apply" >Apply Now</button></td>
    </tr>
    </table>                                                                        
</form>
</body>
</html>