// Importing classes required for file handling
import java.io.*;

// FileProcessor class implements Runnable
// so that objects of this class can run as threads
public class FileProcessor implements Runnable {

        // Stores input file name
    private String inputFile;

    // Stores output file name
    private String outputFile;


    // constructor to initialize filenames
    public FileProcessor(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;

    }

    // Code inside run() executes when thread starts
    @Override
    public void run() {
        try {

            // Reads data from input file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Writes processed data to output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;

            // reads file line by line
            while((line = reader.readLine()) != null) {

                // converts text to uppercase
                String processedLine = line.toUpperCase();

                // write processed text into output file
                writer.write(processedLine);

                // moves to next line
                writer.newLine();

            }

            // Closes reader and writer
            reader.close();
            writer.close();

            // display successful processed messages
            FileLogger.log(Thread.currentThread().getName() + " processed file: " + inputFile);

        } catch (IOException e) {
            FileLogger.log( "Error processing file: " + inputFile );

        e.printStackTrace();    
        }

    }
}











