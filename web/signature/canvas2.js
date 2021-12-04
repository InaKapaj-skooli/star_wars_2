var isSign = false;
var leftMButtonDown = false;

jQuery(function(){
init_Sign_Canvas();
});

function fun_submit() {
if(isSign) {
var canvas = $("#canvas").get(0);
var imageData = canvas.toDataURL();
jQuery('#page').find('p').remove();
jQuery('#page').find('img').remove();
jQuery('#page').append(jQuery('<div id = "inner"/>'));
jQuery('#inner').append(jQuery('<p id = "sign">Your Sign:</p>'));
jQuery('#inner').append($('<div id = "innerdiv" class = "drag" style = "position : relative; width : 70%;"></div>'));
$('#innerdiv').append($('<img id = "dragtarget" class = "ina" style = "position : relative; left : -22%;"/>').attr('src',imageData));
closePopUp();
} 
else 
{
alert('Jepni firmen');
}
}

var x = null;

$(".drag").draggable({
  helper: 'clone',
  cursor: 'move',
  tolerance: 'fit',
  stack: '.drag',
  revert: "invalid"
});

$(".droppable").droppable({
  drop: function(e, ui) {
    if ($(ui.draggable)[0].id != "pdf-preview") {
      x = ui.helper.clone();
      ui.helper.remove();

      x.draggable({

        //helper: 'original',
        containment: '.droppable',
        tolerance: 'fit',
        stack: '.drag'
      });

      x.resizable({

        animate: true,
        //aspectRatio: 16 / 9,

        helper: "ui-resizable-helper",
        handles: "n, e, s, w, nw, ne, sw,se"

      });
      x.appendTo('.droppable');
    }
  }
});

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