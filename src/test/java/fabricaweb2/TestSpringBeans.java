package fabricaweb2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fabricadeprogramador.entidade.Usuario;

public class TestSpringBeans {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		
		Usuario usu = (Usuario)ctx.getBean("usuario");
		System.out.println(usu);
		
		ctx.close();
	}

}
