package dao;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message; // 임포트해주기
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import vo.SmsVO;

public class SmsDAO {
	
	public int sms(SmsVO vo) {
		String api_key = "NCSXKWT2SWGIHXTE"; // 회원가입 시 발급받은 api키
		String api_secret = "C349T2HVW7WU6LZ5FXC1RZEHRHQQEOF8"; // 회원가입 시 발급받은 secret api키
		Message coolsms = new Message(api_key, api_secret);

		Random rd = new Random();
		int randNum = rd.nextInt(899999)+100000; // 임의로 만든 랜덤 인증번호 

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", "010"+vo.getPhone()); //받는 사람 번호
		params.put("from", "01038391324"); //보내는 사람 번호(회사)
		params.put("type", "SMS");
		params.put("text", "사방팔방 인증번호 ["+randNum+"]"); //보낼 메세지
		params.put("app_version", "test app 1.2");

		try {
			//send()는 메세지를 보내는 함수
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println("확인");
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
		return randNum; // 인증번호를 리턴
	}	
	
	public int smsCheck(SmsVO vo) {
		
		if(vo.getPhone().equals(vo.getCheckNum())) {
			return 1;
		}else {
			return 0;
		}
	}

}

