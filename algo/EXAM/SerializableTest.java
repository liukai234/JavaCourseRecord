/*
 * @Description: 
 * @LastEditors: liukai
 * @Date: 2020-04-27 17:14:10
 * @LastEditTime: 2020-04-27 20:59:30
 * @FilePath: /EXAM/SerializableTest.java
 */
import java.io.*;

class Person{ //
	int age;
	String sex;
	String name;
	String number;
	public Person(int age,String sex,String name,String number) {
		this.age=age;
		this.sex=sex;
		this.name=name;
		this.number=number;
	}
}


public class SerializableTest {
	public static void main(String []args) {
		Person person=new Person(18,"女","张艳","1807004310");
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Person.object"));
			System.out.println("--Catch1--");
			oos.writeObject(person);
			System.out.println("--Catch1--");
			oos.close();
			person=null;
			System.out.println("--Catch1--");
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Person.object"));
			System.out.println("--Catch2--");
			person=(Person)ois.readObject();
			ois.close();
			System.out.println("age is："+person.age);
			System.out.println("sex is："+person.sex);
			System.out.println("name is："+person.name);
			System.out.println("number is："+person.number);
		}
		catch(IOException event){
			System.out.println(event);
		}
		catch(ClassNotFoundException event) {
			System.out.println("不能读出对象！");
		}
		finally{
			System.out.println("null &e");
		}
	}
}
