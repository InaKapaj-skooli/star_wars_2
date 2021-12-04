var isSign = false;
var leftMButtonDown = false;

jQuery(function(){
init_Sign_Canvas();
});

function fun_submit() {
if(isSign) {
var canvas = $("#canvas").get(0);
var imageData = canvas.toDataURL('image/jpeg');
jQuery('#page').find('p').remove();
jQuery('#page').find('img').remove();
jQuery('#page').append(jQuery('<div id = "inner"/>'));
jQuery('#inner').append(jQuery('<p id = "sign">Your Sign:</p>'));
jQuery('#inner').append($('<div id = "innerdiv" class = "drop" ondrop = "drop(event)" ondragover = "allowDrop(event)" style = "position : relative; z-index : 5; width : 70%;"></div>'));
$('#innerdiv').append($('<img id = "dragtarget" ondragstart = "dragStart(event)" draggable = "true" style = "position : relative; left : -22%;"/>').attr('src',imageData));
closePopUp();
} 
else 
{
alert('Jepni firmen');
}
}

function dragStart(event) {
  event.dataTransfer.setData("content", event.target.id);
}

function allowDrop(event) {
  event.preventDefault();
}

function drop(event) {
  var theData = event.dataTransfer.getData("content");
  var theDraggedElement = document.getElementById(theData);
  event.target.appendChild(theDraggedElement);
  event.preventDefault();

  document.getElementById("sign").style.display = "none";
}

function closePopUp() {
  jQuery('#divPopUpSignContract').popup('close');
  jQuery('#divPopUpSignContract').popup('close');
  }

function init_Sign_Canvas() {
isSign = false;
leftMButtonDown = false;

var sizedWindowWidth = $('#div_signcontract').width();
if(sizedWindowWidth > 700)
sizedWindowWidth = $(window).width() / 2;
else if(sizedWindowWidth > 400)
sizedWindowWidth = sizedWindowWidth - 50;
else
sizedWindowWidth = sizedWindowWidth - 20;
 
 $("#canvas").width(sizedWindowWidth);
 $("#canvas").height(200);
 $("#canvas").css("border","1px solid #000");

 var canvas = $("#canvas").get(0);

 canvasContext = canvas.getContext('2d');

 if(canvasContext)
 {
 canvasContext.canvas.width  = sizedWindowWidth;
 canvasContext.canvas.height = 200;

 canvasContext.fillStyle = "#fff";
 canvasContext.fillRect(0,0,sizedWindowWidth,200);
 
 canvasContext.moveTo(50,150);
 canvasContext.lineTo(sizedWindowWidth-50,150);
 canvasContext.stroke();

 canvasContext.fillStyle = "#000";
 canvasContext.font="20px Arial";
 canvasContext.fillText("x",40,155);
 }

 $("#canvas").on('vmousedown', function (e) {
  if(e.which === 1) { 
  leftMButtonDown = true;
  canvasContext.fillStyle = "#000";
  var x = e.pageX - $(e.target).offset().left;
  var y = e.pageY - $(e.target).offset().top;
  canvasContext.moveTo(x, y);
  }
  e.preventDefault();
  return false;
  });
 
  $("#canvas").on('vmouseup', function (e) {
  if(leftMButtonDown && e.which === 1) {
  leftMButtonDown = false;
  isSign = true;
  }
  e.preventDefault();
  return false;
  });
 
  $("#canvas").bind('vmousemove', function (e) {
  if(leftMButtonDown == true) {
  canvasContext.fillStyle = "#000";
  var x = e.pageX - $(e.target).offset().left;
  var y = e.pageY - $(e.target).offset().top;
  canvasContext.lineTo(x,y);
  canvasContext.stroke();
  }
  e.preventDefault();
  return false;
  });
}