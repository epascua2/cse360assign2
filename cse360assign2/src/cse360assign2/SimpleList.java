/* Name: Errol Pascua
 * Class ID: 148
 * School ID: 1213015724
 * Class: CSE 360
 * Date: 2/10/2020
 * Purpose: The purpose of this program was to exercise our knowledge on creating classes, as well
 * as uploading to github.
 * 
 */
package cse360assign2;

import java.util.Arrays;

public class SimpleList
{
	
	//global variables
	
	int list[] = new int[10]; //creates a new array called list that holds 10 integers
	int count = 0; // creates an integer variable called count and initializes it to be 0.
	
	
public void add(int value) //value is the number to be added into the array
	{
		//create temporary array to hold new values
	int tempList[] = new int[10];
		
		if(count < list.length) 
		{
			//checks to see if the array got resized
			if(list.length > 10)
			//resize array
			tempList = new int[list.length];
		//first shift the array
		for (int i = 0; i <= count ; i++) // for loop to slide everything in the array
		{
			
			// if first value in the array plug in value
			if(i == 0)
				tempList[i] = value;
			//every further value in the array will contain the previous value in list array
			else
				tempList[i] = list[i-1];
		}
		//increments count
				count++;
		}
		else 
		{
			//resize array to be 50% larger
			tempList = new int[list.length + list.length / 2];
			
			//starting from the 2nd value, put the previous value in the list into the tempList
			for (int i = 0; i <= count; i++)
			{
				if (i == 0)
				//if the list is full, sets the first value in the array to the value being passed
				tempList[0] = value;
				else
				tempList[i] = list[i-1];
	
			}
			//increments count
			count++;
			
		}
		
		
		// copies values of temporary list into list
		list = tempList;

	}

//need to fix
public void remove(int rmvalue)
	{
	int deletionIndex = search(rmvalue); // if -1, do nothing
	
	if(deletionIndex != -1) //checks to see if the value to delete is in the array 
	{
		//slides the values to the left
		for (int i = deletionIndex; i < count-1; i++)
		{ 
			list[i] = list[i + 1]; 
		}
		
		list[count-1] = 0; //removes the last value
		count--;
	}
	
	// checks to see if their are more than 25% empty spaces 
	if(list.length - count > list.length/4)
	{
		int[] tempList = new int[list.length - list.length/4]; //decrease by 25%
		for(int i = 0; i < count; i++)
		{
			tempList[i] = list[i];
		}
		list = tempList;	//set list to be equal to tempList
	}

}
	
		
	

	int count()
	{	//return the integer value of count
		return count;
	}
	
	public String toString()
	{
		//create an empty string
		String intToString = "";
		//iterate through the array
		for(int i = 0; i < count; i++)
		{ 
			// if at the end of the array, add the value of list[i] into the string
			if (i == count - 1)
				intToString += list[i];
			//if not at the end, add a space in between the numbers being added to the string
			else 
				intToString += list[i] + " ";
		}
		//return the string
		return intToString; 
		
	}
	
	public int search(int searchVal)
	{
		
		//flag to detect if the searched value has been found in the for loop
		boolean flag = false; 
		// integer that will be returned at the end of the function
		int returnVal = 0;
		
		/*iterate through the array, if the list contains the searched value, 
		it will set the flag to be true, and then set the value to be returned to the value in the array*/
		
		for(int i= 0; i < count; i++)
		{
			if (list[i] == searchVal)
			{
				flag = true;
				returnVal =  i;
			}
		}
		/* if it runs through the for loop and doesn't find the value in the array,
		 * the flag will remain false, and will set the value to be returned to -1 */
		if (flag == false)
		{
			returnVal = -1;
		}
		//returns the return value
		return returnVal;	
	}
	public void append(int numAppend)
	{
		int temporaryList[] = new int[list.length];
		temporaryList = Arrays.copyOf(list, list.length + 1);
		temporaryList[temporaryList.length - 1] = numAppend;
		list = temporaryList;
	}
	public int first()	//returns the first value in the array
	{
		boolean empty = true;
		for (Object values : list)	 //iterates through list to check to see if its empty
		{
			if(values != null)
			{
				empty = false;
			}
		}
		if (empty == false)
			return -1;
		else
			return list[0];
		
	}
	public int last() // returns the last value in the array
	{
		boolean empty = true;
		for (int values : list)	//checks to see if list is empty or full of zeroes
		{
			if(values == 0)
			{
				empty = false;
			}
		}
		if (empty == false)
			return -1;
		else
			return list[list.length - 1];
		
	}
	
	public int size()	//returns the size of the array
	{
		return list.length;
	}

}


