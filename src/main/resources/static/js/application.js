function goToPageNum(formId, pageNum, pageSize) {
    var formObj = $("#" + formId);
    var param = "<input type='hidden' name='pageNum' value='" + pageNum + "' />";
    formObj.append(param);
    formObj.submit();
}
