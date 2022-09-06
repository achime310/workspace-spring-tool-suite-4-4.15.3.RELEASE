import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextMain {

	public static void main(String[] args) {
		
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("~.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		

	}

}