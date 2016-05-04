package com.gmail.ichglauben.directoryretriever.core.concretes;

import java.io.File;

import javax.swing.JFileChooser;

import com.gmail.ichglauben.directoryretriever.core.utils.abstracts.CustomClass;

public class DirectoryRetriever extends CustomClass {

	/** Handles the cancellation of the file browser. */
	private static void handleCancellation() {
		Object[] options = { "Yes, please exit", "Nope, cancel that!" };
		int n = javax.swing.JOptionPane.showOptionDialog(null, "Are you sure you want to cancel?", "A Silly Question",
				javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, img, options,
				options[0]); // default button title
		if (n == javax.swing.JOptionPane.OK_OPTION) {
			return;
		} else
			retrieveDirectory();
	}

	/**
	 * Opens a file browser.
	 * 
	 * @return String absolute path
	 */
	public static String retrieveDirectory() {
		detectPlatform();
		javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
		String path = null;
		File file = null;

		int selectionMode = JFileChooser.DIRECTORIES_ONLY;
		chooser.setFileSelectionMode(selectionMode);

		// open file chooser dialog
		int dialog = chooser.showOpenDialog(null);

		// if user selects a directory...
		if (dialog == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			path = file.toPath().toAbsolutePath().toString().trim();
		}
		// else the user cancelled the dialog
		else {
			path = null;
			handleCancellation();
		}
		return path;
	}

	/** Returns ImageIcon */
	private static javax.swing.ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = DirectoryRetriever.class.getResource(path);
		if (imgURL != null) {
			return new javax.swing.ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file at: \n" + path);
			return null;
		}
	}

	private final static javax.swing.ImageIcon img = createImageIcon("/medium.gif");

	public String toString() { return "Directory Retriever"; }
}
