/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import static com.codename1.ui.events.ActionEvent.Type.Calendar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entite.Interviews;
import com.mycompany.Service.interviewService;
import java.util.Date;




/**
 *
 * @author User
 */
public class ModifierInterview {
Form f;
     
   
    Button btnmodif;
    Button btnretour;
    public ModifierInterview()  {
        Picker datePicker = new Picker();
        datePicker.setType(Display.PICKER_TYPE_DATE);
        Picker timePicker = new Picker();
        timePicker.setType(Display.PICKER_TYPE_TIME);
       /*  timePicker.setTime(10 * 60);*/

    

    f = new Form("modifier Entretien", BoxLayout.y());
          /*  Label l=new Label("date : ");
        TextField t1 = new TextField();
        f.add(l);
        f.add(t1);
        
       Label l2=new Label("heure : ");
        TextField t2 = new TextField();
        f.add(l2);
        f.add(t2);
        */
          Label l=new Label("date : ");
                          l.getAllStyles().setFgColor(0xE35F5A);

                 l.getAllStyles().setMargin(0, 0, 1, 0);
                l.getAllStyles().setPadding(0, 0, 1, 0);
               l.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                Label l2=new Label("heure : ");
                                                l2.getAllStyles().setFgColor(0xE35F5A);

 l2.getAllStyles().setMargin(0, 0, 1, 0);
                l2.getAllStyles().setPadding(0, 0, 1, 0);
               l2.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
               
        f.add(l);

        f.add(datePicker);
        f.add(l2);
        f.add(timePicker);
            

        
          interviewService iss=new interviewService();
        Interviews s1=iss.getInterviewById(Interviews.focusedId);
      /*    t1.setText(s1.getDate());
        t2.setText(s1.getHeure_ent()) ;*/
      
       /* DateFormat formatD = new SimpleDateFormat("yyyy-MM-dd");
        Date datet = formatD.parse(s1.getDate());
        datePicker.setDate(datet);*/
       Date t;
    try {
        t = getdare(s1);
        datePicker.setDate(t);

    } catch (ParseException ex) {
    }
    
      
                timePicker.setText(s1.getHeure_ent()) ;

  
        /*
        String St = s1.getHeure_ent();
        SimpleDateFormat ft = new SimpleDateFormat("HH:mm");
        
        Date answeredTime;
        try {
        answeredTime = ft.parse(St);
        long times = answeredTime.getTime();
        timePicker.setTime((int) times);
        
        
        } catch (ParseException ex) {
        }
        
        /*SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        int s = Integer.parseInt(sdf.format(new Date()).replace(":",""));*/
 


             

                    btnretour = new Button("retour");
                    btnmodif = new Button("modifier");
                    Label testdate=new Label("La date est dépassé");
                    testdate.getAllStyles().setFgColor(0x00FF0000);


                f.add(btnretour);
                    btnretour.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
                
                AfficheInterview c = new AfficheInterview();
        c.getF().show();
            }
                     }
          );

                    f.add(btnmodif);
                    btnmodif.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
                   Date date = datePicker.getDate();
                   //System.err.println(date);Wed Jan 01 14:31:57 WAT 2020
               DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
               String strDate = dateFormat.format(date);
                         String today = dateFormat.format(new Date());

                String time = timePicker.getText();
              
              if  (today.compareTo(strDate)<0){

                 Interviews i=new Interviews(Interviews.focusedId,strDate,time);
                interviewService is=new interviewService();
                is.ModifierEntretien(i);
 
                AfficheInterview c = new AfficheInterview();
        c.getF().show();
            }
                            else f.add(testdate);

            }
                     }
          );


    }
    
        public Date getdare(Interviews s1) throws ParseException{
            DateFormat formatD = new SimpleDateFormat("yyyy-MM-dd");
        Date datet = formatD.parse(s1.getDate());
        return datet;
        }

     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
