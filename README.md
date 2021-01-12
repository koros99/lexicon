# Lab 7: Super Lexicon

## Useful Links
 * [Course Homepage](http://cs.williams.edu/~cs136/) (with TA schedule)
 * [Lab Webpage](https://williams-cs.github.io/cs136s20-www/assets/labs/lexicon/lexicon.html)


## Repository Contents

This repository contains the starter files for writing and testing
your trie-based Lexicon. You should not need to change many of the
starter files, but you should read, explore, and understand them in
order to make effective use of them in your implementation/testing.

Instructons on how to use `Main.java` to test your code are provided
below. The lab Rubric and feedback instructions follow.


## Using Main.java to Test

```
$ java Main
```

If you hit the `Enter` key, you will be given a list of options.

|shortcut key|command|syntax|description|
|-|-|-|-|
|`a`|`add`|Add &lt;word&gt;|Add word to lexicon|
|`c`|`contains`|Contains &lt;str&gt;|Search lexicon for word/prefix|
|`rem`|`remove`|Remove &lt;word&gt;|Removes word from lexicon|
|`rea`|`read`|Read &lt;filename&gt;|Add words from named file to lexicon|
|`p`|`print`|Print|Print all words in lexicon|
|`s`|`suggest`|Suggest &lt;target&gt; &lt;dist&gt;|Find suggestions for target within distance|
|`m`|`match`|Match &lt;regex&gt;|Find matches for pattern|
|`q`|`quit`|Quit|Quit the program|
|`i`|`iter`|iter|test iter|

After selecting a command, `Main` will execute the corresponding methods
in your `Lexicon` code. (This is why it is important to have "stubs" for
functions that are not yet implemented.) Test your functionality
incrementally!


# Lab Feedback

## Ready for Feeback?
 - [ ] Not completed, development is still in progress
 - [x] Completed, this lab is ready for review.

## Summary Score

| Category       | Score |
| -------------- | ----- |
| Functionality  | . / 4 |
| Design         | . / 4 |
| Documentation  | . / 4 |
| Weighted Score | . / 4 |

---

## Rubric

### Functionality (50%)

Functionality is judged by running your program and inspecting your
code. If you program does not produce the expected results, partial
credit will be assigned based on the specific functionality specified
in the lab assignment.  A well-designed program will comprise several
independent units that can each be tested and verified in
isolation. Writing your programs this way will ensure that we can
award maximum credit for the work that you complete.

Here is a breakdown of the functionality scale:

 0. Lab was not attempted.

 1. Lab is largely incomplete

 2. Most lab infrastructure is present, but key components are largely incorrect.

 3. Functionality is mostly correct or close to correct, but some
    corner cases are missing.

 4. Functionality is correct and complete.

### Design (30%)

Design is judged based on some of the key principles we have discussed
in class and in the readings. Your code should use abstraction in
order to hide/isolate implementation details of classes and your code
should be modular and reusable. This means that the classes that we
write should be self-contained and have their functionality clearly
defined.

Here is a breakdown of the design scale:

 0. Lab was not attempted.

 1. Code is disorganized and does not follow discernible design
    principles.

 2. Code misses many key design principles:

   * Code may use reasonable class structure, but may not wisely allocate
     functionality or define clear abstraction boundaries.

   * Fields and methods may be designated as `public`, `private`, or
     `protected` haphazardly.

   * Functions may be too long or may be unclear.

   * Global variables may be used to communicate across methods,
     rather than performing appropriate parameter passing.

 3. Code largely applies design principles, but may fall short on one
    or more key areas:

   * Logical application of `public`/`private`/`protected` visibility
     modifiers for effective information hiding.

   * Well defined class boundaries.

   * Large tasks are decomposed into concrete subtasks as methods.

   * Little to no unnecessary variables and code.

   * Methods communicate using parameters and return values, rather
     than making assumptions about the state of global variables.

 4. Code is elegant and follows/practices good design principles.

### Documentation (20%)

Documentation is judged on several components:
   * Class-level comments (mandatory)
   * Method-level comments (mandatory)
   * Member variables (documented as needed)
   * In-line comments (describe non-intuitive code as needed)
   * "Overall Quality" of comments/variable naming

Here is a breakdown of the documentation scale:

 0. Code is not documented.

 1. Code is poorly documented:

   * Comments are sparse and/or insufficient to understand the code,
     alternatively, comments may be unhelpful (e.g., comment on *what*
     rather than *why*).

   * Variable/method names are not descriptive.

   * Code is not formatted for readability.

 2. Code documents many methods and classes, but is not thorough:

   * Comments may describe obvious things like `//member variables`,
     rather than details about how the variables should be
     interpreted/used.

   * Comments exist, but are missing components (e.g., pre/post
     conditions for `public` methods)

   * Variable/method names may not always be well-chosen or
     descriptive

 3. Documentation is present and useful:

   * Variable/method names are usually descriptive and follow naming
     conventions.

   * Pre/post conditions are present for `public` methods and and
     assertions are used appropriately.

   * Code is formatted for readability (indentation and whitespace).

   * In-line comments document most non-intuitive code snippets.

 4. Clear, easy-to-read documentation:

   * Code comments follow  [Javadoc](https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html)
     standards.

   * In-line comments document non-intuitive code snippets.

   * All variable/method names are descriptive and follow naming
     conventions.

   * Code is formatted for readability (indentation and whitespace)
     and is therefore easy to read and understand. Logical blocks of
     code are clearly deliniated with whitespace.

   * Pre/post conditions are present for all `public` methods and and
     assertions are used appropriately as documentation and debugging.
