package WordCntPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;


public class wordcounter extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel displayPanel = new JPanel();
	private JButton button = new JButton();
	private JLabel title = new JLabel("Original Text");
	private JTextArea myTextArea = new JTextArea(15, 75);
	private JScrollPane scroll_text_area = new JScrollPane(myTextArea);

	private String mytextData; // to store file's data
	private String[] myArray; // it stores splitted text data word by word

	HashSet<String> myUniqueWordsHS = new HashSet<String>(); // HashSet
	HashMap<String, Integer> myFinalHashMap = new HashMap<String, Integer>(); // HashMap

	private ArrayList<String> myExcludeWordArrayList = new ArrayList<String>(); // it stores excluded words list

	// to clear punctuation from the text data
	private String[] punctuationList = { "!", "\"", "#", "$", "%", "&", "\\", "'", "(", ")", "*", "+", ",", ".", "/",
			":", ";", ">", "<", "=", "?", "@", "[", "]", "^", "_", "`", "{", "}", "|", "~", "-" };


	public wordcounter() throws URISyntaxException, IOException {

		initialise(); // code initialised here

	}

	private void initialise() {
		// Excluded words are added to the arraylist
		myExcludeWordArrayList.add("i");
		myExcludeWordArrayList.add("me");
		myExcludeWordArrayList.add("my");
		myExcludeWordArrayList.add("myself");
		myExcludeWordArrayList.add("we");
		myExcludeWordArrayList.add("our");
		myExcludeWordArrayList.add("ours");
		myExcludeWordArrayList.add("ourselves");
		myExcludeWordArrayList.add("you");
		myExcludeWordArrayList.add("your");
		myExcludeWordArrayList.add("yours");
		myExcludeWordArrayList.add("yourself");
		myExcludeWordArrayList.add("yourselves");
		myExcludeWordArrayList.add("he");
		myExcludeWordArrayList.add("him");
		myExcludeWordArrayList.add("his");

		myExcludeWordArrayList.add("himself");
		myExcludeWordArrayList.add("she");
		myExcludeWordArrayList.add("her");
		myExcludeWordArrayList.add("hers");
		myExcludeWordArrayList.add("herself");
		myExcludeWordArrayList.add("it");
		myExcludeWordArrayList.add("its");
		myExcludeWordArrayList.add("itself");
		myExcludeWordArrayList.add("they");
		myExcludeWordArrayList.add("them");
		myExcludeWordArrayList.add("their");
		myExcludeWordArrayList.add("theirs");
		myExcludeWordArrayList.add("themselves");
		myExcludeWordArrayList.add("what");
		myExcludeWordArrayList.add("which");
		myExcludeWordArrayList.add("who");

		myExcludeWordArrayList.add("whom");
		myExcludeWordArrayList.add("this");
		myExcludeWordArrayList.add("that");
		myExcludeWordArrayList.add("these");
		myExcludeWordArrayList.add("those");
		myExcludeWordArrayList.add("am");
		myExcludeWordArrayList.add("is");
		myExcludeWordArrayList.add("are");
		myExcludeWordArrayList.add("was");
		myExcludeWordArrayList.add("were");
		myExcludeWordArrayList.add("be");
		myExcludeWordArrayList.add("been");
		myExcludeWordArrayList.add("being");
		myExcludeWordArrayList.add("have");
		myExcludeWordArrayList.add("has");
		myExcludeWordArrayList.add("had");

		myExcludeWordArrayList.add("having");
		myExcludeWordArrayList.add("do");
		myExcludeWordArrayList.add("does");
		myExcludeWordArrayList.add("did");
		myExcludeWordArrayList.add("doing");
		myExcludeWordArrayList.add("a");
		myExcludeWordArrayList.add("an");
		myExcludeWordArrayList.add("the");
		myExcludeWordArrayList.add("and");
		myExcludeWordArrayList.add("but");
		myExcludeWordArrayList.add("if");
		myExcludeWordArrayList.add("or");
		myExcludeWordArrayList.add("because");
		myExcludeWordArrayList.add("as");
		myExcludeWordArrayList.add("until");
		myExcludeWordArrayList.add("while");

		myExcludeWordArrayList.add("of");
		myExcludeWordArrayList.add("at");
		myExcludeWordArrayList.add("by");
		myExcludeWordArrayList.add("for");
		myExcludeWordArrayList.add("with");
		myExcludeWordArrayList.add("about");
		myExcludeWordArrayList.add("against");
		myExcludeWordArrayList.add("between");
		myExcludeWordArrayList.add("into");
		myExcludeWordArrayList.add("through");
		myExcludeWordArrayList.add("during");
		myExcludeWordArrayList.add("before");
		myExcludeWordArrayList.add("after");
		myExcludeWordArrayList.add("above");
		myExcludeWordArrayList.add("below");
		myExcludeWordArrayList.add("to");

		myExcludeWordArrayList.add("from");
		myExcludeWordArrayList.add("up");
		myExcludeWordArrayList.add("down");
		myExcludeWordArrayList.add("in");
		myExcludeWordArrayList.add("out");
		myExcludeWordArrayList.add("on");
		myExcludeWordArrayList.add("off");
		myExcludeWordArrayList.add("over");
		myExcludeWordArrayList.add("under");
		myExcludeWordArrayList.add("again");
		myExcludeWordArrayList.add("further");
		myExcludeWordArrayList.add("then");
		myExcludeWordArrayList.add("once");
		myExcludeWordArrayList.add("here");
		myExcludeWordArrayList.add("there");
		myExcludeWordArrayList.add("when");

		myExcludeWordArrayList.add("where");
		myExcludeWordArrayList.add("why");
		myExcludeWordArrayList.add("how");
		myExcludeWordArrayList.add("all");
		myExcludeWordArrayList.add("any");
		myExcludeWordArrayList.add("both");
		myExcludeWordArrayList.add("each");
		myExcludeWordArrayList.add("few");
		myExcludeWordArrayList.add("more");
		myExcludeWordArrayList.add("most");
		myExcludeWordArrayList.add("other");
		myExcludeWordArrayList.add("some");
		myExcludeWordArrayList.add("no");
		myExcludeWordArrayList.add("nor");
		myExcludeWordArrayList.add("not");

		myExcludeWordArrayList.add("only");
		myExcludeWordArrayList.add("own");
		myExcludeWordArrayList.add("same");
		myExcludeWordArrayList.add("so");
		myExcludeWordArrayList.add("than");
		myExcludeWordArrayList.add("too");
		myExcludeWordArrayList.add("very");
		myExcludeWordArrayList.add("can");
		myExcludeWordArrayList.add("will");
		myExcludeWordArrayList.add("just");
		myExcludeWordArrayList.add("don");
		myExcludeWordArrayList.add("should");
		myExcludeWordArrayList.add("now");

		title.setBounds(5, 5, 25, 25); // title label's coordinates and sizes defined
		myTextArea.setBackground(Color.WHITE); // myTextArea background colour is set here
		myTextArea.setForeground(Color.BLACK); // foreground colour is set here
		myTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // myTextArea's font is set here
		myTextArea.setEditable(false); // myTextArea is set to non editable by user

		myTextArea.setColumns(75); // myTextArea's column size is set here
		myTextArea.setRows(40); // myTextArea's row size is set here
		myTextArea.setLineWrap(true); // lines will be wrapped if they are too long to fit within the allocated width.
		myTextArea.setWrapStyleWord(true); // lines will be wrapped at wordboundaries if they are too long to fit within
										// the allocated width.
		button = new JButton("Open File");
		button.setBounds(5, 150, 35, 35); // button's coordinates and sizes defined

		// objects are added to display panel
		displayPanel.add(title);
		displayPanel.add(scroll_text_area);
		displayPanel.add(button);

		add(displayPanel); // display panel added to the frame
		setTitle("Word Counter"); // frame's title is set here

		setSize(850, 800); // frame's width and height is set here
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application using the System exit method
		setLocationRelativeTo(null); //places the form at the centre of the screen
		setVisible(true); // makes the Window visible

		button.addActionListener(this); // action listener is added to the button
	}



	// this method reads text file and returns its data as string
	public String readTextFile() throws URISyntaxException, IOException {
		String myStr = "";
		String line = null;

		// JFileChooser provides a simple mechanism for the user to choose a file.
		JFileChooser myFile_Chooser = new JFileChooser();
		
		// it only selects txt files in dialog box
		myFile_Chooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));

		// it is opened to user's home directory first to choose a text file
		myFile_Chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

