//package basic.thread;
//
//import java.util.HashMap;
//import java.util.concurrent.Callable;
//import java.util.concurrent.CompletionService;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorCompletionService;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
//import org.apache.commons.lang.StringUtils;
//
//import com.chinaway.address.boundary.service.impl.GeoBoundaryServiceImpl.GMapResultTask;
//import com.chinaway.base.NamedThreadFactory;
//import com.chinaway.geo.GMapResult;
//
//public class ExecutorDemo {
//	
//	ExecutorService executorCode = Executors.newFixedThreadPool(15, new NamedThreadFactory("GeoBoundary Code",true));
//	@Override
//	public HashMap<String, GMapResult> location(String lnglats,String orgcode){
//		String ss1[] = StringUtils.split(lnglats, ";");
//		HashMap<String, GMapResult> map = new HashMap<String, GMapResult>();
//		CompletionService<GMapResult> execcomp = new ExecutorCompletionService<GMapResult>(executorCode);
//		for (int i=0; i<ss1.length; i++) {
//			String ss2[] = StringUtils.split(ss1[i], ",");
//			
//			//角标越界
//			if(ss2.length != 2 || StringUtils.isBlank(ss2[0])){
//				continue;
//			}
//			
//			double lat = Double.parseDouble(ss2[0]);
//			double lng = Double.parseDouble(ss2[1]);
//			
//			if(lat>lng){
//				double tmp = lat;
//				lat = lng;
//				lng = tmp;
//			}
//			execcomp.submit(new GMapResultTask(lat, lng,orgcode));
//		}
//		for (int i=0; i<ss1.length; i++) {
//			try {
//				Future<GMapResult> future = execcomp.take();
//				GMapResult result = future.get();
//				if(StringUtils.isNotBlank(result.getCityCode())){
//					map.put(result.getLatitude()+"-" +result.getLongitude(),result);
//				}
//			} catch (InterruptedException e) {
//				log.info("boundary code  InterruptedException ",e);
//			}catch(ExecutionException e){
//				log.info("boundary code  ExecutionException",e);
//			}
//		}
//		return map;
//	}
//	class GMapResultTask implements Callable<GMapResult>{
//		private double lat;
//		private double lng;
//		private String orgcode;
//		public GMapResultTask(double lat,double lng,String orgcode){
//			this.lat = lat;
//			this.lng = lng;
//			this.orgcode = orgcode;
//		}
//		@Override
//		public GMapResult call() throws Exception {
//			return location(lat,lng,orgcode);
//		}
//	}
//
//}
