import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SubmitProductComponent } from './submit-product/submit-product.component';

const routes: Routes = [
  { path: 'submitProduct', component: SubmitProductComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
