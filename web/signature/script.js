window.onload = function pdfDivload (){
    let el = document.getElementById('content');
    let opt = {
        margin:       1,
        filename:     'myfile.pdf',
        image:        { type: 'jpeg', quality: 0.98 },
        html2canvas:  { scale: 2 },
        jsPDF:        { unit: 'in', format: 'A4', orientation: 'portrait' }
    };
    
    html2pdf().set( opt ).from( el ).toPdf().output('datauristring').then(function( pdfAsString ) {
        let data = {
            'fileDataURI': pdfAsString,
        };
        $.post( "../prog/email.php", data);
        console.log( data );
    } );
    };