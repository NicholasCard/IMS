import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { ProductsCategoryComponent } from './products-category/products-category.component';
const routes: Routes = [
  {path: 'products', component:ProductsComponent},
  //{path: 'products/:category', component:ProductsComponent} /*might have to make this a seperate component*/
//actually will have to make this a seperate component... must do that later ... unless its the same thing but switched but the paths are different ahhh
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
