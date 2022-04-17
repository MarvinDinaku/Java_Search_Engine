# Java assignment - Search Engine

This project's purpose is to construct a simple Java search search_engine. 
The search search_engine should be constructed as a memory-based inverted index that can return a list sorted by TF-IDF.

The search search_engine should be able to: 
* accept a list of documents as input 
* support single-term searches inside the document set 
* return a list of matching documents sorted by TF-IDF
	
## Example

The following documents are indexed:
1.txt: "soup tomato cream salt"
2.txt: "cake sugar eggs flour sugar cocoa cream butter"
3.txt: "soup fish potato salt pepper"

## How to Run

When class RunTest is executed the user will be prompted to insert a command.
The commands are:

1- index which will allow the user to insert an ID of the corresponding document
2- query which will allow the user to insert a token to search and display the results
3- stop  which will terminate execution of the program.

NOTE:
The index doesn't have to be stored on disk by the search search_engine. 
It's fine to use a memory-based implementation.
A simple string can be used as a document. 
There is no requirement for a graphical user interface, but you must be able to enter a query and receive a response.
