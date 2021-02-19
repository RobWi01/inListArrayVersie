package intlist;

import java.util.Arrays;
import java.util.stream.IntStream;

// Abstractie invarianten
/**
* Generate a intList object
* 
* @invar The length of an intList always has to be greater or equal than 0
* 		| getLength() >= 0
* 
*/

public class IntList {

// Resprentatie invarianten
	/**
	 * @invar The length of the array always has to be greater or equal than 0
	 * 		| array.length >= 0
	 */

	private int[] array;

	/**
	 * Generates an empty intList object
	 * 
	 * @Post The object is an empty intList of length 0;
	 * 		| result.getLength() == 0
	 */
	public IntList() {
		array = new int[0];		
	}

	/**
	 * @return the length of the intList object
	 * 
	 * @basic
	 */
	public int getLength() {
		return array.length;
	} 

	/**
	 * @return intList and all his elements in a (copied) array
	 * 
	 * @basic
	 */
	public int[] getElementsInArray() {
		return array.clone();
	}

	/**
	 * Gives back the element of the intList object at a certain index
	 * 
	 * Contractueel:
	 * @pre the index has to be within the boundaries of the list
	 * 		| (-1 < index && index < getLength())
	 * 
	 * Defensief:
	 * @throws IllegalArgumentException
	 * 		The index is out of bounds 
	 * 
	 * @basic
	 */
	public int getElementAtIndex(int index) {
//		Defensief:
		if (0 > index || index >= getLength()) {
			throw new IllegalArgumentException("The index is not within the boundaries");
		}

		return array[index];
	} 

	/**
	 * This method adds an element at the end of intList
	 *  
	 *@post The length has to be incremented by 1
	 * 		| getLength() == old(getLength()) + 1
	 * 
	 *@post The last element has to be equal to the inserted elem
	 *		| getElementAtIndex(getLength()-1) == element
	 *
	 *@post All the other elements in the intList remain unchanged
	 *		| IntStream.range(0, old(getLength())).allMatch(index -> getElementsInArray()[index] == old(getElementsInArray())[index])
	 *		
	 */
	public void addElement(int element) {
		int[] newArray = new int[getLength() + 1];
		
		IntStream.range(0, getLength()).forEachOrdered(index -> newArray[index] = getElementAtIndex(index));
		newArray[getLength()] = element;
		
		setIntList(newArray);
	} 
	
	/**
	 * Contractueel:
	 * @pre The length of the intList has to be greater than zero
	 * 		| getLength() > 0
	 * 
	 * @post The length has to decrease with 1
	 * 		| getLength() == old(getLength()) - 1
	 * 
	 * @post The last element has to be deleted
	 * 
	 * @post all the other elements have to remain unchanged 
	 * 	| IntStream.range(0, old(getLength())).allMatch(index -> getElementsInArray()[index] == old(getElementsInArray())[index])
	 */
	public void deleteElement() {
		int[] newArray = new int[array.length - 1];

		IntStream.range(0, getLength()-1).forEachOrdered(index -> newArray[index] = getElementAtIndex(index));
		
		setIntList(newArray);

	}
	/**
	 * @post | Arrays.equals(array, newArray)
	 */
	private void setIntList(int[] newArray) {
		array = newArray;
	}



}
