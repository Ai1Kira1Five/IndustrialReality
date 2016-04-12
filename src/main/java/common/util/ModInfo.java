package common.util;

import common.IModInfo;

/**
 * Created by Àðò¸ì on 11.04.2016.
 */
public class ModInfo implements IModInfo {
    public static final String MOD_NAME = "IdustrialReality";
    public static final String MOD_ID = "Idustrial_Reality";
    public static final String MOD_VERSION = "0.1.12";
    public static final String MOD_DEPENDENCUIES = "required-after:Forge@[10.13.3.1374,)";
    public static final String SERVER_PROXY_CLASS = "";
    public static final String CLIENT_PROXY_CLASS = "";
    public static final String GUI_FACTORY_CLASS = "";

    @Override
    public String MOD_NAME() {
        return "IdustrialReality";
    }

    @Override
    public String MOD_ID() {
        return "Idustrial_Reality";
    }

    @Override
    public String MOD_VERSION() {
        return "0.1.12";
    }

    @Override
    public String MOD_DEPENDENCUIES() {
        return "required-after:Forge@[10.13.3.1374,)";
    }

    public static final class Keys
    {
        public static final String CATEGORY = "";
        public static final String CONFIG = "";
    }
}