//filechooser dialog box is opened to choose a text file and returns dialogBox_result
		int dialogBox_result = myFile_Chooser.showOpenDialog(this);

if (dialogBox_result == JFileChooser.APPROVE_OPTION) { // if a file is chosen
			// chosen file name and its path is stored into selected file
			File selected_File = myFile_Chooser.getSelectedFile();
			try {
				// Reads text from character files using a default buffer size.
				FileReader myFileReader = new FileReader(selected_File.getAbsolutePath());

//Reads text from a character-input stream, buffering
// characters so as to provide for the efficient reading of
// characters, arrays, and lines.
				BufferedReader myBufferedReader = new BufferedReader(myFileReader);



// until the end of file loop gets data line by line and stores it to myStr
while ((line = myBufferedReader.readLine()) != null) {
	myStr = myStr + line;
}

myBufferedReader.close(); // to release the source
myFileReader.close();


} catch (IOException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}

}
return myStr;
}

@SuppressWarnings({ "unchecked", "rawtypes" })
//This method sorts the hashMap by values and in descending order
	private static HashMap<String, Integer> sortMyHashByValues(HashMap<String, Integer> myHashMap) {
		List<Object> myList = new LinkedList<Object>(myHashMap.entrySet());

		Collections.sort(myList, new Comparator() {
			public int compare(Object obj1, Object obj2) {
				// for descending order obj2 is written first
				return ((Comparable) ((Map.Entry) (obj2)).getValue()).compareTo(((Map.Entry) (obj1)).getValue());
			}
		});

		// sorted list is copied to HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap mySortedHashMap = new LinkedHashMap();
		for (Iterator it = myList.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			mySortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return mySortedHashMap;
	}


	public static void main(String[] args) throws URISyntaxException, IOException {
		new wordcounter();
	}


	@Override // Override indicates that a method declaration is intended to override a method
				// declaration in a supertype.
	public void actionPerformed(ActionEvent e) { // Invoked when an action occurs.

		String myCommand = e.getActionCommand().toString(); // action event is caught to myCommand as String

		if (myCommand.equals("Open File")) { // if open file button is clicked

			try {
				mytextData = readTextFile(); // readTextFile class is called to read text file, it catches the result
												// into myTextData
			} catch (URISyntaxException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (mytextData.equals("") != true) { // if mytextdata is not empty

				myTextArea.setText(mytextData); // file's content is stored to text area

				// before counting unique words, all words are converted to lower case to set
				// all the words in the same base
				mytextData = mytextData.toLowerCase();

				// in this loop all punctuations which are stored in a array are cleared in the
				// mytextdata
				for (int punctuation = 0; punctuation < punctuationList.length; punctuation++) {
					mytextData = mytextData.replace(punctuationList[punctuation], "");
			}

			// mytextdata is splitted word by word and stored into myArray
			myArray = mytextData.split(" ");

			// myArray is converted to an arraylist that is called myArrayList. myArray is
			// converted to arraylist because arraylists have removeAll method.
			List<String> myArrayList = new ArrayList<String>(Arrays.asList(myArray));

			// all words that (myExcludeWordArrayList) contains are removed(removeAll) from
			// myArrayList
			myArrayList.removeAll(myExcludeWordArrayList);

			myUniqueWordsHS.clear();// HashSet is cleared here before adding new values

			for (int eachWord = 0; eachWord < myArrayList.size(); eachWord++) {
				if (myArrayList.get(eachWord).isEmpty() == false)
					myUniqueWordsHS.add(myArrayList.get(eachWord));// all unique words are stored in myUniqueWordsHS
																	// HashSet
			}
			myFinalHashMap.clear(); // HashMap is cleared before putting new values
			// Calculates word count for each unique word and puts in to myFinalHashMap
			for (String uniqueWord : myUniqueWordsHS) {
				int myWordCount = 0;
				for (int allWords = 0; allWords < myArrayList.size(); allWords++) {
					if (uniqueWord.equals(myArrayList.get(allWords)) && myArrayList.get(allWords).isEmpty() == false) {
						myWordCount++;
					}
				}
				// Final unique Word List and their count put here in myFinalHashMap
				myFinalHashMap.put(uniqueWord, myWordCount);
			}

			// Sorting hashmap by Word Count descending order (289)
			Map<String, Integer> mySortedHashMap = sortMyHashByValues(myFinalHashMap);

			// unique word counts are added after appending(+) this
			// text to the textarea
			myTextArea.append("\n\nWord Counts of the text:");


			int totalWordCount = 0;
			int uniqueWordsCount = myUniqueWordsHS.size();

			/*
			 * in loop all unique words and their word counts are append and shown on the
			 * text area
			 */
			for (Map.Entry<String, Integer> sortedHashMap : mySortedHashMap.entrySet()) {
				// to append data to the text data
				int HM_Value = sortedHashMap.getValue();
				String HM_Key = sortedHashMap.getKey();

				// all the HM_Value and HM_Key 's append to the text area
				myTextArea.append("\n(" + HM_Value + "," + HM_Key + ")");
				// to calculate (sum) total Word Count
				totalWordCount = totalWordCount + HM_Value;

			}

			myTextArea.append("\nTotal unique word count of the text:" + uniqueWordsCount);
			myTextArea.append("\nTotal word count of the text:" + totalWordCount);

		}
	}
}
}
