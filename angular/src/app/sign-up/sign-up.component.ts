import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  text: string;
  bool: boolean;
  something: string;

  constructor() { }

  ngOnInit() {
    this.text = "emuLadder";

    this.bool = false;
    this.something = "something";
  }

  show() {
    console.log("hello");
    this.bool = !this.bool;
  }

}
