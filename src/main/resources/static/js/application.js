$(function() {
	$(".input-date").datetimepicker({
		locale: 'zh-CN',
		format: 'YYYY-MM-DD'
	});

	$(document).keydown(function(event) {
		if (13 == event.keyCode) {
			$(".page-num").val("1");
			$(".search-form").submit();
		}

		if (27 == event.keyCode) {
			resetForm();
		}
	});
});

function goToPageNum(formId, pageNum, maxPageNum) {
	if (0 >= pageNum || pageNum > maxPageNum) {
		alert("请输入合理的页数!");
		return;
	}
	var formObj = $("#" + formId);
	$(".page-num").val(pageNum + "");
	formObj.submit();
}

function logout() {
    $("#form_logout").submit();
}

function formSubmit(obj) {
	$(".page-num").val("1");
	$(obj).parents("form").submit();
}

function addFormParaQuery(formId, name, value) {
	var formObj = $("#" + formId);
	var inputObj = formObj.find("[name='" + name + "']");
	$(".page-num").val("1");
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
	var formObj;
	if (undefined == formId) {
		formObj = $(".search-form");
	} else {
		formObj = $("#" + formId);
	}
	formObj.find("input").val("");
	formObj.find("select").val("");
}
