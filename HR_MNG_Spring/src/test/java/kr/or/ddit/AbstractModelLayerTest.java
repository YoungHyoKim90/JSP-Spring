package kr.or.ddit;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/resources/kr/or/ddit/spring/*-context.xml")
@WebAppConfiguration
public abstract class AbstractModelLayerTest {

}
