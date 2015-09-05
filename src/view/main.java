package view;

import controller.JsonController;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mateus
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException  {
             
        JsonController json = new JsonController();
    	for (int i = 0; i < json.ReadJsonCalc().size(); i++) {
	    int user_id = json.ReadJsonCalc().get(i).getUserIid();
            String name = json.ReadJsonCalc().get(i).getName();
            
	    System.out.println("name: " + name + " |  user_id: " + user_id);
	}
        
        
        
    }
       
    }


