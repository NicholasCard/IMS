import { Component, OnInit } from '@angular/core';

import { ProductService } from '../product.service';
import { Product } from '../product';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-products-category',
  templateUrl: './products-category.component.html',
  styleUrls: ['./products-category.component.css']
})
export class ProductsCategoryComponent implements OnInit {

  productByCategory: Product[] = [];

  constructor(private productService: ProductService, 
              private route: ActivatedRoute,
              private location: Location) { }

  ngOnInit(): void {
    this.getCategory();
  }

  getCategory() {
    let category: string = String(this.route.snapshot.paramMap.get('category'))
    this.productService.getProductByCategory(category)
    .subscribe(filteredProducts => {
        this.productByCategory = filteredProducts;
      }
    )
  }


}
