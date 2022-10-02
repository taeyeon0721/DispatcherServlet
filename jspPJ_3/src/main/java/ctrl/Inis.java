package ctrl;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.Crawling;
import dao.EstateDAO;
import vo.EstateVO;

/**
 * Application Lifecycle Listener implementation class Crawling
 *
 */
@WebListener
public class Inis implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Inis() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	EstateDAO eDAO = new EstateDAO();
    	EstateVO eVO = new EstateVO();
    	eVO.setSubway("");
    	eVO.setEaddress("");
    	eVO.setCnt(1);
    	Crawling cw = new Crawling();
    	ArrayList<EstateVO> datas = eDAO.eSelectAll(eVO);
    	if(datas.size()==0) {
    		cw.craw();
    	}
    	
    }
	
}
