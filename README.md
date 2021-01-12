# Lexicon

## Description
This is a lexicon program that allows users to add, remove, and check for words. The program uses a trie (a tree with up to 26 chilren) to store the words. Thus, operations such as add, remove, and contains are quick (O(n) where n is the length of the word).

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
in your `Lexicon` code. 
