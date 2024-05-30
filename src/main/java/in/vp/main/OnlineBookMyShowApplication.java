package in.vp.main;

import org.apache.catalina.mbeans.MBeanUtils;
import org.apache.tomcat.jni.Sockaddr;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBookMyShowApplication {

	public static void main(String[] args) {
	System.out.println("Application Started...");
		SpringApplication.run(OnlineBookMyShowApplication.class, args);
		System.out.println("Application Closed...");
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
}
}
