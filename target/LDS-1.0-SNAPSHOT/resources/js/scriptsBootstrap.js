/*
 * http://bootsnipp.com/snippets/featured/dynamic-form-fields-add-new-field-on-focus-or-change
 * */
/* 
    Text fields 
*/
$(function(){
    
	$(document).on('focus', 'div.form-group-options div.input-group-option:last-child input', function(){
        
		var sInputGroupHtml = $(this).parent().html();
		var sInputGroupClasses = $(this).parent().attr('class');
		$(this).parent().parent().append('<div class="'+sInputGroupClasses+'">'+sInputGroupHtml+'</div>');
        
	});
	
	$(document).on('click', 'div.form-group-options .input-group-addon-remove', function(){
        
		$(this).parent().remove();
        
	});
    
});

/* 
    Selects 
*/
$(function(){
        
	var values = new Array();
	
	$(document).on('change', '.form-group-multiple-selects .input-group-multiple-select:last-child select', function(){
        
		var selectsLength = $(this).parent().parent().find('.input-group-multiple-select select').length;
		var optionsLength = ($(this).find('option').length)-1;
		
		if(selectsLength < optionsLength){
			var sInputGroupHtml = $(this).parent().html();
			var sInputGroupClasses = $(this).parent().attr('class');
			$(this).parent().parent().append('<div class="'+sInputGroupClasses+'">'+sInputGroupHtml+'</div>');	
		}
		
		updateValues($(this).parent().parent());
		
	});
	
	$(document).on('change', '.form-group-multiple-selects .input-group-multiple-select:not(:last-child) select', function(){
		
		updateValues($(this).parent().parent());
		
	});
	
	$(document).on('click', '.input-group-addon-remove', function(){
        
        var oSelectContainer = $(this).parent().parent()
    	$(this).parent().remove();
		updateValues(oSelectContainer);
        
	});
	
	function updateValues(oSelectContainer){
        
		values = new Array();
		$(oSelectContainer).find('.input-group-multiple-select select').each(function(){
			var value = $(this).val();
			if(value != 0 && value != ""){
				values.push(value);
			}
		});
		
		$(oSelectContainer).find('.input-group-multiple-select select').find('option').each(function(){
			var optionValue = $(this).val();
			var selectValue = $(this).parent().val();
			if(in_array(optionValue,values)!= -1 && selectValue != optionValue)
			{
				$(this).attr('disabled', 'disabled');
			}
			else
			{
				$(this).removeAttr('disabled');
			}
		});
        
	}
	
	function in_array(needle, haystack){
        
		var found = 0;
		for (var i=0, length=haystack.length;i<length;i++) {
			if (haystack[i] == needle) return i;
			found++;
	    }
	    return -1;
        
	}
    
    // Update all options for first use
    $('.form-group-multiple-selects').each(function(i, e){
        
    	updateValues(e);
        
	});
});

/*
 * http://bootsnipp.com/snippets/featured/js-table-filter-simple-insensitive
 * */

$(document).ready(function() {
    var activeSystemClass = $('.list-group-item.active');

    //something is entered in search form
    $('#system-search').keyup( function() {
       var that = this;
        // affect all table rows on in systems table
        var tableBody = $('.table-list-search tbody');
        var tableRowsClass = $('.table-list-search tbody tr');
        $('.search-sf').remove();
        tableRowsClass.each( function(i, val) {
        
            //Lower text for case insensitive
            var rowText = $(val).text().toLowerCase();
            var inputText = $(that).val().toLowerCase();
            if(inputText != '')
            {
                $('.search-query-sf').remove();
                tableBody.prepend('<tr class="search-query-sf"><td colspan="6"><strong>Searching for: "'
                    + $(that).val()
                    + '"</strong></td></tr>');
            }
            else
            {
                $('.search-query-sf').remove();
            }

            if( rowText.indexOf( inputText ) == -1 )
            {
                //hide rows
                tableRowsClass.eq(i).hide();
                
            }
            else
            {
                $('.search-sf').remove();
                tableRowsClass.eq(i).show();
            }
        });
        //all tr elements are hidden
        if(tableRowsClass.children(':visible').length == 0)
        {
            tableBody.append('<tr class="search-sf"><td class="text-muted" colspan="6">No entries found.</td></tr>');
        }
    });
});

