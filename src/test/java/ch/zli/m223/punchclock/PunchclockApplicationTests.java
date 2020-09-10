package ch.zli.m223.punchclock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/initData.sql")
public class PunchclockApplicationTests {

	@Test
	public void contextLoads() {
	}

}
