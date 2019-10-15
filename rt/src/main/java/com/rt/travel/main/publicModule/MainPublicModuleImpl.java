package com.rt.travel.main.publicModule;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rt.travel.board.dao.BoardDAO;
import com.rt.travel.board.dto.BoardDTO;

public class MainPublicModuleImpl implements MainPublicModule {

   @Autowired
   BoardDAO boardDAO;

   @Override
   public String head() {
      return "" + "" + "   <!-- CSS STYLE -->"
            + "   <link rel=\"stylesheet\" href=\"resources/assets/css/Boardstyle.css\">" + "" + "   <!-- 웹 폰트 -->"
            + "   <link href=\"https://fonts.googleapis.com/css?family=Black+Han+Sans|Orbitron&display=swap\" rel=\"stylesheet\">"
            + "   <link href=\"https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap\" rel=\"stylesheet\">"
            + "   " + "";
   }

   @Override
   public String body(Object sessionId) {
      if (sessionId != null)
         return "<script>" + "$(function() {" + "   $(\"#loginPageHref\").remove();"
               + "   $(\"#signHref\").remove();"
               + "$(\".header_menu\").append(\"<a id='logOut' href='logout'>로그아웃</a>\");" + "})" + "</script>"
               + "   <!-- 스킵 내비게이션 -->\r\n" + "   <div id=\"skip\">\r\n"
               + "      <a href=\"#cont_nav\">전체 메뉴 바로가기</a>\r\n"
               + "      <a href=\"#cont_ban\">배너 영역 바로가기</a>\r\n"
               + "      <a href=\"#cont_cont\">컨텐츠 영역 바로가기</a>\r\n" + "   </div>\r\n"
               + "   <!-- //스킵 내비게이션 -->\r\n" + "   <div id=\"wrap\">\r\n" + "      <div id=\"menu\">\r\n"
               + "         <div class=\"container\">\r\n" + "            <div class=\"menu\">\r\n"
               + "               <div>\r\n"
               + "                  <h3><a class=\"font_color\" href=\"main.do\">홈</a></h3>\r\n"
               + "               </div>\r\n" + "               <div class=\"dropdown\">\r\n"
               + "                  <h3 class=\"font_color\">여행일정</h3>\r\n"
               + "                  <div class=\"dropdown-content\">\r\n"
               + "                     <a class=\"menu_nav\" href=\"typea.do\">여행일정 만들기</a>\r\n"
               + "                  </div>\r\n" + "               </div>\r\n"
               + "               <div class=\"dropdown\">\r\n"
               + "                  <h3 class=\"font_color\">동행찾기</h3>\r\n"
               + "                  <div class=\"dropdown-content\">\r\n"
               + "                     <a class=\"menu_nav\" href=\"companion\">전체동행찾기 리스트</a>\r\n"
               + "                  </div>\r\n" + "               </div>\r\n"
               + "               <div class=\"dropdown\">\r\n"
               + "                  <h3 class=\"font_color\">소통광장</h3>\r\n"
               + "                  <div class=\"dropdown-content\">\r\n"
               + "                     <a class=\"menu_nav\" href=\"list.do?page=1\">여행후기 게시판</a>\r\n"
               + "                  </div>\r\n" + "               </div>\r\n"
               + "               <div class=\"dropdown\">\r\n"
               + "                  <h3 class=\"font_color\">마이페이지</h3>\r\n"
               + "                  <div class=\"dropdown-content\">\r\n"
               + "                     <a class=\"menu_nav\" href=\"myPerfectPlanList\">나의 여행일정</a>\r\n"
               + "                     <a class=\"menu_nav\" href=\"my\">회원정보보기</a>\r\n"
               + "                  </div>\r\n" + "               </div>\r\n" + "            </div>\r\n"
               + "         </div>\r\n" + "      </div>\r\n" + "      <!-- menu -->\r\n"
               + "         <div id=\"header\">\r\n" + "            <div class=\"container\">\r\n"
               + "               <div class=\"header\">\r\n" + "                  <div class=\"header_menu\">\r\n"
               + "                     <a id=\"loginPageHref\" href=\"loginPage\">로그인</a>\r\n"
               + "                     <a id=\"signHref\" href=\"sign\">회원가입</a>\r\n"
               + "                  </div>\r\n" + "               <!-- //헤더 메뉴 -->\r\n"
               + "               <div class=\"header-tit\">\r\n"
               + "                  <h1>모두의 정보 &amp; 모정!!</h1><br>\r\n"
               + "                  <!-- <a href=\"\">www.우리가 정한 사이트 이름</a> -->\r\n" + "               </div>\r\n"
               + "               <!-- //헤더 타이틀 -->\r\n" + "               \r\n"
               + "               <!-- 이미지를 표현하는 방법 \r\n"
               + "                  1. img 태그로 표현(의미가 있을때) / alt 태그 - 대체 문자 표현\r\n"
               + "                  2. background 속성으로 표현(의미가 없을때)\r\n"
               + "                  3. 이미지를 background 속성 - 웹 표준 준수하기 위해서 \r\n"
               + "                     가상으로 대체를 문자를 만들어줌(IR 효과)\r\n" + "                     이미지 스프라이트\r\n"
               + "               -->\r\n" + "               </div>\r\n" + "            </div>\r\n"
               + "         </div>\r\n" + "         <!-- header -->\r\n" + "         \r\n"
               + "         <!-- cont_nav -->\r\n" + "         \r\n" + "            </div>\r\n";
      else
         return "   <!-- 스킵 내비게이션 -->\r\n" + "   <div id=\"skip\">\r\n"
               + "      <a href=\"#cont_nav\">전체 메뉴 바로가기</a>\r\n"
               + "      <a href=\"#cont_ban\">배너 영역 바로가기</a>\r\n"
               + "      <a href=\"#cont_cont\">컨텐츠 영역 바로가기</a>\r\n" + "   </div>\r\n"
               + "   <!-- //스킵 내비게이션 -->\r\n" + "   <div id=\"wrap\">\r\n" + "      <div id=\"menu\">\r\n"
               + "         <div class=\"container\">\r\n" + "            <div class=\"menu\">\r\n"
               + "               <div>\r\n"
               + "                  <h3><a class=\"font_color\" href=\"main.do\">홈</a></h3>\r\n"
               + "               </div>\r\n" + "               <div class=\"dropdown\">\r\n"
               + "                  <h3 class=\"font_color\">여행일정</h3>\r\n"
               + "                  <div class=\"dropdown-content\">\r\n"
               + "                     <a class=\"menu_nav\" href=\"typea.do\">여행일정 만들기</a>\r\n"
               + "                  </div>\r\n" + "               </div>\r\n"
               + "               <div class=\"dropdown\">\r\n"
               + "                  <h3 class=\"font_color\">동행찾기</h3>\r\n"
               + "                  <div class=\"dropdown-content\">\r\n"
               + "                     <a class=\"menu_nav\" href=\"companion\">전체동행찾기 리스트</a>\r\n"
               + "                  </div>\r\n" + "               </div>\r\n"
               + "               <div class=\"dropdown\">\r\n"
               + "                  <h3 class=\"font_color\">소통광장</h3>\r\n"
               + "                  <div class=\"dropdown-content\">\r\n"
               + "                     <a class=\"menu_nav\" href=\"list.do?page=1\">여행후기 게시판</a>\r\n"
               + "                  </div>\r\n" + "               </div>\r\n"
               + "               <div class=\"dropdown\">\r\n"
               + "                  <h3 class=\"font_color\">마이페이지</h3>\r\n"
               + "                  <div class=\"dropdown-content\">\r\n"
               + "                     <a class=\"menu_nav\" href=\"myPerfectPlanList\">나의 여행일정</a>\r\n"
               + "                     <a class=\"menu_nav\" href=\"my\">회원정보보기</a>\r\n"
               + "                  </div>\r\n" + "               </div>\r\n" + "            </div>\r\n"
               + "         </div>\r\n" + "      </div>\r\n" + "      <!-- menu -->\r\n"
               + "         <div id=\"header\">\r\n" + "            <div class=\"container\">\r\n"
               + "               <div class=\"header\">\r\n" + "                  <div class=\"header_menu\">\r\n"
               + "                     <a id=\"loginPageHref\" href=\"loginPage\">로그인</a>\r\n"
               + "                     <a id=\"signHref\" href=\"sign\">회원가입</a>\r\n"
               + "                  </div>\r\n" + "               <!-- //헤더 메뉴 -->\r\n"
               + "               <div class=\"header-tit\">\r\n"
               + "                  <h1>모두의 정보 &amp; 모정!!</h1><br>\r\n"
               + "                  <!-- <a href=\"\">www.우리가 정한 사이트 이름</a> -->\r\n" + "               </div>\r\n"
               + "               <!-- //헤더 타이틀 -->\r\n" + "               \r\n"
               + "               <!-- 이미지를 표현하는 방법 \r\n"
               + "                  1. img 태그로 표현(의미가 있을때) / alt 태그 - 대체 문자 표현\r\n"
               + "                  2. background 속성으로 표현(의미가 없을때)\r\n"
               + "                  3. 이미지를 background 속성 - 웹 표준 준수하기 위해서 \r\n"
               + "                     가상으로 대체를 문자를 만들어줌(IR 효과)\r\n" + "                     이미지 스프라이트\r\n"
               + "               -->\r\n" + "               </div>\r\n" + "            </div>\r\n"
               + "         </div>\r\n" + "         <!-- header -->\r\n" + "         \r\n"
               + "         <!-- cont_nav -->\r\n" + "         \r\n" + "            </div>\r\n";

   }

