public class Battery {
    private double cRate = 0.1;
    private double rRate = 0.2;
    private double charge = 0.0;

    //add the attributes for class Battery


    //No Parameter Constructor
    //set the attributes with default value
    public Battery(){
    }

    public Battery(double cRate,double rRate){
        this.cRate = cRate;
        this.rRate = rRate;
    }

    public double getConsumptionReate(){
        return this.cRate;
    }

    public double getProductionReate(){
        return this.rRate;
    }


    //冲 p 电量
    //charge power which amount is p
    public void chargeBattery(double p) {
        if (p + this.charge >= 1.0) {
            this.charge = 1;
        } else {
            this.charge += p;
        }
    }
    //如果剩余电量》=p，使用 p电量，返回true，否则剩余电量=0，返回false
    //if the remaining power amount is larger than p, consume the p power and return true;
    //else the remaining power become 0 and return false;
    public boolean useBattery(double p){
        if (this.charge >= p) {
            this.charge -= p;
            return true;
        } else {
            this.charge = 0.0;
            return false;
        }
    }

}
