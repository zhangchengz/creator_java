package com.tlf.creatoraccount;

import com.tlf.creatoraccount.dao.AccountMapper;
import com.tlf.creatoraccount.dao.CourseTeacherClassMapper;
import com.tlf.creatoraccount.po.ClassStudentPO;
import com.tlf.creatoraccount.pojo.Accounts;
import com.tlf.creatoraccount.pojo.CourseTeacherClass;
import com.tlf.creatoraccount.pojo.Courses;
import com.tlf.creatoraccount.service.IAccountService;
import com.tlf.creatoraccount.service.ICoursesService;
import com.tlf.creatoraccount.utils.JWTUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatoraccountApplicationTests {

	@Autowired
	private ICoursesService coursesService;

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private CourseTeacherClassMapper ctcMapper;

	@Test
	public void contextLoads() {
		String phone = "000000";
		String password = "123456";
		String pwd = new SimpleHash("MD5", password, "8e575d").toHex();
		System.out.println(pwd);
	}

	@Test
	public void testCase1(){
		List<Accounts> list = accountMapper.selectAccounts("student", 0, 100);
		Integer teacher = accountMapper.selectCounts("student");
		System.out.println(teacher);
	}

	@Test
	public void testCase2(){
		String token = JWTUtil.sign("123456", "192.168.2.223","teacher");
		System.out.println(token);
		String accountId = JWTUtil.getAccountId(token);
		System.out.println(accountId);
		boolean verify = JWTUtil.verify(token);
		System.out.println(verify);
	}

	@Test
	public void testCase3(){
		List<Accounts> list = accountMapper.selectStudentNoClass();
		for(Accounts account : list){
			System.out.println(account);
		}
	}

	@Test
	public void testCase4(){
		List<CourseTeacherClass> courseTeacherClasses = ctcMapper.selectByCourseIdExcludeSelf("7c6684b1-b41c-467a-8706-8b5ebb31d3a0", "af74835f-af65-45ac-b760-57fc76631b0b");
		System.out.println(courseTeacherClasses);
	}

}
