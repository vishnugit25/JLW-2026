public class Main {

    public static void main(String[] args){

        // create file processing task
        FileProcessor processor1 = new FileProcessor("input1.txt", "output1.txt");
        FileProcessor processor2 = new FileProcessor("input2.txt", "output2.txt");

        // creates thread for file processing
        Thread thread1 = new Thread(processor1);
        Thread thread2 = new Thread(processor2);

        // start threads
        thread1.start();
        thread2.start();

        System.out.println("file processing started... ");


    }
    





}
