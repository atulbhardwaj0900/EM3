package main.taskem.com.agri.Utils;


import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class AssetReader {
    public static String LoadData(String inFile, Context context) {
        String tContents = "";

        try {
            InputStream stream = context.getAssets().open(inFile);

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
        }

        return tContents;

    }
}
