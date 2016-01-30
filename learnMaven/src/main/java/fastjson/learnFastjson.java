package fastjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import fastjson.po.Grade;
import fastjson.po.Student;


/**
 * @author Qinghe
 *
 */
public class learnFastjson {
	
	
	/**
	 * 把一个简单类转换为json字符串
	 */
	@Test
	public void getStudentJosn(){
		Student student = new Student();
		student.setId(1L);
		student.setAge(18);
		student.setName("张三");
		
		String jsonStr = JSON.toJSONString(student);
		System.out.println(jsonStr);
	}
	
	/**
	 * 把一个复杂类（grade中有list<student>）转换成json字符串
	 */
	@Test
	public void getGradeJson(){
		Grade grade = new Grade();
		grade.setId(2L);
		grade.setGradeName("计算机");
		
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student(3L,"李四",3));
		stuList.add(new Student(4L,"李五",4));
		
		grade.setStudents(stuList);
		
		String jsonStr = JSON.toJSONString(grade);
		
		System.out.println(jsonStr);
	}
	
	
	/**
	 * 把一个list<map>类型的数据转换成json字符串
	 */
	@Test
	public void getListMapJson(){
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("name", "张三");
		map1.put("id", 1L);
		map1.put("age", 18);
		
		mapList.add(map1);
		
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("name", "张2三");
		map2.put("id", 12L);
		map2.put("age", 128);
		
		mapList.add(map2);
		
		String jsonStr = JSONArray.toJSONString(mapList);
		System.out.println(jsonStr);
		
		System.out.println(JSON.toJSONString(map1));
		System.out.println(JSON.toJSONString(map2));
	}
	
	
	/**
	 * 把一个复杂类（grade中有list<student>）的字符串转换成复杂类
	 */
	@Test
	public void getGradeByJsonString(){
		Grade grade = new Grade();
		grade.setId(2L);
		grade.setGradeName("计算机");
		
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student(3L,"李四",3));
		stuList.add(new Student(4L,"李五",4));
		
		grade.setStudents(stuList);
		
		String gradeJson = JSON.toJSONString(grade);
		
		Grade gradeJsonResult = JSON.parseObject(gradeJson, Grade.class);
		
		System.out.println(gradeJsonResult);
	}
	
	/**
	 * 把一个list<map>结构转换的json字符串还原
	 */
	@Test
	public void getListMapByJsonString(){
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("name", "张三");
		map1.put("id", 1L);
		map1.put("age", 18);
		
		mapList.add(map1);
		
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("name", "张2三");
		map2.put("id", 12L);
		map2.put("age", 128);
		
		mapList.add(map2);
		
		String mapListJsonResult = JSONArray.toJSONString(mapList);
		
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> mapList2 = (List<Map<String, Object>>) JSONArray.parse(mapListJsonResult);
		System.out.println(mapList2.toString());
	}
	
	@Test
	public void analyzeJsonArray(){
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("name", "张三");
		map1.put("id", 1L);
		map1.put("age", 18);
		
		mapList.add(map1);
		
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("name", "张2三");
		map2.put("id", 12L);
		map2.put("age", 128);
		
		mapList.add(map2);
		
		String mapListJsonResult = JSONArray.toJSONString(mapList);
		JSONArray jsonArr = JSONArray.parseArray(mapListJsonResult);
		
		//通过下标遍历jsonArray
		int size = jsonArr.size();
		System.out.println(size);
		System.out.println(jsonArr.getJSONObject(0));
		
		//通过迭代器循环遍历jsonArray
		Iterator<Object> it = jsonArr.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			System.out.println(obj.toString());
		}
		
//		for(Object json : jsonArr.toArray()){
//			System.out.println(json.toString());
//		}
		
		System.out.println(jsonArr.toString());
	}
}
