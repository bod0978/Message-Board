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
import Model.bill;
import Model.member;

@Controller
@RequestMapping(value="loop")
public class loopController {
	
	//admin view
	@RequestMapping(value="view" , method=RequestMethod.GET)
	public ModelAndView view (HttpServletRequest request,HttpServletResponse response) throws Exception{
		return new ModelAndView("loop");
	}
	
	//root view
	@RequestMapping(value="rootview" , method=RequestMethod.GET)
	public ModelAndView rootview (HttpServletRequest request,HttpServletResponse response) throws Exception{
		return new ModelAndView("rootloop");
	}
	
	//admin loop
	@RequestMapping(value="loop" , method=RequestMethod.GET)
	public ModelAndView add (HttpServletRequest request,HttpServletResponse response) throws Exception{
		return new ModelAndView("addloop");
	}
	
	//admin add loop check
	@RequestMapping(value="loopcheck" , method=RequestMethod.POST)
	public ModelAndView addcheck (HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();		
		member m = (member) session.getAttribute("M"); 
		
		String Count = request.getParameter("count");
		String Note = request.getParameter("note");		
		
		bill b = new bill();
		b.setCount(Count);
		b.setName(m.getName());
		b.setNote(Note);
		
		session.setAttribute("B", b);
		
		return new ModelAndView("confirm");
	}
	
	//admin loop add ok
	@RequestMapping(value="loopok" , method=RequestMethod.POST)
	public ModelAndView addok (HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		HttpSession session= request.getSession();
		bill b = (bill)session.getAttribute("B");
		
		new billDao().add(b);
		session.removeAttribute("B");
		return new ModelAndView("loopok");
	}
	
	//admin see loop
	@RequestMapping(value="loopsee" , method=RequestMethod.GET)
	public ModelAndView loopsee (HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		List l = new billDao().queryId(id);
		
		Object o[] = l.toArray();
		bill sb = (bill)o[0];
		HttpSession sessionC = request.getSession();
		sessionC.setAttribute("SB", sb);
		
		return new ModelAndView("loopsee");
		
	}
	
	//root see loop
	@RequestMapping(value="loopsee2" , method=RequestMethod.GET)
	public ModelAndView loopsee2 (HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		List l = new billDao().queryId(id);
		
		Object o[] = l.toArray();
		bill sb = (bill)o[0];
		HttpSession sessionC = request.getSession();
		sessionC.setAttribute("SB", sb);
		
		return new ModelAndView("loopsee2");
		
	}
	
	//root update check
	@RequestMapping(value="loopupdate" , method=RequestMethod.GET)
	public ModelAndView loopupdate (HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		//System.out.println("upload"+id);
		
		List l = new billDao().queryId(id);
		
		Object o[] = l.toArray();
		bill sb = (bill)o[0];
		HttpSession sessionC = request.getSession();
		sessionC.setAttribute("SB", sb);
		
		return new ModelAndView("loopupload");
		
	}
	
	//root update ok
	@RequestMapping(value="updateok" , method=RequestMethod.POST)
	public ModelAndView updateok (HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		HttpSession sessionC = request.getSession();
		bill sb =(bill) sessionC.getAttribute("SB");
		
		String Count = request.getParameter("count");
		String Name = request.getParameter("name");
		String Note = request.getParameter("note");		
		
		bill b = new bill();
		b.setId(sb.getId());
		b.setCount(Count);
		b.setName(Name);
		b.setNote(Note);
		System.out.println(b.getCount()+"\t"+b.getName()+"\t"+b.getNote());
		new billDao().update(b);
		
		sessionC.removeAttribute("SB");
		
		return new ModelAndView("rootok");
	}

	//root delete ok
	@RequestMapping(value="loopdelete" , method=RequestMethod.GET)
	public ModelAndView loopdelete (HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
	
		//System.out.println("delete"+id);
		
		bill b = new bill();
		b.setId(id);
	
		new billDao().delete(b);
		
		return new ModelAndView("rootok");
		
	}
	
}
