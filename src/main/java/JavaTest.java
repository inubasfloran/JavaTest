import service.FileWrite;
import service.GatherInput;

public class JavaTest {

    public static void main(String[] args) {

        GatherInput test = new GatherInput();
        FileWrite fileWrite = new FileWrite();
        String file = "simple.txt";
        fileWrite.createFile(file);
        test.programToGatherInput();
    }


}
