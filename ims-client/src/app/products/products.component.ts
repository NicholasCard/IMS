import { Component, OnInit } from '@angular/core';

import { ProductService } from '../product.service';
import { Product } from '../product';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];
  productByCategory: Product[] = [];
  selectedCategory: string = "";
  
  categorySelection(term: string) {
    this.selectedCategory = term;
    this.getCategory();
  }

  constructor(private productService: ProductService, 
              private route: ActivatedRoute,
              private location: Location) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts() {
    this.productService.getAllProducts()
      .subscribe(products => {
        this.productByCategory = products;
      })
  }

  getCategory() {
    console.log(this.selectedCategory)
    let category = this.selectedCategory
    if (category == "") {
      this.productByCategory = this.products;
    } else {
      this.productService.getProductByCategory(category)
      .subscribe(filteredProducts => {
        this.productByCategory = filteredProducts;
      })
    }
  }



}
