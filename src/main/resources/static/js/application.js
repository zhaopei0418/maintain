function goToPageNum(formId, pageNum) {
	var formObj = $("#" + formId);
	var param = "<input type='hidden' name='pageNum' value='" + pageNum
			+ "' />";
	formObj.append(param);
	formObj.submit();
}

function logout() {
    $("#form_logout").submit();
}

function addFormParaQuery(formId, name, value) {
	var formObj = $("#" + formId);
	var inputObj = formObj.find("[name='" + name + "']");
	var param = "";
	if (0 == inputObj.length) {
		var param = "<input type='hidden' name='" + name + "' value='" 
		+ value + "' />";
		formObj.append(param);
	} else {
		inputObj.val(value);
	}
	formObj.submit();
}

function changePageSize(formId, pageSize) {
	var formObj = $("#" + formId);
	var pageSizeObj = formObj.find("[name='pageSize']");
	pageSizeObj.val("" + pageSize);
	formObj.submit();
}

function switchActiveMenu(menuId) {
	var menuObj = $("#" + menuId);
	menuObj.siblings().each(function() {
		$(this).removeClass("active");
	});
	menuObj.addClass("active");
}

function resetForm(formId) {
	var formObj = $("#" + formId);
	formObj.find("input").val("");
	formObj.find("select").val("");
}
