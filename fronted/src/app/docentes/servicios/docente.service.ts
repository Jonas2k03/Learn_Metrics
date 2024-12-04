import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Docente } from '../listarDocentes/docente';
import { Observable } from 'rxjs';
import { Signup } from '../listarDocentes/signup';

@Injectable({
  providedIn: 'root'
})
export class DocenteService {
  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  private urlEndPointList: string = 'http://localhost:5000/api/docentes';
  private urlEndPoint: string = 'http://localhost:5000/api/auth/signup';
  private enumTiposIdUrl: string = 'http://localhost:5000/api/docentes/tiposId';
  private enumTiposDocUrl: string = 'http://localhost:5000/api/docentes/tiposDoc';
  constructor(private http: HttpClient) { }
  getDocentes(): Observable<Docente[]>{
    console.log("Listando docentes desde el servicio");
    return this.http.get<Docente[]>(this.urlEndPointList);
  }
  create(signup: Signup):Observable<Signup>{
    console.log("Creando desde el servicio");
    return this.http.post<Signup>(this.urlEndPoint, signup, {headers: this.httpHeaders});
  }
  getTiposId(): Observable<string[]>{
    console.log("obteniendo lista de tipos de identificacion");
    return this.http.get<string[]>(this.enumTiposIdUrl);
  }
  getTiposDoc(): Observable<string[]>{
    console.log("obteniendo lista de tipos de docente");
    return this.http.get<string[]>(this.enumTiposDocUrl);
  }

  getDocenteById(id: number): Observable<Docente>{
    console.log("Obteniendo docente con ID: ", id);
    return this.http.get<Docente>(`${this.urlEndPointList}/${id}`)
  }
}
