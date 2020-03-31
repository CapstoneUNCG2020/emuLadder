import { Component, OnInit } from '@angular/core';

export class qa {
  question: string;
  answer: string;
}

@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {

  public qaList: Array<qa>;

  constructor() { }

  ngOnInit(): void {
    this.qaList = this.getFAQ();
  }

  getFAQ(): Array<qa> {
    let list = new Array<qa>();

    let Q = new qa();
    Q.question = 'How do I reset my password?';
    Q.answer = 'When attempting to login, you may click the \'forgot password\' link.';

    list.push(Q);

    Q = new qa();
    Q.question = 'What games are supported?';
    Q.answer = 'We currently support League of Legends, but the rest will be coming.';
    
    list.push(Q);
    Q = new qa();
    Q.question = 'What are the different game modes?';
    Q.answer = 'We currently support Head-to-Head (where a player can challenge one other' +
      ' person to a one-on-one competition) and Multiplayer (where you can choose a Public' + 
      ' or Private match to compete against a group of opponents).';
    
    list.push(Q);
    Q = new qa();
    Q.question = 'How can I invite friends to join so I can play against them?';
    Q.answer = 'When viewing a contest you have signed up for, you can click the invite button' + 
      ' to invite friends by their email address. They will be sent a link to the contest and can' + 
      ' sign up through there.';
    
    list.push(Q);
    Q = new qa();
    Q.question = 'Can I win actual money by winning tournaments?';
    Q.answer = 'Currently, we do not support real-time betting due to the restrictions of our' + 
    ' development team. However, in the future this content may be supported.';
    
    list.push(Q);
    Q = new qa();
    Q.question = 'How soon after a match is complete will I be able to view my scores?';
    Q.answer = 'Ideally you will know the second after the match finishes. However, we are' + 
      ' using the API directly from the streamers so there may be issues with latency.';
    
    list.push(Q);
    Q = new qa();
    Q.question = 'Why does the sign up page ask for my phone number?';
    Q.answer = 'In case we decide to implement the usage of real money into our platform, we' + 
      ' would like to know the contact information of the big winners in case we need to borrow' +
      ' some money.';
    
    list.push(Q);
    Q = new qa();
    Q.question = 'Is my security information secure when being transmitted on the web?';
    Q.answer = 'We do our best to ensure all credential information is stored properly. We pride' + 
      ' ourselves in our plain-text storage and unencrypted transmissions where your private ' +
      ' information will be stored securely in some database even we don\'t know the password to.';
    
    list.push(Q);

    return list;
  }

}