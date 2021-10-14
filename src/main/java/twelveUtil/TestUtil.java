package twelveUtil;

import twelveBase.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 20;
	
	public void switchToFrame(String fm) {
		driver.switchTo().frame(fm);
	}
}