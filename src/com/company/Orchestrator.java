package com.company;

import java.util.LinkedList;
import java.util.List;

enum status {
    READY, BUSY, FAIL ;
}

class Orchestrator implements Runnable {
    private static Orchestrator instance = null;

    private int Master = 1;
    private int freeMaster = 1;

    private List<Job> jobQueue = new LinkedList<>();

    // private constructor restricted to this class itself
    private Orchestrator()
    {
        System.out.println("Daemon Orchestrator started with Master = " + Master );
    }

    // static method to create instance of Singleton class
    public static Orchestrator getInstance()
    {
        if (instance == null)
            instance = new Orchestrator();

        return instance;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
                dispatchToMaster();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /* TODO: Increase/Decrease the number of master nodes */
    public void changeMasterSize(int newSize) {

    }

    /* TODO: Remove Job from Job Queue */
    public void removeJob(int jobID) {

    }

    /* TODO: Try to save all the job status and shutdown myself gracefully   */
    public void shutdown() {

    }


    public void addToQueue(Job job) {
        jobQueue.add(job);
    }

    /* TODO: Display the current status of the whole system */
    public void displayStatus (){
    }


    /* TODO: Create new Master if there are task in the queue */
    private void dispatchToMaster(){
        while(jobQueue.size() > 0 && freeMaster > 0) {
        }
    }

}
