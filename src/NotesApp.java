import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class NotesApp {
    public static final String FILE_NAME ="notes.txt";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       while(true){
           System.out.println("-----------------Notes Menu----------------");
           System.out.println("1. Write Notes");
           System.out.println("2. Read Notes");
           System.out.println("3. Exit Notes");
           System.out.println("Enter your choice: ");
           int choice;
           try {
               choice = s.nextInt();
           } catch (Exception e) {
               System.out.println("Invalid input! Please enter 1, 2, or 3.");
               s.nextLine(); // clear bad input
               continue;
           }

           s.nextLine();

           switch (choice){
               case 1:
                   writeNotes(s);
                   break;
               case 2:
                   readNotes();
                   break;
               case 3:
                   System.out.println("Exiting Notes");
                   s.close();
                   break;
               default:
                   System.out.println("Invalid Choice ");
           }
       }
    }
    private static void writeNotes(Scanner s){
        try{
            FileWriter fw = new FileWriter(FILE_NAME,true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.println("Enter your notes: ");
            String notes = s.nextLine().trim();

            if (notes.isEmpty()) {
                System.out.println("Note cannot be empty!");
            } else {
                bw.write(notes);
                bw.newLine();
                System.out.println("Notes Saved");
            }

            bw.close();
        }
        catch(IOException e){
            System.out.println("Error writing files"+ e.getMessage());
        }
    }
    private static void readNotes(){
        try{
            FileReader fr =new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);
            String line;
            System.out.println("\n--- Your Notes ---");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
            br.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("No notes found yet. Add some first!");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}