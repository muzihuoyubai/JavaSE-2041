$(function () {
  $(document).ajaxError(function (e, xhr) {
    alert("操作失败:" + xhr.responseText);
  });
});

/*
将指定id的form 内容转换成json字符串
返回json字符串
 */
function form2JsonString(formId) {
  // 序列化成 key=value&key1=value1 的字符串
  let paramArray = $('#' + formId).serializeArray();
  let jsonObj = {};
  $(paramArray).each(function () {
    jsonObj[this.name] = this.value;
  });
  // json对象再转换成json字符串
  return JSON.stringify(jsonObj);
}

function getURLParameter(sParam) {
  let sPageURL = window.location.search.substring(1);
  let sURLVariables = sPageURL.split('&');
  for (let i = 0; i < sURLVariables.length; i++) {
    let sParameterName = sURLVariables[i].split('=');
    if (sParameterName[0] === sParam) {
      return sParameterName[1];
    }
  }
}