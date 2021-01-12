# Lexicon Thought Questions

1. For each node in the trie, you need to store pointers to its children nodes. What data structure did you use to store the pointers to children nodes? Justify the choice you made.
   * Data structure choice: OrderedList
   * Justification: An OrderedList saves on space since references are created on necessity
2. Suppose we use an `OrderedVector` to store all the words in our lexicon (so instead of a using a Trie, we have one sorted list that contains all of the words). Discuss how, at a high level, the process of searching for suggested spelling corrections would differ from our trie-based implementation. Which is more efficient? Why?
   * Searching in a trie: O(m) where m is the length of the word
   * Searching in an `OrderedVector`: O(log n)
   * Which is more efficient? The trie is more efficient. While the OrderedVector provides a runtime of log n which is certainly
     appealing, the trie's runtime is almost constant. This is because, we can place an upper bound on the length of the word, say 50
     or so. For an OrderedVector of 1000 words, the runtime will definitely be more than that of the trie.
