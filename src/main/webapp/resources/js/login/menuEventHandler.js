$(document).ready(function() {
	
	var sessionEmail  = sessionStorage.getItem("email"); //세선에 저장된 아이디 조회
	var url = window.location.pathname.split("?")[0];
	
	if(sessionEmail == null && localStorage.getItem("email") == null) { //로그인 기록이 없다면,

		showLoginBtn(); //로그인, 회원가입 버튼 표시
		
		if(url == "/login/basicUserInfo" || url == "/user/Esignout" || url == "/user/Bsignout" || url == "/mypage"
			|| url == "/user/myDipList" ||  url == "/buyTogether/read"
			|| url == "/buyTogether/update"){
			
			//user_number 같이 넘겨주는 값 있을 때는 document.location 으로 바로 보낼 수 없음. returnUrl = url;
			sessionStorage.setItem("returnUrl", window.location.pathname);
			document.location = "/login";
			
		}/*
		url == "/buyTogether/write" ||*/
	} else {
		
		showLogoutBtn(); //로그아웃 버튼 표시
		
	}
	
	//로그인 버튼을 클릭 시 로그인 화면으로 이동
	$('#loginBtn').on("click", function(event) {
		
		localStorage.clear();
		sessionStorage.clear();
		document.location = "/login";

	});
	
	//로그아웃 버튼 클릭 시 세션,로컬저장소 초기화 후 홈화면으로 이동
	$('#logoutBtn').on("click", function(event) {
		
		localStorage.clear();
		sessionStorage.clear();
		document.location = "/";
		
	});
	
	//회원가입 버튼 클릭 시 회원가입 화면으로 이동
	$('#joinBtn').on("click", function(event) {
		
		document.location = "/user/join";
		
	});
	
	//검색아이콘 클릭 시 검색 창 보이기
	$('.c-search-toggler-wrapper').on("click", function(event) {
		
		$('.c-mega-menu').css({display:'none'});
		$('.c-quick-search').css({display:'block'});
		
	});

	$('.c-theme-link').on("click", function(event) {
		
		$('.c-mega-menu').css({display:'block'});
		$('.c-quick-search').css({display:'none'});
		
	});
	
	//로그인,회원가입 버튼 출력
	function showLoginBtn () {
		
		$('#loginBtn').css({display:'block'});
		$('#joinBtn').css({display:'block'});
		$('#logoutBtn').css("display", 'none');
		$('#userId').text("");
		
	};
	
	//환영 멘트, 로그아웃 버튼 출력
	function showLogoutBtn () {
		
		$('#loginBtn').css({display:'none'});
		$('#joinBtn').css({display:'none'});
		$('#logoutBtn').css({display:'block'});
		$('#userId').text(sessionEmail + " 님 환영합니다");
		
	};
    
});
