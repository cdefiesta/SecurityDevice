# Memo 

I have chosen to code my FA using Java. 
  
## How the program works
### Part 1
  The code starts off by taking a valid user's input. The input is checked through a class readInput() and throws an exception whenever the user inputs an integer greater than 9 or less than 0. It will also throw an exception if the user does not input an integer at all. 
  
  Once the program gets a valid input, the input will be compared to the fixed code 84724. To achieve this I split up the fixed code into an array with a pointer starting at index 0. The pointer will traverse through the array one at a time as long as the user input is equal to the value in the array where the pointer is pointing. 
  
  If the user input does not match at any point through the array, the pointer will automatically go back to index 0, but if the pointer reaches the end of the array before the code is broken, there will be three different possible outcomes. If the user’s next input is a ‘1’ or a ‘4’, an FSM class, responsible for the state of the lock, will be called and determine if the lock will be locked or unlocked. If the user’s next input is 8, it will go back to the original fixed code and will look to traverse through the array again starting at index 1 (it will start at index 1 because index 0 of the array equals 8). And if the user’s next input is any other number it will go back to the array at index 0. 
  #### State Transition Diagram
  ![sttDiagram.pdf](https://github.com/cdefiesta/SecurityDevice/files/10062437/sttDiagram.pdf)

### Part 2
   This part will simulate an intruder who does not know the lock's access code and how easy or hard it would be for the intruder to break into the lock. In this scenario the intruder is simply inputting random numbers into the lock. The second part of the program will use the same logic as in part one but instead of a user input, a random number will be generated at the start of the program and anytime after when the number is compared to the fixed code or entered in the FSM class. The code will also start a counter at 0 and add 1 to the count everytime a number is randomly generated. The count will inform us on how many numbers it takes for the intruder to break in. 

Also, in this part, I am assuming that everytime he inputs a number it takes one second. So in the scenario where the intruder doesn't have to check whether or not the number he inputted unlocks the lock, the count simply equals the time taken for the intruder to unlock the lock. In the scenario where he does have to check everytime, the time taken will just be the count doubled. Then to obtain some data for this code I run it 'n' amount of times to get more confident statistics.
    
    Here are my findings with this part (1000 attempts): 
    
    The maximum amount of tries the intruder took was 831084 inputs.
    The minimum amount of tries the intruder took was 73 inputs.
    The average amount of tries the intruder took was 110042 inputs.



    
  

