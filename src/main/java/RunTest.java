import search_engine.SearchEngineImplementation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RunTest {



    public static void main(String args[]) throws IOException {

        SearchEngineImplementation structure = new SearchEngineImplementation();
        String path = "src/main/resources/documents/";
        String finalPath = "";

        Scanner command = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);

        System.out.print(" Insert your command:");

        String input = command.nextLine();

        //User is prompted for input and can stop execution using the (stop) command
         while (!input.equals("stop")){


            if(input.equals("index")){

                System.out.print("Enter document id: ");
                String docId = userInput.nextLine();

                finalPath = path + docId + ".txt";

                File file = new File(finalPath);

                structure.mapFile(file,docId);

            }else if(input.equals("query")){
                System.out.print("Enter token: ");
                String token = userInput.nextLine();
                structure.find(token);
            }else{
                System.out.println("Command not found");
            }

            System.out.print(" Insert your command:");
            input = command.nextLine();
        }


    }

}
