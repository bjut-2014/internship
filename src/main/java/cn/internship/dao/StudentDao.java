package cn.internship.dao;

import cn.internship.entity.Student;

/**
 * 学生持久层接口
 * @author dreamlate
 */
public interface StudentDao {

	//通过学号密码查找学生
	public Student get(String sno,String password);
	
	//通过主键查找学生
	public Student get(Integer id);

	//更新用户信息
	public void updateStudent(Student student);
}
