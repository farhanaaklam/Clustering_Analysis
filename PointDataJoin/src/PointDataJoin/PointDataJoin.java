package PointDataJoin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class PointDataJoin {

    public static void main(String[] args) {

        String edgesFile = "edges.csv"; //CSV Input file of Edges
        String nodesFile = "nodes.csv"; //CSV Input file of Nodes
        String outFile = "output.csv";  //CSV Output file of of Nodes' Coordinate
        String EdgeRows = "";
        String PointRows = "";
        String x1="";
        String y1="";
        String x2="";
        String y2="";
        String cvsSplitBy = ",";
        
          
         
try  {
    
   BufferedReader EdgeRead = new BufferedReader(new FileReader(edgesFile)); //Edges File Read
   EdgeRows = EdgeRead.readLine();  //First Header Line Skip
   
   FileWriter fw = new FileWriter(outFile);
   PrintWriter printWriter = new PrintWriter(fw);
   printWriter.print("X1,Y1,X2,Y2");   //Output File Header
   printWriter.println();
   
           
            
            while ((EdgeRows = EdgeRead.readLine()) != null) {
                x1="";
                y1="";
                x2="";
                y2="";
                // use comma as separator
                
                
                String[] EdgeEachRow = EdgeRows.split(cvsSplitBy);
               
               ///Output Just for Debuggin
               //System.out.println(EdgeEachRow[0] + "," +EdgeEachRow[1] + "," + EdgeEachRow[2] + "," + EdgeEachRow[3]);
               //------------------------------------------------
               // 
               // For each Edge Reacord Check all the Nodes for Match
                
                BufferedReader PointsRead = new BufferedReader(new FileReader(nodesFile)); // Read points file
                PointRows = PointsRead.readLine(); //Frist Header Line Skip
                
   while ((PointRows = PointsRead.readLine()) != null){
                
               String[] PointEachRow=PointRows.split(cvsSplitBy);
                
               // Compare for the First Point
               
               if(Integer.parseInt(PointEachRow[0])==Integer.parseInt(EdgeEachRow[1]))
               {
                x1=PointEachRow[1];
                y1=PointEachRow[2];
               }
               
               // Compare for the Second Point
               
               if  (Integer.parseInt(PointEachRow[0])==Integer.parseInt(EdgeEachRow[2]))
                 {
                x2=PointEachRow[1];
                y2=PointEachRow[2];  
                             
                 }
                }
                
                System.out.println(x1+","+y1+","+x2+","+y2); //Display Output     
                //------------------------------------------------
                
                printWriter.print(x1+","+y1+","+x2+","+y2); //Write Output in File output.csv
                printWriter.println();
            }

    
    printWriter.close();
            
            
        } 
catch (IOException e) {
            e.printStackTrace();
        }

    }

}
