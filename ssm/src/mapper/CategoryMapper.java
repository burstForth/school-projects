package mapper;
  
import java.util.List;
 
import pojo.Category;
import pojo.bcboth;
import pojo.kebiao;
import pojo.kecheng;
import pojo.student;
import pojo.teacher;
  
public interface CategoryMapper {
  
    public int add(Category category); 
        
     
        
    public Category get(int id); 
      
    public int update(Category category);  
        
    public List<Category> list();
     
    public int count(); 
    public Integer delete(int id);
    public Integer deleteone(int id);
    public Integer deletetwo(int id);
    public Integer deletethree(int id);
    public Integer deletefour(int id);
    public Integer login(String userName,String userPw);
    public Integer loginLao(String userName,String userPw);
    public Integer loginStu(String userName,String userPw);
    public List<teacher> teacherList(String name);
    public List<teacher> teacherList();
    public List<kebiao> kebiaoList();
    public List<kecheng> kechengList();
    public List<student> studentList(String name);
    public List<student> studentList();
    public List<bcboth> bcbothList();
    public Integer update(String userPw,String userName);
    public Integer add(String bianhao,String mingcheng,String kecheng);
    public Integer addone(String bianhao,String xingming,String xingbie,String nianling,String zhicheng,String loginname,String loginpw);
    public Integer addtwo(String shijian,String jieci,String jiaoshi);
    public Integer addthree(String bianhao,String xingming,String xingbie,String nianling,String kecheng,String loginname,String loginpw);
}