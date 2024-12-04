import { Routes } from '@angular/router';
import { DocentesComponent } from './docentes/listarDocentes/docentes.component';
import { FormComponent } from './docentes/crearDocentes/form.component';
import { FormConsultarComponent } from './docentes/consultarDocentes/form.component';

export const routes: Routes = [
    {path: '', redirectTo: '/docentes/listarDocentes', pathMatch: 'full'},
    {path: 'docentes/listarDocentes', component: DocentesComponent},
    {path: 'docentes/consultar/:id', component: FormConsultarComponent},
    {path: 'docente/crearDocentes', component: FormComponent}
];
