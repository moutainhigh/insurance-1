/**
 * 
 */
package com.yundian.basic.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ningxia.jin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath*:application-context-test.xml" })  
public abstract class AbstractJUnit {  
} 
