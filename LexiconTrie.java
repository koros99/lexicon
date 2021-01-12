import structure5.*;
import java.util.Iterator;
import java.util.Scanner;

/**
* This class is a collection of LexiconNodes that collectively represent
* various words represented as a trie. The root of this node is just an empty
* space. Each node will have at most 26 other nodes corresponding to the letters
* of the alphabet.
*/
public class LexiconTrie implements Lexicon {
  // the start node for the LexiconTrie, essentially contains nothing
  private LexiconNode root;

  // keeps count of the word in this LexiconTrie
  protected int count;

  //this structure will essentially be used to iterate over words contained in this LexiconTrie
  private OrderedVector<String> wordList;

	/**
	 * Initializes a newly allocated lexicon to
	 * represent an empty word list.
	 */
	public LexiconTrie() {
    root = new LexiconNode(Character.MIN_VALUE,false);
	}

	/**
	 * This member function adds the specified word to this
	 * lexicon.  It returns true if the word was added
	 * (i.e. previously did not appear in this lexicon) and false
	 * otherwise. The word is expected to contain only lowercase
	 * letters.
	 */
	public boolean addWord(String word) {
		 boolean added = addHelper(root,word.toLowerCase());
     if(added) count++;//incrementing the count of words in the trie if the word was successfully added
     return added;
	}

  /**
  * post: returns true if a word is successfully added to the trie
  */
  public boolean addHelper(LexiconNode node, String word){
    String newWord = word.substring(1);//new word that will be passed into the recursive call
    char first = word.charAt(0);
    LexiconNode child = node.getChild(first);
    if (word.length()==1){
        if (child == null){
          /* if the word is a single character long and the corresponding node
           does not exist in the current node's list of children, then the word did not
           exist in this trie and should therefore be added */
          node.addChild(new LexiconNode(first, true));
          return true;
        }
        if(!child.isWord()){
          /*if the word is a single character long,but the corresponding node does exist
          in the current node's list of children,then set the isWord field of this child to true*/
          child.setWord(true);
          return true;
        }
        return false;
    }
    if (child == null){
      /*if no child has been found, means that the word wasn't in the trie*/
        LexiconNode newNode = new LexiconNode(first, false);
        node.addChild(newNode);//add the newly created node to the children of the current node
        addHelper(newNode,newWord);
        return true;
    }
    return addHelper(child,newWord);
}



	/**
	 * This member function opens the specified file, expecting a
	 * text file containing one word per line, and adds each word
	 * to this lexicon. The value returned is the count of new
	 * words that were added. If the file doesn't exist or was
	 * unable to be opened, the function returns 0.
	 */
	public int addWordsFromFile(String filename) {
    int count = 0;//number of words added
    Scanner input = new Scanner(new FileStream(filename));
    while(input.hasNextLine()){
      String line = input.nextLine();
      if (addWord(line)) count++;
    }
		return count;
	}

	/**
	 * This member function attempts to remove a specified word
	 * from this lexicon.
	 *
	 * If the word appears in the lexicon, it is removed and true is
	 *    returned.
	 * If the word was not contained in the lexicon, the lexicon is
	 *    unchanged and false is returned.
	 */
	public boolean removeWord(String word) {
		boolean removed = removeHelper(root,word);
    if(removed) count--;
    return removed;
	}
 /**
 * This member function serves as a helper method to the removeWord function
 * It returns true if a word was contained in the lexicon and removed
 * If the word wasn't contained in the Lexicon, it returns false
 */
  public boolean removeHelper(LexiconNode node, String word){
    LexiconNode parent = node.getChild(word.charAt(0));//child contained in the current node's list of children
    if (parent!=null){
      LexiconNode child = parent.getChild(word.charAt(1));//child to the 'parent' node
        if(child==null) return false;//if child is null, then the word wasn't in the Lexicon to begin with, return false
        if (child.isWord()) {//if isWord is true,we got to a leaf,word was in the Lexicon
          child.setWord(false);
          //if the 'child' node hasChildren,set isWord to false, otherwise, remove the 'child' node
          if(!child.hasChildren()) parent.removeChild(word.charAt(1));
          return true;
        }
       boolean remove = removeHelper(parent,word.substring(1));
       //if the 'child' node doesn't have children and isWord is false, remove the node
       if(remove && !child.hasChildren() && !child.isWord()) parent.removeChild(word.charAt(1));
       return remove;
    }
    return false;
}

	/**
	 * This member function returns the number of words contained
	 * in this lexicon.
	 */
	public int numWords() {
		return count;
	}

	/**
	 * This member function returns true if the specified word
	 * exists in this lexicon, false otherwise.
	 */
	public boolean containsWord(String word){
    return containsHelp(root,word);
	}
  /**
  * This functions serves as a helper method to the containsHelp
  * method.Returns true if the specified word exists in the lexicon,
  * false otherwise
  */
  public boolean containsHelp(LexiconNode node, String word){
    LexiconNode child = node.getChild(word.charAt(0));
    if(child!=null){
      if(word.length()==1 && child.isWord()) return true;
      else if(word.length()==1 && !child.isWord()) return false;
      return containsHelp(child,word.substring(1));
    }
    return false;
  }

	/**
	 * This member function returns true if any words in the
	 * lexicon begin with the specified prefix, false otherwise. A
	 * word is defined to be a prefix of itself and the empty
	 * string is a prefix of everything.
	 */
	public boolean containsPrefix(String prefix){
		return prefixHelper(root,prefix);
	}
  /**
  * This functions serves as a helper method to the containsPrefix
  * method. Returns true if any words in the lexicon begin with
  * the specified prefix,false otherwise.
  */
  public boolean prefixHelper(LexiconNode node, String letters){
    if(letters.length()==0)return true;//empty word is a prefix
    LexiconNode parent = node.getChild(letters.charAt(0));//node associated with the first char of the word
    if(parent!=null){
      if(letters.length()==1)return true;
        LexiconNode child = parent.getChild(letters.charAt(1));//node associated with the second char of the word
        if(child==null)return false;
        return prefixHelper(parent,letters.substring(1));
    }
    return false;
  }

	/**
	 * This member function returns an iterator over all
	 * words contained in the lexicon. Accessing the
	 * words from the iterator will retrieve them in
	 * alpahbetical order.
	 */
	public Iterator<String> iterator() {
    wordList = new OrderedVector<String>();//Vector to hold words contained in the Lexicon
    iteratorHelp(root,"");
    return wordList.iterator();
	}

  public void iteratorHelp(LexiconNode node, String result){
    if(!node.hasChildren()){//if it has no children then it's a leaf. Leaf isWord is always true
      wordList.add(result+=node.letter);
      return;
    }
    if(node.isWord()) wordList.add(result+node.letter);//add node to wordList if its a word
    for(LexiconNode n:node.children)iteratorHelp(n,result+node.letter);//recurse over node's children
  }
	/**
	 * (OPTIONAL!)
	 *
	 * This member function returns a pointer to a set of strings,
	 * where each entry is a suggested correction for the target.
	 * All words in the lexicon with a distance to the target that
	 * is less than or equal to the parameter distance should be
	 * in the returned set.
	 */
	public Set<String> suggestCorrections(String target, int maxDistance) {
		return null;
	}

	/**
	 * (OPTIONAL!)
	 *
	 * This member function returns a pointer to a set of strings,
	 * where each entry is match for the regular expression
	 * pattern.  All words in the lexicon that match the pattern
	 * should be in the returned set.
	 */
	public Set<String> matchRegex(String pattern){
		return null;
	}
}
