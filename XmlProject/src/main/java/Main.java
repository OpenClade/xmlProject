import java.sql.Date;

import com.company.controllers.CarController;
import com.company.controllers.InsuranceController;
import com.company.controllers.Utils;
import com.company.controllers.Xml;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;

public class Main {
	public static void main(String[] args) {
		IDB idb = new PostgresDB();
		CarController controller = new CarController(idb);
		InsuranceController icontroller = new InsuranceController(idb);
		Xml xml = new Xml(controller, icontroller);
		xml.createXml("car.xml", controller.getAllCars());
		xml.readFromXml("car.xml");
	}
}
