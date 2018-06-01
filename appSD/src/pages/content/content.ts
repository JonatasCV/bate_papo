import { Component } from '@angular/core';
import { IonicPage, NavController } from 'ionic-angular';
import { Api } from '../../providers/api/api';
import { Observable } from 'rxjs/Observable';
import { Settings } from '../../providers';

@IonicPage()
@Component({
  selector: 'page-content',
  templateUrl: 'content.html',
  providers: [Api]
})
export class ContentPage {
  options: any;
  settingsReady = false;

  public chats: any = [];
  public acessos: any = [];
  public data: any = "{\"array\":123}";

  constructor(public navCtrl: NavController, public api: Api, public settings: Settings) {

    this.settings.load().then(() => {    
      this.settingsReady = true;
      this.options = this.settings.allSettings;
      console.log(this.options);

      this.api.get("https://" + this.options.option1 + "/chats-realizados").subscribe(result => {
        this.chats = result;
        console.log(this.chats.qtChats); 
      }); 
      this.api.get("http://" + this.options.option1 + "/usuarios-acessos-rede").subscribe(result => {
        this.acessos = result;
        console.log(this.acessos.qtAcessos);  
      }); 
    });    
  }
}