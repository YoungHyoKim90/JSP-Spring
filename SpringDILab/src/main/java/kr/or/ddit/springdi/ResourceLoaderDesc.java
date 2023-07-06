package kr.or.ddit.springdi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import lombok.extern.slf4j.Slf4j;

/**
 * 스프링에서 자원(Resource)을 로딩하는 방법.
 *  파일시스템 자원 D:\medias\images\cat1.jpg - 파일시스템상의 절대경로(물리주소)
 *  클래스패스 자원 kr/or/ddit/case2/conf/Case2-Context.xml - classpath 이후의 경로(논리주소)
 *  웹 자원 https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png - URL(논리주소)
 */
@Slf4j
public class ResourceLoaderDesc {
	public static void main(String[] args) throws MalformedURLException {
		File fsRes = new File("D:\\medias\\images\\cat1.jpg");
		log.info("file system resource : {}", fsRes);
		URL url = ClassLoader.getSystemClassLoader().getResource("kr/or/ddit/case2/conf/Case2-Context.xml");
		log.info("class path resource : {}", url.getFile());
		URL webRes = new URL("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
		log.info("web resource : {}", webRes);
		
		ResourceLoader loader = new ClassPathXmlApplicationContext();
		Resource res1 = loader.getResource("file:D:\\medias\\images\\cat1.jpg");
		Resource res2 = loader.getResource("classpath:kr/or/ddit/case2/conf/Case2-Context.xml");
		Resource res3 = loader.getResource("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
		
		log.info("file system resource : {}", res1);
		log.info("class path resource : {}", res2);
		log.info("web resource : {}", res3);
		
		copyResource(res1, "D:/medias/dest/cat1.jpg");
		
		copyResource(res2, "D:/medias/dest/"+res2.getFilename());
		
		copyResource(res3, "D:/medias/dest/"+res3.getFilename());
	}
	
	private static void copyResource(Resource target, String destPath) {
		FileSystemResource destRes = new FileSystemResource(destPath);
		try(
			InputStream is = target.getInputStream();
			OutputStream os = destRes.getOutputStream();
		){
			IOUtils.copy(is,os);
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
}



















