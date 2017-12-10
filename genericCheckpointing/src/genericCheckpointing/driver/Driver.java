package genericCheckpointing.driver;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.*;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

import java.util.Vector;

// import the other types used in this file

public class Driver {

    public static MyLogger logger = new MyLogger();
    private static int NUM_OF_OBJECTS = 0;
    private static String mode = "";
    private static String fileName = "";
    public static Vector<SerializableObject> objArray;

    public static void main(String[] args) {


        // FIXME: read the value of checkpointFile from the command line
        try {
            if (args.length != 3) {
                System.err.println("Usage: java <MainClass> <InputFile> <OutputFile> <DebugValue[0-2]>");
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

            NUM_OF_OBJECTS = Integer.parseInt(args[1]);

            fileName = args[2];

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        FileProcessor fp = new FileProcessor(fileName);

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


        // FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file

        MyAllTypesFirst myFirst;
        MyAllTypesSecond mySecond;

        if (mode.equals("deser")) {

        }

        // Use an if/switch to proceed according to the command line argument
        // For deser, just deserliaze the input file into the data structure and then print the objects
        // The code below is for "serdeser" mode
        // For "serdeser" mode, both the serialize and deserialize functionality should be called.

        // create a data structure to store the objects being serialized
        // NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst and MyAllTypesSecond
        Vector<SerializableObject> before = new Vector<SerializableObject>();

        if (mode.equals("serdeser")) {
            for (int i = 0; i < NUM_OF_OBJECTS; i++) {

                // FIXME: create these object instances correctly using an explicit value constructor
                // use the index variable of this loop to change the values of the arguments to these constructors
                myFirst = new MyAllTypesFirst(i);
                mySecond = new MyAllTypesSecond(i);

                // FIXME: store myFirst and mySecond in the data structure
                ((StoreI) cpointRef).writeObj(myFirst, "XML");
                ((StoreI) cpointRef).writeObj(mySecond, "XML");

            }
        }

        SerializableObject myRecordRet;

        // create a data structure to store the returned ojects
        for (int j = 0; j < 2 * NUM_OF_OBJECTS; j++) {

            myRecordRet = ((RestoreI) cpointRef).readObj("XML");
            // FIXME: store myRecordRet in the vector
        }

        // FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)

        // FIXME: compare and confirm that the serialized and deserialzed objects are equal.
        // The comparison should use the equals and hashCode methods. Note that hashCode
        // is used for key-value based data structures

    }
}