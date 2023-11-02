package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.test.toy.DBUtil;

public class Dummy {

	public static void main(String[] args) {
		
		try {
			
			Connection conn = null;
			PreparedStatement pstat = null;
			
			conn = DBUtil.open();
			
			String sql = "INSERT INTO tblboard (seq, subject, content, regdate, readcount, id)\n"
					+ "	VALUES (seqboard.nextVal, ?, '내용', DEFAULT, DEFAULT, 'hong')";

			String temp = "11월3일 만화의 날을 하루 앞두고 무단으로 웹툰 콘텐츠들을 제공하던 불법 사이트 150여개가 활동을 멈춘 것으로 나타났다. 네이버웹툰이 앞장서서 해외에 서버를 두고 있는 불법 사이트 색출에 나선 결과다. 이번에 활동을 멈춘 불법 사이트들의 연간 방문수(트래픽)는 약 25억회에 달했던 것으로 집계됐다. 네이버웹툰은 3개월 간 공들인 끝에 해외 불법 사이트 150여개가 활동을 멈췄다고 2일 밝혔다. 웹툰 업계 최초로 미국 법원을 통해 진행한 소환장(Subpoena) 발행 조치의 성과다. 네이버웹툰은 지난 7월 미국의 한 대형 콘텐츠 전송 네트워크(CDN)에 360여개 불법 사이트 운영자의 개인정보 제출을 요구하는 소환장을 발행한 바 있다. 주소, 이메일, 결제 세부 정보 등 불법 사이트 운영자의 정보는 추적 및 검거를 위한 필수 정보다. 소환장은 불법 사이트 운영자의 활동을 위축시키는 효과도 있다. 미국은 DMCA(디지털 밀레니엄 저작권법)에 근거해 온라인 서비스 상에서 저작권 침해가 있는 경우 저작권자가 소환장을 통해 서비스 제공자에게 저작권 침해자로 의심되는 회원들의 개인정보 제출을 요구할 수 있다. 하지만 개인 창작자가 개별로 소환장 발행 요구를 직접 진행하기에는 절차가 매우 복잡하다. 이에 네이버웹툰은 창작자들을 대리해 모든 비용을 부담해 소환장 절차를 진행했다고 강조했다. 네이버웹툰은 소환장에 기재한 360여개의 불법 사이트 중 웹툰을 직접 불법 유포하는 대형 1차 불법 사이트를 포함해 약 150여개 사이트가 완전히 삭제되거나 일시적으로 운영을 중지했다고 설명했다. 트래픽 통계 사이트 시밀러웹에 따르면 네이버웹툰의 이번 조치로 영향을 받은 150여개 불법 사이트의 연간 이용자 방문 트래픽은 약 25억회에 달한다. 네이버웹툰은 이번에 확보한 불법 사이트 운영자에 대한 정보를 수사기관과 공유하고 무관용 원칙으로 엄정 대응할 예정이다.";
			
			String[] templist = temp.split(" ");
			
			Random rnd = new Random();
			
			
			pstat = conn.prepareStatement(sql);
			
			for (int i = 0; i < 250; i++) {
				
				String subject = "";
				
				for (int j = 0; j < 5; j++) {
					subject += templist[rnd.nextInt(templist.length)] + " ";
				}
				pstat.setString(1, subject);
				pstat.executeUpdate();
				System.out.println(i);
			}
			
			pstat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Dummy.main()");
			e.printStackTrace();
		}
		
	}
	
}
