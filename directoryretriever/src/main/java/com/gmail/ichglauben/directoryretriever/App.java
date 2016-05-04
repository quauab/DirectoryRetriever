package com.gmail.ichglauben.directoryretriever;

import com.gmail.ichglauben.directoryretriever.core.concretes.DirectoryRetriever;
import com.gmail.ichglauben.directoryretriever.core.utils.abstracts.CustomClass;

public class App extends CustomClass {
	public static void main(String[] args) {
		String dir = DirectoryRetriever.retrieveDirectory();
		print("Chosen directory: " + dir);
	}
}
