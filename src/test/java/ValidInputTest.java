import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.FileWrite;
import service.GatherInput;
import util.Input;
import util.ServiceUtil;
import util.Validation;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class ValidInputTest {
    private ByteArrayInputStream testIn;
    private final InputStream systemIn = System.in;


    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }
    @Test
    public void checkIfInputIsInteger(){
        Assert.assertEquals(true, Validation.checkIfValidInteger("123"));
    }

    @Test
    public void checkIfInputIsNotInteger(){
        Assert.assertEquals(false, Validation.checkIfValidInteger("qwerty"));
    }

    @Test
    public void validateIfInputIsWithinRange(){
        Assert.assertEquals(true, Validation.validateInput("123"));
    }


    @Test
    public void checkIfScannerIsCreated(){
        testIn = new ByteArrayInputStream("add 5".getBytes());
        System.setIn(testIn);
        Assert.assertEquals("add 5", Input.getInput());

    }

    @Test
    public void checkIfRandomStringGenerated(){
        String input = ServiceUtil.generateARandomString();
        String input2 = ServiceUtil.generateARandomString();
        Assert.assertNotEquals(input,input2);
    }

    @Test
    public void checkIfFileIsGettingCreated() {
        //provideInput("1");
        testIn = new ByteArrayInputStream("1".getBytes());
        System.setIn(testIn);
        FileWrite fileWrite = new FileWrite();
        fileWrite.createFile("test");
        File file = new File("test");
        assert(file.exists());
        System.setIn(systemIn);
    }

    @Test
    public void testGatherInput(){
        GatherInput gatherInput = new GatherInput();
        testIn = new ByteArrayInputStream("1".getBytes());
        System.setIn(testIn);
        gatherInput.programToGatherInput();
        System.setIn(systemIn);
    }

    @Test
    public void testMain(){
        testIn = new ByteArrayInputStream("1".getBytes());
        System.setIn(testIn);
        JavaTest.main(new String[0]);
    }
}
