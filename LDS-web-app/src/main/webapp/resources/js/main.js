// The root URL for the RESTful services
var rootURL = "http://localhost:8181/contact";

var currentContact;

// Retrieve contact id 1
//findById(1);

// Retrieve contact list when application starts 
findAll();

// Nothing to delete in initial application state
$('#btnDelete').hide();

// Register listeners
//$('#btnSearch').click(function() {
//	search($('#searchKey').val());
//	return false;
//});

// Trigger search when pressing 'Return' on search key input field
//$('#searchKey').keypress(function(e){
//	if(e.which == 13) {
//		search($('#searchKey').val());
//		e.preventDefault();
//		return false;
//    }
//});

$('#btnAdd').click(function() {
	newContact();
	return false;
});

$('#btnSave').click(function() {
	if ($('#contactId').val() == '')
		addContact();
	else
		updateContact();
	return false;
});

$('#btnDelete').click(function() {
	deleteContact();
	return false;
});

$('#contactList a').live('click', function() {
	findById($(this).data('identity'));
});

//function search(searchKey) {
//	if (searchKey == '') 
//		findAll();
//	else
//		findByName(searchKey);
//}

function newContact() {
	$('#btnDelete').hide();
	currentContact = {};
	renderDetails(currentContact); // Display empty form
}

function findAll() {
	console.log('findAll');
        
	$.ajax({
                xhrFields: {
                   withCredentials: true
                },
                beforeSend: function (xhr) {
                   xhr.setRequestHeader('Authorization', 'Basic ' + btoa('wsuser:t0ps3cr3t'));
                },
		type: 'GET',
		url: rootURL,
		dataType: "json", // data type of response
		success: renderList
	});
}

//function findByName(searchKey) {
//	console.log('findByName: ' + searchKey);
//	$.ajax({
//		type: 'GET',
//		url: rootURL + '/search/' + searchKey,
//		dataType: "json",
//		success: renderList 
//	});
//}


/*function setAuthHeader(xhr){
            var creds = 'wsuser' + ':' + 't0ps3cr3t';
            var basicScheme = btoa(creds);
            var hashStr = "Basic "+basicScheme;
            xhr.setRequestHeader('Authorization', hashStr);
}*/



function findById(id) {
	console.log('findById: ' + id);

        $.ajax({
            xhrFields: {
                withCredentials: true
            },
//            headers: {
//               'Authorization': 'Basic ' + btoa('wsuser:t0ps3cr3t')
//            },
//            headers: { 'Access-Control-Allow-Origin': '*' },
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Authorization', 'Basic ' + btoa('wsuser:t0ps3cr3t'));
            },
	    type: 'GET',
	    url: rootURL + '/' + id,
	    dataType: "json",
	    success: function(data){
			console.log('findById success: ' + data.name);
                        $('#btnDelete').show();
			currentContact = data;
			renderDetails(currentContact);
	    }
        });
	
//        $.ajax({
//                beforeSend: setAuthHeader,
//		type: 'GET',
//		url: rootURL + '/' + id,
//		dataType: "json",
//		success: function(data){
//			console.log('findById success: ' + data.name);
//			currentContact = data;
//			renderDetails(currentContact);
//		}
//	});
}

function addContact() {
	console.log('addContact');
	$.ajax({
                xhrFields: {
                   withCredentials: true
                },
                beforeSend: function (xhr) {
                   xhr.setRequestHeader('Authorization', 'Basic ' + btoa('wsuser:t0ps3cr3t'));
                },
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Contact created successfully');
			$('#btnDelete').show();
			$('#contactId').val(data.id);
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('addContact error: ' + textStatus);
		}
	});
}

function updateContact() {
	console.log('updateContact');
	$.ajax({
                xhrFields: {
                   withCredentials: true
                },
                beforeSend: function (xhr) {
                   xhr.setRequestHeader('Authorization', 'Basic ' + btoa('wsuser:t0ps3cr3t'));
                },
		type: 'PUT',
		contentType: 'application/json',
		url: rootURL + '/' + $('#contactId').val(),
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Contact updated successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('updateContact error: ' + textStatus);
		}
	});
}

function deleteContact() {
	console.log('deleteContact');
	$.ajax({
                xhrFields: {
                   withCredentials: true
                },
                beforeSend: function (xhr) {
                   xhr.setRequestHeader('Authorization', 'Basic ' + btoa('wsuser:t0ps3cr3t'));
                },
		type: 'DELETE',
		url: rootURL + '/' + $('#contactId').val(),
		success: function(data, textStatus, jqXHR){
			alert('Contact deleted successfully');
                        findAll();
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('deleteContact error');
		}
	});
}

function renderList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$('#contactList li').remove();
	$.each(list, function(index, contact) {
		$('#contactList').append('<li><a href="#" data-identity="' + contact.id + '">'+contact.firstName+' '+contact.lastName+'</a></li>');
	});
}

function renderDetails(contact) {
	$('#contactId').val(contact.id);
	$('#firstName').val(contact.firstName);
	$('#lastName').val(contact.lastName);
	$('#phone').val(contact.phone);

}

// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	var contactId = $('#contactId').val();
	return JSON.stringify({
		"id": contactId == "" ? null : contactId, 
		"firstName": $('#firstName').val(), 
		"lastName": $('#lastName').val(),
		"phone": $('#phone').val()
		});
}
