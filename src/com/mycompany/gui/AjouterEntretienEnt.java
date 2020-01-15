/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import static com.codename1.ui.events.ActionEvent.Type.Calendar;
import static com.codename1.ui.events.ActionEvent.Type.Response;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.util.Base64;
import com.mycompany.Entite.Interviews;
import com.mycompany.Entite.OffreEnt;
import com.mycompany.Entite.TwilioSMS;
import com.mycompany.Service.OffreEntService;
import com.mycompany.Service.interviewService;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author User
 */
public class AjouterEntretienEnt {
    Form f;
     
   
    Button btnmodif;
    Button btnajout;
    Button retour;

    public AjouterEntretienEnt()  {
        
        Form n  = createDemo();
Picker datePicker = new Picker();
        datePicker.setType(Display.PICKER_TYPE_DATE);
        Picker timePicker = new Picker();
        timePicker.setType(Display.PICKER_TYPE_TIME);
        
    f = new Form("Ajouter entretien", BoxLayout.y());
            Label l=new Label("date : ");
        TextField t1 = new TextField();
         l.getAllStyles().setMargin(0, 0, 1, 0);
                l.getAllStyles().setPadding(0, 0, 1, 0);
               l.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
        f.add(l);
                f.add(datePicker);

       Label l2=new Label("heure : ");
        TextField t2 = new TextField();
         l2.getAllStyles().setMargin(0, 0, 1, 0);
                l2.getAllStyles().setPadding(0, 0, 1, 0);
               l2.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
        f.add(l2);
        
                       
        f.add(timePicker);

        btnajout = new Button("ajouter");
        /////////////
                    Label testdate=new Label("La date est dépassé");
                    testdate.getAllStyles().setFgColor(0x00FF0000);

       Date date = datePicker.getDate();
               DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                              String strDate = dateFormat.format(date);

       String today = dateFormat.format(new Date());
//get the other date into a string

    /*   Validator v = new Validator() ;  

v.addConstraint(datePicker,new Constraint() {
       @Override
            public boolean isValid(Object value) {
     boolean res = false;
                         Date birthday ;
                         birthday.setTime((Date) value);

                   boolean newdate = (today.compareTo(strDate)>0);
                    if (newdate = true ) {
                        res = true;
                    
                }
                return res;          
            }
            @Override
            public String getDefaultFailMessage() {
                return "Cette date est déja depassé";
                
            }

         
        });
        v.addSubmitButtons(btnajout);

*/

//////////
                    
                    f.add(btnajout);
                    btnajout.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
                Date date = datePicker.getDate();
               DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
               String strDate = dateFormat.format(date);
               
                String time = timePicker.getText();
              if  (today.compareTo(strDate)<0){
                Interviews i=new Interviews(OffreEnt.focusedId, strDate,time);
                interviewService is=new interviewService();
                is.AjouterEntretien(i);
 ///////////////////////////////////
 /*String accountSID = "ACdc77affecc39c811afbb3fe81b3beed0";
String authToken = "03ec4f223bf7db5c491232febb28efde";
String fromPhone = "+13306178577";
                 Response<Map> result = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + "/Messages.json").
        queryParam("To","+21655460783").
        queryParam("From", fromPhone).
        queryParam("Body", "Félicitation vous étes selectioné pour un entretien "+"\n"+"avec l'Entreprise:"+OffreEnt.focusedNomEntre+"\n"+"pour le Poste:"+"\n"+OffreEnt.focusedPoste+"\n"+"Heure:"+time+"\n"+"Date:"+"\n"+strDate+"\n").
        header("Authorization", "Basic " + Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
        getAsJsonMap();
               */
    TwilioSMS sms=new TwilioSMS("ACaa1a4f312d916842b47cd283604a4b74","1392160125d5296e5eac8e2704fae690","+12054303463");
            sms.sendSmsAsync("+21652003948","Félicitation vous étes selectioné pour un entretien "+"\n"+"avec l'Entreprise:"+OffreEnt.focusedNomEntre+"\n"+"pour le Poste:"+"\n"+OffreEnt.focusedPoste+"\n"+"Heure:"+time+"\n"+"Date:"+"\n"+strDate+"\n");
            
                 ////////////////

                
                
             //   n.show();
                AfficheInterview3 c = new AfficheInterview3();
        c.getF().show();
              }
              else f.add(testdate);
            }
                     }
          );
                    
                    retour = new Button("retour");

                    
                    f.add(retour);
                    retour.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
               
                AfficheOffres_Ent c = new AfficheOffres_Ent();
        c.getF().show();
            }
                     }
          );
                    
                    


    }
    public Form createDemo() {
    Form message = new Form(new BoxLayout(BoxLayout.Y_AXIS));        
    ComponentGroup gp = new ComponentGroup();
    message.addComponent(gp);
    
    final TextField to = new TextField("");
    to.setHint("TO:");
    gp.addComponent(to);

    final TextField subject = new TextField("Codename One Is Cool");
    subject.setHint("Subject");
    gp.addComponent(subject);
    final TextField body = new TextField("Try it out at http://www.codenameone.com/");
    body.setSingleLineTextArea(false);
    body.setRows(4);
    body.setHint("Message Body");
    gp.addComponent(body);
    
    ComponentGroup buttonGroup = new ComponentGroup();
    Button btn = new Button("Send");
    buttonGroup.addComponent(btn);
    message.addComponent(buttonGroup);
    btn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            Message msg = new Message(body.getText());
            Display.getInstance().sendMessage(new String[] {to.getText()}, subject.getText(), msg);
        }
    });
        return message;
    }
    
        public void afficherModif(int ref){
        }

     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
