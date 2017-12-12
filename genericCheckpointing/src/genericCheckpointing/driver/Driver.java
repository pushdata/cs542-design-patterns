package genericCheckpointing.driver;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.*;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

import static genericCheckpointing.util.MyLogger.DebugLevel;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

// import the other types used in this file

public class Driver {

    public static MyLogger logger = new MyLogger();


    public static void main(String[] args) throws IOException {

        int NUM_OF_OBJECTS = 0;
        String mode = "";
        String checkpointFile = "";
        int counter = 0;
        MyLogger.setDebugValue(1); //Defaults to PRINT


        // FIXME: read the value of checkpointFile from the command line
        try {
            if (args.length != 3) {
                System.err.println("Usage: java <MainClass> <Mode> <N> <File>");
                System.exit(0);
            }

            if (null == args[0] || args[0].equals("${arg0}")) {
                System.err.println("Please provide valid input arguments");
                System.exit(1);

            }

            if (null == args[1] || args[1].equals("${arg1}")) {
                System.err.println("Please provide valid input arguments");
                System.exit(1);
            }


            if (null == args[2] || args[2].equals("${arg2}")) {
                System.err.println("Please provide valid input arguments");
                System.exit(1);
            }

            mode = args[0];

            if (!mode.equals("serdeser") && !mode.equals("deser")) {
                System.out.println("Invalid Mode! Mode must be 'serdeser' or 'deser'");
                System.exit(1);
            }

            NUM_OF_OBJECTS = Integer.parseInt(args[1]);

            checkpointFile = args[2];

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        FileProcessor fp = new FileProcessor(checkpointFile);

        ProxyCreator pc = new ProxyCreator();

        // create an instance of StoreRestoreHandler (which implements
        // the InvocationHandler
        StoreRestoreHandler srh = new StoreRestoreHandler(fp);


        // create a proxy
        StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
                new Class[]{
                        StoreI.class, RestoreI.class
                },
                new StoreRestoreHandler(fp)
        );


        //Delete file if exists
        if (mode.equals("serdeser")) {
            new File(checkpointFile).delete();
        }


        // FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file
        srh.setCheckpointFile(checkpointFile);

        MyAllTypesFirst myFirst;
        MyAllTypesSecond mySecond;


        // Use an if/switch to proceed according to the command line argument
        // For deser, just deserliaze the input file into the data structure and then print the objects
        // The code below is for "serdeser" mode
        // For "serdeser" mode, both the serialize and deserialize functionality should be called.

        // create a data structure to store the objects being serialized
        // NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst and MyAllTypesSecond
        Vector<SerializableObject> vector_old = new Vector<SerializableObject>();


        if (mode.equals("serdeser")) {
            MyLogger.writeMessage("Serializing Objects to Wire Format(XML)", DebugLevel.STORE);
            //Opening file for Writing!
            srh.setCheckpointFile("output.txt");
            srh.openFileForWriting();
            for (int i = 0; i < NUM_OF_OBJECTS; i++) {

                // FIXME: create these object instances correctly using an explicit value constructor
                // use the index variable of this loop to change the values of the arguments to these constructors
                myFirst = new MyAllTypesFirst(i);
                mySecond = new MyAllTypesSecond(i);

                // FIXME: store myFirst and mySecond in the data structure
                ((StoreI) cpointRef).writeObj(myFirst, "XML");
                ((StoreI) cpointRef).writeObj(mySecond, "XML");

                vector_old.add(myFirst);
                vector_old.add(mySecond);
            }
            srh.closeFileForWriting();
        }

        SerializableObject myRecordRet;

        srh.openFileForReading();
        // Open the input file for deserializing
        // create a data structure to store the returned objects
        Vector<SerializableObject> vector_new = new Vector<>();

        MyLogger.writeMessage("Deserializing Wire Format(XML) to Objects", DebugLevel.RESTORE);
        for (int j = 0; j < 2 * NUM_OF_OBJECTS; j++) {
            myRecordRet = ((RestoreI) cpointRef).readObj("XML");
            if (myRecordRet != null) {
                vector_new.add(myRecordRet);
            }
            // FIXME: store myRecordRet in the vector
        }


        if (mode.equals("deser")) {
            for (SerializableObject serObj : vector_new) {
                MyLogger.writeMessage(serObj.toString(), DebugLevel.PRINT);
            }
        }

        // FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)

        // FIXME: compare and confirm that the serialized and deserialized objects are equal.
        if (mode.equals("serdeser")) {
            for (int i = 0; i < 2 * NUM_OF_OBJECTS; i++) {
                if (vector_old.get(i).equals(vector_new.get(i))) {

                } else {
                    counter++;
                }
            }
            MyLogger.writeMessage("Total mismatched objects " + counter, DebugLevel.PRINT);
        }
        // The comparison should use the equals and hashCode methods. Note that hashCode
        // is used for key-value based data structures
        srh.closeFileForReading();

    }
}