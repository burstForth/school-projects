package controller;
 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import pojo.Category;
import pojo.bcboth;
import pojo.kebiao;
import pojo.kecheng;
import pojo.student;
import pojo.teacher;
import service.CategoryService;
 
// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
 
//    @RequestMapping("listCategory")
//    public ModelAndView listCategory(){
//        ModelAndView mav = new ModelAndView();
//        List<Category> cs= categoryService.list();
//         
//        // 放入转发参数
//        mav.addObject("cs", cs);
//        // 放入jsp路径
//        mav.setViewName("listCategory");
//        return mav;
//    }
    public void find(HttpServletRequest request) {
    	List<kebiao> kb= categoryService.kebiaoList();
		 List<kecheng> kz= categoryService.kechengList();
		 List<bcboth> bc= categoryService.bcbothList();
		 List<Category> cg= categoryService.list();
		 List<teacher> tl= categoryService.teacherList();
		 List<student> sl= categoryService.studentList();
		 request.getSession().setAttribute("kb", kb);
		 request.getSession().setAttribute("kz", kz);
		 request.getSession().setAttribute("bc", bc);
		 request.getSession().setAttribute("cg", cg);
		 request.getSession().setAttribute("tl", tl);
		 request.getSession().setAttribute("sl", sl);
    }
    @RequestMapping("loging")
    public String loging(){
    	 return "login";
    }
    @RequestMapping("adminn")
    public String adminn(){
    	 return "admin";
    }
    @RequestMapping("teacher")
    public String teacher(){
    	return "teacher";
    }
    @RequestMapping("student")
    public String student(){
    	return "student";
    }
    @RequestMapping("login")
    public String login(HttpServletRequest request){
    	//ModelAndView mav = new ModelAndView();
    	String userName=request.getParameter("userName");
    	String userPw=request.getParameter("userPw");
    	String userType=request.getParameter("userType");
    	Integer typee=Integer.parseInt(userType);
    	//find(request);
//    	System.out.println(typee);
//    	System.out.println(userName);
//    	System.out.println(userPw);
    	if(typee==0) {
    		Integer ad=categoryService.login(userName,userPw);
    		 if(ad!=null) {		
    			 
    			 return "redirect:adminn";
    	    	  // return "redirect:admin";
    	       }else {
    	    	   
    	    	   return "login";
    	       }
    	}else if(typee==1) {
    		Integer ad=categoryService.loginLao(userName,userPw);
    		 if(ad!=null){
    			 List<teacher> cs= categoryService.teacherList(userName);
    			 List<bcboth> bc= categoryService.bcbothList();
    			 request.getSession().setAttribute("info", cs);
    			 request.getSession().setAttribute("bc", bc);
    			 return "redirect:teacher";
    	       }else { 
    	    	   return "login";
    	       }
    	}else {
    		Integer ad=categoryService.loginStu(userName,userPw);
    		 if(ad!=null) {
    			 List<student> cs= categoryService.studentList(userName);
    			 List<bcboth> bc= categoryService.bcbothList();
    			 request.getSession().setAttribute("ma", cs);
    			 request.getSession().setAttribute("bc", bc);
    			 return "redirect:student";
    	       }else {
    	    	   return "login";
    	       }
    	} 
    }
    @RequestMapping(value="admin",method=RequestMethod.POST)
    public void admin(HttpServletRequest request,HttpServletResponse response)throws IOException {
    	find(request);
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out=response.getWriter();
    	
    	out.print("");
    	out.flush();
		out.close();
    }
    @RequestMapping(value="dell",method=RequestMethod.POST)//对应jq里面的url
    @ResponseBody//需要传值就用这个注解
    public void del(@RequestParam("ide") String idd,HttpServletResponse response,HttpServletRequest request) throws IOException{//ide就是jq传进来的参数
    		//System.out.println("进来了");
		
			Integer id=Integer.parseInt(idd);
			int sd=categoryService.delete(id);
			find(request);
			PrintWriter out=response.getWriter();
			
			if(sd>0) {
				List<Category> ad= categoryService.list();
				String jsonn=JSON.toJSONString(ad);
				out.print(jsonn);
			}else {
				out.print("<script>alert('删除失败');</script>");
			}
			out.flush();
			out.close();
    }
    @RequestMapping(value="delone",method=RequestMethod.POST,produces = "application/json; charset=utf-8")//对应jq里面的url
    @ResponseBody//需要传值就用这个注解
    public void delone(@RequestParam("ide") String idd,
    		HttpServletResponse response,
    		HttpServletRequest request) throws IOException{//ide就是jq传进来的参数
    		//System.out.println("进来了");
		
			Integer id=Integer.parseInt(idd);
			int sd=categoryService.deleteone(id);
			find(request);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out=response.getWriter();
			
			if(sd>0) {
				List<kecheng> ad= categoryService.kechengList();
				String jsonn=JSON.toJSONString(ad);
				
				out.print(jsonn);
			}else {
				out.print("ha");
			}
			out.flush();
			out.close();
    }
    @RequestMapping(value="deltwo",method=RequestMethod.POST,produces = "application/json; charset=utf-8")//对应jq里面的url
    @ResponseBody//需要传值就用这个注解
    public void deltwo(@RequestParam("ide") String idd,
    		HttpServletResponse response,
    		HttpServletRequest request) throws IOException{//ide就是jq传进来的参数
    	//System.out.println("进来了");
    	
    	Integer id=Integer.parseInt(idd);
    	int sd=categoryService.deletethree(id);
    	find(request);
    	response.setContentType("application/json;charset=UTF-8");
    	PrintWriter out=response.getWriter();
    	
    	if(sd>0) {
    		List<teacher> ad= categoryService.teacherList();
    		String jsonn=JSON.toJSONString(ad);
    		
    		out.print(jsonn);
    	}else {
    		out.print("ha");
    	}
    	out.flush();
    	out.close();
    }
    @RequestMapping(value="delthree",method=RequestMethod.POST,produces = "application/json; charset=utf-8")//对应jq里面的url
    @ResponseBody//需要传值就用这个注解
    public void delthree(@RequestParam("ide") String idd,
    		HttpServletResponse response,
    		HttpServletRequest request) throws IOException{//ide就是jq传进来的参数
    	//System.out.println("进来了");
    	
    	Integer id=Integer.parseInt(idd);
    	int sd=categoryService.deletetwo(id);
    	find(request);
    	response.setContentType("text/json;charset=UTF-8");
    	PrintWriter out=response.getWriter();
    	
    	if(sd>0) {
    		List<bcboth> ad= categoryService.bcbothList();
    		
    		String jsonn=JSON.toJSONString(ad);
    		
    		out.print(jsonn);
    	}else {
    		out.print("ha");
    	}
    	out.flush();
    	out.close();
    }
    @RequestMapping(value="delfour",method=RequestMethod.POST,produces = "application/json; charset=utf-8")//对应jq里面的url
    @ResponseBody//需要传值就用这个注解
    public void delfour(@RequestParam("ide") String idd,
    		HttpServletResponse response,
    		HttpServletRequest request) throws IOException{//ide就是jq传进来的参数
    	//System.out.println("进来了");
    	
    	Integer id=Integer.parseInt(idd);
    	int sd=categoryService.deletefour(id);
    	find(request);
    	response.setContentType("text/html;charset=UTF-8");//必须要放到PrintWriter的上面否则不管用
    	PrintWriter out=response.getWriter();
    	
    	if(sd>0) {
    		List<student> ad= categoryService.studentList();
    		String jsonn=JSON.toJSONString(ad);
    		
    		out.print(jsonn);
    	}else {
    		out.print("ha");
    	}
    	out.flush();
    	out.close();
    }
    @RequestMapping("gai")
    public String gai(HttpServletRequest request) {
    	String userName=request.getParameter("userName");
    	String userPw=request.getParameter("userPw");
    	String xinPw=request.getParameter("xinPw");
    	Integer ad=categoryService.login(userName,userPw);
    	if(ad>0) {
    		Integer up=categoryService.update(xinPw,userName);
    		return "login";
    	}else {
    		return "admin";
    	}
    }
    @RequestMapping("add")
    public String add(HttpServletRequest request) {
    	String one=request.getParameter("one");
    	String two=request.getParameter("two");
    	String three=request.getParameter("three");
    	Integer up=categoryService.add(one,two,three);
    	if(up>0) {
    		return "zhongzhuan";
    	}else {
    		return "kelu";
    	}
    }
    @RequestMapping("addone")
    public String addone(HttpServletRequest request) {
    	String one=request.getParameter("one");
    	String two=request.getParameter("two");
    	String three=request.getParameter("three");
    	String four=request.getParameter("four");
    	String five=request.getParameter("five");
    	String six=request.getParameter("six");
    	String seven=request.getParameter("seven");
    	Integer up=categoryService.addone(one,two,three,four,five,six,seven);
    	if(up>0) {
    		return "zhongzhuan";
    	}else {
    		return "kelu";
    	}
    }
    @RequestMapping("addtwo")
    public String addtwo(HttpServletRequest request) {
    	String one=request.getParameter("one");
    	String two=request.getParameter("two");
    	String three=request.getParameter("three");

    	Integer up=categoryService.addtwo(one,two,three);
    	if(up>0) {
    		return "zhongzhuan";
    	}else {
    		return "";
    	}
    }
    @RequestMapping("addthree")
    public String addthree(HttpServletRequest request) {
    	String one=request.getParameter("one");
    	String two=request.getParameter("two");
    	String three=request.getParameter("three");
    	String four=request.getParameter("four");
    	String five=request.getParameter("five");
    	String six=request.getParameter("six");
    	String seven=request.getParameter("seven");
    	Integer up=categoryService.addthree(one,two,three,four,five,six,seven);
    	if(up>0) {
    		return "zhongzhuan";
    	}else {
    		return "kelu";
    	}
    }
}