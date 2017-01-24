
function saveContent() {
	Editor.save(); // 이 함수를 호출하여 글을 등록하면 된다.
}

/*
 * Editor.save()를 호출한 경우 데이터가 유효한지 검사하기 위해 부르는 콜백함수(data입력검사)
 * 모든 데이터가 유효할 경우에 true를 리턴한다.
 */
function validForm(editor) {
	
	if($('#title').val() == '') {
		
		$('#title').focus(); 
		$('#titleCheck').show();
		return;
		
	} else {
		$('#titleCheck').hide();
	}
	if($('#category_number').val() == '') {
		
		$('#category_number').focus(); 
		$('#categoryCheck').show();
		return;
		
	} else {
		$('#categoryCheck').hide();
	}
	if($('#huntingType').val() == '') {
		
		$('#huntingType').focus(); 
		$('#huntingTypeCheck').show();
		return;
		
	} else {
		$('#huntingTypeCheck').hide();
	}
	if($('#duedate').val() == '') {
		
		$('#duedate').focus(); 
		$('#dueDateCheck').show();
		return;
		
	} else {
		$('#dueDateCheck').hide();
	}
	if($('#joinin_number').val() == '') {
		
		$('#joinin_number').focus(); 
		$('#joininCheck').show();
		return;
		
	} else {
		$('#joininCheck').hide();
	}
	
	if($('#price').val() == '') {
		
		$('#price').focus(); 
		$('#priceCheck').show();
		return;
		
	} else {
		$('#priceCheck').hide();
	}
	return true;
}

/**
 * Editor.save()를 호출한 경우 validForm callback 이 수행된 이후
 * 실제 form submit을 위해 form 필드를 생성, 변경하기 위해 부르는 콜백함수로
 * 각자 상황에 맞게 적절히 응용하여 사용한다.
 * @function
 * @param {Object} editor - 에디터에서 넘겨주는 editor 객체
 * @returns {Boolean} 정상적인 경우에 true
 */
function setForm(editor) {
	var i, input;
	var form = editor.getForm();
	var content = editor.getContent();

	// 본문 내용을 필드를 생성하여 값을 할당하는 부분
	var textarea = document.createElement('textarea');
	textarea.name = 'content';
	textarea.value = content;
	textarea.hidden = 'hidden';
	form.createField(textarea);

	return true;
}
