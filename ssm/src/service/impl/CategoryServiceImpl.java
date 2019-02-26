package service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import mapper.CategoryMapper;
import pojo.Category;
import pojo.bcboth;
import pojo.kebiao;
import pojo.kecheng;
import pojo.student;
import pojo.teacher;
import service.CategoryService;
 
@Service
public class CategoryServiceImpl  implements CategoryService{
	@Autowired //当时没有加这个注解，自动装配Bean，会报空指针异常
    CategoryMapper categoryMapper;
     
    public List<Category> list(){
        return categoryMapper.list();
    }

	public Integer login(String userName,String userPw) {
		
		return categoryMapper.login(userName,userPw); 
	}
	
	public Integer loginLao(String userName, String userPw) {
		
		return categoryMapper.loginLao(userName,userPw);
	}
	
	public Integer loginStu(String userName, String userPw) {
		
		return categoryMapper.loginStu(userName,userPw);
	}
	public List<teacher> teacherList(String name){
		return categoryMapper.teacherList(name);
	}

	public List<teacher> teacherList() {
		
		return categoryMapper.teacherList();
	}
	public List<kebiao> kebiaoList(){
		return categoryMapper.kebiaoList();
	}
    public List<kecheng> kechengList(){
    	return categoryMapper.kechengList();
    }
    public List<student> studentList(String name){
    	return categoryMapper.studentList(name);
    }
    public List<student> studentList(){
    	return categoryMapper.studentList();
    }
    public List<bcboth> bcbothList(){
    	return categoryMapper.bcbothList();
    }
	@Override
	public Integer delete(int id) {
		return categoryMapper.delete(id);
	}
	public Integer deleteone(int id) {
		return categoryMapper.deleteone(id);
	}
	@Override
	public Integer deletetwo(int id) {
		return categoryMapper.deletetwo(id);
	}
	@Override
	public Integer deletethree(int id) {
		return categoryMapper.deletethree(id);
	}
	@Override
	public Integer deletefour(int id) {
		return categoryMapper.deletefour(id);
	}


	@Override
	public Integer update(String userPw, String userName) {
		return categoryMapper.update(userPw,userName);
	}

	public Integer add(String bianhao,String mingcheng,String kecheng) {
		return categoryMapper.add(bianhao,mingcheng,kecheng);
	}

	@Override
	public Integer addone(String bianhao, String xingming, String xingbie, String nianling, String zhicheng,
			String loginname, String loginpw) {
		return categoryMapper.addone(bianhao,xingming,xingbie,nianling,zhicheng,loginname,loginpw);
	}

	@Override
	public Integer addtwo(String shijian, String jieci, String jiaoshi) {
		return categoryMapper.addtwo(shijian,jieci,jiaoshi);
	}

	@Override
	public Integer addthree(String bianhao, String xingming, String xingbie, String nianling, String kecheng,
			String loginname, String loginpw) {
		return categoryMapper.addthree(bianhao,xingming,xingbie,nianling,kecheng,loginname,loginpw);
	}

}