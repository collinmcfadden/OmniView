#include <iostream>
#include <fstream>
#include <boost/algorithm/string/replace.hpp>

using namespace std;

int main() {
	std::string line;
	ifstream inFile;
	inFile.open("./ankleBreak.txt");

	if (!inFile) {
		cerr << "File was not opened\n";
		exit(1);
	}

	ofstream outFile;
	outFile.open("./parsedAnkleBreak.txt");

	if (!outFile) {
		cerr << "Output file creation failed";
		exit(1);
	}

	while (getline(inFile, line)) {
		// These two delimiters are the start and end to most image links within 
		// the Bing search URL
		std::string delimiter1 = "&mediaurl=";
		std::string delimiter2 = "&ex";
		
		// The three file types that we are interested in gathering photos of
		std::string delimiter3 = ".jpg";
		std::string delimiter4 = ".png";
		std::string delimiter5 = ".jpeg";

		std::string lineCopy = line;
		std::string parse = lineCopy.substr(line.find(delimiter1) + 10, lineCopy.length());
		std::string parse2 = parse.substr(0, parse.find(delimiter2));
		
		// Checks that the url is an image file
		std::string lastFour = parse2.substr(parse2.length() - 4, parse2.length());
		std::string lastFive = parse2.substr(parse2.length() - 5, parse2.length());
		
		if (!(lastFour.compare(delimiter3) == 0 || lastFour.compare(delimiter4) == 0 || 
				lastFive.compare(delimiter5) == 0)) {
			continue;
		}
 		
		// Replaces characters in the pseudo-URL's with their original characters
		std::string delimiterSlash = "%2f";
		std::string delimiterColon = "%3a";

		boost::replace_all(parse2, delimiterSlash, "/");
		boost::replace_all(parse2, delimiterColon, ":");
		
		// Prints the url to the file
		outFile << parse2 << std::endl;		 
	}
	inFile.close();
	outFile.close();
}
