package dao;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import vo.EstateVO;


public class Crawling {

   public void craw() {
      final String url="https://dusdn1022.tistory.com/65";
      Document doc=null;
      
      try {
         doc = Jsoup.connect(url).get(); 
         
         String str1 ="tbody > tr > td";
         String str2 ="tbody > tr > td > figure > span > img";
         
         Elements eles1 = doc.select(str1);
         Elements eles2 = doc.select(str2);  
         Iterator<Element> itr1 = eles1.iterator();
         Iterator<Element> itr2 = eles2.iterator();

         EstateDAO model = new EstateDAO();
         while(itr1.hasNext()) {
            EstateVO vo=new EstateVO();
            String ename = itr1.next().text(); 
            String price = itr1.next().text(); 
            String category = itr1.next().text(); 
            String eaddress = itr1.next().text(); 
            String einfo = itr1.next().text(); 
            String epay = itr1.next().text(); 
            String subway = itr1.next().text(); 
            String rid = itr1.next().text(); 
            itr1.next();
            String eimgsrc = itr2.next().attr("src");
            
            System.out.println("ename "+ename);
            System.out.println("price "+price);
            System.out.println("category "+category);
            System.out.println("eaddress"+eaddress);
            System.out.println("einfo "+einfo);
            System.out.println("epay "+epay);
            System.out.println("subway "+subway);
            System.out.println("rid "+rid);
            System.out.println(eimgsrc);
            
            vo.setEname(ename);
            vo.setPrice(price);
            vo.setCategory(category);
            vo.setEaddress(eaddress);
            vo.setEinfo(einfo);
            vo.setEpay(epay);
            vo.setSubway(subway);
            vo.setRid(rid);
            vo.setEimgsrc(eimgsrc);
            
            model.eInsert(vo);
         }
         System.out.println("로그: Crowling 성공");
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}