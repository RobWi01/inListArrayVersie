package intlisttest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import intlist.IntList;

class IntListTest {

	@Test
	void test() {
		IntList list1 = new IntList();
//		System.out.println(list1);

		list1.addElement(1);
		assertEquals(1,list1.getElementAtIndex(0));

		list1.addElement(2);
		assertEquals(2,list1.getElementAtIndex(1));

		list1.deleteElement();
		//list1.getElementAtIndex(1);
		//Zou out of range Exception moeten geven


		Assert.assertThrows(AssertionError.class, () -> list1.getElementAtIndex(10));

//		Assert.assertThrows(IllegalArgumentException.class, () -> list1.getElementAtIndex(10));
	}

}

