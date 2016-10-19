'use strict';

function loadLoanList(loans) {
    //hide loan summary container if list is empty
    if(loans == null || loans.length === 0) {
        $("#loanSummaryContainer").hide();
    }
    else {
        var loanSummaryList = $("#loanSummaryList");
        for(var i in clientObj.loans) {

            var loanReport = $('<li class="list-group-item liitem"/><ul class="list-group" />');
            loanSummaryList.append(loanReport);

            var loan = clientObj.loans[i];
            for(var key in loan) {
                var loanRow = $('<li class="list-group-item liitem" />');
                loanReport.append(loanRow);
                loanRow.text(key + ": " + loan[key]);
            }
        }
    }
}

//Run this code when the document is loaded
$(document).ready(function() {
    
    //Form submit event handler
    $("#clientLookupForm").submit(function(event) {
        
        //Retrieve the client ID from the form inputs
        var clientId = $(this).find('input[name="clientId"]').val();
        
        //Perform the Rest API request
        $.getJSON("/LDS/rest/client/" + clientId, {}, function(clientObj, status) {
            
            //Stop if request failed
            if (status !== "success")
                return;
            
            console.log(clientObj);
            
            //Populate report fields with the JSON data
            for(var attr in clientObj) {
                $("span#client_" + attr).text(clientObj[attr] || "(empty)");
            }
            
            loadLoanList(clientObj.loans);
            
            //Display the Client report
            $("#clientReport").show();
        });
        
        //Prevent the browser from submitting the form
        return false;
    });
});
