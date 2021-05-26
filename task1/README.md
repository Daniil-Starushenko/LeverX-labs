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

* We can create `.jar` int root directory with `jar cfm main.jar manifest.txt com/leverX/lab1/*.class` command
which will create new jar with merged line from `manifest.txt` with `MANIFEST.MF`.
* And than run it from terminal

![alt text](img/5.png)

* You can see `META-INF` directory with its content by using `jar xf main.jar` command to check if the  file is correct.
