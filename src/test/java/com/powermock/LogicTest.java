package com.powermock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class LogicTest {

	// target
	private LogicEx target = new LogicEx();

	// service
	private ServiceI mockService;
	
	@BeforeClass    
    public static void beforeClass() {        
    };

    @AfterClass
    public static void afterClass() { 
    }; 
	
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogicEx() {
		// common use
		try{
			mockService = PowerMockito.mock(ServiceI.class);
			target.setService(mockService);
			when(mockService.selDate()).thenReturn("Mock Date");
			assertEquals("Mock Date",target.getDate());
			verify(mockService).selDate();
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	@PrepareForTest({LogicEx.class})
	public void testLogicEx_NEW() {
		// mock inner new object
		try {
			ServiceEx service_001 = PowerMockito.mock(ServiceEx.class);
			PowerMockito.whenNew(ServiceEx.class).withNoArguments().thenReturn(service_001);
			
			PowerMockito.when(service_001.createNewId()).thenReturn(5);
			assertEquals(5, target.getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	@PrepareForTest({ServiceI.class})
	public void testLogicEx_FINAL() {
		// mock final method
		try {
			mockService = PowerMockito.mock(ServiceI.class);
			target.setService(mockService);
			
			PowerMockito.when(mockService.getStatus()).thenReturn(true);
			assertEquals(true, target.isOK());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	@PrepareForTest({ServiceEx.class})
	public void testLogicEx_STATIC() {
		// mock static method
		try {
			PowerMockito.mockStatic(ServiceEx.class);
			
			PowerMockito.when(ServiceEx.getCount()).thenReturn(1);
			assertEquals(1, target.getCount());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	@PrepareForTest({LogicEx.class})
	public void testLogicEx_PRIVATE() {
		// mock private method
		try {
			LogicEx target_001 = PowerMockito.mock(LogicEx.class);
			
			PowerMockito.when(target_001.getMsg()).thenCallRealMethod();
			PowerMockito.when(target_001, "print").thenReturn("Mock Date");
			assertEquals("Mock Date", target_001.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
