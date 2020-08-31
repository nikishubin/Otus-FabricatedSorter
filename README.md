# Otus-FabricatedSorter

###Project Modules:
- application
- sorter
- file-reader
- file-writer

---

Flow:
1. Get sorting algorithm from arg[0];
2. Read input data from a file passed to arg[1];
3. Write result to a file passed to arg[2].

Supported sorting algorithms:
1. merge;
2. insertion;
3. selection.

Command:

`gradle clean application:run --args="merge D:\\Projects\\Otus\\sorter_input.txt D:\\Projects\\Otus\\sorter_output.txt"`

---

Used technologies:
- Java 14 modular without experimental functionality
- Gradle 6.5
- jUnit 5 (Jupiter)