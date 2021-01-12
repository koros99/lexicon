import structure5.*;
import java.util.Iterator;

/*
 * This class represents a singular node.
 * The node contains a character and a boolean variable
 * It also contains an OrderedList which stores other Lexicon Nodes
 * within it. Those nodes are considered 'children' of this node
 */
class LexiconNode implements Comparable<LexiconNode> {

	/* single letter stored in this node */
	protected char letter;

	/* true if this node ends some path that defines a valid word */
	protected boolean isWord;

  /*list to store the children nodes in alphabetical order*/
	protected OrderedList<LexiconNode> children = new OrderedList<>();

	/**
	 *creates a new Lexicon Node containing a character and a boolean state
	 */
	public LexiconNode(char letter, boolean isWord) {
		this.letter = letter;
		this.isWord = isWord;
	}

	/**
	 * post: returns an integer that describes the comparison
	 * between the two nodes
	 */
	public int compareTo(LexiconNode o) {
		 return Character.compare(this.letter, o.letter);
	}

	/**
	 *
	 * post: adds the node passed as the parameter to the
	 * list of children of this node
	 */
	public void addChild(LexiconNode ln) {
      children.add(ln);
	}

	/**
	*
	* post: returns the node among the list of children for this node
	* whose letter corresponds to the character passed as a parameter
	* If the node doesn't exist it returns null
	*/
	public LexiconNode getChild(char ch) {
		for (LexiconNode i : children) {//traversing the list of children for this node
	       if (i.letter == ch) {
	       	  return i;
	       }
		}
		return null;
	}


	/**
	 * post: calls getChild() to find the child node whose
	 * letter corresponds to the character passed.
	 *
	 */
	public void removeChild(char ch) {
		Assert.pre(getChild(ch)!=null,"Node does not exist");
		children.remove(getChild(ch));
	}

	/**
	* post: returns false if the list containing children of this node
	* is empty, true otherwise
	*/
	public boolean hasChildren(){
	 	return !children.isEmpty();
	}

	/**
	* post: returns the letter associated with this node
	*/
	public boolean isWord(){
		return isWord;
	}
  /**
	* post: sets the isWord variable associated with this node
	* to the boolean passed in as a parameter
	*/
	public void setWord(boolean state){
		isWord = state;
	}

	/**
	 * post: returns the iterator for the list containing the
	 * child nodes for this node
	 */
	public Iterator<LexiconNode> iterator() {
		return children.iterator();
	}
	/*
	* post: returns a String representation of this node
	*/
	public String toString(){
		return "[Letter:" + "(" + this.letter + ")" + "," + "Valid? " + this.isWord+ "]";
	}

}
