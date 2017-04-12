package com.cbstd.locator.api.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cbstd.locator.api.TestDO;

public class TestControllerTest {

	private TestController testController;
	
	@Before
	public void setUp() throws Exception {
		testController =  new TestController();
	}

	@Test
	public void testTest() {
		TestDO testDO = testController.test(null);
		assertEquals("Hello", testDO.getMessage());
		assertEquals("World!", testDO.getName());
		
		testDO = testController.test("Coşkun!");
		assertEquals("Coşkun!", testDO.getName());
		
	}

}
