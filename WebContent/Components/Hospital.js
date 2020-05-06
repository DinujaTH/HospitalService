$(document).ready(function() {

	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateHospitalForm();
	if (status != true) {

		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	// If valid------------
	var type = ($("#hidhpIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "HospitalAPI",
		type : type,
		data : $("#formHospital").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onHospitalSaveComplete(response.responseText, status);
		}
	});
});

function onHospitalSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divHospitalGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}

	$("#hidhpIDSave").val("");
	$("#formHospital")[0].reset();
}

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) {
	$("#hidhpIDSave").val($(this).closest("tr").find('#hidehpIDUpdate').val());
	$("#hpCode").val($(this).closest("tr").find('td:eq(0)').text());
	$("#hpName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#hpTp").val($(this).closest("tr").find('td:eq(2)').text());
	$("#hpAddress").val($(this).closest("tr").find('td:eq(3)').text());
	$("#hpDOC").val($(this).closest("tr").find('td:eq(4)').text());
	$("#hpDesc").val($(this).closest("tr").find('td:eq(5)').text());
});

// Remove================================================
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "HospitalAPI",
		type : "DELETE",
		data : "hpID=" + $(this).data("hpId"),
		dataType : "text",
		complete : function(response, status) {
			onHospitalDeleteComplete(response.responseText, status);
		}
	});
});

function onHospitalDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divHospitalGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// CLIENTMODEL=========================================================================
function validateHospitalForm() {
	// CODE
	if ($("#hpCode").val().trim() == "") {
		return "Insert Hospital Code.";
	}
	// NAME
	if ($("#hpName").val().trim() == "") {
		return "Insert Hospital Name.";
	}

	// TELEPHONE
	if ($("#hpTp").val().trim() == "") {
		return "Insert Telephone No.";

		var tmptp = $("#hpTp").val().trim();
		if (!$.length < 1 || length > 10(tmpTp)) {
			return "Insert a Telephone No Must be 1 to 10 Integers.";
		}
	}

	// ADDRESS
	if ($("#hpAddress").val().trim() == "") {
		return "Insert Hospital Address.";
	}
	// DOCTOR
	if ($("#hpDOC").val().trim() == "") {
		return "Insert Doctor Name.";
	}

	// DESCRIPTION
	if ($("#hpDesc").val().trim() == "") {
		return "Insert Description.";
	}

	return true;
}
