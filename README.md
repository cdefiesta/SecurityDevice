# SecurityDevice

## What does the program do? ##

This program is meant to emulate a real-life security lock that functions through a number keypad with keys from '0' to '9'. 

### Part one ###

This program will take an integer from user input, one a time, and the state of the lock will only change if the full code is inputted with no interruption. The lock uses a fixed access code, the least 5 significant digits of my student ID ("84724"), and depending what number follows next will either lock, unlock or not change the state of the lock.

When the fixed access code is followed by a "1" the lock will unlock.
  ex: 847241

When the fixed access code is followed by a "4" the lock will lock.
  ex: 847244

When the fixed access code is followed by any other digit the lock will not be affected.
  ex: 847246, 847247, 847249
  
This code uses a simple FSM that is responsible for setting the state of the lock. There are only three possible states for the lock as mentioned above, locked, unlocked or no change. 

Any input longer than one digit, or is not an integer will be quietly ignored and the code will continue as normal.

### Part two ###

This program tests how easy or difficult it is for an intruder to unlock the lock without actually knowing the code. In this code, we are testing to see how efficient inputting in random numbers into the device using a random number generator.

## How to run program ##

You must have 'gradle' installed to complete this set-up.

1) Clone the repository:
```
$ git clone https://github.com/cdefiesta/SecurityDevice.git
```

2) Make sure all the unit tests pass:
```
$ ./gradlew test
```
  
  2.5) If permission is denied to run gradlew tasks, enter:
  ```
  $ chmod u+x gradlew
  ```
  This should allow you to execute any gradlew task.
  
3) Build an executable jar:
```
$ ./gradlew jar
```

4) Run the executable:
```
$ java -jar ./app/build/libs/app.jar
```
Once the executable is ran you will get a choice to access either part one or two of the program. For part one, you will have to input integers between '0' and '9', one at a time, and used the fixed access code to lock and unlock.
