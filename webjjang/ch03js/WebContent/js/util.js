/**
 * 
 */

// ====객체선택(id, class, tag)===//
function get(objName){
//	alert("get() : " +objName);
	//id에 대한 처리 - id 앞에는 "#"을 붙여서 넣어준다. 예) #deleteBtn
	if(objName.indexOf("#")==0){//#의 위치가 0이면(첫번째이면)
//		alert("id 선택")
		return document.getElementById(removeFirstChar(objName));
	}
	if(objName.indexOf(".")==0)
		return document.getElementByClass(objName);
	return document.getElementByTagName(objName);
	
}

//첫글자를 잘라내는 함수
function removeFirstChar(objName){
	return objName.substring(1);
}

//=========날짜를 형식에 맞는 문자열로 만들어주는 함수
//dateToString(날짜객체, 년, 월, 일 사이에 들어갈 문자);
function dateToString(date, ch){
	if(date == null) return "객체가 null입니다.";
	if(!(typeof date ==="object" && date instanceof Date))
		return "객체가 Date Type이 아닙니다.";
	if(ch == null) ch = "-";
	return date.getFullYear() + ch + (date.getMonth() +1) + ch + date.getDate();
}