/* http://bootsnipp.com/snippets/6nezr */

$(function () {
	$('#btnAdd_4').click(function () {
	        var num     = $('.clonedInput_4').length, // Checks to see how many "duplicatable" input fields we currently have
	            newNum  = new Number(num + 1),      // The numeric ID of the new input field being added, increasing by 1 each time
	            newElem = $('#date' + num).clone().attr('id', 'date' + newNum).fadeIn('slow'); // create the new element via clone(), and manipulate it's ID using newNum value
	    
	    /*  This is where we manipulate the name/id values of the input inside the new, cloned element
	        Below are examples of what forms elements you can clone, but not the only ones.
	        There are 2 basic structures below: one for an H2, and one for form elements.
	        To make more, you can copy the one for form elements and simply update the classes for its label and input.
	        Keep in mind that the .val() method is what clears the element when it gets cloned. Radio and checkboxes need .val([]) instead of .val('').
	    */
	        // H2 - section
	        newElem.find('.label_date').attr('id', 'ID' + newNum + '_reference').attr('name', 'ID' + newNum + '_reference').html('Date #' + newNum);

	        // date - text
	        newElem.find('.label_date').attr('for', 'ID' + newNum + '_date_number');
	        newElem.find('.input_date').attr('id', 'ID' + newNum + '_date_number').attr('name', 'ID' + newNum + '_date_number').val('');

	    // Insert the new element after the last "duplicatable" input field
	        $('#date' + num).after(newElem);
	        $('#ID' + newNum + '_title').focus();

	    // Enable the "remove" button. This only shows once you have a duplicated section.
	        $('#btnDel_4').attr('disabled', false);

	    // Right now you can only add 4 sections, for a total of 5. Change '5' below to the max number of sections you want to allow.
	        // This first if statement is for forms using input type="button" (see older demo). DELETE if using button element.
	        if (newNum == 5)
	        $('#btnAdd_4').attr('disabled', true).prop('value', "You've reached the limit"); // value here updates the text in the 'add' button when the limit is reached
	        // This second if statement is for forms using the new button tag (see Bootstrap demo). DELETE if using input type="button" element.
	        if (newNum == 5)
	        $('#btnAdd_4').attr('disabled', true).text("You've reached the limit"); // value here updates the text in the 'add' button when the limit is reached 
	    });

	    $('#btnDel_4').click(function () {
	    // Confirmation dialog box. Works on all desktop browsers and idate.
	        if (confirm("Are you sure you wish to remove this date number? This cannot be undone."))
	            {
	                var num = $('.clonedInput_4').length;
	                // how many "duplicatable" input fields we currently have
	                $('#date' + num).slideUp('slow', function () {$(this).remove();
	                // if only one element remains, disable the "remove" button
	                    if (num -1 === 1)
	                $('#btnDel_4').attr('disabled', true);
	                // enable the "add" button. IMPORTANT: only for forms using input type="button" (see older demo). DELETE if using button element.
	                $('#btnAdd_4').attr('disabled', false).prop('value', "Add date");
	                // enable the "add" button. IMPORTANT: only for forms using the new button tag (see Bootstrap demo). DELETE if using input type="button" element.
	                $('#btnAdd_4').attr('disabled', false).text("Add date");});
	            }
	        return false; // Removes the last section you added
	    });
	    // Enable the "add" button
	    $('#btnAdd_4').attr('disabled', false);
	    // Disable the "remove" button
	    $('#btnDel_4').attr('disabled', true);

	});