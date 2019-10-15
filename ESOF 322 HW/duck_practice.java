public abstract class Car():
     EngineBehavior engineBehavior;
     FuelBehavior fuelBehavior;
     
     public Car():
          public void performEngineRev():
          
          
public Interface EngineBehavior():
     public void rev();
     
     
public Class ElectricMotor implements EngineBehavior():
     public void rev():
          System.out.println("<<silence>>")
          