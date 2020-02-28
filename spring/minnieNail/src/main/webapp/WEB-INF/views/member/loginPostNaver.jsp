<html lang="ko"><head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <title>네이버 : 로그인</title>
    <link rel="stylesheet" type="text/css" href="https://nid.naver.com/login/css/oauth_201804.css">
    <script type="text/javascript" src="https://static.nid.naver.com/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" nonce="">
        var serviceScope = {"default":[]};
        var profileScope = {"required":["ID"],"optional":["NICKNAME","GENDER","AGE"]};
        var logout_url = "https://nid.naver.com/oauth2.0/authorize?response_type=token&state=4efae0ff-80db-464f-9cc9-9a190277b3ed&redirect_uri=http%3A%2F%2Fstatic.nid.naver.com%2Foauth%2Fsample%2Fcallback.html&client_id=jyvqXeaVOVmV&oauth_os=&inapp_view=&locale=ko_KR&auth_type=reauthenticate";
        var cancel_url = "http://static.nid.naver.com/oauth/sample/callback.html?error=access_denied&error_description=Canceled+By+User&state=4efae0ff-80db-464f-9cc9-9a190277b3ed";
        var profile_url = "https://phinf.pstatic.net/contactthumb/20190602_101/1559469060257KLKW4_JPEG/image.jpg?type=s80";
        var isNeedRealNameCheck =  false;
        var isNeedParentsAgreeCheck = false;
        var nickname = "Camila";
        var viewExtendProfile = true;
        var regTimestamp = 1523038512;
        var locale = "ko_KR";
        var isMobile = false;
        var internal = false;
        var setNaverId = false;
    </script>
