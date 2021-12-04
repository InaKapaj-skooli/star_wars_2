<script src = "file.js"></script>
<?php
   use PHPMailer\PHPMailer\PHPMailer;
   use PHPMailer\PHPMailer\Exception;
   include('simple_html_dom.php');
   require_once __DIR__ . '/vendor/autoload.php';
   if (isset($_POST['mail']))
   {
      $message1 = "";
      $receiver = $_POST['Email'];
      $message = "";
      $message .= " Pershendetje! Kjo eshte PDF-ja e firmosur";
      $subject  = "PDF Attachment";
      $headers  = "";
      
      $mail = new PHPMailer();
      $mail->isSMTP();
      $mail->Host = 'smtp.gmail.com;';  
      $mail->SMTPAuth = true; 
      $mail->Username = 'inakapaj622@gmail.com';
      $mail->Password = 'politekniku'; 
      $mail->SMTPSecure = 'tls';
      $mail->Port = 587; 
      $mail->SMTPDebug = 0; 
      $mail->setFrom('inakapaj622@gmail.com', 'Ina Kapaj');
      $mail->addAddress($receiver); 

      $mpdf = new \Mpdf\Mpdf();
      $content = $_COOKIE["ina"];
      $mpdf -> WriteHTML($content);
      $pdf = $mpdf->Output('','S');
      $mail->addStringAttachment($pdf,'attachment.pdf');

      $mail->addReplyTo('$email');
      $mail->isHTML(true); 
      $mail->Subject=''.$subject;
      $mail->Body=''.$message;

      if(!$mail->send()) 
      {                            
        echo "Didn't Send";
      }
      else 
      {            
        echo "Sent";                
      }
   }
?>