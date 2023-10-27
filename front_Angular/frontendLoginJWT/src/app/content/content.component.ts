import { Component } from '@angular/core';
import { AxiosService} from "../axios.service";

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent {
// on ajoute le Axios service et on l'injecte dans le constructeur

  constructor(private axiosService: AxiosService) {
  }

  onLogin(input: any) { // mothode appelé et utilisé dans le contentcomponent
    //on demande le endpoint de connexion
    this.axiosService.request(
      "POST",
      "/login",
      {
        login: input.login,
        password: input.password
      }
    );
  }
}
