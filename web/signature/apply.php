<?php
 
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
require_once __DIR__ . '/vendor/autoload.php';
if(isset($_POST['apply'])) 
    {
    $message1="";
    $c_name=$_POST['c_name']; // Contain Candidate name 
    $email_id =$_POST['email_id']; //Contain candidate e-mail id
    $mob_number =$_POST['mob_number']; //Contain candidate mobile number
                
    $message="";
    $message .= "  
    <table width='800' border='1' cellspacing='0' cellpadding='8' bordercolor='#CCCCCC'>      
        <tr>        
              <td colspan='2' bgcolor='#CDD9F5'><strong>Candidate Details</strong></td>               
        </tr> 
        <tr>        
            <td width='168' bgcolor='#FFFFEC'><strong>Candidate Name</strong></td>        
            <td width='290' bgcolor='#FFFFEC'>$c_name</td>      
        </tr>      
        <tr>        
            <td bgcolor='#FFFFDD'><strong>E-mail ID</strong></td>        
            <td bgcolor='#FFFFDD'>$email_id</td>      
        </tr>
        <tr>        
            <td bgcolor='#FFFFDD'><strong>Mobile Number</strong></td>        
            <td bgcolor='#FFFFDD'>$mob_number</td>      
        </tr>                        
     </table>";
        $subject  = "PDF Attachment"; //like--- Resume From Website
        $headers  = "";
        
      
        $mail = new PHPMailer();
                                      // Enable verbose debug output
        $mail->isSMTP(); // Set mailer to use SMTP
        $mail->Host = 'smtp.gmail.com;';  // Specify main and backup SMTP servers
        $mail->SMTPAuth = true; // Enable SMTP authentication
        $mail->Username = 'inakapaj622@gmail.com';// SMTP username 
        $mail->Password = 'politekniku'; // SMTP password 
        $mail->SMTPSecure = 'tls';// Enable TLS encryption, `ssl` also accepted
        $mail->Port = 587; 
        $mail->SMTPDebug = 0; // TCP port to connect to
        $mail->setFrom('inakapaj622@gmail.com', 'Your_From_Message'); //You Can add your own From mail
        $mail->addAddress('ina.kapaj@yahoo.com'); // Add a recipient id where you want to send mail 
            
        $mail->addAttachment($_FILES['cv']['tmp_name'],$_FILES['cv']['name']); //This line Use to Keep User Txt,Doc,pdf file ,attachment      
        $mail->addReplyTo('$email'); //where you want reply from user
        $mail->isHTML(true); 
        $mail->Subject=''.$subject;
        $mail->Body=''.$message;
        if(!$mail->send()) 
            {                            
            echo "Didnt Send";
            }
        else 
            {            
            echo "Sent";                
            }
                
            }
            else
            {
            $message1.= "Code Error";
                
            }
?>