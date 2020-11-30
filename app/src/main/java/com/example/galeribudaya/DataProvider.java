package com.example.galeribudaya;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.example.galeribudaya.model.Budaya;
import com.example.galeribudaya.model.Rumah;
import com.example.galeribudaya.model.Tari;



public class DataProvider {
    private static List<Budaya> budayas = new ArrayList<>();
    private static List<Tari> initDataTari(Context ctx) {
        List<Tari> taris = new ArrayList<>();
        taris.add(new Tari("Jaipong", "Jawa Barat",
                "Tari Jaipong adalah salah satu jenis tari yang sangat populer di daerah Jawa Barat dan sudah dikenal juga oleh masyarakat Indonesia.  ", R.drawable.tari_jaipong));
        taris.add(new Tari("Kecak", "Bali",
                "Jenis tarian ini menggambarkan tentang cerita Pewayangan, khususnya untuk cerita Ramayana yang dipertunjukan dengan seni gerak dan tarian.", R.drawable.tari_kecak));
        taris.add(new Tari("Saman", "Gayo",
                "Tarian satu inimerupakan sebuah tarian suku Gayo yang biasa ditampilkan ketika perayaan peristiwa-peristiwa penting di dalam adat.", R.drawable.tari_saman_meuseukat));
        taris.add(new Tari("Topeng", "Jakarta",
                "Sebab kota ,yang dipenuhi dengan berbagai gedung tinggi ini juga memiliki berbagai kesenian tradisional yang unik dan dikenal hingga mancanegara.", R.drawable.tarireog_ponorogo));
        taris.add(new Tari("Ponorogo", "Jawa Timur",
                "Tarian Reog Ponorogo juga menjadi salah satu tarian daerah di Provinsi Indonesia yang akan Mamikos bahas pada kesempatan ini.", R.drawable.tari_topeng_betawi));
        return taris;
    }

    private static List<Rumah> initDataRumah(Context ctx) {
        List<Rumah> rumahs = new ArrayList<>();
        rumahs.add(new Rumah(" Nangroe Aceh", "aceh",
                "Rumah adat Nangroe Aceh Darussalam atau biasa dikenal dengan rumah adat kronge bade berasal dari Provinsi paling barat di indonesia,", R.drawable.rumah_aceh_krongbade));
        rumahs.add(new Rumah("panggung kajang leko", "jambi",
                "Rumah adat panggung kajang leko, adalah rumah  yang berasal dari provonsi Jambi. Rumah ini merupakan rumah adat yang cukup lengkap", R.drawable.rumah_jambi_panggungkajangleko));
        rumahs.add(new Rumah("gadang", "sumatra barat",
                "Rumah gadang adalah rumah adat  yang hingga kini masih banyak di temui di Provinsi Sumatra Barat. Nah rumah gadang juga ada di Malaysia,", R.drawable.rumah_sumaterabarat_gadang));
        rumahs.add(new Rumah("rakit limas", "bangka belitung",
                "Rumah adat Bangka Belitung yang merupakan daerah pulau, sehingga menambahkan pada aksen rakit, sebagai pembeda dan penanda, ", R.drawable.rumah_bangkabelitung_rakitlimas));
        rumahs.add(new Rumah("balon", "sumatra utara",
                "Rumah balon adalah rumah khas sumatera utara yang berasal dari batak. Ada juga beberapa jenis rumah balon dan memiliki gaya arsitektur rumah orang batak", R.drawable.rumah_sumaterautara_balon));
        return rumahs;
    }





    private static void initAllBudayas(Context ctx) {
        budayas.addAll(initDataTari(ctx));
        budayas.addAll(initDataRumah(ctx));

    }

    public static List<Budaya> getAllBudaya(Context ctx) {
        if (budayas.size() == 0) {
            initAllBudayas(ctx);
        }
        return  budayas;
    }

    public static List<Budaya> getBudayasByTipe(Context ctx, String jenis) {
        List<Budaya> budayaBytipe = new ArrayList<>();
        if (budayas.size() == 0) {
            initAllBudayas(ctx);
        }
        for (Budaya o : budayas) {
            if (o.getJenis().equals(jenis)) {
                budayaBytipe.add(o);
            }
        }
        return budayaBytipe;
    }

}






