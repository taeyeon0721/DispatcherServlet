package test;

import java.util.HashMap;
import java.util.Map;

public class ExModel {
   // Q. 자바의 메서드 파라미터는 지역변수이다.
   //      커맨드 객체 or 모델 객체 등은 어떻게 데이터를 유지하는가?
   // A. 
   public static void main(String[] args) { // 컨테이너의 역할
      Map<String,String> model=new HashMap<>();
      String path=root(model); // 커맨드 객체 or 모델 객체 -> 객체 변수, 참조형 변수
      printData(path,model);
   }
   public static String root(Map model) {
      model.put("name1", "티모");
      model.put("name2", "아리");
      return "memberListPage"; // 응답할 페이지명
   }
   public static void printData(String path,Map model) {
      System.out.println("현재 페이지: WEB-INF/views/"+path+".jsp");
      System.out.println("데이터: "+model.get("name2"));
   }
}