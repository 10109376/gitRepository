import java.net.MalformedURLException;

import remote.service.Boxservice;

import com.caucho.hessian.client.HessianProxyFactory;


public class mainTest {
	
	public Boxservice boxService() throws MalformedURLException {
	        HessianProxyFactory hessianProxyFactoryBean = new HessianProxyFactory();
	        String url = "http://localhost:8080/box.service";
	        String aString = "aaa";
	        String bString = "bbbb";
	        System.out.println(aString+" "+bString);
	        return (Boxservice) hessianProxyFactoryBean.create(Boxservice.class, url);
	}
	
	public static void main(String[] args) {
		Boxservice bs = null;
		try {
			bs = new mainTest().boxService();
			String str = bs.getResult();
			System.out.println(str);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
