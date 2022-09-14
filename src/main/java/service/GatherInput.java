package service;

import util.Input;
import util.Validation;

import java.util.Scanner;

public class GatherInput {

    public void programToGatherInput(){
        while (true){
            System.out.println("Enter a number between 1 and 229");
            String variableToValidate = Input.getInput();
            if(Validation.validateInput(variableToValidate)){
                break;
            } else {
                System.out.println("Invalid input try again");
            }
        }
    }
}
