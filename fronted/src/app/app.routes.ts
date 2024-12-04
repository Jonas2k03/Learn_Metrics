import { Routes } from '@angular/router';
import { DocentesComponent } from './docentes/listarDocentes/docentes.component';
import { FormComponent } from './docentes/crearDocentes/form.component';

export const routes: Routes = [
    {path: '', redirectTo: '/docentes/listarDocentes', pathMatch: 'full'},
    {path: 'docentes/listarDocentes', component: DocentesComponent},
    {path: 'docente/crearDocentes', component: FormComponent}
];
