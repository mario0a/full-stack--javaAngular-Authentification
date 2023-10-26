import { Component } from '@angular/core';
import {  AxiosService} from "../axios.service";


@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent {

  //creation d'une variable dans laquelle on stockera la reponse du backend
  data: string[] = [];
  //on injecte le services Acios dans le constructeur.
  constructor(private axiosService: AxiosService) {}

  // on requete le backend à l'initialisation de ce composant
  // on appelle la methode de requete du service Axios

  ngOnInit(): void {
    //c'est une methode get pour le endpoint (controlleur message) des messages, sans argument.
    this.axiosService.request(
      "GET",
      "/messages",
      {}

    ).then(// on stoke la reponse dans la variable data
      (response)=> this.data =response.data
    )
    ;

  }

}
