function goToPageNum(formId, pageNum) {
	var formObj = $("#" + formId);
	var param = "<input type='hidden' name='pageNum' value='" + pageNum
			+ "' />";
	formObj.append(param);
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
