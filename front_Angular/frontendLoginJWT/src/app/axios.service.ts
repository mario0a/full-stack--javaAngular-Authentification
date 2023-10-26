import { Injectable } from '@angular/core';
import axios from "axios";

@Injectable({
  providedIn: 'root'
})
export class AxiosService {

  // configuration et communication avec le backend spring

  constructor() {
    // configuration et communication avec le backend spring
    axios.defaults.baseURL = "http://localhost:8080"
// configuration et par defaut ,toutes les demande post auront le header content-type comme json
    axios.defaults.headers.post["Content-Type"] = "application/json"
  }


  request(method: string,url:string,data:any): Promise<any>{
    return axios({
      method: method,
      url: url,
      data: data

    });
  }
}
