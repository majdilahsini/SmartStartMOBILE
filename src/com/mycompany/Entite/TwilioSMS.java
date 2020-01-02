package com.mycompany.Entite;



import com.codename1.components.ToastBar;
import com.codename1.io.Log;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.ui.FontImage;
import com.codename1.util.Base64;
import com.codename1.util.Callback;
import java.util.Map;

/**
 * Sends an SMS via the Twilio REST API
 *
 * @author Shai Almog
 */
public class TwilioSMS {
    private String accountSID;
    private String authToken;
    private String fromPhone;
    
    public TwilioSMS(String accountSID, String authToken, String fromPhone) {
        this.accountSID = accountSID;
        this.authToken = authToken;
        this.fromPhone = fromPhone;
    }
    
    /**
     * Create an instance of the SMS API
     * 
     * @param accountSID the account id
     * @param authToken the authorization token
     * @param fromPhone the phone from which we are sending
     * @return twilio instance
     */
    public static TwilioSMS create(String accountSID, String authToken, String fromPhone) {
        return new TwilioSMS(accountSID, authToken, fromPhone);
    }
    
    /**
     * Sends an SMS using the twilio API asynchronously
     * @param phone the phone we are sending to
     * @param body the body of the sms
     */
    public void sendSmsAsync(String phone, String body) {
        Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + 
                    "/Messages.json").
                queryParam("To", phone).
                queryParam("From", fromPhone).
                queryParam("Body", body).
                header("Authorization", "Basic " + Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
                getAsJsonMapAsync(new Callback<Response<Map>>() {

            @Override
            public void onSucess(Response<Map> value) {
                if(value.getResponseData() != null) {
                    String error = (String)value.getResponseData().get("error_message");
                    if(error != null) {
                        ToastBar.showErrorMessage(error);
                    }
                } else {
                    ToastBar.showErrorMessage("Error sending SMS: " + value.getResponseCode());
                }
            }

            @Override
            public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                ToastBar.showErrorMessage("Error sending SMS: " + errorCode);
                Log.e(err);
            }
        });
    }        
   
    /**
     * Sends an SMS using the twilio API synchronously
     * @param phone the phone we are sending to
     * @param fromPhone the phone from which we are sending
     * @param body the body of the sms
     */
    public void sendSmsSync(String phone, String fromPhone, String body) {
        Response<Map> value = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + 
                    "/Messages.json").
                queryParam("To", phone).
                queryParam("From", fromPhone).
                queryParam("Body", body).
                header("Authorization", "Basic " + Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
                getAsJsonMap();

        if(value.getResponseData() != null) {
            String error = (String)value.getResponseData().get("error_message");
            if(error != null) {
                ToastBar.showErrorMessage(error);
            }
        } else {
            ToastBar.showErrorMessage("Error sending SMS: " + value.getResponseCode());
        }
    }        
   
}