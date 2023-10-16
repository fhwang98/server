package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. 서블릿 클래스 선언
//	a. javax.servlet.http.HttpServlet 클래스를 상속받는다.	
public class Ex01 extends HttpServlet {
	
	//	2. doGet/doPost 메소드 선언 > 예약된 이름의 메소드 > 요청 메소드
	//	- 둘 중 하나 선언 or 둘 다 선언
	//	- 클라이언트(브라우저)의 요청이 들어오면 자동으로 호출되는 메소드
	//	- "주문하기" 메소드
	//	- 커피 만드는 메소드 > HTML 페이지를 만드는 메소드
	//	- 메소드 작성 규칙
	//		a. 매개변수
	//			1. java.servlet.http.HttpServletRequest
	//			2. java.servlet.http.HttpServletResponse
	//		b. 예외 미루기
	//			1. java.io.IOException
	//			2. java.servlet.ServletException
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		// 3. 동적 HTML 페이지 작성 구현
		//	- doGet/doPost 메소드의 구현부 > HTML 페이지를 만들기 위한 자바 코드 작성
		//	- HttpServletResponse 객체의 getWriter() 메소드 호출 > PrintWriter 객체 반환
		//	- PrintWriter 객체의 printXXX("태그) 메소드를 사용해서 HTML 페이지를 작성한다. > 동적으로 웹페이지 생산
		//	- 페이지 완성 > 브라우저에게 반환 > 웹 페이지 출력
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<meta charset='UTF-8'>");
		writer.print("<style>");
		writer.print("h1 {color: 'cornflowerblue;'}");
		writer.print("</style>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h1>Hello</h1>");
		writer.print("<p>Servlet으로 페이지를 만들었습니다.</p>");
		writer.print("</body>");
		writer.print("</html>");
		
		writer.close(); // 일종의 스트림
		
		//4. 요청(실행)
		// - http://localhost:8090/servlet/servlet/com.test.sevlet.Ex01
		// - 자바 클래스는 웹에서는 실행 불가
		// - 자바 클래스 > URL을 통해서는 실행 불가
		// - 가상 URL 생성 > 내부적으로 자바 클래스 호출 가능
		// - Tomcat이 중간에서 처리 > webapp/WEB-INF/web.xml(톰캣이 사이트 운영과 관련된 설정 파일)
		 
		
	}
	
	
}

