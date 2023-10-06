/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_3;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Quiz_3 {

        private Quiz_3 next;
        private int data;
        private int priority;
        static int MAX = 10;
       
        private int[] Data = new int [MAX];
       
        private int rear = -1;
        private int Front = -1;
        
    private class Quiz {
        int string;
        int data;
        int priority;
        Quiz_3 next;
    }
    
    private Quiz_3 front;
        
private void insertion (int item, int priority){
    Quiz_3 node = new Quiz_3 ();
    node.data = item;
    node.priority = priority;
    node.next = null;
    
    if (front == null || priority <= front.priority){
        node.next = front;
        front = node;
    }else {
        Quiz_3 temp = front;
        while (temp.next!= null && temp.next.priority <= priority){
        temp = temp.next;
    }  
    node. next = temp.next;
    temp.next = node;
    
    }
}

    public void insertionBeginning (int item) throws Exception{
        
        if (rear == MAX-1 ) {
            throw new Exception("Queue is full");
        }if (Front == -1) {
            Front = rear = 0;
            Data[Front] = item;
        } else {
            if (Front == 0) {
                throw new Exception("Connot"+ "insert at the beginning" + "Queue is full.");
            }
            Data[--Front] = item;
        }
        
    }
    
    public int deletionBeginning ()throws Exception{
        if (Front == -1) {
            throw new Exception ("Queue is empty");
        }
        int temp = Data[Front];
        if (Front == rear) {
            Front = rear = -1;
        }else {
            Front++;
        }
        return temp;
    }
    
    private void insertEnding(int item) throws Exception {
        if (rear == MAX-1) {
            throw new Exception("Queue is full");
        }
        Data[++rear] = item;
    }
    
    public int deletionEnding () throws Exception {
        if (Front == -1){
            throw new Exception ("Queue is empty");
        }
        
        int temp = Data[rear];
            if (Front == rear) {
                Front = rear = -1;
            }else{
                rear--;
            }
            return temp;
    }
    
    public void display () throws Exception {
        if (Front == -1) {
            throw new Exception("Queue is empty");
            
        }
        for (int i = Front; i <= rear; i++) {
            System.out.println(Data[i] + "->");
    }  
        System.out.println("NULL");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Quiz_3 quiz = new Quiz_3();
        Scanner scn = new Scanner(System.in);
        
        while (true){
            System.out.println("Choose an operation: ");
            System.out.println("1. Insert an elements");
            System.out.println("2. Insert element on beginning");
            System.out.println("3. delete element on Ending");
            System.out.println("4. delete element on Beginning");
            System.out.println("5. Insert element on Ending");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            
            int choice =  scn.nextInt();
            
            try{
                switch (choice) {
                    case 1:
                    System.out.println("Insert an elements");
                    int item1 = scn.nextInt();
                    quiz.insertion(item1, choice);
                    break;
                    
                    case 2:
                        System.out.println("Insert number at beginning: ");
                        int item2 = scn.nextInt();
                        quiz.insertionBeginning(item2);
                        break;
                        
                    case 3:
                        System.out.println("delete element on ending");
                        int item3 = scn.nextInt();
                        quiz.deletionEnding();
                        break;
                        
                    case 4:
                        System.out.println("delete number on beginning");
                        int item4 = scn.nextInt();
                        quiz.deletionBeginning();
                        break;
                        
                    case 5:
                        System.out.println("insert number on ending");
                        int item5 = scn.nextInt();
                        quiz.insertEnding(item5);
                        break;
                        
                    case 6:
                        System.out.println("Display");
                        int item6 = scn.nextInt();
                        quiz.display();
                        break;
                        
                    case 7:
                        System.out.println("Exit");
                        scn.close();
                        System.exit(0);
                        break;
                        
                    default:
                        System.out.println("Invalid choice.");
                        break;
                    
                }
            }catch (Exception e){
                System.out.println("Exception: " +e.getMessage());
            }
        }
    }
}