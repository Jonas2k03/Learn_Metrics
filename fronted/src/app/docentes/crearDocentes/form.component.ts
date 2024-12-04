import { Component } from '@angular/core';
import { Docente } from '../listarDocentes/docente';
import { DocenteService } from '../servicios/docente.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module} from '@sweetalert2/ngx-sweetalert2';
import Swal from 'sweetalert2';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Signup } from '../listarDocentes/signup';


@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule, SweetAlert2Module, HttpClientModule, CommonModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  public docente: Docente = new Docente();
  public signup: Signup = new Signup();
  public titulo: String = 'Crear docente';
  public tipoDeIdentificacion: string[] = [];
  public tipoDeDocente: string[] = [];

  constructor(private docenteService: DocenteService, private router:Router){}

  ngOnInit(): void {
    this.docenteService.getTiposId().subscribe(
      (tipoDeIdentificacion) => this.tipoDeIdentificacion = tipoDeIdentificacion
    );
    this.docenteService.getTiposDoc().subscribe(
      (tipoDeDocente) => this.tipoDeDocente = tipoDeDocente
    );
  }
  public crearDocente(){
    console.log("Creando docente");
    console.log("Datos a enviar:", this.signup);
    this.docenteService.create(this.signup).subscribe(
      response =>
      {
        console.log("Docente creado exitosamente");
        console.log(this.docente);
        this.router.navigate(['docentes/listarDocentes']);
        Swal.fire('Nuevo docente creado con éxito!', 'success');
      }
    )
  }
}
