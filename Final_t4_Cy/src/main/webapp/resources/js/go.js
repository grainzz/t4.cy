

function payGo(){
	location.href="pay.go";
}


function loginGo(){
	location.href="member.login.go";
}

function joinGo(){
	location.href='member.join.go';
}

function logout(){
	location.href="member.logout.go";
}

function shopGo(){
	location.href='shop.go';
}

function homeGo(){
	location.href="menu.home.go";
}

function boardGo(){
	location.href="menu.board.go";
}

function messageGo(){
	location.href="menu.message.go";
}

function settingGo(){
	location.href="menu.setting.go";
}

function memberInfoGo(){
	location.href='member.info.go';
}

function byebye(){
	if(confirm('정말 탈퇴 하시겠습니까?')){
		location.href='member.bye';
	}
}

function goDel(){
	if(confirm('정말 삭제 하시겠습니까?')){
		location.href='msg.del.go';
	}
}
	
function goSearch(){
	let a = document.getElementById("search").value;
	if(a != null){
		location.href = "msg.search?search=" + a;
	}
}

function EditGo() {
	location.href='Edit.go';
}

function UpdateGo(){
		location.href="msg.update.go?c_no=";
	}


function updateDo(a, c){
   if(confirm('수정 하시겠습니까?')){
      location.href="msg.update.do?c_no=" + a + "&c_guest_comment=" + c;
   }
}
function msgPageChange(page){
	location.href="msg.page.change?p=" +page;
}

function portDetailGo() {
	location.href='port.Detail.go';
}

function resumeGo() {
	location.href='resume.Detail.go';
}

function correctOK() {
	location.href='correct.OK';
}

function RandomGo(){
	location.href='random.go';
}

function myHomeGo(){
	location.href='myHome.go';
}

