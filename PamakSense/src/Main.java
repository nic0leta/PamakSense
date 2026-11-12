
public class Main {

	public static void main(String[] args) {
		Sensor s1 = new Sensor("TomatoesNW", "D0:96:E1:8E:5E:41");
		Sensor s2 = new Sensor("TomatoesNE", "AB:C3:E7:B7:6E:33");
		Sensor s3 = new Sensor("TomatoesSW", "BD:CE:24:FA:0E:65");
		Sensor s4 = new Sensor("TomatoesSE", "EB:28:A7:71:4F:0B");
		Sensor s5 = new Sensor("TomatoesCenter", "BD:A2:E4:EE:4F:E7");
		Sensor s6 = new Sensor("Lettuce", "0A:86:C0:45:68:1D");
		Sensor s7 = new Sensor("Precise_Avocado", "FF:C6:39:61:7C:E1");
		Sensor s8 = new Sensor("FaultySensor", "BF:50:ZZ:B9:5A:81"); //invalid address format
		Zone z1 = new Zone("MyGarden", "Large garden with tomatoes and lettuce");
		PrecisionZone z2 = new PrecisionZone("SensitiveArea", "A few avocado plants");
		
		s1.connectTo(s2);
		s1.connectTo(s3);
		s2.connectTo(s5);
		s2.connectTo(s6);
		s3.connectTo(s4);
		s3.connectTo(s6);
		s4.connectTo(s5);
		s4.connectTo(s6);
		s5.connectTo(s6);
		s6.connectTo(s5);
		s4.connectTo(s4);
		s7.connectTo(s5);
		
		System.out.println("****************************************************");
		
		s1.returnCommonConnections(s6);
		
		s6.returnCommonConnections(s4);
		
		s4.printConnections();
		
		System.out.println("****************************************************");
		
		s2.printConnections();
		
		z1.addSensor(s1);
		z1.addSensor(s2);
		z1.addSensor(s3);
		z1.addSensor(s4);
		z1.addSensor(s5);
		z1.addSensor(s6);
		z1.addSensor(s7);
		
		
		System.out.println("****************************************************");
		
		z1.printSensors();
		
		z2.addSensor(s6);
		
		z2.addSensor(s7);
		
		System.out.println("****************************************************");
		
		z2.printSensors();
		
		System.out.println("****************************************************");
		
		z1.printSensors();
		
		System.out.println("****************************************************");
		
		s1.getNeighbours();

	}

}
