/*
var muCnt = 5;
function fncShow(pos) {
    var i = 0;
    for(i; i < muCnt; i++) {
        var obj = document.getElementById("menu" + i);
        var obj2 = document.getElementById("m" + i);
        if (i == pos) {
            obj.style.display = '';
            obj2.style.color = "#ff0000";
        } else {
            obj.style.display = 'none';
            obj2.style.color = "#000000";
        }
    }
}

function fncHide(pos) {
    var obj = document.getElementById("menu" + pos);
    obj.style.display = 'none';
}
*/
function menuItemAddListner() {
    let element = document.getElementById("menuItem");
    element.addEventListener("mouseover", element.style.color="#ff0000");
    element.addEventListener("mouseout", element.style.color="#000000");
}
function headerCall() {
    document.getElementById("header").innerHTML = 
        "<div class=\"navbar navbar-light flex-column flex-md-row bd-navbar\" style=\"background-color: #333\">"
      +     "<div class=\"col-2\"></div>"
      +     "<div class=\"menu\">"
      +        "<button class=\"menuTab\">리조트소개</button>"
      +        "<div class=\"menu-content\">"
      +            "<a href=\"main.html\">"
      +                "<span class=\"menuItem\">조아 리조트</span>"
      +            "</a>"
      +            "<a href=\"a_01.html\">"
      +                "<span class=\"menuItem\">VIP 룸</span>"
      +            "</a>"
      +            "<a href=\"a_02.html\">"
      +                "<span class=\"menuItem\">일반 룸</span=>"
      +            "</a>"
      +            "<a href=\"a_03.html\">"
      +                "<span class=\"menuItem\">합리적인 룸</span=>"
      +            "</a>"
      +        "</div>"
      +    "</div>"
      +    "<div class=\"menu\">"
      +        "<button class=\"menuTab\">찾아오기</button>"
      +        "<div class=\"menu-content\">"
      +            "<a href=\"b_01.html\">"
      +                "<span class=\"menuItem\">찾아오는 길</span>"
      +            "</a>"
      +            "<a href=\"b_02.html\">"
      +                "<span class=\"menuItem\">대중교통 이용</span>"
      +            "</a>"
      +            "<a href=\"b_03.html\">"
      +                "<span class=\"menuItem\">자가용 이용</span>"
      +            "</a>"
      +        "</div>"
      +    "</div>"
      +    "<div class=\"menu\">"
      +        "<button class=\"menuTab\">주변여행지</button>"
      +        "<div class=\"menu-content\">"
      +            "<a href=\"c_01.html\">"
      +                "<span class=\"menuItem\">높아 산</span>"
      +            "</a>"
      +            "<a href=\"c_02.html\">"
      +                "<span class=\"menuItem\">조아 해수욕장</span>"
      +            "</a>"
      +            "<a href=\"c_03.html\">"
      +                "<span class=\"menuItem\">따끈 온천</span>"
      +            "</a>"
      +        "</div>"
      +    "</div>"
      +    "<div class=\"menu\">"
      +        "<button class=\"menuTab\">예약하기</button>"
      +        "<div class=\"menu-content\">"
      +            "<a href=\"d_01.html\">"
      +                "<span class=\"menuItem\">예약상황</span>"
      +            "</a>"
      +            "<a href=\"d_02.html\">"
      +                "<span class=\"menuItem\">예약하기</span>"
      +            "</a>"
      +            "<a href=\"adm_allview.jsp\">"
      +                "<span class=\"menuItem\">관리자 페이지</span>"
      +            "</a>"
      +            "<a href=\"adm_logout.jsp\">"
      +                "<span class=\"menuItem\">관리자 로그아웃</span>"
      +            "</a>"
      +        "</div>"
      +    "</div>"
      +    "<div class=\"menu\">"
      +        "<button class=\"menuTab\">리조트소식</button>"
      +        "<div class=\"menu-content\">"
      +            "<a href=\"e_01.html\">"
      +                "<span class=\"menuItem\">리조트소식</span>"
      +            "</a>"
      +            "<a href=\"e_02.html\">"
      +                "<span class=\"menuItem\">이용후기</span>"
      +            "</a>"
      +        "</div>"
      +    "</div>"
      +    "<div class=\"col-5\"></div>"
      + "</div>";
}