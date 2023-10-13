public class Torch {
    //add attibutes for torch


    Battery battery;
    public Torch(Battery battery){
        //add code here
        this.battery = battery;
    }

    /**
     * 10% power consumption per hour for using a torch
     * return true if enough power
     * return false if battery cannot support for the specified hours
     */
    public boolean turnOn(int hours){
        //add code here
        return this.battery.useBattery(hours * battery.getConsumptionReate());
    }
    /**
     * 20% power production per hour for charging the battery
     */
    public void charge(int hours){
        //add code here
        this.battery.chargeBattery(hours * battery.getProductionReate());
    }

}
