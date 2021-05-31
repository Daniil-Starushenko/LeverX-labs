# Instruction for building:
## Creation .class and running with java
* For creation  `.class`, we use javac:
* In terminal from directory with `Main.java` file use command *javac Main.java*

![alt text](img/1.png)

* We can run this program from console with `java package1.package2.package3.Main` command from root directory.
![alt text](img/2.png)

## Building .jar and running this from console
*  After that we need to build `.jar` in addition to class file `package1/package2/package3/*.class`.
You must to add `Main-Class` into `MANIFEST.MF` which is located in `META-INF`. 
For that we can create `.txt` file with line that contains `Main-Class` which we need to add to `MANIFEST.MF`.

![alt text](img/3.png)
    `file should be ended with new line`
![alt text](img/4.png)

* We can create `.jar` in root directory with `jar cfm main.jar manifest.txt com/leverX/lab1/*.class` command
which will create new jar with merged line from `manifest.txt` with `MANIFEST.MF`.
* And than run it from terminal

![alt text](img/5.png)

* You can see `META-INF` directory with its content by using `jar xf main.jar` command to check if the  file is correct.
## Compiling and running .jar with libraries
* Firstly we can download library, for example `commons-math-20040218.045431.jar`.
To compile we need to add option `-cp` or `-classpath` with path to library like I do below:

![alt text](img/62.png)

* We must add this library to `CLASSPATH` by using command `export CLASSPATH=$CLASSPATH:path/to/.jar`:

![alt text](img/7.png)

* We can run this program from root directory like we did in the first part without libraries:

![alt text](img/8.png)

* Now to create correct `main.jar` we need to change `MANIFEST.MF` by changing created before `manifest.txt` and merging it during creating `main.jar`.
`manifest.txt` looks like on thee screen below (was added `Class-Path` with path to the library):

![alt text](img/10.png)

* Then we can create `main.jar`, but we need to change a few details:
* * like we did before with adding `com/levrx/lab/Main.class` in the end of command we need to add path to the library

![alt text](img/9.png)

* Like you can see above we can run program from jar `main.jar` using additional libraries
