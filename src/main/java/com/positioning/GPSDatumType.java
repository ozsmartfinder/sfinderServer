package com.positioning;

public enum GPSDatumType {
	
	SECUMORE_G03(1),
    UBLOX_C030(2),
    SQUAD_ARDUINO(3);

    private int _type ;

    private GPSDatumType(int type) {
        this._type = type;
    }
    
    public int getGPSDatumType() {
    	return this._type;
    }

    @Override
    public String toString() {
        return String.valueOf (this._type);
    }

}
