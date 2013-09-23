package openbaas;

import com.example.openbaas.Openbaas;

import android.app.Application;

public class Baas extends Application {

	public Openbaas openbaas;
	private static Baas singleton;
    public static Baas getInstance() {
    	if (singleton == null){
    		singleton = new Baas();
        }
        return singleton;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
    public Openbaas getOpenbaas(){
    	return openbaas;
    }
    private Baas(){
    	 openbaas = new Openbaas();
    }
}
