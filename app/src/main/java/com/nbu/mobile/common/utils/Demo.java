package com.nbu.mobile.common.utils;

import com.nbu.mobile.R;
import com.nbu.mobile.mobile.models.UniversalPartners;

import java.util.ArrayList;

/**
 * Created by macbookpro on 03.09.17.
 */

public class Demo {


    public static ArrayList<UniversalPartners> partners;

    static {
        partners = new ArrayList<>();
        partners.add(new UniversalPartners(1,1,"Beeline", R.mipmap.ic_launcher_round,null));
        partners.add(new UniversalPartners(1,2,"UMS", R.mipmap.ic_launcher_round,null));
        partners.add(new UniversalPartners(1,3,"Ucell", R.mipmap.ic_launcher_round,null));
        partners.add(new UniversalPartners(1,4,"Perfectum Mobile", R.mipmap.ic_launcher_round,null));
        partners.add(new UniversalPartners(1,5,"UzMobile", R.mipmap.ic_launcher_round,null));
    }
}
