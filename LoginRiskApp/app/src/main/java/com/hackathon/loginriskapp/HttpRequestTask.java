package com.hackathon.loginriskapp;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by edge on 11/03/17.
 */

class HttpRequestTask extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String ...data) {
        URL url;
            HttpURLConnection client = null;
            OutputStream output = null;
            InputStream input = null;

        try {
            url = new URL(data[0]);

            client = (HttpURLConnection) url.openConnection();


            client.setReadTimeout( 10000 /*milliseconds*/ );
            client.setConnectTimeout( 15000 /* milliseconds */ );
            client.setDoInput(true);
            client.setDoOutput(true);

            client.setRequestMethod("POST");
            client.setRequestProperty("accept", "application/json");
            client.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            client.setChunkedStreamingMode(0);
            //client.setFixedLengthStreamingMode(data[1].getBytes().length);

            client.connect();

            output = new BufferedOutputStream(client.getOutputStream());

            writeStream(output, new JSONObject(data[1]).toString()); //data[1]);

            input = new BufferedInputStream(client.getInputStream());

            readStream(input);

        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (client != null) {
                client.disconnect();
                try {
                    if (output != null)
                        output.close();
                    if (input != null)
                        input.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //Do anything with response..
    }


    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }

    private void writeStream(OutputStream output, String data) {

        try {

            output.write(data.getBytes());

        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                output.flush();
            } catch(IOException ex) {
                System.out.println(ex);
            }
        }
    }
}
