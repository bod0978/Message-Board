package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Dao.billDao;
import Dao.memberDao;
import Model.bill;
import Model.member;

@Controller
@RequestMapping(value="member")
public class memController {
	
	//index
	@RequestMapping(value="view", method=RequestMethod.GET)
	public ModelAndView view (HttpServletRequest request ,HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		
		
	
		session.removeAttribute("M");
		return new ModelAndView("redirect:../index.jsp");
	}
	
	//check account
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login (HttpServletRequest request ,HttpServletResponse response) throws Exception{
		
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		
		List l = new memberDao().logincheck(user,pass);
		
		if(l.size() == 1) {
			
			HttpSession session = request.getSession();
			
			Object o[] = l.toArray();
			member m = (member)o[0];
			
			if(m.getType()== 1) {
				session.setAttribute("M", m);
				return new ModelAndView("rootloop");
			}
				session.setAttribute("M", m);
				return new ModelAndView("loop");
				
		}else {
			return new ModelAndView("redirect:../index.jsp");
		}
	}
	
	//add user
	@RequestMapping(value="addmv", method=RequestMethod.GET)
	public ModelAndView addmv (HttpServletRequest request ,HttpServletResponse response) throws Exception{

		return new ModelAndView("addm");
	}
	
	@RequestMapping(value="addm", method=RequestMethod.POST)
	public ModelAndView addm (HttpServletRequest request ,HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		String phone = request.getParameter("phone");
		String stud =request.getParameter("stud");
		
		List l = new memberDao().checkuser(user);
		
		if(l.size() != 1) {

			member m = new member();
			m.setUser(user);
			m.setPassword(pass);
			m.setName(name);
			m.setPhone(phone);
			m.setStudent(stud);
			m.setType(0);
			System.out.println(m.getName()+"\t"+m.getPassword()+"\t"+m.getPhone()+"\t"+m.getType()+"\t"+stud);
			new memberDao().add(m);
			
			return new ModelAndView("addok");
		}else {
			return new ModelAndView("addm");
		}
	}
	
	//root see user
	@RequestMapping(value="lookuser" , method=RequestMethod.GET)
	public ModelAndView lookuser (HttpServletRequest request,HttpServletResponse response) throws Exception{
		return new ModelAndView("lookuser");
	}
	
	//root see update
	@RequestMapping(value="Mupdate" , method=RequestMethod.GET)
	public ModelAndView Mupdate (HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		int id =Integer.parseInt( request.getParameter("id"));
		
		List l = new memberDao().userloo(id);
		Object o [] = l.toArray();
		member m = (member)o[0];
		HttpSession session = request.getSession();
		session.setAttribute("U1",m );
		return new ModelAndView("Mupdate");
	}
}
