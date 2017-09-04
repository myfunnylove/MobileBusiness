package com.nbu.mobile.common.utils;

import com.nbu.mobile.R;
import com.nbu.mobile.mobile.models.Balance;
import com.nbu.mobile.mobile.models.News;
import com.nbu.mobile.mobile.models.Report;
import com.nbu.mobile.mobile.models.UniversalPartners;

import java.util.ArrayList;

/**
 * Created by macbookpro on 03.09.17.
 */

public class Demo {


    public static ArrayList<UniversalPartners> partners;

    static {
        partners = new ArrayList<>();
        partners.add(new UniversalPartners(1,1,"Beeline", R.drawable.beeline,null));
        partners.add(new UniversalPartners(1,2,"UMS", R.drawable.ums,null));
        partners.add(new UniversalPartners(1,3,"Ucell", R.drawable.ucell,null));
        partners.add(new UniversalPartners(1,4,"Perfectum Mobile", R.drawable.perfectum,null));
        partners.add(new UniversalPartners(1,5,"Texnomart Kredit", R.drawable.texnomart,null));
        partners.add(new UniversalPartners(1,4,"Perfectum Mobile", R.drawable.perfectum,null));
        partners.add(new UniversalPartners(1,2,"UMS", R.drawable.ums,null));


    }

    public static ArrayList<News> news;

    static {
        news = new ArrayList<>();
        news.add(new News(1,"Panasonic o‘zi yegulik keltirib beradigan kelajak sovitgichini taqdim etdi","Panasonic kompaniyasi Berlindagi IFA ko‘rgazmasida ovoz yordamida chaqirish mumkin bo‘lgan sovitgich robotni taqdim etdi, deb yozadi “Hi-tech.mail.ru”.", "Panasonic kompaniyasi Berlindagi IFA ko‘rgazmasida ovoz yordamida chaqirish mumkin bo‘lgan sovitgich robotni taqdim etdi, deb yozadi “Hi-tech.mail.ru”."));
        news.add(new News(1,"Qozog‘istonda ommaviy tartibsizliklardan so‘ng WhatsApp o‘chirib qo‘yildi","2-sentabr kechki soatlarda Ostonadagi Abu Dhabi Plaza nomli yangi qurilayotgan kompleks yonida ommaviy tartibsizliklar ro‘y berdi. Tartibsizliklar ishtirokchilari tarqalgach, mamlakatda WhatsApp messenjeri ishlamay qoldi. Bu haqda TJournal xabar bermoqda.", "2-sentabr kechki soatlarda Ostonadagi Abu Dhabi Plaza nomli yangi qurilayotgan kompleks yonida ommaviy tartibsizliklar ro‘y berdi. Tartibsizliklar ishtirokchilari tarqalgach, mamlakatda WhatsApp messenjeri ishlamay qoldi. Bu haqda TJournal xabar bermoqda."));
        news.add(new News(1,"OAV: Olimlar mitti galaktikadan kelayotgan 15 ta radiosignalni qayd etdi","Breakthrough Listen loyihasi doirasida ishlayotgan bir guruh olimlar Yerdan uch milliard yorug‘lik yili uzoqlikda bo‘lgan kichik galaktikadan kelayotgan 15 ta sirli radiosignalni qayd etdi. Bu haqda “TASS” xabar bermoqda.", "Breakthrough Listen loyihasi doirasida ishlayotgan bir guruh olimlar Yerdan uch milliard yorug‘lik yili uzoqlikda bo‘lgan kichik galaktikadan kelayotgan 15 ta sirli radiosignalni qayd etdi. Bu haqda “TASS” xabar bermoqda."));
        news.add(new News(1,"Qozog‘istonda ommaviy tartibsizliklardan so‘ng WhatsApp o‘chirib qo‘yildi","2-sentabr kechki soatlarda Ostonadagi Abu Dhabi Plaza nomli yangi qurilayotgan kompleks yonida ommaviy tartibsizliklar ro‘y berdi. Tartibsizliklar ishtirokchilari tarqalgach, mamlakatda WhatsApp messenjeri ishlamay qoldi. Bu haqda TJournal xabar bermoqda.", "2-sentabr kechki soatlarda Ostonadagi Abu Dhabi Plaza nomli yangi qurilayotgan kompleks yonida ommaviy tartibsizliklar ro‘y berdi. Tartibsizliklar ishtirokchilari tarqalgach, mamlakatda WhatsApp messenjeri ishlamay qoldi. Bu haqda TJournal xabar bermoqda."));
        news.add(new News(1,"OAV: Olimlar mitti galaktikadan kelayotgan 15 ta radiosignalni qayd etdi","Breakthrough Listen loyihasi doirasida ishlayotgan bir guruh olimlar Yerdan uch milliard yorug‘lik yili uzoqlikda bo‘lgan kichik galaktikadan kelayotgan 15 ta sirli radiosignalni qayd etdi. Bu haqda “TASS” xabar bermoqda.", "Breakthrough Listen loyihasi doirasida ishlayotgan bir guruh olimlar Yerdan uch milliard yorug‘lik yili uzoqlikda bo‘lgan kichik galaktikadan kelayotgan 15 ta sirli radiosignalni qayd etdi. Bu haqda “TASS” xabar bermoqda."));
        news.add(new News(1,"Panasonic o‘zi yegulik keltirib beradigan kelajak sovitgichini taqdim etdi","Panasonic kompaniyasi Berlindagi IFA ko‘rgazmasida ovoz yordamida chaqirish mumkin bo‘lgan sovitgich robotni taqdim etdi, deb yozadi “Hi-tech.mail.ru”.", "Panasonic kompaniyasi Berlindagi IFA ko‘rgazmasida ovoz yordamida chaqirish mumkin bo‘lgan sovitgich robotni taqdim etdi, deb yozadi “Hi-tech.mail.ru”."));


    }
    public static ArrayList<Balance> balance;

    static {
        balance = new ArrayList<>();
        balance.add(new Balance("1 000 000 sum","8600 31** **** **21","11/19"));
        balance.add(new Balance("765 000 sum","8600 31** **** **21","11/19"));
        balance.add(new Balance("1 000 sum","8600 31** **** **21","11/19"));
;

    }
    public static ArrayList<Report> report;

    static {
        report = new ArrayList<>();

        report.add(new Report(1,12,"Beeline",R.drawable.beeline,"May 10 2016 12:00","5 000 sum",Report.SUCCESS));
        report.add(new Report(1,12,"UMS",R.drawable.ums,"May 10 2016 12:00","1 000 sum",Report.SUCCESS));
        report.add(new Report(1,12,"UzMobile",R.drawable.texnomart,"May 10 2016 12:00","50 000 sum",Report.WAITING));
        report.add(new Report(1,12,"Beeline",R.drawable.beeline,"May 10 2016 12:00","15 000 sum",Report.ERROR));
        report.add(new Report(1,12,"Perfectum Mobile",R.drawable.perfectum,"May 10 2016 12:00","500 000 sum",Report.SUCCESS));
        report.add(new Report(1,12,"Texnomart",R.drawable.ucell,"May 10 2016 12:00","500 sum",Report.ERROR));
    }
}