   @Override
   public String body2() {
      List<BoardDTO> mainBoardList = null;
      try {
         mainBoardList = boardDAO.mainBoardList();
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      String body2 = "            <div id = \"cont_cont\">\r\n" + "               <div class=\"container\">\r\n"
            + "                  <div class=\"cont\">\r\n" + "                     <div class=\"column col\">\r\n"
            + "                        <h3><span class=\"ico_img ir_pm\">아이콘</span><span class=\"ico_tit\">Notice</span></h3>\r\n"
            + "                        <p class=\"col_desc\">게시판 내용 리스트</p>\r\n"
            + "                        <!-- 게시판 -->\r\n" + "                        <div class=\"notice\">\r\n"
            + "                           <h4>Web Publisher Notice</h4>\r\n"
            + "                           <table class=\"type_01 \"border=\"1\">\r\n"
            + "                               <thead>\r\n" + "                               <tr>\r\n"
            + "                                   <th scope=\"co_1\">작성자</th>\r\n"
            + "                                   <th scope=\"co_2\">제목</th>\r\n"
            + "                                   <th scope=\"co_3\">조회수</th>\r\n"
            + "                                   <th scope=\"co_4\">작성날짜</th>\r\n"
            + "                               </tr>\r\n" + "                               </thead>\r\n"
            + "                               <tbody>\r\n";
      BoardDTO boardDTO = null;
      for (int i = 0; i < mainBoardList.size(); i++) {
         boardDTO = mainBoardList.get(i);
         SimpleDateFormat formatType = new SimpleDateFormat("yyyy-MM-dd HH:mm");
         body2 += " <tr>\r\n" 
               + "       <th scope=\"row\">작성자</th>\r\n"
               + "      <td><a href = \"view.do?bno="+boardDTO.getBno()+"\">"+ boardDTO.getTitle() +"</a><span style=\"margin: 10px; color: red;\">"+boardDTO.getCommentCount()+"</span></td>\r\n"
               + "      <td>"+ boardDTO.getViewcnt()+"</td>\r\n"
               + "      <td>"+ formatType.format(boardDTO.getRegdate()) +"</td>\r\n"
               + "</tr>\r\n";
      }

      return body2 += "                          </tbody>\r\n" + "                           </table>\r\n"
            + "                           <a href=\"list.do?page=1\" class=\"\">더보기</a>\r\n"
            + "                        </div>\r\n" + "                     </div>\r\n"
            + "                  </div>\r\n" + "               </div>\r\n" + "            </div>\r\n"
            + "         <!-- cont_cont -->\r\n" + "         \r\n" + "            <div id = \"cont_ban\">\r\n"
            + "               <div class=\"container\">cont_ban</div>\r\n" + "            </div>\r\n"
            + "         <!-- cont_ban -->\r\n" + "         </div>\r\n" + "         <!-- content -->\r\n"
            + "         \r\n" + "         <div id=\"footer\">\r\n" + "            <div class=\"container\">"
            + "               <h2 class=\"ir_su\">푸터 영역</h2>\r\n"
            + "                  <div class=\"footer\">\r\n" + "                     <ul>\r\n"
            + "                        <li><a href=\"\">사이트 도움말</a></li>\r\n"
            + "                        <li><a href=\"\">사이트 이용약관</a></li>\r\n"
            + "                        <li><a href=\"\">사이트 운영규칙</a></li>\r\n"
            + "                        <li><a href=\"\"><strong>사이트 개인정보취급방침</strong></a></li>\r\n"
            + "                        <li><a href=\"\">책임의 한계와 법적고지</a></li>\r\n"
            + "                        <li><a href=\"\">게시중단요청 서비스</a></li>\r\n"
            + "                        <li><a href=\"\">고객센터</a></li>\r\n"
            + "                     </ul>\r\n" + "                     <address>\r\n"
            + "                     Copyright&copy;rt.co.kr All Right Rederved"
            + "                     </address>\r\n" + "                  </div>\r\n"
            + "               </div>\r\n" + "         </div>\r\n" + "         <!-- footer -->\r\n"
            + "         \r\n" + "      </div>";
   }

   @Override
   public String footer() {
      return "" + "      <div class=\"footer\">\r\n" + "         <div id=\"footer\">\r\n"
            + "            <div class=\"container\">" + "               <h2 class=\"ir_su\">푸터 영역</h2>\r\n"
            + "                  <div class=\"footer\">\r\n" + "                     <ul>\r\n"
            + "                        <li><a href=\"\">사이트 도움말</a></li>\r\n"
            + "                        <li><a href=\"\">사이트 이용약관</a></li>\r\n"
            + "                        <li><a href=\"\">사이트 운영규칙</a></li>\r\n"
            + "                        <li><a href=\"\"><strong>사이트 개인정보취급방침</strong></a></li>\r\n"
            + "                        <li><a href=\"\">책임의 한계와 법적고지</a></li>\r\n"
            + "                        <li><a href=\"\">게시중단요청 서비스</a></li>\r\n"
            + "                        <li><a href=\"\">고객센터</a></li>\r\n"
            + "                     </ul>\r\n" + "                     <address>\r\n"
            + "                     Copyright&copy;rt.co.kr All Right Rederved"
            + "                     </address>\r\n" + "                  </div>\r\n"
            + "               </div>\r\n" + "            </div>\r\n" + "            <!-- footer -->\r\n"
            + "            \r\n" + "         </div>\r\n" + "      </div>";

   }
}