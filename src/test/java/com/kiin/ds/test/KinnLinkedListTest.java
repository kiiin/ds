package com.kiin.ds.test;

import static org.junit.Assert.*;

import java.util.StringTokenizer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kiin.ds.KiinLinkedList;
import com.kiin.ds.exceptions.KiinLLException;

public class KinnLinkedListTest {
	
	KiinLinkedList kiinLinkedList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		kiinLinkedList = new KiinLinkedList();
	}

	@After
	public void tearDown() throws Exception {
	}


	
	@Test
	public void createLinkedListTest()
	{
		assertTrue(kiinLinkedList.getLenCount() == 0);
	}
	
	@Test
	public void inserFirsttItemToLLTest() throws KiinLLException 
	{
		assertTrue(kiinLinkedList.addItem(new Integer("1")) ==1);
	}
	
	@Test
	public void inserFewItemToLLTest() throws KiinLLException 
	{
		assertTrue(kiinLinkedList.addItem(new Integer("1")) ==1);		
		assertTrue(kiinLinkedList.addItem("1") ==1);
		assertTrue(kiinLinkedList.addItem("Test Value") ==1);
		assertTrue(kiinLinkedList.addItem(new Double("3.75")) ==1);		
		
	}
	
	@Test
	public void getListItems()	throws KiinLLException 
	{		
		kiinLinkedList.addItem(new Integer("1"));
		kiinLinkedList.addItem("1");
		kiinLinkedList.addItem("Test Value");
		kiinLinkedList.addItem(new Double("3.75"));
		
		int localLenVar = kiinLinkedList.getLenCount();
		String strOpVal = kiinLinkedList.toString();
		//Cheap trick to count number of tokens in an output
		int tokenLen = new StringTokenizer(strOpVal, "[" ).countTokens();
		
		assertTrue(localLenVar == tokenLen);
	}
	
	@Test
	public void remveItemsFromMiddle() throws KiinLLException 
	{
		kiinLinkedList.addItem(new Integer("1"));
		kiinLinkedList.addItem("1");
		kiinLinkedList.addItem("Test Value");
		
		//Remove an item from the middle 
		assertTrue(kiinLinkedList.removeItem(1) == 1);
		assertTrue(kiinLinkedList.getLenCount() == 2);
		
		//Remove one more 
		assertTrue(kiinLinkedList.removeItem(0) == 1);
		assertTrue(kiinLinkedList.getLenCount() == 1);
		
		//Remove the last item
		//System.out.println(kiinLinkedList.removeItem(1));
		//assertTrue(kiinLinkedList.removeItem(-1) == 1);
		//assertTrue(kiinLinkedList.getLenCount() == 0);
	}
	
	@Test
	public void inserItemMiddleTest() throws KiinLLException
	{
		kiinLinkedList.addItem(new Integer("1"));
		kiinLinkedList.addItem("1");
		kiinLinkedList.addItem("Test Value");

		assertTrue(kiinLinkedList.addItem("Hello", 1) == 1);
		
		assertTrue(kiinLinkedList.getLenCount() == 4);
		
		assertTrue(kiinLinkedList.getItem(1).toString().equals("Hello"));
		
	}

}
