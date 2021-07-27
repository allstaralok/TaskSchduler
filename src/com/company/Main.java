package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Orchestrator orchestrator = Orchestrator.getInstance();
        Thread daemon = new Thread(orchestrator);
        daemon.setDaemon(true);
        daemon.start();
        int i=0;
        while(true) {
            System.out.println("1. Add New Job To Queue");
            System.out.println("2. Display Job Status");
            System.out.println("3. Change Master Size");
            System.out.println("4. Remove Job from Queue"); /* If not picked by master */
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            if(choice == 1) {
                System.out.println("Enter the n");
                int n = scanner.nextInt();
                orchestrator.addToQueue(new Job(n));
            }
            else if(choice == 2) {
                orchestrator.displayStatus();
            }
            else if(choice == 3) {
                System.out.println("Enter the new Master Size");
                int size = scanner.nextInt();
                orchestrator.changeMasterSize(size);
            }
            else if(choice == 4) {
                System.out.println("Enter the Job ID");
                int jobID = scanner.nextInt();
                orchestrator.removeJob(jobID);
            }
            else if(choice == 5) {
                System.out.println("Enter the Job ID");
                orchestrator.shutdown();

            }
            else {
                System.out.println("Wrong Choice");
            }

        }
    }
}
