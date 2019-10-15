public abstract class Car{
     EngineBehavior engineBehavior;
     FuelBehavior fuelBehavior;
     
     public void performEngineRev(){
         EngineBehavior.rev()
     }
          
}
          
public Interface EngineBehavior():
     public void rev();
     
     
public Class ElectricMotor implements EngineBehavior(){
     public void rev(){
          System.out.println("<<silence>>")
     }
}

public Class DieselEngine implements EngineBehavior(){
     public void rev(){
          System.out.println("VROOOOOOOM!!! I'm a Cummins, bitch!")
     }
}