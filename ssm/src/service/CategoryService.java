package service;
 
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Category;
import pojo.bcboth;
import pojo.kebiao;
import pojo.kecheng;
import pojo.student;
import pojo.teacher;
 
public interface CategoryService {
 
    List<Category> list();
    Integer login(@Param(value="userName")String userName,@Param(value="userPw")String userPw);
    Integer loginLao(String userName,String userPw);
    Integer loginStu(String userName,String userPw);
    List<teacher> teacherList(@Param(value="loginname")String name);
    List<teacher> teacherList();
    List<kebiao> kebiaoList();
    List<kecheng> kechengList();
    List<student> studentList(@Param(value="loginname")String name);
    List<student> studentList();
    List<bcboth> bcbothList();
    Integer delete(int id);
    Integer deleteone(int id);
    Integer deletetwo(int id);
    Integer deletethree(int id);
    Integer deletefour(int id);
    Integer update(String userPw,String userName);
    Integer add(String bianhao,String mingcheng,String kecheng);
    Integer addone(String bianhao,String xingming,String xingbie,String nianling,String zhicheng,String loginname,String loginpw);
    Integer addtwo(String shijian,String jieci,String jiaoshi);
    Integer addthree(String bianhao,String xingming,String xingbie,String nianling,String kecheng,String loginname,String loginpw);
}