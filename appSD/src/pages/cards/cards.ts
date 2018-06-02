import { Component } from '@angular/core';
import { IonicPage, NavController } from 'ionic-angular';
import { Api } from '../../providers/api/api';
import { Settings } from '../../providers';

@IonicPage()
@Component({
  selector: 'page-cards',
  templateUrl: 'cards.html'
})
export class CardsPage {
  cardItems: any[];
  items: any;
  options: any;
  settingsReady = false;

  constructor(public navCtrl: NavController, public api: Api, public settings: Settings) {
    this.settings.load().then(() => {    
      this.settingsReady = true;
      this.options = this.settings.allSettings;

      this.api.get("https://" + this.options.option1 + "/topicos-mais-acessados").subscribe(result => {
        this.items = result;
        for(let i=0; i<this.items.length; i++){
          if(this.items[i].nometopico == "Eleições 2018") this.items[i].image = 'assets/img/Image1.jpg'  ;
          if(this.items[i].nometopico == "Multas de trânsito") this.items[i].image = 'assets/img/Image5.jpg';
          if(this.items[i].nometopico == "Sistema nacional de saúde") this.items[i].image = 'assets/img/Image3.jpg';
          if(this.items[i].nometopico == "Preço da gasolina") this.items[i].image = 'assets/img/Image4.jpg';
          if(this.items[i].nometopico == "Segurança pública") this.items[i].image = 'assets/img/Image8.jpg';
          if(this.items[i].nometopico == "Educação") this.items[i].image = 'assets/img/Image6.jpg';
          if(this.items[i].nometopico == "Traição") this.items[i].image = 'assets/img/Image7.jpg';
          if(this.items[i].nometopico == "Aposentadoria") this.items[i].image = 'assets/img/Image2.jpg';
        }   
      }); 
    }); 
  }
}
/*    this.cardItems = [
      {
        name: 'Eleições 2018',
        date: 'November 5, 1955',
        image: 'assets/img/image1.jpg',
        content: 'Wait a minute. Wait a minute, Doc. Uhhh... Are you telling me that you built a time machine... out of a DeLorean?! Whoa. This is heavy.',
        acessos: "2222",
        chats : "6510"
      },
      { 
        name: 'Aposentadoria',
        date: 'May 12, 1984',
        image: 'assets/img/image2.jpg',
        content: 'I face the unknown future, with a sense of hope. Because if a machine, a Terminator, can learn the value of human life, maybe we can too.',
        acessos: "56783",
        chats : "1043"
      },
      {
        name: 'Sistema Nacional de Saúde',
        date: 'June 28, 1990',
        image: 'assets/img/image3.jpg',
        content: 'Your scientists were so preoccupied with whether or not they could, that they didn\'t stop to think if they should.',
        acessos: "567",
        chats : "1043"
      },
      {
        name: 'Preço da Gasolina',
        date: 'June 28, 1990',
        image: 'assets/img/image4.jpg',
        content: 'Your scientists were so preoccupied with whether or not they could, that they didn\'t stop to think if they should.',
        acessos: "87",
        chats : "1120"
      },
      {
        name: 'Multas de Trânsito',
        date: 'June 28, 1990',
        image: 'assets/img/image5.jpg',
        content: 'Your scientists were so preoccupied with whether or not they could, that they didn\'t stop to think if they should.',
        acessos: "1222",
        chats : "10"
      },
      {
        name: 'Educação',
        date: 'June 28, 1990',
        image: 'assets/img/image6.jpg',
        content: 'Your scientists were so preoccupied with whether or not they could, that they didn\'t stop to think if they should.',
        acessos: "33112",
        chats : "1054"
      },
      {
        name: 'Traição',
        date: 'June 28, 1990',
        image: 'assets/img/image7.jpg',
        content: 'Your scientists were so preoccupied with whether or not they could, that they didn\'t stop to think if they should.',
        acessos: "433",
        chats : "140"
      },
      {
        name: 'Segurança Pública',
        date: 'June 28, 1990',
        image: 'assets/img/image8.jpg',
        content: 'Your scientists were so preoccupied with whether or not they could, that they didn\'t stop to think if they should.',
        acessos: "154",
        chats : "1210"
      }
      ];*/



