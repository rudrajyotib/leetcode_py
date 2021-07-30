package com.ace.leetcode;

import com.ace.leetcode.utils.AncestryTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AncestryTreeTest
{
	private AncestryTree ancestry;
	
	@Before
	public void setup()
	{
		ancestry = AncestryTree.build("QEII(George VI(George V(Edward VII(Prince Albert)(Queen Victoria))(Alexandra of Denmark(Christian IX of Denmark)"
											  + "(Louise of Hesse-Kassel)))(Mary of Teck(Francis, Duke of Teck(Duke Alexander of Württemberg)"
											  + "(Countess Claudine Rhédey von Kis-Rhéde))(Princess Mary Adelaide of Cambridge(Prince Adolphus, Duke of Cambridge)"
											  + "(Princess Augusta of Hesse-Kassel))))(Elizabeth Bowes-Lyon(Claude Bowes-Lyon, 14th Earl of Strathmore and Kinghorne"
											  + "(Claude Bowes-Lyon, 13th Earl of Strathmore and Kinghorne(Thomas Lyon-Bowes, Lord Glamis)"
											  + "(Charlotte Lyon-Bowes, Lady Glamis))(Frances Dora Smith(Oswald Smith)(Henrietta Mildred Hodgson)))"
											  + "(Cecilia Cavendish-Bentinck(Charles Cavendish-Bentinck(Lord Charles Cavendish-Bentinck)"
											  + "(Anne Wellesley))(Caroline Louisa Burnaby(Edwyn Burnaby, of Baggrave Hall)(Anne Caroline Salisbury))))");
	}
	
	@Test
	public void shouldReturnInorderList()
	{
		assertEquals(ancestry.toInorder(), new String[]{"Prince Albert", "Edward VII", "Queen Victoria", "George V", "Christian IX of Denmark", "Alexandra of Denmark", "Louise of Hesse-Kassel", "George VI", "Duke Alexander of Württemberg", "Francis, Duke of Teck", "Countess Claudine Rhédey von Kis-Rhéde", "Mary of Teck", "Prince Adolphus, Duke of Cambridge", "Princess Mary Adelaide of Cambridge", "Princess Augusta of Hesse-Kassel", "QEII", "Thomas Lyon-Bowes, Lord Glamis", "Claude Bowes-Lyon, 13th Earl of Strathmore and Kinghorne", "Charlotte Lyon-Bowes, Lady Glamis", "Claude Bowes-Lyon, 14th Earl of Strathmore and Kinghorne", "Oswald Smith", "Frances Dora Smith", "Henrietta Mildred Hodgson", "Elizabeth Bowes-Lyon", "Lord Charles Cavendish-Bentinck", "Charles Cavendish-Bentinck", "Anne Wellesley", "Cecilia Cavendish-Bentinck", "Edwyn Burnaby, of Baggrave Hall", "Caroline Louisa Burnaby", "Anne Caroline Salisbury"});
	}
	
	@Test
	public void shouldReturnPreorderList()
	{
		assertEquals(ancestry.toPreorder(), new String[]{"QEII", "George VI", "George V", "Edward VII", "Prince Albert", "Queen Victoria", "Alexandra of Denmark", "Christian IX of Denmark", "Louise of Hesse-Kassel", "Mary of Teck", "Francis, Duke of Teck", "Duke Alexander of Württemberg", "Countess Claudine Rhédey von Kis-Rhéde", "Princess Mary Adelaide of Cambridge", "Prince Adolphus, Duke of Cambridge", "Princess Augusta of Hesse-Kassel", "Elizabeth Bowes-Lyon", "Claude Bowes-Lyon, 14th Earl of Strathmore and Kinghorne", "Claude Bowes-Lyon, 13th Earl of Strathmore and Kinghorne", "Thomas Lyon-Bowes, Lord Glamis", "Charlotte Lyon-Bowes, Lady Glamis", "Frances Dora Smith", "Oswald Smith", "Henrietta Mildred Hodgson", "Cecilia Cavendish-Bentinck", "Charles Cavendish-Bentinck", "Lord Charles Cavendish-Bentinck", "Anne Wellesley", "Caroline Louisa Burnaby", "Edwyn Burnaby, of Baggrave Hall", "Anne Caroline Salisbury"});
	}
	
	@Test
	public void shouldReturnPostorderList()
	{
		assertEquals(ancestry.toPostorder(), new String[]{"Prince Albert", "Queen Victoria", "Edward VII", "Christian IX of Denmark", "Louise of Hesse-Kassel", "Alexandra of Denmark", "George V", "Duke Alexander of Württemberg", "Countess Claudine Rhédey von Kis-Rhéde", "Francis, Duke of Teck", "Prince Adolphus, Duke of Cambridge", "Princess Augusta of Hesse-Kassel", "Princess Mary Adelaide of Cambridge", "Mary of Teck", "George VI", "Thomas Lyon-Bowes, Lord Glamis", "Charlotte Lyon-Bowes, Lady Glamis", "Claude Bowes-Lyon, 13th Earl of Strathmore and Kinghorne", "Oswald Smith", "Henrietta Mildred Hodgson", "Frances Dora Smith", "Claude Bowes-Lyon, 14th Earl of Strathmore and Kinghorne", "Lord Charles Cavendish-Bentinck", "Anne Wellesley", "Charles Cavendish-Bentinck", "Edwyn Burnaby, of Baggrave Hall", "Anne Caroline Salisbury", "Caroline Louisa Burnaby", "Cecilia Cavendish-Bentinck", "Elizabeth Bowes-Lyon", "QEII"});
	}
	
	@Test
	public void shouldCreateAncestryTreeFromString()
	{
		assertEquals(ancestry.getName(), "QEII");
		assertEquals(ancestry.getFather().getName(), "George VI");
		assertEquals(ancestry.getMother().getName(), "Elizabeth Bowes-Lyon");
	}
	
	@Test
	public void shouldReturnAncestorsOfSpecifiedDescendants()
	{
		AncestryTree ancestors1 = ancestry.getAncestors("Edward VII");
		
		assertEquals(ancestors1.getName(), "Edward VII");
		assertEquals(ancestors1.getFather().getName(), "Prince Albert");
		assertEquals(ancestors1.getMother().getName(), "Queen Victoria");
		
		assertNull(ancestors1.getFather().getFather());
		assertNull(ancestors1.getFather().getMother());
		assertNull(ancestors1.getMother().getFather());
		assertNull(ancestors1.getMother().getMother());
		
		AncestryTree ancestors2 = ancestry.getAncestors("Mary of Teck");
		
		assertEquals(ancestors2.getName(), "Mary of Teck");
		assertEquals(ancestors2.getFather().getName(), "Francis, Duke of Teck");
		assertEquals(ancestors2.getMother().getName(), "Princess Mary Adelaide of Cambridge");
		
		assertEquals(ancestors2.getFather().getFather().getName(), "Duke Alexander of Württemberg");
		assertEquals(ancestors2.getFather().getMother().getName(), "Countess Claudine Rhédey von Kis-Rhéde");
		assertEquals(ancestors2.getMother().getFather().getName(), "Prince Adolphus, Duke of Cambridge");
		assertEquals(ancestors2.getMother().getMother().getName(), "Princess Augusta of Hesse-Kassel");
		
		assertNull(ancestors2.getFather().getFather().getFather());
		assertNull(ancestors2.getFather().getMother().getMother());
		assertNull(ancestors2.getMother().getFather().getFather());
		assertNull(ancestors2.getMother().getMother().getMother());
	}
	
	@Test
	public void shouldReturnDescendantsOfSpecifiedAncestor()
	{
		assertNull(ancestry.getDescendants("Edward VII"));
	}
}
