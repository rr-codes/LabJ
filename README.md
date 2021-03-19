# EECS 1021 Lab J

Practice Stream questions available [here](https://gist.github.com/rr-codes/0df0d59fa00845430fc02b1272c1c09f).

### CLI Applications

Command Line Interface (CLI) applications are some of the most common types of programs. 
CLI applications are typically small utilities which provide specific functionality.

In this Lab, you will be creating a CLI utility to extract water level data from the Canadian Weather Service site.
Your program should have the following API:

```shell
./labj [-agh] [station]
```
where:
- `station` is the weather station code
- The `-a` (or `--average`) flag specifies the `average` mode. In this mode, the utility should print the average water level.
- The `-g` (or `--graph`) flag specifies the `graph` mode. In this mode, the utility should output a PNG image of a line graph of the water level data.
- The `-h` (or `--help`) flag is a special flag, which prints a synopsis of the CLI command.

Note that the `-a` and `-g` flags are mutually exclusive.

An example of using this utility is `./labj -g ABC123`.

### Java Streams

Java 8 introduced _Streams_, a collection of _functional programming_ APIs which operate on a sequential flow of data.
Functional programming is a fairly new paradigm in programming, and is becoming increasingly popular due to its
efficiency and ease of use.

For example, to get the sum of squares of all even numbers from 0 to 10, one can do

```java
import java.util.stream.IntStream;

public class Main {
    public static int square(int x) {
        return x * x;
    }
    
    public static void main(String[] args) {
        var sum = IntStream.range(0, 10) // create an IntStream of numbers 0 through 10
                .filter(x -> x % 2 == 0) // discard any odd numbers
                .map(Main::square) // map all values to their squares (using a method reference)
                .sum(); // return the sum of all the values
    }
}
```

### Instructions
For this lab, you are required to implement all the pieces of code as instructed in each `TODO`. This involves parsing, computations, etc.