</head>
<body>
<div id="wrap">
    <!-- 스킵네비게이션 : 웹접근성대응-->
    <div id="u_skip">
        <a href="#content" onclick="document.getElementById('content').tabIndex=-1;document.getElementById('content').focus();return false;"><span>본문으로 바로가기</span></a>
    </div>
    <!-- //스킵네비게이션 -->


    <!-- header -->
    <div id="header" role="banner">
        <div class="oauth_header">
            <a href="http://www.naver.com" target="_blank" class="oauth_logo oauth_sprites" onclick="try{nclks('top.naver',this,event)}catch(e){}"><h1 class="blind">Naver</h1></a>
            <a class="oauth_user" style="cursor: default;">
                <span class="oauth_user_mask oauth_sprites"></span>
                <img src="https://phinf.pstatic.net/contactthumb/20190602_101/1559469060257KLKW4_JPEG/image.jpg?type=s80" width="26" height="26" id="oauth_user_img" alt="사용자 이미지" style="width: 26px; height: 26px;">
                <div class="oauth_user_id" id="oauth_user_id" style="cursor: pointer;">Camila</div>
                <div class="oauth_user_arrow oauth_sprites"><span class="blind">화살표</span></div>
            </a>
            <div class="oauth_user_pop oauth_sprites" id="oauth_user_pop" style="display:none"><a id="change_account" href="https://nid.naver.com/oauth2.0/authorize?response_type=token&amp;state=4efae0ff-80db-464f-9cc9-9a190277b3ed&amp;redirect_uri=http%3A%2F%2Fstatic.nid.naver.com%2Foauth%2Fsample%2Fcallback.html&amp;client_id=jyvqXeaVOVmV&amp;oauth_os=&amp;inapp_view=&amp;locale=ko_KR&amp;auth_type=reauthenticate">다른 아이디로 로그인</a></div>
        </div>
    </div>
    <!-- // header -->
    <!-- container -->
    <div class="oauth_container" role="main">
        <div id="content" class="oauth_content">
            <div class="access_logo"><img src="https://static.nid.naver.com/images/login/oauth_new/noimage.png" onerror="this.src='https://static.nid.naver.com/images/login/oauth_new/noimage.png';" width="70" height="70" alt="네이버 아이디로 로그인하기"></div>
            <div class="oauth_personal">
                <p class="oauth_personal_desc"><strong class="txt_bold">네이버 아이디로 로그인하기</strong>에서 <em class="txt_bold green">mayu1989</em>님의 개인정보에 접근하는 것에 동의하십니까?</p>
                <p class="oauth_personal_desc">제공된 정보는 이용자 식별, 통계, 계정 연동 및 CS 등을 위해 서비스 이용기간 동안 활용/보관됩니다.&nbsp;<span id="oauth_personal_desc_mandatory" style="display: none;">기본정보 및 필수 제공 항목은 <strong class="txt_bold">네이버 아이디로 로그인하기</strong>서비스를 이용하기 위해 반드시 제공되어야 할 정보입니다.</span><span id="oauth_personal_desc_optional">기본정보는 <strong class="txt_bold">네이버 아이디로 로그인하기</strong>서비스를 이용하기 위해 반드시 제공되어야 할 정보입니다.</span></p>
                <div class="oauth_personal_basic">
                    <strong class="tit">기본 정보</strong>
                    <div class="text" id="default_profile_desc">이용자 고유 식별자</div>
                    <div class="text" id="default_profile_old_desc" style="display:none">이용자 식별자, 별명, 프로필사진, 성별, 생일, 연령대</div>
                </div>

                <div class="oauth_personal_item" id="profile_mandatory" style="display: none;">
                    <strong class="tit">필수 제공 항목</strong>
                    <div class="item" id="profile_mandatory_list">
                    </div>
                </div>
                <div class="oauth_personal_item" id="profile_optional">
                    <strong class="tit">추가 제공 항목</strong>
                    <div class="item" id="profile_optional_list">
                    <span class="item_list"><input onclick="nclks('ai.nickname',this,event)" name="oauth_right" type="checkbox" id="extend_profile_nickname"><label for="extend_profile_nickname" class="item_text">별명</label></span><span class="item_list"><input onclick="nclks('ai.gender',this,event)" name="oauth_right" type="checkbox" id="extend_profile_gender"><label for="extend_profile_gender" class="item_text">성별</label></span><span class="item_list"><input onclick="nclks('ai.age',this,event)" name="oauth_right" type="checkbox" id="extend_profile_age"><label for="extend_profile_age" class="item_text">연령대</label></span></div>
                </div>

            </div>
            <div class="oauth_personal_guide">
                동의 후에는, 해당 서비스의 이용약관 및 개인정보처리방침에 따라 정보가 관리됩니다.
            </div>
            <div class="btn_area_double">
                <div class="btn_unit"><button type="button" class="btn_unit_off" onclick="try{nclks('agr.cancel',this,event)}catch(e){}"><span>취소</span></button></div>
                <div class="btn_unit"><button type="button" class="btn_unit_on" onclick="try{nclks('agr.agreement',this,event)}catch(e){}"><span>동의하기</span></button></div>
            </div>
        </div>
    </div>


    <!-- //container -->
    <!-- footer -->
    <div id="footer" class="oauth_footer" role="contentinfo">
        <ul>
            <li><!-- tg-text=footer_terms --><a href="http://policy.naver.com/rules/service.html" onclick="try{nclks('ftr.useragr',this,event)}catch(e){}" target="_blank">이용 약관</a></li>
            <li><strong><!-- tg-text=footer_privacy --><a href="http://policy.naver.com/rules/privacy.html" onclick="try{nclks('ftr.privacy',this,event)}catch(e){}" target="_blank">개인정보처리방침</a></strong></li>
            <li class="u_cr eng_none"><a href="http://policy.naver.com/rules/disclaimer.html" onclick="try{nclks('ftr.legal',this,event)}catch(e){}" target="_blank">책임의 한계와 법적고지</a></li>
            <li class="u_cr"><!-- tg-text=footer_help --><a href="https://help.naver.com/support/service/main.nhn?serviceNo=532" onclick="try{nclks('ftr.cs',this,event)}catch(e){}" target="_blank">회원정보 고객센터</a></li>
        </ul>
        <address>
            <em><a href="http://www.naver.com/" target="_blank" class="sp_img logo"><span class="blind">naver</span></a></em>
            <em class="copy">Copyright</em>
            <em class="u_cri">©</em>
            <a href="http://www.navercorp.com/" target="_blank" class="u_cra">NAVER Corp.</a>
            <span class="bar" aria-hidden="true">|</span>
            <!-- tg-text=footer_help -->
            <a href="https://help.naver.com/support/service/main.nhn?serviceNo=532" onclick="try{nclks('ftr.cs',this,event)}catch(e){}" target="_blank" class="u_cri">
                회원정보 고객센터
            </a>
            <span class="all_r">All Rights Reserved.</span>
        </address>
    </div>
    <!-- //footer -->
    <form id="oauthagreeFrm" name="oauthagreeFrm" action="https://nid.naver.com/login/noauth/allow_oauth.nhn" method="post" class="accept_form">
        <input type="hidden" id="oauth_token" name="oauth_token" value="P8ibN2A8Mhb1tyooBw">
        <input type="hidden" id="with_pin" name="with_pin" value="">
        <input type="hidden" id="step" name="step" value="agree_term">
        <input type="hidden" name="service_scope" value="">
        <input type="hidden" id="inapp_view" name="inapp_view" value="">
        <input type="hidden" id="oauth_os" name="oauth_os" value="">
    </form>
</div>
<script type="text/javascript" src="https://nid.naver.com/login/js/oauth_gnb.js"></script>
<script type="text/javascript" src="https://nid.naver.com/login/js/oauth_common_message.js"></script>
<script type="text/javascript" src="https://nid.naver.com/login/js/oauth_common_201804.js?20190128"></script>
<script type="text/javascript" src="https://nid.naver.com/login/js/common.util.js"></script>
<script type="text/javascript" nonce="">
    var nsc = "nid.login_kr";
    switch(locale) {
        case "ko_KR": nsc = "nid.login_kr"; break;
        case "en_US": nsc = "nid.login_en"; break;
        case "zh-Hans_CN": nsc = "nid.login_cn"; break;
        case "zh-Hant_TW": nsc = "nid.login_tw"; break;
    }
    if( isMobile ) {
        nsc = "M" + nsc;
    }
    lcs_do();
</script>

</body></html>