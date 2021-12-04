document.querySelector("#file_upload").addEventListener("change", function(e){
    var canvasElement = document.querySelector("#pdf");
    var file = e.target.files[0]
    if(file.type != "application/pdf"){
      console.error(file.name, "is not a pdf file.")
      return
    }
    var fileReader = new FileReader();  
  
    fileReader.onload = function() 
    {
      var typedarray = new Uint8Array(this.result);
  
      PDFJS.getDocument(typedarray).then(function(pdf) 
      {
        console.log("the pdf has ",pdf.numPages, "page(s).")
      
        pdf.getPage(pdf.numPages).then(function(page) 
        {
          var viewport = page.getViewport('1.0');
          var canvas = document.querySelector("canvas")
          canvas.height = viewport.height;
          canvas.width = viewport.width;
          page.render
          ({
            canvasContext: canvas.getContext('2d'),
            viewport: viewport
          });
      });
    });
    }
    fileReader.readAsArrayBuffer(file);
  })