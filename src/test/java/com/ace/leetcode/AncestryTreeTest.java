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
	public void shouldCreateAncestryTreeFromString()
	{
		assertEquals(ancestry.getName(), "QEII");
		assertEquals(ancestry.getFather().getName(), "George VI");
		assertEquals(ancestry.getMother().getName(), "Elizabeth Bowes-Lyon");
	}
	
	@Test
	public void shouldReturnAncestorsOfSpecifiedDescendants()
	{
		assertNull(ancestry.getAncestors("Edward VII"));
	}
	
	@Test
	public void shouldReturnDescendantsOfSpecifiedAncestor()
	{
		assertNull(ancestry.getDescendants("Edward VII"));
	}
}
