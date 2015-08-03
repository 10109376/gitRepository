package remote.service.impl;

import remote.service.Boxservice;

import com.store59.rpc.utils.server.annotation.RemoteService;
import com.store59.rpc.utils.server.annotation.ServiceType;

@RemoteService(serviceType = ServiceType.HESSIAN, serviceInterface = Boxservice.class, exportPath = "/box.service")
public class BoxserviceImpl implements Boxservice {

	public String getResult() {
		return "success!";
	}

}
