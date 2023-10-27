import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

  //creation du formulaire de connexion
// on cree un champ de sortie
  // de cette facon, la methode submit sera dans le composant content, dans le composant parent.
  //Ainsi, avoir la demande de connexion dans le composant parent me permet de gerer la réponse et de passer
  // du formulaire de connexion au composant de contenu d'authentification une fois authentifié
  @Output() onSubmitLoginEvent = new EventEmitter();

  // on cree les variables qui contiendront le login et le mot de passe.
  login: string ="";
  password: string = "";

  // cette methode permettra d'emettre la variable de sortie
  onSubmitLogin(): void {
    this.onSubmitLoginEvent.emit({"login": this.login,"password": this.password}); // pour afficher un formulaire, on doit ajouter un nouveau module dans app.module.ts
  }

}
