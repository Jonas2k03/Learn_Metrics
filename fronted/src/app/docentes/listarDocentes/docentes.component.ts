import { Component } from '@angular/core';
import { Docente } from './docente';
import { DocenteService } from '../servicios/docente.service';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-docentes',
  standalone: true,
  imports: [CommonModule, RouterLink, HttpClientModule],
  templateUrl: './docentes.component.html',
  styleUrl: './docentes.component.css'
})
export class DocentesComponent {
  docentes: Docente[]=[];
  docenteSeleccionado: Docente | undefined;

  constructor(private objDocenteService: DocenteService, private router: Router){}

  ngOnInit(): void{
    this.objDocenteService.getDocentes().subscribe
    (
      docentes => {
        console.log("listando docentes");
        this.docentes = docentes;
      }
    );
  }
  setDocenteSeleccionado(docente: Docente) {
    this.docenteSeleccionado = docente;
}
  consultarDocente(doc_id: number): void {
    this.router.navigate(['/docentes/consultar',doc_id]);
  }
}
