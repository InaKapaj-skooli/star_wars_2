document.getElementById("shkarko").addEventListener("click", function(e)
{
    if($('#content').find('img').length > 0)
    {
        const content = document.getElementById("content");
        html2pdf().from(content).save();
    }

    else
    {
        alert("Firmos pdf");
    }
})