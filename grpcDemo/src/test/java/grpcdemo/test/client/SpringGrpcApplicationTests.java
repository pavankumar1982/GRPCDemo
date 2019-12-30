package grpcdemo.test.client;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringGrpcApplicationTests {
	
	@Autowired
	private HelloWorldClient helloClient;
	
	@Test
	public void testSayHello() {
		Assertions.assertThat(helloClient.sayHello("pavan", "kowlgi")).isEqualTo("Hello pavan kowlgi!");		
	}

}
