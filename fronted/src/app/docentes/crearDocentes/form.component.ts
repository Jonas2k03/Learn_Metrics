import { Component } from '@angular/core';
import { Docente } from '../listarDocentes/docente';
import { DocenteService } from '../servicios/docente.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module} from '@sweetalert2/ngx-sweetalert2';
import Swal from 'sweetalert2';
import { HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule, SweetAlert2Module, HttpClientModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  public docente: Docente = new Docente();
  public titulo: String = 'Crear docente';

  constructor(private docenteService: DocenteService, private router:Router){}
  public crearDocente(){
    console.log("Creando docente");
    this.docenteService.create(this.docente).subscribe(
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
