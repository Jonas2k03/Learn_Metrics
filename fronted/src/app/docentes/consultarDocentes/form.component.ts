import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Docente } from '../listarDocentes/docente';
import { DocenteService } from '../servicios/docente.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormConsultarComponent {
  public docente: Docente = new Docente();

  constructor(private docenteService: DocenteService, private router: Router, private route: ActivatedRoute){}
  ngOnInit(): void {
    const doc_id = this.route.snapshot.paramMap.get('id');
    if(doc_id){
      this.docenteService.getDocenteById(+doc_id).subscribe( {
        next: docente =>{this.docente = docente}
      });
    }
    else{
      this.volverLista();
    }
  }
  public volverLista(): void {
    this.router.navigate(['docentes/listarDocentes']);
  }
}
