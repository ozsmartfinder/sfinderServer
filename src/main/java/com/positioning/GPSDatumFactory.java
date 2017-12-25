package com.positioning;

//Simple factory model to make protocols
public class GPSDatumFactory {
	public GPSDatum getGPSDatum(String datum, int type) {
		switch(type) {
		    case 1:
			    return new GPSDatum_Secumore_G03(datum);
		    default:
			    break;
		}
		
		return null;
			
	}

}
