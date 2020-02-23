/* Name: Errol Pascua
 * Class ID: 148
 * School ID: 1213015724
 * Class: CSE 360
 * Date: 2/10/2020
 * Purpose: The purpose of this program was to exercise our knowledge on creating classes,
 * as well as learning how to use JUNIT test cases.
 * 
 */
package cse360assign2;

public class SimpleList
{
	
	//global variables
	
	int list[] = new int[10]; //creates a new array called list that holds 10 integers
	int count = 0; // creates an integer variable called count and initializes it to be 0.
	
	
public void add(int value) //value is the number to be added into the array
	{
		//create temporary array to hold new values
		int tempList[] = new int[10];
		
		if(count != 10) 
		{
		//first shift the array
		for (int i = 0; i <= count; i++) // for loop to slide everything in the array
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
			//if the list is full, sets the first value in the array to the value being passed
			tempList[0] = value;
			//starting from the 2nd value, put the previous value in the list into the tempList
			for (int i = 1; i < count; i++)
			{
				tempList[i] = list[i-1];
			}
		}
		
		
		// copies values of temporary list into list
		list = tempList;
		
		
	}

//need to fix
public void remove(int rmvalue)
	{
		//initialize flag to check to see when the value to be deleted is found
		boolean flag = false;
		
		//creates a new temporary list
		int tempList[] = new int[10];
		//iterates through the array
		for(int i = 0; i < count - 1 ; i++)
		{
			/* if the value to be removed = the value at i in the list,
			 * put the value at list[i+1] into the current value of tempList
			 *  and trigger the flag */
			
			if(list[i] == rmvalue)
			{
				tempList[i] = list[i+1];
				flag = true;
			}
			/* if the flag has been triggered, the value to be deleted has been found,
			 * and put the value at list[i+1] into the current location of tempList */
			else if(flag == true)
			{
				tempList[i] = list[i + 1];
			}
			/* if the flag has not been triggered, then the values in the tempList 
			 * are going to be the same value of the original list */
			else if (flag == false)
				tempList[i]= list[i];		
		}
		
		//fills in the list with the values of tempList
		list = tempList;
		
		//decrements count
		count--;
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

}


