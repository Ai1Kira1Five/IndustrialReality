package common.util;

import common.interfaces.ICompatModule;

import java.util.ArrayList;

/**
 * Created by ���� on 11.04.2016.
 */
public class CompatManager {
    public ArrayList<ICompatModule> compatModules = new ArrayList();
    public static CompatManager INSTANCE = new CompatManager();
    //public static boolean isIC2Loaded = false;
    //public static boolean isIC2ClassicLoaded = false;
    //public static boolean isClassicEnet = false;
    //public static boolean isGregTechLoaded = false;

	/*public CompatManager()
	{
		if(isIC2Loaded = Loader.isModLoaded("IC2")){
			System.out.println("Fuck eah!");
		}
		//isIC2ClassicLoaded = IC2Classic.isIc2ClassicLoaded();

	}
	*/
}
